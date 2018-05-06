package agilex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Klient implements Serializable {

    private String username;
    private Menu sajatmenu;
    private Server szerver;

    private Menu focused;

    List<String> backgrounds = new ArrayList<String>();
    private String activeBG = "default";

    List<String> icons = new ArrayList<String>();

    List<String> running_apps = new ArrayList<String>();

    Klient(String name, Server szrv) {
        username = name;
        szerver = szrv;
        sajatmenu = new Menu(this);
        focused = sajatmenu;
        backgrounds.add("default");
    }

    public void addIcon(String icon_add) {
        if (icons.contains(icon_add)) {
            szerver.message = "Icon added unsuccessfully";
        } else {
            szerver.message = "Icon added unseccessfully";
            icons.add(icon_add);
        }
    }

    public void adjIcon(String from, String to) {
        if (!icons.contains(from)) {
            szerver.message = "Icon not found.";
        } else {
            icons.remove(from);
            icons.add(to);
            szerver.message = "Icon successfully changed";
        }
    }

    public void runApp(String r_app) {
        if (icons.contains(r_app)) {
            running_apps.add(r_app);
            szerver.message = "App started succesfully.";
        } else {
            szerver.message = "App not found.";
        }
    }

    public void delIcon(String del_icon) {
        if (!icons.contains(del_icon)) {
            szerver.message = "Icon not found.";
        } else {
            icons.remove(del_icon);
            szerver.message = "Delete was succesful.";
        }
    }

    public boolean addBackGround(String name) {
        if (backgrounds.contains(name)) {
            return false;
        } else {
            backgrounds.add(name);
            return true;
        }
    }

    public void printBGs() {
        if (activeBG != null) {
            System.out.println("Active background:   " + activeBG);
        }
        System.out.println("Other chooseable backgrounds:");
        System.out.println(backgrounds);
    }

    public void chooseBG(String name) {
        if (backgrounds.contains(name)) {
            activeBG = name;
            szerver.message = "Background seccesfully set.";
        } else {
            szerver.message = "Background not found.";
        }

    }

    public void setFocused(Menu m) {
        focused = m;
    }

    public Server getServer() {
        return szerver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String new_name) {
        username = new_name;
    }

    public void showActive() {
        focused.menuOut();
    }

    public void menuItemPressed(String str) {
        focused.menupont_Pressed(str);
    }

}
