package com.example.bishwakhatri.nesteddrawer2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class RoutinesActivityIT1 extends DrawerBaseClass {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.routine_activity_it1, frameLayout);
       // setContentView(R.layout.routine_activity_it1);
        viewPager= (ViewPager) findViewById(R.id.pagerit1);

        FragmentManager fm=getSupportFragmentManager();
        MyAdaptor adaptor=new MyAdaptor(fm);
        viewPager.setAdapter(adaptor);
    }

    class MyAdaptor extends FragmentStatePagerAdapter {


        public MyAdaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            if(i==0){
                fragment=new FragmentSundayIT1();
            }
            if(i==1){
                fragment=new FragmentMondayIT1();
            }
            if(i==2){
                fragment=new FragmentTuesdayIT1();
            }
            if(i==3){
                fragment=new FragmentWednesdayIT1();
            }
            if(i==4){
                fragment=new FragmentThursdayT1();
            }
            if(i==5){
                fragment=new FragmentFridayIT1();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if(position==0){


                return "Sunday";
            }
            if(position==1){
                return "Monday";
            }
            if(position==2){
                return "Tuesday";
            }
            if(position==3){
                return "Wednesday";
            }
            if(position==4){
                return "Thursday";
            }
            if(position==5){
                return "Friday";
            }
            return null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_routines, menu);
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
