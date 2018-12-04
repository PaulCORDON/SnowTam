package com.ensim.projetsnowtam.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class AirportResult implements Parcelable {
    private static final String TAG = "AirportResult";
    private String ICAO_Code;
    private double latitude;
    private double longitude;
    private String snowtam;
    private String snowtamDecoded;
    private boolean isOnTarget;

    public AirportResult() {
    }

    public AirportResult(String ICAO_Code, double latitude, double longitude, String snowtam, String snowtamDecoded, boolean isOnTarget) {
        this.ICAO_Code = ICAO_Code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.snowtam = snowtam;
        this.snowtamDecoded = snowtamDecoded;
        this.isOnTarget = isOnTarget;
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

    public boolean isOnTarget() {
        return isOnTarget;
    }

    public void setOnTarget(boolean onTarget) {
        isOnTarget = onTarget;
    }

    public String getSnowtamDecoded() {
        return snowtamDecoded;
    }

    public void setSnowtamDecoded(String snowtam) {
        //TODO décodé comme il faut
        this.snowtamDecoded = "";
        for (String s : snowtam.split("\n")) {
            this.snowtamDecoded = this.snowtamDecoded + decodeString(s) + "\n";
        }
    }


    String decodeString(String s) {
        String decoded = "";


        if (s.contains("A) ")) {
            decoded =  s + "\n";
        }
        if (s.contains("B) ")) {
            decoded = "B) " + decodeB(s.split("B\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("C) ")) {
            Log.d(TAG, "Le snowtam contien un C) ");
            decoded = "C) " + decodeC(s.split("C\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("D) ")) {
            decoded = "D) " + decodeD(s.split("D\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("E) ")) {
            decoded = "E) " + decodeE(s.split("E\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("F) ")) {
            decoded = "F) " + decodeF(s.split("F\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("G) ")) {
            decoded = "G) " + decodeG(s.split("G\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("H) ")) {
            decoded = "H) " + decodeH(s.split("H\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("J) ")) {
            decoded = "J) " + decodeJ(s.split("J\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("K) ")) {
            decoded = "K) " + decodeK(s.split("K\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("L) ")) {
            decoded = "L) " + decodeL(s.split("L\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("M) ")) {
            decoded = "M) " + decodeM(s.split("M\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("N) ")) {
            decoded = "N) " + decodeN(s.split("N\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("P) ")) {
            decoded = "P) " + decodeP(s.split("P\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("R) ")) {
            decoded = "R) " + decodeR(s.split("R\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("S) ")) {
            decoded = "S) " + decodeS(s.split("S\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if (s.contains("T) ")) {
            decoded = "T) " + decodeT(s.split("T\\)")[1].split("(?=[A-Z])" + "\\)")[0])+"\n";
        }
        if(!(s.contains("A) ")||s.contains("B) ")||s.contains("C) ")||s.contains("D) ")||s.contains("E) ")||s.contains("F) ")||s.contains("G) ")||s.contains("H) ")||s.contains("J) ")||s.contains("K) ")||s.contains("L) ")||s.contains("M) ")||s.contains("N) ")||s.contains("P) ")||s.contains("R) ")||s.contains("S) ")||s.contains("T) "))){
            decoded=s;
        }

        return decoded;
    }

    String decodeB(String s) {
        return s;
    }

    String decodeC(String s) {
        Log.d(TAG, s);
        return "piste : " + s;
    }

    String decodeD(String s) {
        return "DDDD" + s;
    }

    String decodeE(String s) {
        return s;
    }

    String decodeF(String s) {
        return s;
    }

    String decodeG(String s) {
        return s;
    }

    String decodeH(String s) {
        return "HHHH" + s;
    }

    String decodeJ(String s) {
        return s;
    }

    String decodeK(String s) {
        return s;
    }

    String decodeL(String s) {
        return s;
    }

    String decodeM(String s) {
        return s;
    }

    String decodeN(String s) {
        return s;
    }

    String decodeP(String s) {
        return s;
    }

    String decodeR(String s) {
        return s;
    }

    String decodeS(String s) {
        return s;
    }

    String decodeT(String s) {
        return s;
    }


    protected AirportResult(Parcel in) {
        ICAO_Code = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        snowtam = in.readString();
        snowtamDecoded = in.readString();
        isOnTarget = in.readByte() != 0;
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
        parcel.writeByte((byte) (isOnTarget ? 1 : 0));
    }


}
