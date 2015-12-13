package com.example.sebat.resume;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText ET_NAME,ET_USERNAME,ET_USERPASS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_NAME= (EditText) findViewById(R.id.name);
        ET_USERNAME= (EditText) findViewById(R.id.username);
        ET_USERPASS= (EditText) findViewById(R.id.password);

    }
    public void Registery(View view){

        String name=ET_NAME.getText().toString();
        String username=ET_USERNAME.getText().toString();
        String password=ET_USERPASS.getText().toString();
        String method="Register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,name,username,password);
        Log.d("TESTING", "NO ERRORS YET");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
    public void Go_Next(View view) {
        Intent go_to_next= new Intent(this,Json.class);
        startActivity(go_to_next);
    }
}
