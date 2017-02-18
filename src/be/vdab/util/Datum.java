/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Datum implements Comparable<Datum>, Serializable{
    
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar){
        
        if(maand == 2){
            if (jaar%4==0 && jaar%100!=0 || jaar%400==0){
                if ((dag<1 || dag>29)){
                   throw new DatumException("Day out of bounds; 1 - 29"); 
                } else {
                    this.dag = dag;
                }
            } else {
                if ((dag<1 || dag>28)){
                   throw new DatumException("Day out of bounds, 1 - 28"); 
                } else {
                    this.dag = dag;
                }
            }
            this.maand = maand;
            
        } else if (maand == 4 || maand == 6 || maand == 9 || maand == 11) {
            if ((dag<1 || dag>30)){
                   throw new DatumException("Day out of bounds, 1 - 30"); 
                } else {
                    this.dag = dag;
                }
            this.maand = maand;
            
        } else if (maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12) {
            if ((dag<1 || dag>31)){
                   throw new DatumException("Day out of bounds, 1 - 31"); 
                } else {
                    this.dag = dag;
                }
            this.maand = maand;
            
        } else {
            throw new DatumException("Month out of bounds");
        }

         if (jaar<1583 || jaar>4099){
            throw new DatumException("Year out of bounds");
        } else {
            this.jaar = jaar;
        }
        
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        String d;
        String m;
        
        if(dag<10){
           d = "0"+dag; 
        } else {
            d = ""+dag;
        }
        if(maand<10){
           m = "0"+maand; 
        } else {
            m = ""+maand;
        }
       
        
        return d + "/" + m + "/" + jaar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.dag;
        hash = 79 * hash + this.maand;
        hash = 79 * hash + this.jaar;
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
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Datum o){
        if(this.jaar != o.getJaar()){
           return this.jaar - o.getJaar();
        }
        else if (this.maand != o.getMaand()){
            return this.maand - o.getMaand();
        } else {
            
            return this.dag - o.getDag(); 
        } 
    } 
    
    
    
    
    
    
}
