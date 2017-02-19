package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {

    private Volume laadvolume;
    private String kleur;

    public Boekentas(String kleur, Volume laadvolume) {
        this.laadvolume = laadvolume;
        this.kleur = kleur;
        if (laadvolume == null || kleur == null) {
            throw new IllegalArgumentException();
        }
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
        if (kleur == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadVolume) {
        this.laadvolume = laadVolume;
        if (laadvolume == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.laadvolume);
        hash = 19 * hash + Objects.hashCode(this.kleur);
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
        final Boekentas other = (Boekentas) obj;
        if (!Objects.equals(this.laadvolume, other.laadvolume)) {
            return false;
        }
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boekentas " + kleur + " " + laadvolume;
    }

}
