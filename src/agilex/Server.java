package agilex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Server implements Serializable {

    private List<Klient> kliensek = new ArrayList<Klient>();
    private Klient k;
    public String message;

    void printMsg() {
        System.out.println(message);
        message = "";
        System.out.println();
    }

    public void setActiveKliens(Klient active_k) {
        k = active_k;
    }

    public void activeMenu() {
        k.showActive();
    }

    public Klient activeUser() {
        return k;
    }

    public void remove(String str) {

        for (Klient k : kliensek) {
            if (k.getUsername().equals(str)) {
                kliensek.remove(k);
                this.k = null;
                break;
            }
        }
    }

    public boolean add_kliens(String str) {
        boolean inuse = false;
        for (Klient k : kliensek) {
            if (k.getUsername().equals(str)) {
                inuse = true;
            }
        }
        if (inuse == false) {
            kliensek.add(new Klient(str, this));
        }

        return !inuse;
    }

    public boolean add_kliens(Klient newK) {
        boolean inuse = false;
        for (Klient k : kliensek) {
            if (k.getUsername().equals(newK.getUsername())) {
                inuse = true;
            }
        }
        if (inuse == false) {
            kliensek.add(newK);
        }
        return inuse;
    }

    public boolean auth_kliens(String str) {
        boolean inuse = false;
        for (Klient k : kliensek) {
            if (k.getUsername().equals(str)) {
                inuse = true;
            }
        }
        return inuse;
    }

}
