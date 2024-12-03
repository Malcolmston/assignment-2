
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JAllPets extends JPanel {
    ArrayList<Animal> animals;

    JAllPets (ArrayList<Animal> a) {
        this.animals = a;

        setLayout(new GridLayout(a.size(), 1));

        animals.forEach(pet -> {
            this.add(new JPet(pet));
        });
    }
}
