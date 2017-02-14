/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author frank.roelants
 */
public class Nummerplaat implements Comparable<Nummerplaat>, Serializable{
    
    private String plaat;
    
    
    
    

    Nummerplaat(String plaat){
        
        this.plaat = plaat;
        
        
        
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.plaat);
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
        final Nummerplaat other = (Nummerplaat) obj;
        if (!Objects.equals(this.plaat, other.plaat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.plaat;
    }

    @Override
    public int compareTo(Nummerplaat o) {
        
        return this.plaat.compareTo(o.getPlaat());
    }
    
    
    
    
    
    
}
