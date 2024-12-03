
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Popup extends JDialog {
    JButton closeBTN = new JButton("Close");

    public Popup (Account account) {   
        setTitle("User: " + account.getUsername());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(300, 150);

        JPanel m = new JUser(account);

        setLayout( new GridLayout(2, 1));

        add(m);

        add(closeBTN);

    }

    public Popup (Animal animal) {
        setTitle("Animal: " + animal.getName());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(300, 150);

        JPanel m = new JPet(animal);

        setLayout( new GridLayout(2, 1));

        add(m);

        add(closeBTN);
    }

    public Popup (ArrayList<Animal> animals) {
        setTitle("All Pets");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(300, 150);

        JPanel m = new JAllPets(animals);

        setLayout( new GridLayout(2, 1));

        add(m);

        add(closeBTN);
    }
    
}
