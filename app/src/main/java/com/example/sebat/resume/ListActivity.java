package com.example.sebat.resume;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    protected List<Teams> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        data = DataProvider.getData();

        ArrayAdapter<Teams> teamsArrayAdapter= new TeamArrayAdaper(this,0,data);
        ListView display= (ListView) findViewById(android.R.id.list);
        display.setAdapter(teamsArrayAdapter);

        display.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teams takimim=data.get(position);
                showDetails(takimim);

            }
        });

    }
    private void showDetails(Teams takimim){
        Intent go=new Intent(this,DetailTurkTeams.class);
        go.putExtra("Teamname",takimim.getTitle());
        go.putExtra("Desc",takimim.getDescription());
        startActivity(go);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

    public void Register(View view) {
        Intent go_to_next= new Intent(this,Register.class);
        startActivity(go_to_next);
    }



    class TeamArrayAdaper extends ArrayAdapter<Teams>{

        Context kontext;
        List<Teams>my_teams;
        public TeamArrayAdaper(Context context, int resource, List<Teams> objects) {
            super(context, resource, objects);
            this.kontext=context;
            this.my_teams=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Teams teams_list=my_teams.get(position);
            LayoutInflater inflater= (LayoutInflater) kontext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View new_view= inflater.inflate(R.layout.teams_item,null);
            TextView text_view = (TextView) new_view.findViewById(R.id.tvTitle);
            text_view.setText(teams_list.getTitle());
            ImageView team_logo= (ImageView) new_view.findViewById(R.id.imageTeam);
            int resource=kontext.getResources().getIdentifier("img_"+teams_list.getTeamNumber(),"drawable",kontext.getPackageName());
            team_logo.setImageResource(resource);


            return new_view;
        }
    }
}
