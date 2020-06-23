package com.example.objekt_lebensmittel_verwaltung;

import java.time.LocalDate;

public class Lebensmittel {

    private String name;
    private int stk;
    private LocalDate date;

    public Lebensmittel(String name, int stk) {
        this.name = name;
        this.stk = stk;
    }

    public Lebensmittel(String name, int stk, LocalDate date) {
        this.name = name;
        this.stk = stk;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStk() {
        return stk;
    }

    public void setStk(int stk) {
        this.stk = stk;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
