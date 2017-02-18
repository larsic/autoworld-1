/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Volume implements Comparable<Volume>, Serializable{
   private int hoogte;
   private int breedte;
   private int diepte;
   private Maat maat;
   
    public Volume(int hoogte, int breedte, int diepte, Maat maat) {
        if(hoogte<0 || breedte<0 || diepte<0){
            throw new VolumeException();
        } else {
           this.hoogte = hoogte;
           this.breedte = breedte;
           this.diepte = diepte;
           this.maat = maat; 
        }
    }

    public int getHoogte() {
         return hoogte;
    }

    public int getBreedte() {
         return breedte;
    }

    public int getDiepte() {
         return diepte;
    }

    public Maat getMaat() {
        return maat;
    }

   public long getVolume(){
        long h;
        long b;
        long d;
       if(maat.equals(Maat.meter)){
           h = hoogte*100L;
           b = breedte*100L;
           d = diepte*100L;
       } else if(maat.equals(Maat.decimeter)){
           h = hoogte*10L;
           b = breedte*10L;
           d = diepte*10L;
       } else {
           h = hoogte*1L;
           b = breedte*1L;
           d = diepte*1L;
       }
           return h*b*d;
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.hoogte;
        hash = 47 * hash + this.breedte;
        hash = 47 * hash + this.diepte;
        hash = 47 * hash + Objects.hashCode(this.maat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Volume other = (Volume) obj;
        if (this.hoogte != other.hoogte) {
            return false;
        }
        if (this.breedte != other.breedte) {
            return false;
        }
        if (this.diepte != other.diepte) {
            return false;
        }
        if (this.maat != other.maat) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Volume o) {
           return (int) ( this.getVolume()-o.getVolume());  
    }

    @Override
    public String toString() {
        return hoogte + "(h)x" + breedte + "(b)x" + diepte + "(d) " + maat;
    }
}
