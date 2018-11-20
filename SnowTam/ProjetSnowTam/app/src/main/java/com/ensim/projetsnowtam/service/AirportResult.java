package com.ensim.projetsnowtam.service;

import android.os.Parcel;
import android.os.Parcelable;

public class AirportResult implements Parcelable{
    private String ICAO_Code;
    private double latitude;
    private double longitude;
    private String snowtam;

    public AirportResult() {
    }

    public AirportResult(String ICAO_Code, double latitude, double longitude, String snowtam) {
        this.ICAO_Code = ICAO_Code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.snowtam = snowtam;
    }



    public String getICAO_Code() {
        return ICAO_Code;
    }

    public void setICAO_Code(String ICAO_Code) {
        this.ICAO_Code = ICAO_Code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSnowtam() {
        return snowtam;
    }

    public void setSnowtam(String snowtam) {
        this.snowtam = snowtam;
    }




    protected AirportResult(Parcel in) {
        ICAO_Code = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        snowtam = in.readString();
    }

    public static final Creator<AirportResult> CREATOR = new Creator<AirportResult>() {
        @Override
        public AirportResult createFromParcel(Parcel in) {
            return new AirportResult(in);
        }

        @Override
        public AirportResult[] newArray(int size) {
            return new AirportResult[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ICAO_Code);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeString(snowtam);
    }


}
