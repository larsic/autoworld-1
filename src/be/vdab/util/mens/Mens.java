/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Mens implements Comparable<Mens>{
   
    private String naam;
    private Rijbewijs [] rijbewijs;

    public Mens(String naam) {
        this.naam = naam;
        rijbewijs = new Rijbewijs [0];
    }
    
    

    public Mens(String naam, Rijbewijs r) {
        this.naam = naam;
        rijbewijs = new Rijbewijs [1];
        this.rijbewijs[0] = r;        
        
    }

    public Mens(String naam, Rijbewijs r, Rijbewijs s) {
        int i = 0;
        this.naam = naam;
        Rijbewijs[] rijbewijstemp = new Rijbewijs [2];
        rijbewijstemp[0] = r;
        i++;
        if(!r.equals(s)){ rijbewijstemp[i] = s; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
        
        
    }
    public Mens(String naam, Rijbewijs r, Rijbewijs s, Rijbewijs t) {
        int i = 0;
        this.naam = naam;
        Rijbewijs[] rijbewijstemp = new Rijbewijs [3];
        rijbewijstemp[0] = r;
        i++;
        if(!s.equals(r)){ rijbewijstemp[i] = s; i++;}
        if(!t.equals(r) && !t.equals(s)){ rijbewijstemp[i] = t; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
    }
    
    public Mens(String naam, Rijbewijs r, Rijbewijs s, Rijbewijs t, Rijbewijs u) {
        int i = 0;
        this.naam = naam;
        Rijbewijs[] rijbewijstemp = new Rijbewijs [4];
        rijbewijstemp[0] = r;
        i++;
        if(!s.equals(r)){ rijbewijstemp[i] = s; i++;}
        if(!t.equals(r) && !t.equals(s)){ rijbewijstemp[i] = t; i++;}
        if(!u.equals(r) && !u.equals(s) && !u.equals(t)){ rijbewijstemp[i] = u; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
        
    }
    public Mens(String naam, Rijbewijs r, Rijbewijs s, Rijbewijs t, Rijbewijs u, Rijbewijs v) {
        int i = 0;
        this.naam = naam;
        Rijbewijs[] rijbewijstemp = new Rijbewijs [5];
        rijbewijstemp[0] = r;
        i++;
        if(!s.equals(r)){ rijbewijstemp[i] = s; i++;}
        if(!t.equals(r) && !t.equals(s)){ rijbewijstemp[i] = t; i++;}
        if(!u.equals(r) && !u.equals(s) && !u.equals(t)){ rijbewijstemp[i] = u; i++;}
        if(!v.equals(r) && !v.equals(s) && !v.equals(t) && !v.equals(u)){ rijbewijstemp[i] = v; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
    }
    
    public Mens(String naam, Rijbewijs r, Rijbewijs s, Rijbewijs t, Rijbewijs u, Rijbewijs v, Rijbewijs w) {
        int i = 0;
        this.naam = naam;
        Rijbewijs[] rijbewijstemp = new Rijbewijs [6];
        rijbewijstemp[0] = r;
        i++;
        if(!s.equals(r)){ rijbewijstemp[i] = s; i++;}
        if(!t.equals(r) && !t.equals(s)){ rijbewijstemp[i] = t; i++;}
        if(!u.equals(r) && !u.equals(s) && !u.equals(t)){ rijbewijstemp[i] = u; i++;}
        if(!v.equals(r) && !v.equals(s) && !v.equals(t) && !v.equals(u)){ rijbewijstemp[i] = v; i++;}
        if(!w.equals(r) && !w.equals(s) && !w.equals(t) && !w.equals(u) && !w.equals(v)){ rijbewijstemp[i] = w; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
    }
    
    public Mens(String naam, Rijbewijs r, Rijbewijs s, Rijbewijs t, Rijbewijs u, Rijbewijs v, Rijbewijs w, Rijbewijs x) {
        int i = 0;
        this.naam = naam;
       Rijbewijs[] rijbewijstemp = new Rijbewijs [7];
        rijbewijstemp[0] = r;
        i++;
        if(!s.equals(r)){ rijbewijstemp[i] = s; i++;}
        if(!t.equals(r) && !t.equals(s)){ rijbewijstemp[i] = t; i++;}
        if(!u.equals(r) && !u.equals(s) && !u.equals(t)){ rijbewijstemp[i] = u; i++;}
        if(!v.equals(r) && !v.equals(s) && !v.equals(t) && !v.equals(u)){ rijbewijstemp[i] = v; i++;}
        if(!w.equals(r) && !w.equals(s) && !w.equals(t) && !w.equals(u) && !w.equals(v)){ rijbewijstemp[i] = w; i++;}
        if(!x.equals(r) && !x.equals(s) && !x.equals(t) && !x.equals(u) && !x.equals(v) && !x.equals(w)){ rijbewijstemp[i] = x; i++;}
        //rijbewijs = new String [i];
        rijbewijs = Arrays.copyOf(rijbewijstemp, i);
    }
    

    @Override
    public String toString() {
        if(this.rijbewijs.length == 0){
            return this.naam;
        }
        else if (this.rijbewijs.length == 1){
            return this.naam + "(" +this.rijbewijs[0]+")";
        }
        else{
            String rrr = "";
            for (Rijbewijs s: this.rijbewijs){
                      rrr = rrr+s+", ";  
                    }
            rrr = rrr.substring(0, rrr.length()-2);
            return this.naam + "(" + rrr + ")";
                    
        }
    }

    public String getNaam() {
        return naam;
    }

    public Rijbewijs[] getRijbewijs() {
        return rijbewijs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.naam);
        hash = 79 * hash + Arrays.deepHashCode(this.rijbewijs);
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
        final Mens other = (Mens) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.rijbewijs, other.rijbewijs)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Mens o) {
              
            return this.naam.compareTo(o.getNaam());
    }     
   
    public boolean equals(Mens o){
        
        if (o == null) {
            return false;
        }
               
        if (!this.naam.equals(o.getNaam())) {
            return false;
        }

        if (!Arrays.equals(this.rijbewijs, o.getRijbewijs())) {
            return false;
        }

        return true;
        
    }
    
        
    
}
