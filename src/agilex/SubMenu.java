package agilex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubMenu extends Menu implements Serializable {

    protected Menu recent_menu;
    final private String sname;

    public String getName() {
        return sname;
    }

    public SubMenu(String name, Menu menu) {
        recent_menu = menu;
        sname = name;
    }

    public void addMenupont(Menupont mp) {
        if (mp != null) {
            menupontok.add(mp);
        }
    }
    
    @Override
    public void menupont_Pressed(String mpp) {
        boolean smtgpressed = false;

        for (Menupont mp : menupontok) {
            if (mp.getNev().equals(mpp)) {
                mp.pressed();
                smtgpressed = true;
            }
        }
        if (!smtgpressed) {
            recent_menu.getKlient().getServer().message = "Invalid input.";
        }
    }

    public void pressed(String mpp) {
        boolean smtgpressed = false;

        for (Menupont mp : menupontok) {
            if (mp.getNev().equals(mpp)) {
                mp.pressed();
                smtgpressed = true;
            }
        }
        if (!smtgpressed) {
            recent_menu.getKlient().getServer().message = "Invalid input.";
        }
    }

    public void menupontOut() {
        System.out.println(sname);
    }

    public void back_btn_pressed() {
        recent_menu.getKlient().setFocused(recent_menu);
    }
}
