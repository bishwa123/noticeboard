package com.example.bishwakhatri.nesteddrawer2;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class RoutineActivity extends DrawerBaseClass {

    ListView routineListView;
    ArrayList<RoutineCustomlist> routineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_routine);
        getLayoutInflater().inflate(R.layout.activity_routine,frameLayout);

        routineListView= (ListView) findViewById(R.id.listViewRoutine);
        routineList=new ArrayList<RoutineCustomlist>();

        routineList.add(new RoutineCustomlist("7:00-8:30","CNET","A404","MBG","L","CNET","A404","MBG","L"));
        routineList.add(new RoutineCustomlist("8:30-10:00","CNET","A404","MBG","L","CNET","A404","MBG","L"));
        routineList.add(new RoutineCustomlist("10:45-12:00","CNET","A404","MBG","L","CNET","A404","MBG","L"));
        routineList.add(new RoutineCustomlist("12:00-1:30","CNET","A404","MBG","L","CNET","A404","MBG","L"));
      //  routineList.add(new RoutineCustomlist("","CNET","A404","MBG","L"));

        RoutineAdaptor adaptor=new RoutineAdaptor(this,routineList);
        routineListView.setAdapter(adaptor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_routine, menu);
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

    private class RoutineAdaptor extends BaseAdapter {

        public ArrayList<RoutineCustomlist> data;
        LayoutInflater inflater;
        Context c;
        public RoutineAdaptor(Context context, ArrayList<RoutineCustomlist> routineList) {

            this.c=context;
            this.data=routineList;
            inflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view=convertView;
            if(view==null) {

                view = inflater.inflate(R.layout.single_row_routine, null);

                TextView txt2= (TextView) view.findViewById(R.id.teacherA);
                 TextView txt1= (TextView)view. findViewById(R.id.subjectA);
                TextView txt3= (TextView) view.findViewById(R.id.roomA);
                TextView txt4= (TextView)view. findViewById(R.id.modeA);
                TextView txt5= (TextView)view. findViewById(R.id.time);

                TextView txt7= (TextView) view.findViewById(R.id.teacherB);
                TextView txt6= (TextView)view. findViewById(R.id.subjectB);
                TextView txt8= (TextView) view.findViewById(R.id.roomB);
                TextView txt9= (TextView)view. findViewById(R.id.modeB);


                String subjectA=data.get(position).getLectnameA();
                String teacherA=data.get(position).getTeachnameA();
                String roomA=data.get(position).getRoomnoA();
                String modeA=data.get(position).getModeA();
                String time=data.get(position).getTime();

                String subjectB=data.get(position).getLectnameB();
                String teacherB=data.get(position).getTeachnameB();
                String roomB=data.get(position).getRoomnoB();
                String modeB=data.get(position).getModeB();

                txt1.setText(subjectA);
                txt2.setText(teacherA);
                txt3.setText(roomA);
                txt4.setText(modeA);
                txt5.setText(time);

                txt6.setText(subjectB);
                txt7.setText(teacherB);
                txt8.setText(roomB);
                txt9.setText(modeB);


            }
            return view;
        }
    }
}
