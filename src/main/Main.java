/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import be.vdab.util.Datum;
import static be.vdab.util.Maat.decimeter;
import static be.vdab.util.Maat.meter;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import static be.vdab.util.mens.Rijbewijs.C;
import static be.vdab.util.mens.Rijbewijs.CE;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import static java.awt.Color.BLUE;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        SortedSet<Voertuig> lijst = new TreeSet<Voertuig>();
            
            Voertuig a = new Personenwagen("VW", new Datum(1, 1, 2010), 2000, 5, YELLOW, new Mens("Fritz", B));
            Voertuig b = new Personenwagen("Fiat", new Datum(1, 1, 2011), 1000, 7, PINK, new Mens("Fangio", BE));
            Voertuig c = new Pickup("VW", new Datum(1, 1, 2012), 4000, 3, BLUE, new Volume(10, 10, 10, decimeter), new Mens("Franz", B));
            Voertuig d = new Pickup("Toyota", new Datum(1, 1, 2013), 3000, 3, RED, new Volume(20, 20, 20, decimeter), new Mens("Kenzo", B));
            Voertuig e = new Vrachtwagen("Scania", new Datum(1, 1, 2014), 10000, 2, new Volume(20, 20, 20, meter), 1000, 2, new Mens("Lasse", C));
            Voertuig f = new Vrachtwagen("Renault", new Datum(1, 1, 2015), 15000, 2, new Volume(40, 40, 40, meter), 5000, 3, new Mens("Jean", CE));
                        
            lijst.add(a);
            lijst.add(b);
            lijst.add(c);
            lijst.add(d);
            lijst.add(e);
            lijst.add(f);
            System.out.println("SORTEDSET 1\n");
            for(Voertuig v: lijst){
              System.out.println(v); 
                
            }
            
            System.out.println("\nSORTEDSET op aankoopprijs\n");
            SortedSet lijstB = new TreeSet(Voertuig.getAankoopprijsComparator()).descendingSet();
            lijstB.addAll(lijst);
            for(Object v: lijstB){
              System.out.println(v);  
            }
            
            System.out.println("\nSORTEDSET op merk (inputstream)\n");
            SortedSet lijstC = new TreeSet(Voertuig.getMerkComparator());
            lijstC.addAll(lijst);
            for(Object v: lijstC){
              System.out.println(v);  
            }
            
            System.out.println("\nSORTEDSET op merk (outputstream)\n");
            SortedSet<Voertuig> lijstD = new TreeSet();
            
            try {
			
			FileOutputStream fos = new FileOutputStream("lijstjes.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
                        ObjectOutput output = new ObjectOutputStream(oos);
                        output.writeObject(lijstC);
                        output.close();
                        
			FileInputStream fis = new FileInputStream("lijstjes.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        ObjectInput input = new ObjectInputStream (ois);
			lijstD = (SortedSet<Voertuig>) input.readObject();
                        input.close();

		} catch (FileNotFoundException eee) {
			eee.printStackTrace();
		} catch (IOException rrr){
                        rrr.printStackTrace();
                } catch (ClassNotFoundException ttt) {
                        ttt.printStackTrace();
        }
        
        for(Object v: lijstD){
              System.out.println(v);  
            }
                
    }
}
