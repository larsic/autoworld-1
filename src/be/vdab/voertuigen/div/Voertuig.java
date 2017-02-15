/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public abstract class Voertuig {
    
   private Nummerplaat nummerplaat;
   private String merk;
   private Datum DatumEersteIngebruikname;
   private int Aankoopprijs;
   private final int Zitplaatsen;
   private Mens m;
   private List<Mens> mensen;

    public Voertuig(String merk, Datum DatumEersteIngebruikname, int Aankoopprijs, int Zitplaatsen, Mens ...args){
        this.nummerplaat = DIV.INSTANCE.getNummerplaat();
        this.merk = merk;
        this.DatumEersteIngebruikname = DatumEersteIngebruikname;
        this.Aankoopprijs = Aankoopprijs;
        this.Zitplaatsen = Zitplaatsen;
        mensen = new ArrayList<Mens>();
        for(Mens m: args){
                // check for right DL WHERE ???? merk?
            if(!m.getRijbewijs().toString().isEmpty()){
                //insert at 0 & shift others
                mensen.add(0, m);
            } else{
                // insert at end of list, at 1 if empty
                if(mensen.isEmpty()){
                    mensen.add(1, m);
                } else{
                    mensen.add(m);
                }
            }
        }
        try {
           this.m = mensen.get(0); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
   
   
   
   
   
}
