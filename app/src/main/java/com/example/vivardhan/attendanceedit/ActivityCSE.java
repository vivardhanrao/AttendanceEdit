/*
package com.example.vivardhan.attendanceedit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Vivardhan on 12/7/2015.
 *//*

public class ActivityCSE extends AppCompatActivity {

    int count=0;

    public List<Students> students = new ArrayList<Students>();
    public List<Students> absentees = new ArrayList<Students>();
    public List<String> absentees_htno = new ArrayList<String>();
    public List<String> absentees_name = new ArrayList<String>();
    public List<String> absentees_mobile = new ArrayList<String>();

    SQLiteDatabase myDB;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        myDB = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        myDB.execSQL("create table if not exists student(name varchar, htno varchar primary key, mobile varchar);");

        Cursor c = myDB.rawQuery("select * from student;", null);

        if (c.moveToFirst()) {
            do {
                String sname = c.getString(0);
                String shtno = c.getString(1);
                String smobile = c.getString(2);
                students.add(new Students(sname, shtno, smobile));
            } while (c.moveToNext());

        }

        ArrayAdapter<Students> adapter = new MyListAdapter();
        ListView list= (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        c.close();

    }

    public class MyListAdapter extends ArrayAdapter<Students>{
        public MyListAdapter(){
            super(ActivityCSE.this, R.layout.activity_layout, students);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.activity_layout,parent,false);
            }

            final Students currentStudent =students.get(position);

            TextView sname= (TextView) itemView.findViewById(R.id.textRollNumber);
            sname.setText(currentStudent.getSname());

            final CheckBox cb = (CheckBox) itemView.findViewById(R.id.checkBox);



            cb.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View v) {
                    if (cb.isChecked()) {
                        absentees.add(currentStudent);
                        absentees_htno.add(currentStudent.getShtno());
                        absentees_name.add(currentStudent.getSname());
                        absentees_mobile.add(currentStudent.getSmobile());
                        count++;
                        //info.setText(absentees.toString());

                    }
                    if (cb.isChecked()==false) {
                        absentees.remove(currentStudent);
                        absentees_htno.remove(currentStudent.getShtno());
                        absentees_name.remove(currentStudent.getSname());
                        absentees_mobile.remove(currentStudent.getSmobile());
                        count--;


                    }



                    final Intent intent = new Intent(ActivityCSE.this, AcitivityAbsentees.class);
                    intent.putStringArrayListExtra("absentees_htno", (ArrayList<String>) absentees_htno);
                    intent.putStringArrayListExtra("absentees_name", (ArrayList<String>) absentees_name);
                    intent.putStringArrayListExtra("absentees_mobile", (ArrayList<String>) absentees_mobile);
                    intent.putExtra("the_count",count);
                    buttonSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intent);
                        }
                    });


                }

            });

            return itemView;
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0,0,1,"Add student");
        menu.add(0,1,2,"Remove student");
        menu.add(0,2,3,"Edit student details");
        menu.add(0,3,4,"Delete DB");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == 0) {
            Intent i=new Intent(ActivityCSE.this,studentDetails.class);
            startActivity(i);
        }
        if (id == 1){
            Intent i1=new Intent(ActivityCSE.this,DeleteStudent.class);
            startActivity(i1);

        }
        if (id==2){
              Intent i2=new Intent(ActivityCSE.this,EditDetails.class);
            startActivity(i2);

        }
        if(id==3){
            myDB.execSQL("delete from student;");
        }

        return super.onOptionsItemSelected(item);
    }


}
*/
