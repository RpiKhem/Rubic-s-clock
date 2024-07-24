/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikora;

import java.util.Random;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class Field {
    private int number;
    Random rand = new Random();

    public Field() {        
        number = rand.nextInt(12) + 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
