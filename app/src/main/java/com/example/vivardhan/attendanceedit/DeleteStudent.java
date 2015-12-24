package com.example.vivardhan.attendanceedit;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;;

/**
 * Created by madga_000 on 12/11/2015.
 */
public class DeleteStudent extends AppCompatActivity implements View.OnClickListener {
    EditText htNo;
    Button deleteStud;

    SQLiteDatabase myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletestudent);

        htNo=(EditText)findViewById(R.id.editText);
        deleteStud=(Button)findViewById(R.id.deleteStudent);

        myDB = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();
    }

    @Override
    public void onClick(View v) {
        if (v==deleteStud){

            String ht=htNo.getText().toString();
            try {
                myDB.execSQL("delete from student where htno='" + ht + "';");
                Toast.makeText(getApplicationContext(), ht+" Deleted.", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            htNo.setText("");

        }

    }


}
