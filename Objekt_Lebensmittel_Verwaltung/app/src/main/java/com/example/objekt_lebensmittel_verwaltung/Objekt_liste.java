package com.example.objekt_lebensmittel_verwaltung;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class Objekt_liste extends Fragment {
    View view;
    Button bt_add_objektlist;
    ListView lv_objektlist;
    TextView tv_objektlist_title;
    Spinner spinner;
    ArrayList<Objekt_liste_item> objekt_liste_items = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public Objekt_liste() {
        // Required empty public constructor
    }


    public static Objekt_liste newInstance(String param1, String param2) {
        Objekt_liste fragment = new Objekt_liste();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_objekt_liste, container, false);

        tv_objektlist_title = view.findViewById(R.id.tv_objekt_list_ueberschrift);
        Objekt_fragment fragment = new Objekt_fragment();
//        tv_objektlist_title.setText("Bücher");
        bt_add_objektlist = (Button) view.findViewById(R.id.bt_objekt_liste);
        bt_add_objektlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeView(view);
            }
        });

        return view;
    }

    private void initializeView(View view) {
        lv_objektlist = (ListView) view.findViewById(R.id.objekt_liste_lv);

        final View vDialog = getLayoutInflater().inflate(R.layout.layout_objekt_liste_dialog, null);
        AlertDialog.Builder dialog_objekt_liste = new AlertDialog.Builder(view.getContext());
        dialog_objekt_liste.setMessage("Bitte ausfüllen:");

        spinner = (Spinner) vDialog.findViewById(R.id.spinner_objekt_liste);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.massliste));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        dialog_objekt_liste.setCancelable(false)
                .setView(vDialog)
                .setPositiveButton("ok", (dialog, which) -> handleDialog(vDialog))
                .setNegativeButton("Cancle", null)
                .show();

        Objekt_liste_Adapter objekt_liste_adapter = new Objekt_liste_Adapter(getActivity(), R.layout.lv_objekt_liste, objekt_liste_items);
        lv_objektlist.setAdapter(objekt_liste_adapter);
    }

    private void handleDialog(View vDialog) {
        EditText txtname = vDialog.findViewById(R.id.et_name_objekt_liste);
        String obj_list_name = txtname.getText().toString();
        EditText txtmenge = vDialog.findViewById(R.id.et_menge_objekt_liste);
        int obj_list_menge = Integer.parseInt(txtmenge.getText().toString());
        String obj_list_mass = spinner.getSelectedItem().toString();
        Objekt_liste_item item = new Objekt_liste_item(obj_list_name, obj_list_menge, obj_list_mass);
        objekt_liste_items.add(item);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
