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
public class AddIcon extends Menupont {

    public AddIcon(String name, Menu m) {
        super(name, m);
    }

    @Override
    public void pressed() {
        System.out.println("Type the name of the new icon.");
        Scanner scn = new Scanner(System.in);
        recent_menu.getKlient().addIcon(scn.next());
    }
}
