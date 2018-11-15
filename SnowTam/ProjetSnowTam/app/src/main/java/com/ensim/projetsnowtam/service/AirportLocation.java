package com.ensim.projetsnowtam.service;

public class AirportLocation {

    private String Terr_code;
    private String State_Name;
    private String ICAO_Code;
    private String AFTN;
    private String Location_Name;
    private String Lat;
    private String Long;
    private float Latitude;
    private float Longitude;
    private String codcoun;
    private String IATA_Code;
    private String ctry_code;


    // Getter Methods

    public String getTerr_code() {
        return Terr_code;
    }

    public String getState_Name() {
        return State_Name;
    }

    public String getICAO_Code() {
        return ICAO_Code;
    }

    public String getAFTN() {
        return AFTN;
    }

    public String getLocation_Name() {
        return Location_Name;
    }

    public String getLat() {
        return Lat;
    }

    public String getLong() {
        return Long;
    }

    public float getLatitude() {
        return Latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public String getCodcoun() {
        return codcoun;
    }

    public String getIATA_Code() {
        return IATA_Code;
    }

    public String getCtry_code() {
        return ctry_code;
    }

    // Setter Methods

    public void setTerr_code(String Terr_code) {
        this.Terr_code = Terr_code;
    }

    public void setState_Name(String State_Name) {
        this.State_Name = State_Name;
    }

    public void setICAO_Code(String ICAO_Code) {
        this.ICAO_Code = ICAO_Code;
    }

    public void setAFTN(String AFTN) {
        this.AFTN = AFTN;
    }

    public void setLocation_Name(String Location_Name) {
        this.Location_Name = Location_Name;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public void setLong(String Long) {
        this.Long = Long;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public void setCodcoun(String codcoun) {
        this.codcoun = codcoun;
    }

    public void setIATA_Code(String IATA_Code) {
        this.IATA_Code = IATA_Code;
    }

    public void setCtry_code(String ctry_code) {
        this.ctry_code = ctry_code;
    }
}
