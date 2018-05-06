package agilex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Scanner;

public class Adj_felh extends Menupont implements Serializable {

    public Adj_felh(String str, Menu m) {
        super(str, m);
    }

    @Override
    public void pressed() {
        System.out.println("Type the new username below.");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        recent_menu.getKlient().setUsername(input);
        recent_menu.getKlient().getServer().message = "Username succesfully changed.";
    }
}
