import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * CMS270 Group Project
 * 
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose
 */

public class JUser extends JPanel {
    private final String username;
    private final int numPets;
    private final Animal[] animals;

    private static ArrayList<Animal> toArrayList(Animal[] animals) {
        ArrayList<Animal> list = new ArrayList<>();
        list.addAll(Arrays.asList(animals));
        return list;
    }

    JUser(Account account) {
        super();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        this.username = account.getUsername();
        this.numPets = account.getNumPets();
        this.animals = account.getPets();

        JLabel userLabel = new JLabel("User: " + username);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(userLabel, gbc);

        JLabel numPetsLabel = new JLabel("Number of pets: " + numPets);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(numPetsLabel, gbc);

        JAllPets jp = new JAllPets(JUser.toArrayList(animals));

        JScrollPane pp = new JScrollPane(jp);
        pp.setPreferredSize(new Dimension(500, 400));
        pp.setMinimumSize(new Dimension(500, 400));
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(pp, gbc);

    }
}
