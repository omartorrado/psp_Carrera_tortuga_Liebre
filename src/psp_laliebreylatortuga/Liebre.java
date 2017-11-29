/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_laliebreylatortuga;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Liebre extends Thread{

    private Random rd = new Random();
    private int casilla = 0;
    Tortuga t;
  
    @Override
    public void run() {
        int turno=0;
        while (casilla < 70 && t.getCasilla()<70) {
            try {
                turno++;
                sleep(100);
                suceso();
                System.out.println("L esta en la casilla "+casilla+" y ha jugado "+turno+" turnos");
                if(casilla>=70){
                    System.out.println("L ganó la carrera");
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
        if (prob < 20) {
            
        } else if (prob < 40) {
            casilla += 9;
        } else if(prob<50){
            casilla-=12;
        } else if(prob<80){
            casilla++;
        }else{
            casilla-=2;
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
    public void setTortuga(Tortuga t){
        this.t=t;
    }
}
