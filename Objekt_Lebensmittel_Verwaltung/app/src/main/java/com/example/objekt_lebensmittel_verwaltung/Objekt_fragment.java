package com.example.objekt_lebensmittel_verwaltung;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Objekt_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Objekt_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Objekt_fragment extends Fragment {
    View view;
    Button objekt_bt;
    ListView list;
    ArrayList<Objekt>objekts = new ArrayList<>();
    LinearLayout linearLayout;
    int defaultColor;
    public int newcolor;

    private OnSelectionChangedListener mListener;

    public Objekt_fragment() {
        // Required empty public constructor
    }

    public static Objekt_fragment newInstance(String param1, String param2) {
        Objekt_fragment fragment = new Objekt_fragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_objekt_fragment, container, false);
        //Switch aSwitch = (Switch) view.findViewById(R.id.)

        //if (){}
        ArrayList<Objekt>lebensmittel = new ArrayList<>();
        Objekt objekt = new Objekt("Lebensmittel", R.color.colorPrimary);
        lebensmittel.add(objekt);
        list = view.findViewById(R.id.objekt_lv);
        Objekt_Adapter adapter = new Objekt_Adapter(getActivity(), R.layout.lv_objekt, lebensmittel);
        list.setAdapter(adapter);

        objekt_bt = view.findViewById(R.id.add_objekt_bt);
        objekt_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeView(view);
            }
        });

        return view;
    }

    private void initializeView(View view) {
        list = view.findViewById(R.id.objekt_lv);
        final View vDialog = getLayoutInflater().inflate(R.layout.layout_objekt_dialog, null);
        AlertDialog.Builder dialog_obj = new AlertDialog.Builder(view.getContext());
        dialog_obj.setMessage("Bitte Name vergeben")
                .setCancelable(false)
                .setView(vDialog)
                .setPositiveButton("ok", (dialog, which) -> handleDialog(vDialog))
                .setNegativeButton("Cancle", null)
                .show();

        Objekt_Adapter adapter = new Objekt_Adapter(getActivity(), R.layout.lv_objekt, objekts);
        list.setAdapter(adapter);
    }

    private void handleDialog(View vDialog) {
        EditText txtname = vDialog.findViewById(R.id.dialog_objekt_et);
        String obj_name = txtname.getText().toString();

        /*final View vDialog2 = getLayoutInflater().inflate(R.layout.layout_objekt_colourpicker, null);
        AlertDialog.Builder dialog_color = new AlertDialog.Builder(view.getContext());
        dialog_color.setMessage("Farbe wählen:")
                .setCancelable(false)
                .setView(vDialog2)
                .setPositiveButton("ok", (dialog, which) -> handleDialog2(vDialog2, obj_name))
                .setNegativeButton("Cancle", null)
                .show();*/
        linearLayout = (LinearLayout) vDialog.findViewById(R.id.color_layout);
        defaultColor = ContextCompat.getColor(vDialog.getContext(), R.color.colorPrimary);
        openColorPicker();

        Objekt objekt = new Objekt(obj_name, newcolor);
        objekts.add(objekt);

    }

   /* private void handleDialog2(View vDialog2, String obj_name) {
        linearLayout = (LinearLayout) vDialog2.findViewById(R.id.color_layout);
        defaultColor = ContextCompat.getColor(vDialog2.getContext(), R.color.colorPrimary);
        openColorPicker();
        Objekt objekt = new Objekt(obj_name, defaultColor);
        objekts.add(objekt);
    }*/

    private void openColorPicker() {

        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(getActivity(), defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {


            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
               newcolor = color;

            }
        });
        colorPicker.show();
    }


    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
