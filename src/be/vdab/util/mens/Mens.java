package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Mens implements Comparable<Mens>, Serializable {

    private String naam;
    private Rijbewijs[] rijbewijs;

    public Mens(String naam) {
        this.naam = naam;
        rijbewijs = new Rijbewijs[0];
    }

    public Mens(String naam, Rijbewijs... args) {
        this.naam = naam;
        int i = 0;
        Rijbewijs[] temp = new Rijbewijs[args.length];
        for (Rijbewijs r1 : args) {
            if (!Arrays.asList(temp).contains(r1)) {
                temp[i] = r1;
                i++;
            }
        }
        rijbewijs = Arrays.copyOf(temp, i);
    }

    @Override
    public String toString() {
        if (this.rijbewijs.length == 0) {
            return this.naam;
        } else {
            return this.naam + "(" + Arrays.toString(rijbewijs).substring(1, Arrays.toString(rijbewijs).length() - 1) + ")";
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
    public int compareTo(Mens o) {
        return this.naam.compareTo(o.getNaam());
    }

    public boolean equals(Mens o) {
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
        if (!Arrays.deepEquals(this.rijbewijs, other.rijbewijs)) {
            return false;
        }
        return true;
    }
    
}
