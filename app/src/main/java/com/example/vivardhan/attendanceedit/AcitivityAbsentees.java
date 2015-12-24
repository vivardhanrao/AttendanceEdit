package com.example.vivardhan.attendanceedit;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivardhan on 12/8/2015.
 */
public class AcitivityAbsentees extends AppCompatActivity implements View.OnClickListener {

    Button sendSms;
    TextView textMessage;
    String message="";
    int count;
    List<String> absentees_mobile;
    List<String> absentees_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_absentees);

        sendSms=(Button)findViewById(R.id.sendBtn);
        textMessage=(TextView)findViewById(R.id.textView7);


        //String[] items = {"Motorola","Samsung","Apple","Google","HTC"};

        //Bundle extra = getIntent().getBundleExtra("extra");
        //ArrayList<String> absenteesList = (ArrayList<String>) extra.getSerializable("objects");

        List<String> sample = new ArrayList<String>();
        sample.add("A");
        sample.add("B");


        List<String> absentees_htno = getIntent().getStringArrayListExtra("absentees_htno");
        absentees_name = getIntent().getStringArrayListExtra("absentees_name");
        absentees_mobile = getIntent().getStringArrayListExtra("absentees_mobile");
        count=getIntent().getExtras().getInt("the_count");

        //List<String> absenteeslist2 = new ArrayList<String>();
        //absenteeslist2.add(getIntent().getStringArrayListExtra("absenteeslist").toString());

        ArrayAdapter<String> absenteesHtnoAdapter = new ArrayAdapter<String>(this, R.layout.activity_absentees_layout,absentees_htno);
        //ArrayAdapter<String> absenteesAdapter2 = new ArrayAdapter<String>();
        ListView lv2 = (ListView) findViewById(R.id.listView2);
        lv2.setAdapter(absenteesHtnoAdapter);





    }


    @Override
    public void onClick(View v) {
        if(v==sendSms){

            try {
                for(int i=0;i<count;i++) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(absentees_mobile.get(i), null, "Dear parent, Your ward "+absentees_name.get(i)+" is absent for today class. Contact principal.", null, null);
                    Toast.makeText(getApplicationContext(), "Sent to "+absentees_name.get(i)+".", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"ERROR.",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}
