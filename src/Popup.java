import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;

public class Popup extends JPopupMenu {
    private boolean dicAge = true;
    private boolean dicGender = true;

    private final JToggleButton button = new JToggleButton("Discriminate on age");
    private final JToggleButton button2 = new JToggleButton("Discriminate on gender");


    public boolean getDicAge() {
        return dicAge;
    };


    public boolean isDicGender() {
        return dicGender;
    }

    public void setDicAge(boolean dicAge) {
        this.dicAge = dicAge;
    }

    public void setDicGender(boolean dicGender) {
        this.dicGender = dicGender;
    }

    public JToggleButton getButton() {
        return button;
    }

    public JToggleButton getButton2() {
        return button2;
    }


}
