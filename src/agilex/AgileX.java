package agilex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AgileX {

    public static Klient noAuth(Server s) {
        System.out.println("Authenticat yourself!(typing 'exit' means shut down the app)");

        Scanner scn = new Scanner(System.in);
        String u_name = scn.next();
        if (u_name.equals("exit")) {

            try {
                File file = new File("server.ser");
                if (!file.isFile()) {
                    file.createNewFile();
                }
                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(f);
                out.writeObject(s);
                try {
                    out.writeObject(s);
                } finally {
                    out.close();
                }
            } catch (IOException io) {
            }
            System.out.println("Succesful logout.");
            System.exit(0);
        }
        if (s.auth_kliens(u_name)) {
            s.message = "Succesful login.";
            return new Klient(u_name, s);
        } else {
            s.message = "Unsuccesful login. Try again.";
            return null;
        }
    }

    public static void main(String[] args) {

        Server s1 = new Server();

        //Deszerializas vagy kezdo felhasznalo inicializalasa
        try {
            File f = new File("server.ser");
            if (f.isFile() && f.canRead()) {
                FileInputStream fin = new FileInputStream(f);
                try (ObjectInputStream oin = new ObjectInputStream(fin)) {
                    s1 = (Server) oin.readObject();
                }
            } else {
                Klient k = new Klient("dad", s1);
                s1.add_kliens(k);
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        Klient authed = null;
        Scanner scn = new Scanner(System.in);

        while (true) {
            if (authed != null) {
                //Jelenlegi menupontok kilistazasa
                authed.showActive();

                //Felhasznalo altal valasztott menupont aktivalasa
                authed.menuItemPressed(scn.next());

                //Ha kozben kijelentkezett volna vagy torolte volna magat
                authed = s1.activeUser();

            } else {
                //Bejelentkezes lehetosege
                authed = noAuth(s1);
                s1.setActiveKliens(authed);
            }
            //Clear console, verzo szivvel irtam le ilyen kodot :S
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
            //Utolso muvelet uzenetenek kiirasa
            s1.printMsg();
        }

    }

}
