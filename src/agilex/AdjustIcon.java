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
public class AdjustIcon extends Menupont {

    public AdjustIcon(String name, Menu m) {
        super(name, m);
    }

    @Override
    public void pressed() {
        System.out.println("Type the old name of the icon:");
        Scanner scn = new Scanner(System.in);
        String from = scn.next();
        System.out.println("Typw in the new name of the icon.");
        String to = scn.next();
        recent_menu.getKlient().adjIcon(from, to);
    }
}
