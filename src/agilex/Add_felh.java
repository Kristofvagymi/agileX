package agilex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Scanner;

public class Add_felh extends Menupont implements Serializable {

    public Add_felh(String str, Menu m) {
        super(str, m);
    }

    @Override
    public void pressed() {
        System.out.println("Type the new Users name below.");
        Scanner scn = new Scanner(System.in);

        String input = scn.next();
        boolean success = recent_menu.getKlient().getServer()
                .add_kliens(input);
        if (success == true) {
            recent_menu.getKlient().getServer().message = "User succesfully added.";
        } else {
            recent_menu.getKlient().getServer().message = "User unsuccesfully added.";
        }
    }

}
