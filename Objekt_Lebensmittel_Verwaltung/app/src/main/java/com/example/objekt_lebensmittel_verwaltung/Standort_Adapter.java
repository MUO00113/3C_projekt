package com.example.objekt_lebensmittel_verwaltung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Standort_Adapter extends BaseAdapter {

    ArrayList<Standort> arrayList;
    int layoutID;
    LayoutInflater inflater;

    public Standort_Adapter(Context context, int layoutID, ArrayList<Standort> arrayList) {
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
        Standort standort = arrayList.get(position);
        View listItem = (convertView == null) ? inflater.inflate(this.layoutID, null) : convertView;
        ((TextView) listItem.findViewById(R.id.tv_name_ort)).setText(standort.getName());
        ((TextView) listItem.findViewById(R.id.tv_address_ort)).setText(standort.getAddress());
        return listItem;
    }
}
