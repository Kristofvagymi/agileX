package agilex;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {

    protected List<Menupont> menupontok = new ArrayList<Menupont>();
    protected Klient k;
    private List<SubMenu> almenuk = new ArrayList<SubMenu>();

    public Menu(Klient new_k) {
        k = new_k;

        //profile submenu
        SubMenu profSM = new SubMenu("Profiles", this);

        profSM.addMenupont(new Add_felh("Add", this));
        profSM.addMenupont(new Adj_felh("Change", this));
        profSM.addMenupont(new Del_felh("Delete", this));
        profSM.addMenupont(new Back_btn("Back", this));
        addAlMenupont(profSM);

        SubMenu iconsSM = new SubMenu("Icons", this);
        iconsSM.addMenupont(new AddIcon("Add", this));
        iconsSM.addMenupont(new AdjustIcon("Adjust", this));
        iconsSM.addMenupont(new DeleteIcon("Delete", this));
        iconsSM.addMenupont(new Back_btn("Back", this));

        addAlMenupont(iconsSM);
        
        addMenupont(new RunApp("Run", this));
        
        addMenupont(new BackGroundAdd("AddBG", this));
        addMenupont(new ChooseBackground("ChooseBG", this));

        addMenupont(new Exit("Exit", this));

    }

    public Menu() {
    }

    public Klient getKlient() {
        return k;
    }

    public void menupont_Pressed(String mpp) {
        boolean smtgpressed = false;

        for (Menupont mp : menupontok) {
            if (mp.getNev().equals(mpp)) {
                mp.pressed();
                smtgpressed = true;
            }
        }
        for (SubMenu almp : almenuk) {
            if (almp.getName().equals(mpp)) {
                k.setFocused(almp);
                smtgpressed = true;
            }
        }
        if (!smtgpressed) {
            k.getServer().message = "Invalid input.";
        }
    }

    public void menuOut() {

        almenuk.forEach((mp) -> {
            mp.menupontOut();
        });
        menupontok.forEach((mp) -> {
            mp.menupontOut();
        });
    }

    public void addMenupont(Menupont mp) {
        if (mp != null) {
            menupontok.add(mp);
        }
    }

    public void addAlMenupont(SubMenu mp) {
        if (mp != null) {
            almenuk.add(mp);
        }
    }

}
