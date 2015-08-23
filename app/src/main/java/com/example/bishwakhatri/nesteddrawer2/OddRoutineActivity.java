package com.example.bishwakhatri.nesteddrawer2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class OddRoutineActivity extends DrawerBaseClass {

    Button button1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_odd_routine);
        getLayoutInflater().inflate(R.layout.activity_odd_routine,frameLayout);
        button1= (Button) findViewById(R.id.buttonIT1);

    }

    public void check(View v)
    {
        int id=v.getId();



        if(id == R.id.buttonBA3||id==R.id.buttonBA1||id==R.id.buttonBA5||id==R.id.buttonBA7||id==R.id.buttonCAB1||id==R.id.buttonCAB3||id==R.id.buttonCAB5
                ||id==R.id.buttonCAB7||id==R.id.buttonCCD1||id==R.id.buttonCCD3||id==R.id.buttonCCD5||id==R.id.buttonCCD7
                        ){
            startActivity(new Intent(v.getContext(),RoutinesActivityIT1.class));
        }

        if(id==R.id.buttonCE1||id==R.id.buttonCE3||id==R.id.buttonCE5||id==R.id.buttonCE7||id==R.id.buttonEX1||id==R.id.buttonEX3||id==R.id.buttonEX5||id==R.id.buttonEX7
                ||id==R.id.buttonIT1||id==R.id.buttonIT3||id==R.id.buttonIT5||id==R.id.buttonIT7){

            startActivity(new Intent(v.getContext(),RoutinesActivityIT1.class));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_odd_routine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
