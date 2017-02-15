/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Nummerplaat;
import be.vdab.voertuigen.div.DIV;
import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public abstract class Voertuig implements Comparable<Voertuig>, Serializable{
    
   private Nummerplaat nummerplaat;
   private String merk;
   private Datum datumEersteIngebruikname;
   private int aankoopprijs;
   private final int zitplaatsen;
   private Mens bestuurder;
   private List<Mens> mensen;
   
   protected abstract Rijbewijs[] getToegestaneRijbewijzen();
   protected abstract int getMAX_ZITPLAATSEN();

    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens ...args){
        this.nummerplaat = DIV.INSTANCE.getNummerplaat();
        this.merk = merk;
        this.datumEersteIngebruikname = datumEersteIngebruikname;
        this.aankoopprijs = aankoopprijs;
        this.zitplaatsen = zitplaatsen;
        mensen = new ArrayList<Mens>();
        try {
           this.bestuurder = bestuurder; 
           mensen.set(0, bestuurder); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Mens m: args){
                // check for right DL WHERE ???? merk?
            if(!m.getRijbewijs().toString().isEmpty()){
                //insert at 0 & shift others
                mensen.add(0, m);
                this.bestuurder = m;
            } else{
                // insert at end of list, at 1 if empty
                if(mensen.isEmpty()){
                    mensen.add(1, m);
                } else{
                    mensen.add(m);
                }
            }
        }
        
        
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public Datum getDatumEersteIngebruikname() {
        return datumEersteIngebruikname;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public Mens getBestuurder() {
        
          
           return this.bestuurder; 
    }   

    public List<Mens> getMensen() {
        return mensen;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setDatumEersteIngebruikname(Datum datumEersteIngebruikname) {
        this.datumEersteIngebruikname = datumEersteIngebruikname;
    }

    public void setAankoopprijs(int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public void setBestuurder(Mens bestuurder) {
        this.bestuurder = bestuurder;
        mensen.add(0, bestuurder);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nummerplaat);
        hash = 61 * hash + Objects.hashCode(this.merk);
        hash = 61 * hash + Objects.hashCode(this.datumEersteIngebruikname);
        hash = 61 * hash + this.aankoopprijs;
        hash = 61 * hash + this.zitplaatsen;
        hash = 61 * hash + Objects.hashCode(this.bestuurder);
        hash = 61 * hash + Objects.hashCode(this.mensen);
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
        final Voertuig other = (Voertuig) obj;
        if (!Objects.equals(this.nummerplaat, other.nummerplaat)) {
            return false;
        }
        return true;
    }
    @Override
    public int compareTo(Voertuig o) {
        
        return this.nummerplaat.compareTo(o.getNummerplaat());
    }
    
    static class MerkComparator implements Comparator<Voertuig>{
            public int compare(Voertuig e1, Voertuig e2) {
            return e1.getMerk().compareTo(e2.getMerk());
            }
        }
   public static Comparator<Voertuig> getMerkComparator(){
       return new Voertuig.MerkComparator();
   }

    static class AankoopprijsComparator implements Comparator<Voertuig>{
            public int compare(Voertuig e1, Voertuig e2) {
            return e1.getAankoopprijs()-(e2.getAankoopprijs());
            }
        }
     public static Comparator<Voertuig> getAankoopprijsComparator(){
       return new Voertuig.AankoopprijsComparator();
   }   
   
    

    
    public List getIngezetenen(){
        return this.mensen;
    }
    public List getIngezeteneExclusiefBestuurder(){
        List<Mens> zonderBestuurder = new ArrayList<Mens>(this.mensen);
        //Collections.copy(zonderBestuurder, this.mensen);
        zonderBestuurder.remove(0);
        return zonderBestuurder;
    }
    public void addIngezetene(Mens m){
        this.mensen.add(m);
    }
    public boolean isIngezetene(Mens m){
        return getIngezetenen().contains(m);
    }
}
