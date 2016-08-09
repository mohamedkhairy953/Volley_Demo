package com.example.moham.volleydemo;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    String My_Url = "https://pixabay.com/static/uploads/photo/2016/06/10/18/10/man-1448627_960_720.jpg";
    ImageView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (ImageView) findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest = new ImageRequest(My_Url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                     textView.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "ERROR >>>", Toast.LENGTH_SHORT).show();
                    }
                });
                MySingletone.getmInstance(getApplicationContext()).addToRequestQueue(imageRequest);
            }
        });

    }
}


      /*  Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        final RequestQueue queue = new RequestQueue(cache, network);*/


    /*
     first lecture


     btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, My_Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     textView.setText(response);
                        queue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText(" ERROR ");
                        queue.stop();
                    }
                });
                queue.add(stringRequest);
            }
        });
*/