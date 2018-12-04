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
            this.snowtamDecoded = this.snowtamDecoded + decodeString(s);
        }
    }


    String decodeString(String s) {
        String decoded = "";


        if (s.contains("A) ")) {
            Log.d(TAG, "Le snowtam contien un A) ");
            decoded =  s + "\n";
        }
        if (s.contains("B) ")) {
            Log.d(TAG, "Le snowtam contien un B) ");
            decoded = decoded+"B) " + decodeB(s.split("B\\)")[1].split("[A-Z]" +"\\)")[0])+"\n";
        }
        if (s.contains("C) ")) {
            Log.d(TAG, "Le snowtam contien un C) ");
            decoded = decoded+"C) " + decodeC(s.split("C\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("D) ")) {
            decoded = decoded+"D) " + decodeD(s.split("D\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("E) ")) {
            decoded = decoded+"E) " + decodeE(s.split("E\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("F) ")) {
            decoded =decoded+ "F) " + decodeF(s.split("F\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("G) ")) {
            decoded =decoded+ "G) " + decodeG(s.split("G\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("H) ")) {
            decoded =decoded+ "H) " + decodeH(s.split("H\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("J) ")) {
            decoded =decoded+ "J) " + decodeJ(s.split("J\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("K) ")) {
            decoded = decoded+"K) " + decodeK(s.split("K\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("L) ")) {
            decoded = decoded+"L) " + decodeL(s.split("L\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("M) ")) {
            decoded =decoded+ "M) " + decodeM(s.split("M\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("N) ")) {
            decoded =decoded+ "N) " + decodeN(s.split("N\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("P) ")) {
            decoded =decoded+ "P) " + decodeP(s.split("P\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("R) ")) {
            decoded =decoded+ "R) " + decodeR(s.split("R\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("S) ")) {
            decoded = decoded+"S) " + decodeS(s.split("S\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if (s.contains("T) ")) {
            decoded = decoded+"T) " + decodeT(s.split("T\\)")[1].split("[A-Z]" + "\\)")[0])+"\n";
        }
        if(!(s.contains("A) ")||s.contains("B) ")||s.contains("C) ")||s.contains("D) ")||s.contains("E) ")||s.contains("F) ")||s.contains("G) ")||s.contains("H) ")||s.contains("J) ")||s.contains("K) ")||s.contains("L) ")||s.contains("M) ")||s.contains("N) ")||s.contains("P) ")||s.contains("R) ")||s.contains("S) ")||s.contains("T) "))){
            decoded=s;
        }

        return decoded;
    }

    String decodeB(String s) {
        String res="";
        String s1= s.substring(1,3);
        String s2= s.substring(3,5);
        String s3= s.substring(5,7);
        String s4= s.substring(7,9);
        switch (s1){
            case "01" :
                s1="Jan";
                break;
            case "02" :
                s1="Feb";
                break;
            case "03" :
                s1="Mar";
                break;
            case "04" :
                s1="Apr";
                break;
            case "05" :
                s1="May";
                break;
            case "06" :
                s1="Jun";
                break;
            case "07" :
                s1="Jul";
                break;
            case "08" :
                s1="Aug";
                break;
            case "09" :
                s1="Sep";
                break;
            case "10" :
                s1="Oct";
                break;
            case "11" :
                s1="Nov";
                break;
            case "12" :
                s1="Dec";
                break;
            default:
                break;

        }
        Log.d(TAG,"AZERTYUIO"+s2+" "+s1+" "+s3+":"+s4);
        res=s2+" "+s1+" "+s3+":"+s4;
        return res;
    }

    String decodeC(String s) {
        String res="RUNWAY";
        int numpiste = Integer.parseInt(s.replace(" ",""));
        if(numpiste<=36){
            res=res+" "+numpiste+" Left";
        }
        else if(numpiste<=86){
            numpiste=numpiste-50;
            res=res+" "+numpiste+"Right";
        }
        else if(numpiste==88){
            res="ALL "+res;
        }
        return res;
    }

    String decodeD(String s) {
        return "CLEARED RUNWAY LENGTH "+ s+"m";
    }

    String decodeE(String s) {
       String res="CLEARED RUNWAY WIDTH ";
        if (s.contains("L")){
            res=res+s.split("L")[0]+"m "+"Left";
        }
        else if(s.contains("R")){
            res=res+s.split("R")[0]+"m "+"Right";
        }
        else{
            res=res+s+"m";
        }
        return res;
    }

    String decodeF(String s) {
        String s1 = traduireF(s.split("\\/")[0].replace(" ",""));
        String s2 = traduireF(s.split("\\/")[1].replace(" ",""));
        String s3 = traduireF(s.split("\\/")[2].replace(" ",""));
        return "Threshold : "+s1+" \nMid runway : "+s2+"\nRoll out : "+s3;
    }

    String decodeG(String s) {
        return s;
    }

    String decodeH(String s) {
        return "HHHH" + s;
    }

    String decodeJ(String s) {
        String[] S1 = s.split("/");
        if(S1[1].contains("LR")){
            String[] S2 = S1[1].split("L");
            return  "CRITICAL SNOW BANK "+ S1[0] +"cm /"+ S2[0] +"m LEFT and RIGHT of Runway";
        }
        if(S1[1].contains("L")){
            String[] S2 = S1[1].split("L");
            return  "CRITICAL SNOW BANK "+ S1[0] +"cm /"+ S2[0] +"m LEFT of Runway";
        }
        if(S1[1].contains("R")){
            String[] S2 = S1[1].split("R");
            return  "CRITICAL SNOW BANK "+ S1[0] +"cm /"+ S2[0] +"m RIGHT of Runway";
        }

        return s;
    }

    String decodeK(String s) {
        if(s.contains("YES")){
            if(s.contains("LR")){
                return " Lights obscured: YES LEFT RIGHT of RUNWAY ";
            }
            if(s.contains("L")){
                return " Lights obscured: YES LEFT of RUNWAY ";
            }
            if(s.contains("R")){
                return " Lights obscured: YES RIGHT of RUNWAY ";
            }
        }
        return s;
    }

    String decodeL(String s) {
        if (s.equals("TOTAL")){
            return " FURTHER CLEARANCE : Total length and width of the runway";
        }else{
            String[] S1 = s.split("/");
            return " FURTHER CLEARANCE : "+ S1[0]+ " metres of length, and "+ S1[1] +" metres of width";
        }

    }

    String decodeM(String s) {
        String s1 = s.substring(1,3);
        String s2 = s.substring(3,5);

        return s1+":"+s2;
    }

    String decodeN(String s) {
        if(s.length()==1){
            return "taxiway contamination :" + traduireF(s);
        }
        if(s.equals("NO")){
            return "all aprons are unusable";
        }
        else{
            return s;
        }
    }

    String decodeP(String s) {
        if(s.length()>=3){
            String s1 = s.substring(1,4);
            String s2 = s.substring(4);

            if (s1.equals("YES")){
                return  "SNOW BANKS: YES SPACE "+ s2+"m" ;
            }
            else{
                return s;
            }
        }
        return s;
    }

    String decodeR(String s) {
        if(s.length()==1){
            return "aprons contamination :" + traduireF(s);
        }
        if(s.equals("NO")){
            return "all aprons are unusable";
        }
        else{
            return s;
        }
    }

    String decodeS(String s)
    {
        String res ="";
        String s1 = s.substring(1,3);
        String s2 = s.substring(3,5);
        String s3 = s.substring(5,7);
        String s4 = s.substring(7,9);
        switch (s1){
            case "01" :
                s1="Jan";
                break;
            case "02" :
                s1="Feb";
                break;
            case "03" :
                s1="Mar";
                break;
            case "04" :
                s1="Apr";
                break;
            case "05" :
                s1="May";
                break;
            case "06" :
                s1="Jun";
                break;
            case "07" :
                s1="Jul";
                break;
            case "08" :
                s1="Aug";
                break;
            case "09" :
                s1="Sep";
                break;
            case "10" :
                s1="Oct";
                break;
            case "11" :
                s1="Nov";
                break;
            case "12" :
                s1="Dec";
                break;
            default:
                break;
        }
            res = "Next observation"+ s2 + " " + s1 + " " + s3+":"+s4;

        return res;
    }

    String decodeT(String s) {
        return s;
    }




    String traduireF(String s){

        switch (s){
            case "0" :
                s="CLEAR AND DRY";
                break;
            case "1" :
                s="DAMP";
                break;
            case "2" :
                s="WET or WATER PATCHES";
                break;
            case "3" :
                s="RIME OR FROST COVERED";
                break;
            case "4" :
                s="DRY SNOW";
                break;
            case "5" :
                s="WET SNOW";
                break;
            case "6" :
                s="SLUSH";
                break;
            case "7" :
                s="ICE";
                break;
            case "8" :
                s="COMPACTED OR ROLLED SNOW";
                break;
            case "9" :
                s="FROZEN RUTS OR RIDGES";
                break;
            default:
                break;

        }

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
