import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PreferencesDialog extends JDialog {
    private boolean dicAge = true;
    private boolean dicGender = true;

    private final JToggleButton button = new JToggleButton("Discriminate on age");
    private final JToggleButton button2 = new JToggleButton("Discriminate on gender");

    private final JLabel labelA = new JLabel("Discriminate on age");
    private final JLabel labelB = new JLabel("Discriminate on gender");


    private final JButton closeBTN = new JButton("Close");

    private CloseListener listener;


    public PreferencesDialog() {
        // Set dialog properties
        setTitle("Preferences");

        setLayout(new GridLayout(2, 1));
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);

        button.addItemListener(e -> {
            this.dicAge = e.getStateChange() == ItemEvent.SELECTED;
            button.setText(dicAge ? "Discriminate on age" : "Don't discriminate on age");
            labelA.setText(dicAge? "Discriminate on age" : "Don't discriminate on age");
        });

        button2.addItemListener(e -> {
            this.dicGender = e.getStateChange() == ItemEvent.SELECTED;
            button2.setText(dicGender ? "Discriminate on gender" : "Don't discriminate on gender");
            labelB.setText(dicGender ? "Discriminate on gender" : "Don't discriminate on gender");
        });

        // Configure close button
        closeBTN.addActionListener(e -> {
            if (listener != null) {
                listener.onClose(dicAge, dicGender);
            }
            dispose();
        });

        // Add components to the dialog
        JPanel togglePanel = new JPanel(new GridLayout(1, 2));

        JPanel buttonA = new JPanel(new GridLayout(2, 1));
        JPanel buttonB = new JPanel(new GridLayout(2, 1));


        buttonA.add(labelA);
        buttonA.add(button);



        buttonB.add(labelB);
        buttonB.add(button2);


        togglePanel.add(buttonA);
        togglePanel.add(buttonB);

        button.setSelected(this.dicAge);
        button2.setSelected(this.dicGender);

        add(togglePanel);
        add(closeBTN);
    }

    public void setCloseListener(CloseListener listener) {
        this.listener = listener;
    }

    // Public getter methods for state
    public boolean isDicAge() {
        return dicAge;
    }

    public boolean isDicGender() {
        return dicGender;
    }

    // Optional: Public methods to set initial states
    public void setDicAge(boolean dicAge) {
        this.dicAge = dicAge;
        button.setSelected(dicAge);
        button.setText(dicAge ? "Discriminate on age" : "Don't discriminate on age");
    }

    public void setDicGender(boolean dicGender) {
        this.dicGender = dicGender;
        button2.setSelected(dicGender);
        button2.setText(dicGender ? "Discriminate on gender" : "Don't discriminate on gender");
    }
}