package com.example.rishi.project;

import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    String uniqueData="";
    String totalData="";
    @Override

    protected Void doInBackground(Void... voids) {
        try {
            URL url= new URL("https://raw.githubusercontent.com/iranjith4/radius-intern-mobile/master/users.json");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream =httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String l="";
            while(l!=null){
                l= bufferedReader.readLine();
                data=data+l;
            }
            JSONArray jaob=new JSONObject(data).getJSONArray("results");
            for(int i=0;i<jaob.length();i++)
            {
                try {
                    JSONObject temp=(JSONObject) jaob.get(i);
                    String names="";
                    JSONObject name=(JSONObject) temp.get("name");
                    String title=(String) name.get("title");
                    String first=(String) name.get("first");
                    String last=(String) name.get("last");
                    names=title+" "+first+" "+last;

                    JSONObject dob=(JSONObject) temp.get("dob");
                    int age= dob.getInt("age");

                    JSONObject picture=(JSONObject) jo.get("picture");
                    String picPath=(String) picture.get("medium");

                    //Picasso.with(this).load(picPath).networkPolicy(com.squareup.picasso.NetworkPolicy.NO_CACHE).into(MainActivity.image);

                    uniqueData="NAME : "+names+"\n"+"AGE : "+age+"\n"+"Photo :"+picPath+"\n";
                    totalData+=singleData+"\n";
                    Log.e("t",combinedData);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.text.setText(this.totalData);
        MainActivity.text.setMovementMethod(new ScrollingMovementMethod());
    }


}
