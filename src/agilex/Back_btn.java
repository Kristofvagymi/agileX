package agilex;

import java.io.Serializable;

public class Back_btn extends Menupont implements Serializable {

    public Back_btn(String str, Menu m) {
        super(str, m);
    }

    @Override
    public void pressed() {
        recent_menu.k.setFocused(recent_menu);
    }
}
