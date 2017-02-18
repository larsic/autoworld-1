/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Personenwagen extends Voertuig implements Serializable {
    
   private Color kleur;

    public Personenwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... args) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, args);
        this.kleur = kleur;
        if(zitplaatsen>8){
            throw new IllegalArgumentException();
        }
    }

      

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }
   
   

    @Override
    Rijbewijs[] getToegestaneRijbewijzen() {
        Rijbewijs[] pw = new Rijbewijs[2];
        pw[0] = Rijbewijs.B;
        pw[1] = Rijbewijs.BE;
        return pw;
    }

    @Override
    int getMAX_ZITPLAATSEN() {
        return 8;
    }

    @Override
    public String toString() {
        return super.toString() + " " + super.getZitplaatsen();
    }
    
    
}
