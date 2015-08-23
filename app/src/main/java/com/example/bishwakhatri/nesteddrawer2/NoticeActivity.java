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


public class NoticeActivity extends DrawerBaseClass implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<NoticeCustomlist> userList;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(getLayoutId());
        getLayoutInflater().inflate(R.layout.activity_notice, frameLayout);

        listView= (ListView) findViewById(R.id.listView1);
int[] id={R.drawable.a,R.drawable.b};
        userList=new ArrayList<NoticeCustomlist>();
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor projectsidjiosdjwpiodjwepfijwepifj wef8w34y3048dolfgksd;lgjd;f'lgjdf';lgjsd;flgjd;f'lgjsd;fl d;lgjerpgoerjpgorgjeprogjerpogjeprogjeprogjeprogjeprogjerpogjrpogjerpogjerogjerpogjerpogjerpogjfuck uh0fwejoi oweifhjwetiojhweoifjhwe weoifhwejiojh ow3ijweio ","10m ago","All the students are notified to cubmit the propoosal...","BEIT011",R.drawable.ais));
        userList.add(new NoticeCustomlist("Classes on Saturday...","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.a));
        userList.add(new NoticeCustomlist("Funding of the tour published..","10m ago","All the students are notified to cubmit the propoosal...","BCA12",R.drawable.cis));
        userList.add(new NoticeCustomlist("Supervisor of the minor projects..","10m ago","All the students are notified to cubmit the propoosal...","BEX13",R.drawable.ais));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.bis));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.cis));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.ais));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","BEIT011",R.drawable.ais));
        userList.add(new NoticeCustomlist("Classes on Saturday...","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.bis));
        userList.add(new NoticeCustomlist("Funding of the tour published..","10m ago","All the students are notified to cubmit the propoosal...","BCA12",R.drawable.cis));
        userList.add(new NoticeCustomlist("Supervisor of the minor projects..","10m ago","All the students are notified to cubmit the propoosal...","BEX13",R.drawable.ais));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.bis));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.cis));
        userList.add(new NoticeCustomlist("Submiting the proposal of Minor project","10m ago","All the students are notified to cubmit the propoosal...","ALL",R.drawable.ais));

        UserAdaptor adaptor=new UserAdaptor(this,userList);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(this);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name= userList.get(position).getName();

        String address= userList.get(position).getAddress();
        String phone=userList.get(position).getPhone();
        String bday=userList.get(position).getBirthday();
         int img=userList.get(position).getImages();

        Intent intent=new Intent(this,NoticeActivity2.class);
        intent.putExtra("heading",name);
        intent.putExtra("descp",address);
        intent.putExtra("time",phone);
        intent.putExtra("sdf",name);
        intent.putExtra("msa",img);
        startActivity(intent);
    }

    private class UserAdaptor extends BaseAdapter{

        public ArrayList<NoticeCustomlist> data;
        LayoutInflater inflater;
        Context c;

        public UserAdaptor(Context context, ArrayList<NoticeCustomlist> userList) {

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

                view=inflater.inflate(R.layout.single_row_notice,null);
                TextView txt1= (TextView) view.findViewById(R.id.textView5);
              //  TextView txt2= (TextView)view. findViewById(R.id.textView6);
                TextView txt3= (TextView) view.findViewById(R.id.textView7);
                TextView txt4= (TextView)view. findViewById(R.id.textView8);
                ImageView image1= (ImageView) view.findViewById(R.id.imageView5);

              // ImageView image2= (ImageView) view.findViewById(R.id.imageView6);

                final   String name= data.get(position).getName();
                final String address= data.get(position).getAddress();
                final String phone=data.get(position).getPhone();
                final String bday=data.get(position).getBirthday();

                final int img=data.get(position).getImages();




                txt1.setText(name);
                //txt2.setText(address);
                txt3.setText(phone);
                txt4.setText(bday);
                image1.setImageResource(img );
               /* image1.setOnClickListener(new View.OnClickListener() {
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
}
