/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agilex;

import java.util.Scanner;

/**
 *
 * @author ivani
 */
public class ChooseBackground extends Menupont {

    public ChooseBackground(String name, Menu m) {
        super(name, m);
    }

    @Override
    public void pressed() {
        recent_menu.getKlient().printBGs();
        System.out.println("Type the name of the choosen backgroun:");
        Scanner scn = new Scanner(System.in);
        recent_menu.getKlient().chooseBG(scn.next());
    }

}
