package com.example.objekt_lebensmittel_verwaltung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ObjektActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objekt_activity_objekt);
        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if (intent == null)return;
        Objekt_fragment objektFragment = (Objekt_fragment) getSupportFragmentManager().findFragmentById(R.id.objekt_frag);
    }
}