package com.ensim.projetsnowtam.service;

import android.os.Parcel;
import android.os.Parcelable;

public class AirportResult implements Parcelable{
    private String ICAO_Code;
    private double latitude;
    private double longitude;
    private String snowtam;
    private String snowtamDecoded;

    public AirportResult() {
    }

    public AirportResult(String ICAO_Code, double latitude, double longitude, String snowtam,String snowtamDecoded) {
        this.ICAO_Code = ICAO_Code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.snowtam = snowtam;
        this.snowtamDecoded=snowtamDecoded;
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
    public String getSnowtamDecoded() {
        return snowtamDecoded;
    }

    public void setSnowtamDecoded(String snowtam) {
        this.snowtamDecoded="";
        for(String s : snowtam.split("\n")){
            if(s.contains("A) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nA) ";
            }
            else if(s.contains("B) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nB) ";
            }
            else if(s.contains("C) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nC) ";
            }
            else if(s.contains("D) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nD) ";
            }
            else if(s.contains("E) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nE) ";
            }
            else if(s.contains("F) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nF) ";
            }
            else if(s.contains("G) ")){
                this.snowtamDecoded = this.snowtamDecoded+"\nG) ";
            }
            else{
                this.snowtamDecoded = this.snowtamDecoded+s;
            }
        }
    }



    protected AirportResult(Parcel in) {
        ICAO_Code = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        snowtam = in.readString();
        snowtamDecoded=in.readString();
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
        parcel.writeString(snowtamDecoded);
    }


}
