package com.example.vivardhan.attendanceedit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by madga_000 on 12/11/2015.
 */
public class EditDetails extends AppCompatActivity implements View.OnClickListener {

    EditText edit_ht,edit_name,edit_mobileNo;
    Button editBt,updateBt;
    SQLiteDatabase myDB;
    String ht_no,std_name,std_num;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edit_ht =(EditText)findViewById(R.id.htNo);
        edit_name=(EditText)findViewById(R.id.editText2);
        edit_mobileNo=(EditText)findViewById(R.id.mobileNum);
        editBt=(Button)findViewById(R.id.editBtn);
        updateBt=(Button)findViewById(R.id.updateBtn);

        myDB = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        myDB.execSQL("create table if not exists student(name varchar, htno varchar primary key, mobile varchar);");
    }
    private void showMessage(String ht_no,String name_db,String mob_no) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("New Details");
        builder.setMessage("Ht.No: " + ht_no + "\nName: " + name_db + "\nMobile No: " + mob_no);
        builder.show();


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();

    }

    @Override
    public void onClick(View v) {
        if (v==editBt){
            ht_no= edit_ht.getText().toString();
            Cursor c = myDB.rawQuery("select * from student where htno='"+ht_no+"'", null);
            if(c.moveToFirst()){
                std_name=c.getString(0);
                std_num=c.getString(2);
                edit_name.setText(std_name);
                edit_mobileNo.setText(std_num);



            }
            c.close();


        }
        if(v==updateBt){
            String std_name1=edit_name.getText().toString();
            String std_num1=edit_mobileNo.getText().toString();
            try {

                myDB.execSQL("update student set name='" + std_name1 + "',mobile='" + std_num1 + "' where htno='" + ht_no + "';");
                showMessage(ht_no,std_name1,std_num1);
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(),"HT number doesn't exist",Toast.LENGTH_LONG).show();
            }
            clear();


        }


    }

    private void clear() {

        edit_ht.setText("");
        edit_name.setText("");
        edit_mobileNo.setText("");


    }
}
