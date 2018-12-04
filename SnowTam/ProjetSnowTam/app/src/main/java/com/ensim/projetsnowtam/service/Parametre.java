package com.ensim.projetsnowtam.service;

import java.io.Serializable;

public class Parametre implements Serializable {



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
}
