package com.ensim.projetsnowtam.service;

import java.util.ArrayList;


public class DataSearchAirportSnowtam {
    private int total;
    private ArrayList<AirportSnowtam> data;


    public ArrayList<AirportSnowtam> getData() {
        return data;
    }

    public void setData(ArrayList<AirportSnowtam> data) {
        this.data = data;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
