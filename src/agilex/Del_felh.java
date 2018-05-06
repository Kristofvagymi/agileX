package agilex;

import java.io.Serializable;

public class Del_felh extends Menupont implements Serializable {

    public Del_felh(String str, Menu m) {
        super(str, m);
    }

    @Override
    public void pressed() {
        recent_menu.getKlient().getServer().remove(recent_menu.getKlient().getUsername());
    }
}
