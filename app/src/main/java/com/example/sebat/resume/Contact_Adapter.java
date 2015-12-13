package com.example.sebat.resume;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebat on 11/27/2015.
 */
public class Contact_Adapter extends ArrayAdapter {
    List list= new ArrayList();
    public Contact_Adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Connect object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
       return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ConnectHolder connectHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.rowlayout, parent, false);
            connectHolder = new ConnectHolder();
            connectHolder.tx_name = (TextView) row.findViewById(R.id.tx_name);
            connectHolder.tx_title = (TextView) row.findViewById(R.id.tx_userame);
            connectHolder.tx_comment = (TextView) row.findViewById(R.id.tx_userpass);
            row.setTag(connectHolder);

        } else {
            connectHolder=(ConnectHolder) row.getTag();
        }

        Connect connects= (Connect) this.getItem(position);
        connectHolder.tx_name.setText("Username: "+connects.getName());
        connectHolder.tx_title.setText("Title: "+connects.getUsername());
        connectHolder.tx_comment.setText("Post: "+connects.getPass());
        Log.w("TESTING", "Are the values making it?" + connects.getName());
        return row;

    }


    static class ConnectHolder{
TextView tx_name,tx_title,tx_comment;



    }



}
