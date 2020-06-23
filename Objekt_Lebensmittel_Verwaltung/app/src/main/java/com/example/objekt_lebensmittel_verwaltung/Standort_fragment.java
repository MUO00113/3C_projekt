package com.example.objekt_lebensmittel_verwaltung;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.LOCATION_SERVICE;


public class Standort_fragment extends Fragment {

    private static final String TAG = Standort_fragment.class.getSimpleName();
    private ListView list;
    private ArrayList<Standort> orte = new ArrayList<>();
   // private ArrayList<String> ort_names = new ArrayList<>();
    View view;
    Button add_ort_bt;
    LocationManager manager;
    int RQ_ACCESS_FINE_LOCATION;

    private OnSelectionChangedListener mListener;

    public Standort_fragment() {
        // Required empty public constructor
    }

    public static Standort_fragment newInstance(String param1, String param2) {
        Standort_fragment fragment = new Standort_fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        *//*if (requestCode == RQ_ACCESS_FINE_LOCATION)
        {
            if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED)
            {
                //nicht erlaubt
            }
            else
            {
                //erlaubt
            }
        }*//*
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.d(TAG,"onCreate: entered");
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_standort_fragment, container, false);

        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, RQ_ACCESS_FINE_LOCATION);
        }


        add_ort_bt = (Button) view.findViewById(R.id.add_standort_bt);
        add_ort_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeView(view);
            }
        });

        /*list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Objekt_fragment.class);
                startActivity(intent);
            }
        });*/

        return view;
    }



    private void initializeView(View view)
    {
        list = view.findViewById(R.id.standort_lv);
        final View vDialog = getLayoutInflater().inflate(R.layout.layout_standort_dialog, null);
        AlertDialog.Builder dialog_ort = new AlertDialog.Builder(view.getContext());
        dialog_ort.setMessage("Bitte Name vergeben:")
                .setCancelable(false)
                .setView(vDialog)
                .setPositiveButton("ok", (dialog, which) -> handleDialog(vDialog))
                .setNegativeButton("Cancle", null)
                .show();

        Standort_Adapter adapter = new Standort_Adapter(getActivity(), R.layout.lv_standort, orte);
        list.setAdapter(adapter);

    }

    private void handleDialog(View vDialog) {
        EditText txtname = vDialog.findViewById(R.id.et_name_standort);
        String ort_name = txtname.getText().toString();


        GPS_traker gpsTraker = new GPS_traker(getActivity());
        Location location = gpsTraker.getLocation();
        String str_location = "";
        if (location != null)
        {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            str_location = "Latitude: "+Double.toString(lat) + ", Longitude: " + Double.toString(lon);
        }
        Standort standort = new Standort(ort_name, str_location);
        orte.add(standort);
    }


    /*@Override
    public void onStart() {
        super.onStart();
        ArrayAdapter<Standort> standortArrayAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, orte);
//        list.setAdapter(standortArrayAdapter);
    }*/

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectionChangedListener) {
            mListener = (OnSelectionChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
