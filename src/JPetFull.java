
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPetFull extends JPanel {
    private static String[][] getFileOut () {
        try (Scanner scanner = FileReader.getScanner()) {

            String[][] arr = FileReader.readFile(scanner);

            return arr;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Animal> getPets (String[][] data) {
        return FileReader.parseAnimals(data);
    }

    public static ArrayList<Account> getAccounts (String[][] data) {
        return FileReader.parse(data);
    }
    
    private static ArrayList<Animal> getTop(int amount, ArrayList<HashMap<String, Object>> peList) {

        peList.sort((map1, map2) -> 
        Integer.compare(
            (int) map2.get("points"), (int) map1.get("points")
            ));
    
        ArrayList<Animal> top = new ArrayList<>();
        for (int i = 0; i < amount && i < peList.size(); i++) {
            top.add((Animal) peList.get(i).get("pet"));
        }
    
        return top;
    }
    
    public JPetFull (Animal pet) {
        super();

        String[][] arr = getFileOut();

        ArrayList<Animal> AllPets = getPets(arr);
        ArrayList<Account> accounts = getAccounts(arr);

  
        ArrayList< HashMap<String, Object> > petIds = Animal.computeCompatibility(pet, true, true, AllPets);

        ArrayList<Animal> top = getTop(3, petIds);

        JPet ypurJPet = new JPet(pet);

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new GridLayout(4, 1));

        topPanel.add(ypurJPet);

        top.forEach(x -> {
            JPet jpet = new JPet(pet, x);
            topPanel.add(jpet);
        } );

        JScrollPane scroll = new JScrollPane(topPanel);

        add(scroll);
    }
}
