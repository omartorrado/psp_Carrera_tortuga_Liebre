/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_laliebreylatortuga;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Tortuga extends Thread {

    private Random rd = new Random();
    private int casilla = 0;
    Liebre l;
        
    @Override
    public void run() {
        int turno=0;
        while (casilla < 70 && l.getCasilla()< 70) {
            try {
                turno++;
                sleep(100);
                suceso();
                System.out.println("T esta en la casilla " + casilla + " y ha jugado " + turno + " turnos");
                if(casilla>=70){
                    System.out.println("T ganó la carrera");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int suceso() {
        //generamos un numero de 0 a 99
        int prob = rd.nextInt(100);
        //determinamos el suceso en base al numero anterior
        if (prob < 50) {
            casilla += 3;
        } else if (prob < 70) {
            casilla -= 6;
        } else {
            casilla++;
        }
        //nos aseguramos de que casilla nunca sea menor de 0 ni mayor de 70
        if (casilla < 0) {
            casilla = 0;
        }
        if (casilla >= 70) {
            casilla = 70;
        }
        return casilla;
    }

    public int getCasilla() {
        return casilla;
    }
    
    public void setLiebre(Liebre l){
        this.l=l;
    }
    
}
