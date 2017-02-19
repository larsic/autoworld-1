/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

/**
 *
 * @author Administrator
 */
public enum DIV {

    INSTANCE;
    private int counter = 1;
    private String plaatje;

    public Nummerplaat getNummerplaat() {

        if (counter < 10) {
            plaatje = "AAA" + "00" + counter;
        } else if (9 < counter && counter < 100) {
            plaatje = "AAA" + "0" + counter;
        } else {
            if (99 < counter && counter < 1000) {
                plaatje = "AAA" + counter;
            } else {
                counter = 1;
                plaatje = "AAA" + "00" + counter;
            }
        }
        counter++;
        return new Nummerplaat(plaatje);
    }

}
