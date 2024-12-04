import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        this.username = account.getUsername();
        this.numPets = account.getNumPets();
        this.animals = account.getPets();


        setLayout(new GridLayout(3, 1));

        JLabel userLabel = new JLabel("User: " + username);
        JLabel numPetsLabel = new JLabel("Number of pets: " + numPets);

        add(userLabel);
        add(numPetsLabel);

        add(new JAllPets( JUser.toArrayList( animals ) ) );
    }
}
