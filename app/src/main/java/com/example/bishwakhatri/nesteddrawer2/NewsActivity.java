package com.example.bishwakhatri.nesteddrawer2;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class NewsActivity extends DrawerBaseClass {
    //private static String url = "http://docs.blackberry.com/sampledata.json";
    private static String url = "http://192.168.10.10/a.php";

  /*  private static final String VTYPE = "vehicleType";
    private static final String VCOLOR = "vehicleColor";
    private static final String FUEL = "fuel";
    private static final String TREAD = "treadType";*/

    private static final String VTYPE = "FirstName";
    private static final String VCOLOR = "LastName";
    private static final String FUEL = "Age";
    private static final String TREAD = "Moblie";


    ArrayList<HashMap<String, String>> jsonlist = new ArrayList<HashMap<String, String>>();

    ListView lv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        lv = (ListView) findViewById(R.id.list);
       // StrictMode.enableDefaults();
        new ProgressTask(NewsActivity.this).execute();

    }

    private class ProgressTask extends AsyncTask<String, Void, Boolean> {
        private ProgressDialog dialog;

//	        private ListActivity activity;

        // private List<Message> messages;
        public ProgressTask(NewsActivity activity) {
//	            this.activity = activity;
            context = activity;
            dialog = new ProgressDialog(context);
        }

        private Context context;

        protected void onPreExecute() {
            this.dialog.setMessage("Progress start");
            this.dialog.show();
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            ListAdapter adapter = new SimpleAdapter(context, jsonlist,
                    R.layout.news_list_item, new String[] { VTYPE, VCOLOR,
                    FUEL }, new int[] {
                    R.id.title, R.id.date, R.id.desc
            });


           lv. setAdapter(adapter);

            // select single ListView item

        }

        protected Boolean doInBackground(final String... args) {

            JSONParser jParser = new JSONParser();

            // get JSON data from URL
            JSONArray json = jParser.getJSONFromUrl(url);

            for (int i = 0; i < json.length(); i++) {

                try {
                    JSONObject c = json.getJSONObject(i);
                    String vtype = c.getString(VTYPE);

                    String vcolor = c.getString(VCOLOR);
                    String vfuel = c.getString(FUEL);
                    String vtread = c.getString(TREAD);

                    HashMap<String, String> map = new HashMap<String, String>();

                    // Add child node to HashMap key & value
                    map.put(VTYPE, vtype);
                    map.put(VCOLOR, vcolor);
                    map.put(FUEL, vfuel);
                    map.put(TREAD, vtread);
                    jsonlist.add(map);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
