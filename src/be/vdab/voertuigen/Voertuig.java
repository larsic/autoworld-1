/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public abstract class Voertuig implements Serializable, Comparable<Voertuig> {

    private Nummerplaat nummerplaat;
    private String merk;
    private Datum datumEersteIngebruikname;
    private int aankoopprijs;
    private final int zitplaatsen;
    private ArrayList<Mens> mensen;

    abstract Rijbewijs[] getToegestaneRijbewijzen();

    abstract int getMAX_ZITPLAATSEN();

    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... args) {
        this.nummerplaat = DIV.INSTANCE.getNummerplaat();
        this.merk = merk;
        this.datumEersteIngebruikname = datumEersteIngebruikname;
        this.aankoopprijs = aankoopprijs;
        mensen = new ArrayList<Mens>();
        if (zitplaatsen > 0) {
            this.zitplaatsen = zitplaatsen;
        } else {
            throw new IllegalArgumentException("geen zitplaatsen");
        }

        boolean match = false;
        for (Rijbewijs a : this.getToegestaneRijbewijzen()) {
            for (Rijbewijs b : bestuurder.getRijbewijs()) {
                if (a == b) {
                    match = true;
                    break;
                }
            }
        }

        if (match) {
            mensen.add(0, bestuurder);
        } else {
            throw new MensException("fout rijbewijs");
        }

        for (Mens m : args) {

            if (!isIngezetene(m)) {
                mensen.add(m);
            }
            if (mensen.size() > this.zitplaatsen) {
                throw new MensException();
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
        return mensen.get(0);
    }

    public ArrayList<Mens> getMensen() {
        return mensen;
    }

    public ArrayList getIngezetenen() {
        ArrayList<Mens> passagiers = new ArrayList<Mens>(this.mensen);
        Collections.sort(passagiers);
        return passagiers;
    }

    public ArrayList getIngezeteneExclusiefBestuurder() {
        ArrayList<Mens> zonderBestuurder = new ArrayList<Mens>(this.mensen);
        zonderBestuurder.remove(0);
        Collections.sort(zonderBestuurder);
        return zonderBestuurder;
    }

    public void addIngezetene(Mens m) {
        if (!isIngezetene(m)) {
            if (mensen.size() < this.getMAX_ZITPLAATSEN()) {
                this.mensen.add(m);
            } else {
                throw new MensException("geen plaats");
            }
        }
    }

    public boolean isIngezetene(Mens m) {
        return this.mensen.contains(m);
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

        boolean match = false;
        for (Rijbewijs a : this.getToegestaneRijbewijzen()) {
            for (Rijbewijs b : bestuurder.getRijbewijs()) {
                if (a == b) {
                    match = true;
                    break;
                }
            }
        }

        if (bestuurder.getRijbewijs().length != 0) {
            if (match) {
                // wijzig inizttende nr bestuurder
                if (isIngezetene(bestuurder)) {
                    mensen.remove(bestuurder);
                    mensen.add(0, bestuurder);

                } else {
                    if (this.zitplaatsen < this.mensen.size() + 1) {
                        throw new MensException("geen plaaats meer");
                    } else {

                        mensen.add(0, bestuurder);
                    }
                }
            } else {
                throw new MensException("fout rijbewijs");
            }
        } else {
            throw new MensException("geen rijbewijs");
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nummerplaat);
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
        Voertuig other = (Voertuig) obj;
        if (!Objects.equals(nummerplaat, other.nummerplaat)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Voertuig o) {

        return this.nummerplaat.compareTo(o.getNummerplaat());
    }

    static class MerkComparator implements Comparator<Voertuig>, Serializable {

        @Override
        public int compare(Voertuig e1, Voertuig e2) {
            if (e1.getMerk().compareTo(e2.getMerk()) != 0) {
                return e1.getMerk().compareTo(e2.getMerk());
            } else {
                return e1.getNummerplaat().compareTo(e2.getNummerplaat());
            }
        }
    }

    public static Comparator<Voertuig> getMerkComparator() {
        return new Voertuig.MerkComparator();
    }

    static class AankoopprijsComparator implements Comparator<Voertuig>, Serializable {

        @Override
        public int compare(Voertuig e1, Voertuig e2) {
            if (e1.getAankoopprijs() - (e2.getAankoopprijs()) != 00) {
                return e1.getAankoopprijs() - (e2.getAankoopprijs());
            } else {
                return e1.getNummerplaat().compareTo(e2.getNummerplaat());
            }
        }
    }

    public static Comparator<Voertuig> getAankoopprijsComparator() {
        return new Voertuig.AankoopprijsComparator();
    }

    @Override
    public String toString() {
        if (getIngezeteneExclusiefBestuurder().size() > 0) {
            return nummerplaat + " " + merk + " " + datumEersteIngebruikname + " " + aankoopprijs + " " + this.mensen.get(0) + " " + this.getIngezeteneExclusiefBestuurder();
        } else {
            return nummerplaat + " " + merk + " " + datumEersteIngebruikname + " " + aankoopprijs + " " + this.mensen.get(0);
        }
    }

}
