package com.example.sebat.resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Display_ListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Contact_Adapter contact_adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        json_string=getIntent().getStringExtra("json_data");
        setContentView(R.layout.display_listview_layout);
        listView= (ListView) findViewById(R.id.lisview);
        contact_adapter = new Contact_Adapter(this,R.layout.rowlayout);
        listView.setAdapter(contact_adapter);

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_res");
            int count = 0;
            String name,title,comment;
            while (count < jsonArray.length()) {
             JSONObject JO= jsonArray.getJSONObject(count);
            name=JO.getString("name");
            title= JO.getString("user_name");
            comment=JO.getString("user_pass");
             Connect connect=new Connect(name,title,comment);
                contact_adapter.add(connect);
            count++;
                Log.w("TESTING","Object?"+name);
            }
        }
         catch (JSONException e) {
            e.printStackTrace();
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display__list_view, menu);
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
