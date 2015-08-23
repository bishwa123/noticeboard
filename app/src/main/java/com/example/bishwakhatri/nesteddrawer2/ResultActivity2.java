package com.example.bishwakhatri.nesteddrawer2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity2 extends DrawerBaseClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_result_activity2);
        getLayoutInflater().inflate(R.layout.activity_result_activity2, frameLayout);

        Bundle extras= getIntent().getExtras();

        String s1=extras.getString("title");
        String s2=extras.getString("faculty");
        String s3=extras.getString("time");
        ImageView imageView= (ImageView) findViewById(R.id.imageView2);
        TextView textView1= (TextView) findViewById(R.id.textView12);
        //  String s=i.getStringExtra("msa");
        //  String t=s.toString();

             int img = extras.getInt("msa");
            imageView.setImageResource(img);

        //   TextView txt1= (TextView) findViewById(R.id.tx);

      //  TextView textView2= (TextView) findViewById(R.id.textView6);
        //TextView textView3= (TextView) findViewById(R.id.textView10);
        // int a=Integer.parseInt(s);

        textView1.setText(s1);
       // textView2.setText(s3);
        //textView3.setText(s2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_activity2, menu);
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
