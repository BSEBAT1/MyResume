package com.example.sebat.resume;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Json extends AppCompatActivity {
    String JSON_String;
    String json_string;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

            new KackgroundTask().execute();




    }


    class KackgroundTask extends AsyncTask<Void,Void,String>{

        String Json_url;


        @Override
        protected void onPreExecute() {
            Json_url="http://berkaysebat.com/json_get_data.php";
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url=new URL(Json_url);
                HttpURLConnection httpURLConnection =  (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                StringBuilder stringBuilder=new StringBuilder();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                while ((JSON_String=bufferedReader.readLine())!=null){
                stringBuilder.append(JSON_String+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            json_string=result;
            Intent go_here = new Intent(getApplicationContext(),Display_ListView.class);
            go_here.putExtra("json_data",json_string);
            go_here.putExtra("testing","test1");
            startActivity(go_here);

        }
    }
   
//testing github
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_json, menu);
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
