package com.example.bishwakhatri.nesteddrawer2;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public  class DrawerBaseClass extends ActionBarActivity {

    protected static int position;
    protected  DrawerLayout drawerLayout;
     protected ActionBarDrawerToggle adt;
   protected ListView listView;
    String[] list;
   protected FrameLayout frameLayout;

   // String[] actions={"even","odd"};


  //  private static boolean isLaunch = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_drawer_base_class);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        listView= (ListView) findViewById(R.id.navigation_drawer);
        frameLayout= (FrameLayout) findViewById(R.id.layout_frame);




       // list=getResources().getStringArray(R.array.frens);
      //  ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        ArrayList<DrawerList> dlist=new ArrayList<DrawerList>();
        dlist.add(new DrawerList("Home",R.drawable.home));
        dlist.add(new DrawerList("News",R.drawable.news));
        dlist.add(new DrawerList("Notices",R.drawable.notice));
        dlist.add(new DrawerList("Result",R.drawable.result));
        dlist.add(new DrawerList("Report Bugs",R.drawable.reportus));
        dlist.add(new DrawerList("About us",R.drawable.aboutus));


        Draweradaptor adapter=new Draweradaptor(this,dlist);
        listView.setAdapter(adapter);

        adt=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_launcher,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Drawer opened");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("Drawer closed");
            }
        };
        drawerLayout.setDrawerListener(adt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  openActivity(position);

                if(position==0){
                    Intent intent=new Intent(parent.getContext(),MainActivity.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(parent.getContext(),NewsActivity.class);
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(parent.getContext(), NoticeActivity.class);
                    startActivity(intent);
                }
                    if(position==3){
                        Intent intent=new Intent(parent.getContext(),ResultActivity.class);
                        startActivity(intent);
                }
            }
        });

     //  if(isLaunch){
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
           // isLaunch = false;
           // openActivity(0);
        //}
    }

  /*  protected void openActivity(int position) {


	//listView.setItemChecked(position, true);
		//setTitle(listArray[position]);

     //   drawerLayout.closeDrawer(drawerLayout);
      //  DrawerBaseClass.position = position; //Setting currently selected position in this field so that it will be available in our child activities.

        switch (position) {
            case 0:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, MainActivity3.class));
                break;
            case 2:
                startActivity(new Intent(this, MainActivity4.class));
                break;


            default:
                break;
        }

        Toast.makeText(this, "Selected Item Position::" + position, Toast.LENGTH_LONG).show();
    }*/


   // protected abstract int getLayoutId();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawer_base_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (adt.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
        }

    private class Draweradaptor extends BaseAdapter {
        ArrayList<DrawerList> data;
        LayoutInflater inflater;
        public Draweradaptor(Context context, ArrayList<DrawerList> dlist) {

                    this.data=dlist;
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
            View rootView=convertView;
            rootView=inflater.inflate(R.layout.single_row_drawerlist,null);

            ImageView imageView= (ImageView) rootView.findViewById(R.id.imageView);
            TextView textView= (TextView) rootView.findViewById(R.id.textView);

            int img=data.get(position).getImages();
            String name=data.get(position).getNames();
            textView.setText(name);
            imageView.setImageResource(img);

            return rootView;
        }
    }

    //  return super.onOptionsItemSelected(item);
    }



