import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose Creates user-interactable GUI pop-ups.
 */

public class Popup extends JDialog implements ActionListener {
    private final JButton closeBTN = new JButton("Close");

    public Popup(Account account) {
        setTitle("User: " + account.getUsername());
        initializeDialog();
        
        JPanel m = new JUser(account);
        setupLayout(m);
    }

    public Popup(Animal animal) {
        setTitle("Animal: " + animal.getName());
        initializeDialog();
        
        JPanel m = new JPet(animal);
        setupLayout(m);
    }

    public Popup(ArrayList<Animal> animals) {
        setTitle("All Pets");
        initializeDialog();
        
        JPanel m = new JAllPets(animals);
        setupLayout(m);
    }

    private void initializeDialog() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setModal(true); // Make the dialog block input to other windows
        setLocationRelativeTo(null); // Center the dialog on the screen

        // Add close button functionality
        closeBTN.addActionListener(this::actionPerformed);
    }

    private void setupLayout(JPanel contentPanel) {
        setLayout(new GridLayout(2, 1));
        add(contentPanel);
        add(closeBTN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose(); // Close the dialog
    }
}
