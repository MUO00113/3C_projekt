package com.example.objekt_lebensmittel_verwaltung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Objekt_Adapter extends BaseAdapter {

    ArrayList<Objekt> arrayList;
    int layoutID;
    LayoutInflater inflater;

    public Objekt_Adapter(Context context, int layoutID, ArrayList<Objekt> arrayList) {
        this.arrayList = arrayList;
        this.layoutID = layoutID;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Objekt objekt = arrayList.get(position);
        String name = objekt.getName();
        int color = objekt.getColor();
        View listItem = (convertView == null) ? inflater.inflate(this.layoutID, null) : convertView;
        TextView tv = ((TextView) listItem.findViewById(R.id.tv_name_objekt));
        /*if (name.equals(null) == true)
        {
            tv.setText("niki");
        }
        else if (name.equals(null) == false)
        {
            tv.setText("basti");
        }*/
        tv.setText(name);
        tv.getText();
        ((TextView) listItem.findViewById(R.id.tv_farbe)).setBackgroundColor(color);
        return listItem;

    }

}

