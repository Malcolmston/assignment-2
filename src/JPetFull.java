import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose 
 */

public class JPetFull extends JPanel {
    private boolean dicAge;
    private boolean dicGender;


    public JPetFull(Animal pet, boolean dicAge, boolean dicGender) {
        super();

        this.dicAge = dicAge;
        this.dicGender = dicGender;

        String[][] arr = getFileOut();
        if (arr == null) {
            throw new IllegalStateException("Error: Unable to load file data.");
        }

        ArrayList<Animal> allPets = getPets(arr);

        ArrayList<HashMap<String, Object>> petIds = Animal.computeCompatibility(pet, dicAge, dicGender, allPets);
        ArrayList<Animal> top = getTop(3, petIds);

        JPet yourJPet = new JPet(pet);
        JPanel topPanel = new JPanel(new GridLayout(0, 1));

        topPanel.add(yourJPet);

        top.forEach(x -> {
            JPet jpet = new JPet(pet, x);
            topPanel.add(jpet);
        });

        JScrollPane scroll = new JScrollPane(topPanel);
        scroll.setPreferredSize(new Dimension(600, 500));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        
    }


    private static String[][] getFileOut() {
        try (Scanner scanner = FileReader.getScanner()) {
            return FileReader.readFile(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Animal> getPets(String[][] data) {
        return FileReader.parseAnimals(data);
    }

    public static ArrayList<Account> getAccounts(String[][] data) {
        return FileReader.parse(data);
    }

    private static ArrayList<Animal> getTop(int amount, ArrayList<HashMap<String, Object>> peList) {
        peList.sort((map1, map2) -> Integer.compare((int) map2.get("points"), (int) map1.get("points")));

        ArrayList<Animal> top = new ArrayList<>();
        for (int i = 0; i < amount && i < peList.size(); i++) {
            top.add((Animal) peList.get(i).get("pet"));
        }
        return top;
    }

    public void setDicGender(boolean dicGender) {
        this.dicGender = dicGender;
    }

    public boolean isDicAge() {
        return dicAge;
    }

    public void setDicAge(boolean dicAge) {
        this.dicAge = dicAge;
    }

    public boolean isDicGender() {
        return dicGender;
    }
}
