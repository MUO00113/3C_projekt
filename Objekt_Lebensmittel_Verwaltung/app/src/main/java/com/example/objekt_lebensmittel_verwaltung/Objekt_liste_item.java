package com.example.objekt_lebensmittel_verwaltung;

public class Objekt_liste_item {

    String name;
    int menge;
    String mengenmass;

    public Objekt_liste_item(String name, int menge, String mengenmass) {
        this.name = name;
        this.menge = menge;
        this.mengenmass = mengenmass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getMengenmass() {
        return mengenmass;
    }

    public void setMengenmass(String mengenmass) {
        this.mengenmass = mengenmass;
    }
}
