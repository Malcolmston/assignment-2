import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;

public class Popup extends JPopupMenu {
    private boolean dicAge = true;
    private boolean dicGender = true;
    private final JToggleButton button = new JToggleButton("Discriminate on age");
    private final JToggleButton button2 = new JToggleButton("Discriminate on gender");
    private final JButton closeBTN = new JButton("Close");
    private CloseListener listener;

    public interface CloseListener {
        void onClose(boolean dicAge, boolean dicGender);
    }

    public void setCloseListener(CloseListener listener) {
        this.listener = listener;
    }

    public Popup() {
        button.addItemListener(e -> {
            dicAge = e.getStateChange() == ItemEvent.SELECTED;
            button.setText(dicAge ? "Discriminate on age" : "Don't discriminate on age");
        });

        button2.addItemListener(e -> {
            dicGender = e.getStateChange() == ItemEvent.SELECTED;
            button2.setText(dicGender ? "Discriminate on gender" : "Don't discriminate on gender");
        });

        closeBTN.addActionListener(e -> {
            if (listener != null) {
                listener.onClose(dicAge, dicGender);
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);
        panel.setLayout(new GridLayout(1, 2));
        add(panel);
        add(closeBTN);
    }

    public boolean getDicAge() {
        return dicAge;
    }

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

    public JButton getCloseBTN() {
        return closeBTN;
    }
}