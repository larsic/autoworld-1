package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;

public class Vrachtwagen extends Voertuig implements Laadbaar {

    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    public Vrachtwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume volume, int maximaalToegelatenMassa, int aantalAssen, Mens bestuurder, Mens... args) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, args);
        this.laadvolume = volume;
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        this.aantalAssen = aantalAssen;
        if (zitplaatsen > 3) {
            throw new IllegalArgumentException();
        }
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }

    @Override
    Rijbewijs[] getToegestaneRijbewijzen() {
        Rijbewijs[] pw = new Rijbewijs[2];
        pw[0] = Rijbewijs.C;
        pw[1] = Rijbewijs.CE;
        return pw;
    }

    @Override
    int getMAX_ZITPLAATSEN() {
        return 3;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadVolume) {
        this.laadvolume = laadVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " assen:" + aantalAssen + ", maximaal toegelaten massa:" + maximaalToegelatenMassa + ", laadvolume:" + laadvolume;
    }

}
