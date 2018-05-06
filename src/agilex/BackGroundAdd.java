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
public class BackGroundAdd extends Menupont {

    public BackGroundAdd(String name, Menu m) {
        super(name, m);
    }

    @Override
    public void pressed() {
        System.out.println("Type the name of the new background.");
        Scanner scn = new Scanner(System.in);
        boolean success = recent_menu.k.addBackGround(scn.next());
        if (success) {
            recent_menu.k.getServer().message = "Background added.";
        } else {
            recent_menu.k.getServer().message = "Background unsuccesfully added.";
        }
    }
}
