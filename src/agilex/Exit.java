/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agilex;

import java.io.Serializable;

/**
 *
 * @author Kris
 */
public class Exit extends Menupont implements Serializable {

    public Exit(String str) {
        super(str);
    }

    @Override
    public void pressed() {
        recent_menu.getKlient().getServer().setActiveKliens(null);
    }

    public Exit(String str, Menu m) {
        super(str, m);
    }
}
