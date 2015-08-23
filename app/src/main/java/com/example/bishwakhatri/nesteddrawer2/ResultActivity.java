package com.example.bishwakhatri.nesteddrawer2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultActivity extends DrawerBaseClass implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<ResultCustomList> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(getLayoutId());
        getLayoutInflater().inflate(R.layout.activity_result, frameLayout);
//        listView.setItemChecked(position, true);

        listView= (ListView) findViewById(R.id.listViewresult);
        int[] a={R.drawable.ais,R.drawable.bis};
        int[] b={R.drawable.cis,R.drawable.bis};
        int[] c={R.drawable.bis,R.drawable.bis};
        int[] d={R.drawable.ais,R.drawable.bis};
        int[] e={R.drawable.cis,R.drawable.bis};


        userList=new ArrayList<ResultCustomList>();
        userList.add(new ResultCustomList("Internal evaluation of BBA 13..","10m ago","BBA",R.drawable.ais));
        userList.add(new  ResultCustomList("Internal evaluation of BEIT 11..","50m ago","BEIT11",R.drawable.bis));
        userList.add(new  ResultCustomList("Internal evaluation of BEIT 12..","30m ago","BCA12",R.drawable.cis));
        userList.add(new  ResultCustomList("Internal evaluation of BCE 11..","1h ago","BEX13",R.drawable.bis));
        userList.add(new  ResultCustomList("Internal evaluation of BCV AB 11..","10m ago","ALL",R.drawable.ais));
        userList.add(new ResultCustomList("Internal evaluation of BEX 13..","10m ago","BBA",R.drawable.ais));
        userList.add(new  ResultCustomList("Internal evaluation of BCE 12..","50m ago","BEIT11",R.drawable.bis));
        userList.add(new  ResultCustomList("Internal evaluation of BCV 13 CD..","30m ago","BCA12",R.drawable.cis));
        userList.add(new  ResultCustomList("Internal evaluation of BEIT 12..","1h ago","BEX13",R.drawable.bis));
        userList.add(new  ResultCustomList("Internal evaluation of BBA13..","10m ago","ALL",R.drawable.ais));

        UserAdaptor adaptor=new UserAdaptor(this,userList);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final   String title= userList.get(position).getTitle();
        final String time= userList.get(position).getTime();
        final String faculty=userList.get(position).getFaculty();


        final int img=userList.get(position).getImages();


        Intent intent=new Intent(this,ResultActivity2.class);
        intent.putExtra("title",title);
        intent.putExtra("time",time);
        intent.putExtra("faculty",faculty);

            intent.putExtra("msa", img);

        startActivity(intent);
    }

    private class UserAdaptor extends BaseAdapter {

        public ArrayList< ResultCustomList> data;
        LayoutInflater inflater;
        Context c;

        public UserAdaptor(Context context, ArrayList< ResultCustomList> userList) {

            this.data=userList;

            this.c=context;
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
            if(view==null){

                view=inflater.inflate(R.layout.single_row_result,null);
                TextView txt1= (TextView) view.findViewById(R.id.textView3);
                //  TextView txt2= (TextView)view. findViewById(R.id.textView6);
                TextView txt3= (TextView) view.findViewById(R.id.textView4);
                TextView txt4= (TextView)view. findViewById(R.id.textView11);
                ImageView image1= (ImageView) view.findViewById(R.id.imageViewresult);

                // ImageView image2= (ImageView) view.findViewById(R.id.imageView6);

                final   String title= data.get(position).getTitle();
                final String time= data.get(position).getTime();
                final String faculty=data.get(position).getFaculty();


                final int img=data.get(position).getImages();




                txt1.setText(title);
                //txt2.setText(address);
                txt4.setText(faculty);
                txt3.setText(time);

                    image1.setImageResource(img);

              /*  image1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(c,NewsActivity.class);
                        intent.putExtra("ima",img);

                        intent.putExtra("msg","Name: "+name+" " +"Address"+" "+address+"Phone number"+" "+phone+"Birth day:"+" "+bday+" "+img);
                        startActivity(intent);

                    }
                });*/

           /*     image2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

                        startActivity(intent);
                    }
                });*/




            }

            return view;
        }
    }




    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
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
