package com.example.objekt_lebensmittel_verwaltung;

import android.graphics.Color;

public class Objekt {

    private String name;
    private int color;

    public Objekt(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
