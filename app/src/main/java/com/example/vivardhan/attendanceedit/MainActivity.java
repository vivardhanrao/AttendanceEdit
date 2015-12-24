package com.example.vivardhan.attendanceedit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton button_cse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_cse=(ImageButton)findViewById(R.id.buttonCSE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //Eefgjam


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        try {
            if (v == button_cse) {
                Intent i = new Intent(MainActivity.this, Activity_CSE.class);
                startActivity(i);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
        }
    }
}
