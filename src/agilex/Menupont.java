package agilex;

import java.io.Serializable;

abstract public class Menupont implements Serializable {

    protected String name;
    protected Menu recent_menu;

    public Menupont(String kapott_nev, Menu m) {
        name = kapott_nev;
        recent_menu = m;
    }

    public Menupont(String kapott_nev) {
        name = kapott_nev;
    }

    abstract public void pressed();

    public void menupontOut() {
        System.out.println(name);
    }

    ;
    
    public String getNev() {
        return name;
    }
}
