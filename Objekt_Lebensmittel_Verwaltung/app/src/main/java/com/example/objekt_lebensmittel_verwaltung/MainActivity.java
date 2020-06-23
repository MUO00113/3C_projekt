package com.example.objekt_lebensmittel_verwaltung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnSelectionChangedListener {

//    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    //public static FragmentManager fragmentManager;
    private Objekt_fragment objekt_fragment;
    private Objekt_liste objekt_liste;
    private boolean showObj = false;
    private boolean showObjlist = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objekt_fragment = (Objekt_fragment) getSupportFragmentManager().findFragmentById(R.id.objekt_frag);
        showObj = objekt_fragment != null && objekt_fragment.isInLayout();
        objekt_liste = (Objekt_liste) getSupportFragmentManager().findFragmentById(R.id.objekt_list_frag);
        showObjlist = objekt_liste != null && objekt_liste.isInLayout();

    }

    @Override
    public void onSelectionChanged(int pos, String itemname) {
        if (showObj);
        else if (showObjlist);
        //else
    }
}
