package com.ensim.projetsnowtam.service;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Parametre implements Serializable, Parcelable {



    String langue;
    boolean choixAffichage;
    /* Afficher d'abord la carte ou d'abord les snowTam */
    boolean choixDecryptage;
    /* Afficher d'abord le snowTam décrypté ou crypté */

    public Parametre(String L,boolean aff, boolean crypt){
        langue = L;
        choixAffichage= aff;
        choixDecryptage=crypt;
    }





    public String getLangue() {
        return langue;
    }

    public boolean isChoixAffichage() {
        return choixAffichage;
    }

    public boolean isChoixDecryptage() {
        return choixDecryptage;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.langue);
        dest.writeByte(this.choixAffichage ? (byte) 1 : (byte) 0);
        dest.writeByte(this.choixDecryptage ? (byte) 1 : (byte) 0);
    }

    protected Parametre(Parcel in) {
        this.langue = in.readString();
        this.choixAffichage = in.readByte() != 0;
        this.choixDecryptage = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Parametre> CREATOR = new Parcelable.Creator<Parametre>() {
        @Override
        public Parametre createFromParcel(Parcel source) {
            return new Parametre(source);
        }

        @Override
        public Parametre[] newArray(int size) {
            return new Parametre[size];
        }
    };
}
