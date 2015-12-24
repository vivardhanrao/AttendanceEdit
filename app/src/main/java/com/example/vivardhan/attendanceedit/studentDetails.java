package com.example.vivardhan.attendanceedit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vivardhan on 12/8/2015.
 */
public class studentDetails extends AppCompatActivity implements View.OnClickListener {

    EditText edName,check_ht;
    EditText edHTNo;
    EditText edMobile;

    Button bAdd;
    Button refreshBtn;
    Button bDisplay;

    SQLiteDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudentdetails);

        edName = (EditText) findViewById(R.id.editName);
        edHTNo = (EditText) findViewById(R.id.editHTNo);
        edMobile = (EditText) findViewById(R.id.editMobile);
        check_ht=(EditText)findViewById(R.id.editTestDisplay);
        bAdd = (Button) findViewById(R.id.button);
        refreshBtn = (Button) findViewById(R.id.button2);
        bDisplay = (Button) findViewById(R.id.bDisplay);


        myDB = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        myDB.execSQL("create table if not exists student(name varchar, htno varchar primary key, mobile varchar);");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();
    }

    private void showMessage(String ht_no,String name_db,String mob_no) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Details");
        builder.setMessage("Ht.No: " + ht_no + "\nName: " + name_db + "\nMobile No: " + mob_no);
        builder.show();


    }

    @Override
    public void onClick(View v) {
        if(v==bAdd){
            if (edName.getText().toString().trim().length() == 0 || edHTNo.getText().toString().trim().length() == 0 || edMobile.getText().toString().trim().length() == 0) {
                Toast.makeText(studentDetails.this, "Error", Toast.LENGTH_LONG).show();
            }
            try {
                myDB.execSQL("insert into student values('" + edName.getText() + "','" + edHTNo.getText() + "','" + edMobile.getText() + "');");
                Toast.makeText(studentDetails.this, edName.getText().toString() + " has been added.", Toast.LENGTH_LONG).show();
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(),"HT Number already exists",Toast.LENGTH_LONG).show();
            }
            edName.setText("");
            edHTNo.setText("");
            edMobile.setText("");
        }
        if(v== refreshBtn){
            Intent i=new Intent(getApplicationContext(),Activity_CSE.class);
            startActivity(i);
        }

        if(v==bDisplay) {
            String ht=check_ht.getText().toString();
            try{
            Cursor c = myDB.rawQuery("select * from student where htno='"+ht+"'", null);
            if (c.moveToFirst()) {
                String sname = c.getString(0);
                String shtno = c.getString(1);
                String smobile = c.getString(2);
                showMessage(shtno, sname, smobile);
            }
                c.close();
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(),"Enter correct HT number",Toast.LENGTH_LONG).show();
            }
            check_ht.setText("");

        }




    }
}
