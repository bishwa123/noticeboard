package com.example.bishwakhatri.nesteddrawer2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class NoticeActivity2 extends DrawerBaseClass implements View.OnTouchListener {


    ImageView imageView;
    Button btnsave;
    Button btnshare;

    private static final String TAG = "Touch";
    @SuppressWarnings("unused")
    private static final float MIN_ZOOM = 1f, MAX_ZOOM = 1f;

    // These matrices will be used to scale points of the image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // The 3 states (events) which the user is trying to perform
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // these PointF objects are used to record the point(s) the user is touching
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main_activity5);
        getLayoutInflater().inflate(R.layout.activity_main_activity5, frameLayout);
        // Intent i=getIntent();Im

        imageView = (ImageView) findViewById(R.id.imageView12);
        btnsave= (Button) findViewById(R.id.btnsave);
        btnshare= (Button) findViewById(R.id.btnshare);

        Bundle extras = getIntent().getExtras();

        String s1 = extras.getString("heading");
        String s2 = extras.getString("time");
        // String s2=extras.getString("desc");
        //String s3=extras.getString("time");

        //  String s=i.getStringExtra("msa");
        //  String t=s.toString();
        int r = extras.getInt("msa");
        //   TextView txt1= (TextView) findViewById(R.id.tx);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView12);
        TextView textView1 = (TextView) findViewById(R.id.textView9);
        TextView textView2 = (TextView) findViewById(R.id.textView6);
        // TextView textView2= (TextView) findViewById(R.id.textView6);
        //TextView textView3= (TextView) findViewById(R.id.textView10);
        // int a=Integer.parseInt(s);
        imageView.setImageResource(r);
        textView1.setText(s1);
        textView2.setText(s2);

        imageView.setOnTouchListener(this);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setDrawingCacheEnabled(true);
                Bitmap bitmap = imageView.getDrawingCache();

                String root = Environment.getExternalStorageDirectory().toString();
                File newDir = new File(root + "/notices");
                newDir.mkdirs();
                Random gen = new Random();
                int n = 10000;
                n = gen.nextInt(n);
                String fotoname = "photo-"+ n +".jpg";
                File file = new File (newDir, fotoname);
                if (file.exists ()) file.delete ();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.flush();
                    out.close();
                    Toast.makeText(getApplicationContext(), "safed to your folder", Toast.LENGTH_SHORT ).show();

                } catch (Exception e) {

                }


            }

        });

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                // Save this bitmap to a file.
                File cache = getApplicationContext().getExternalCacheDir();
                File sharefile = new File(cache, "toshare.png");
                try {
                    FileOutputStream out = new FileOutputStream(sharefile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                } catch (IOException e) {

                }

                // Now send it out to share
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + sharefile));
                try {
                    startActivity(Intent.createChooser(share, "Share photo"));
                } catch (Exception e) {

                }
            }

        });
        //textView2.setText(s3);
        //textView3.setText(s2);
        //   txt1.setText(s);
        // setContentView(txt1);
       /* Button savebtn= (Button) findViewById(R.id.btnsave);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap;
                OutputStream output;

                // Retrieve the image from the res folder
                bitmap = BitmapFactory.decodeResource(getResources(),
                        R.id.imageView12);

                // Find the SD Card path
                File filepath = Environment.getExternalStorageDirectory();

                // Create a new folder in SD Card
                File dir = new File(filepath.getAbsolutePath()
                        + "/notices");
                dir.mkdirs();

                // Create a name for the saved image
                File file = new File(dir, "myimage.png");

                // Show a toast message on successful save
                Toast.makeText(NoticeActivity2.this, "Image Saved to SD Card",
                        Toast.LENGTH_SHORT).show();
                try {

                    output = new FileOutputStream(file);

                    // Compress into png format image from 0% - 100%
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                    output.flush();
                    output.close();
                }

                catch (Exception e) {

                    e.printStackTrace();
                }

              //  Toast.makeText(getApplicationContext(),"Image saved",Toast.LENGTH_LONG).show();

            }
        });

*/

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity5, menu);
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
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        view.setScaleType(ImageView.ScaleType.MATRIX);
        float scale;

        dumpEvent(event);
        // Handle touch events here...

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:   // first finger down only
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());
                // Log.d(TAG, "mode=DRAG"); // write to LogCat
                mode = DRAG;
                break;

            case MotionEvent.ACTION_UP: // first finger lifted

            case MotionEvent.ACTION_POINTER_UP: // second finger lifted

                mode = NONE;
                // Log.d(TAG, "mode=NONE");
                break;

            case MotionEvent.ACTION_POINTER_DOWN: // first and second finger down

                oldDist = spacing(event);
                //Log.d(TAG, "oldDist=" + oldDist);
                if (oldDist > 5f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                    //  Log.d(TAG, "mode=ZOOM");
                }
                break;

            case MotionEvent.ACTION_MOVE:

                if (mode == DRAG) {
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y); // create the transformation in the matrix  of points
                } else if (mode == ZOOM) {
                    // pinch zooming
                    float newDist = spacing(event);
                    //Log.d(TAG, "newDist=" + newDist);
                    if (newDist > 5f) {
                        matrix.set(savedMatrix);
                        scale = newDist / oldDist; // setting the scaling of the
                        // matrix...if scale > 1 means
                        // zoom in...if scale < 1 means
                        // zoom out
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }

        view.setImageMatrix(matrix); // display the transformation on screen

        return true; // indicate event was handled
    }

    /*
     * --------------------------------------------------------------------------
     * Method: spacing Parameters: MotionEvent Returns: float Description:
     * checks the spacing between the two fingers on touch
     * ----------------------------------------------------
     */

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt(x * x + y * y);
    }

    /*
     * --------------------------------------------------------------------------
     * Method: midPoint Parameters: PointF object, MotionEvent Returns: void
     * Description: calculates the midpoint between the two fingers
     * ------------------------------------------------------------
     */

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }

    /**
     * Show an event in the LogCat view, for debugging
     */
    private void dumpEvent(MotionEvent event) {
        String names[] = {"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"};
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        sb.append("event ACTION_").append(names[actionCode]);

        if (actionCode == MotionEvent.ACTION_POINTER_DOWN || actionCode == MotionEvent.ACTION_POINTER_UP) {
            sb.append("(pid ").append(action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
            sb.append(")");
        }

        sb.append("[");
        for (int i = 0; i < event.getPointerCount(); i++) {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount())
                sb.append(";");
        }



    }
}
