package com.example.objekt_lebensmittel_verwaltung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Objekt_liste_Adapter extends BaseAdapter {

    ArrayList<Objekt_liste_item> arrayList;
    int layoutID;
    LayoutInflater inflater;

    public Objekt_liste_Adapter(Context context, int layoutID, ArrayList<Objekt_liste_item> arrayList) {
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
        Objekt_liste_item objektListeItem = arrayList.get(position);
        View listItem = (convertView == null) ? inflater.inflate(this.layoutID, null) : convertView;
        ((TextView) listItem.findViewById(R.id.name_tv_objekt_lidte)).setText(objektListeItem.getName());
        ((TextView) listItem.findViewById(R.id.menge_tv_objekt_liste)).setText(String.valueOf(objektListeItem.getMenge()));
        ((TextView) listItem.findViewById(R.id.massangaben_tv_objekt_liste)).setText(objektListeItem.getMengenmass());
        return listItem;
    }
}
