package com.example.sebat.resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTurkTeams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_turk_teams);
        String Titles=getIntent().getStringExtra("Teamname");
        TextView title_set=(TextView) findViewById(R.id.Titles);
        title_set.setText(Titles);

        String Team_Desc=getIntent().getStringExtra("Desc");
        TextView team_info= (TextView) findViewById(R.id.teaminfo);
        team_info.setText(Team_Desc);

        ImageView logo_detail= (ImageView) findViewById(R.id.detailie);

        switch (Titles){
            case "Akhisar Belediye": logo_detail.setImageResource(R.drawable.img_10101);
                break;
            case "Balikesirspor": logo_detail.setImageResource(R.drawable.img_10102);
                break;
            case "Besiktas":logo_detail.setImageResource(R.drawable.img_10103);
                break;
            case "Bursaspor":logo_detail.setImageResource(R.drawable.img_10104);
                break;
            case "Fenerbahce": logo_detail.setImageResource(R.drawable.img_10105);
                break;
            case "Trabzonspor": logo_detail.setImageResource(R.drawable.img_10106);
                break;
            case "Eskisehirspor":logo_detail.setImageResource(R.drawable.img_10107);
                break;
            case "Kasimpasa":logo_detail.setImageResource(R.drawable.img_10108);
                break;
            case "Caykur Rize Spor": logo_detail.setImageResource(R.drawable.img_10109);
                break;
            case "Galatasaray": logo_detail.setImageResource(R.drawable.img_20109);
                break;
            default: break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_turk_teams, menu);
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
