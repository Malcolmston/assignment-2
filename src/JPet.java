import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class JPet extends JPanel {
    private final JLabel lblName;
    private final JLabel lblAge;
    private final JLabel lblGender;

    private JLabel lblA;
    private JLabel lblB;
    private JLabel lblC;

    private Border BORDER;


    private final JPanel panelA = new JPanel();

    private final ImageIcon lblTitle;

    private static ArrayList<String> getValidFlags(Animal a, Animal b) {
        ArrayList<String> validFlags = new ArrayList<>();

        for (int i = 0; i < a.getFlags().length; i++) {
            if (a.getFlags()[i] && b.getFlags()[i]) {
                String description = switch (i) {
                    case 1 -> String.format("The pet %s and pet %s both enjoy being adventurous.", a.getName(), b.getName());
                    case 2 -> String.format("The pet %s and pet %s both enjoy baths.", a.getName(), b.getName());
                    case 3 -> String.format("The pet %s and pet %s both enjoy car rides.", a.getName(), b.getName());
                    case 4 -> String.format("The pet %s and pet %s both enjoy cosplay.", a.getName(), b.getName());
                    case 5 -> String.format("The pet %s and pet %s both enjoy eating.", a.getName(), b.getName());
                    case 6 -> String.format("The pet %s and pet %s both have high energy.", a.getName(), b.getName());
                    case 7 -> String.format("The pet %s and pet %s both are friendly.", a.getName(), b.getName());
                    case 8 -> String.format("The pet %s and pet %s both enjoy running.", a.getName(), b.getName());
                    case 9 -> String.format("The pet %s and pet %s both enjoy sleeping.", a.getName(), b.getName());
                    case 10 -> String.format("The pet %s and pet %s both enjoy playing.", a.getName(), b.getName());
                    case 11 -> String.format("The pet %s and pet %s both enjoy walks.", a.getName(), b.getName());
                    default -> "";
                };
                validFlags.add(description);
            }
        }

        return validFlags;
    }

    public static int[] generateUniqueRandomInts(int min, int max, int size) {
        if (max - min + 1 < size || size < 1) {
            throw new IllegalArgumentException("Invalid range or size for unique numbers.");
        }
    
        int[] result = new int[size];
        int count = 0;
    
        while (count < size) {
            int randomNum = (int) (Math.random() * (max - min + 1)) + min;
    
            // Check if the number is already in the result array
            boolean isDuplicate = false;
            for (int i = 0; i < count; i++) {
                if (result[i] == randomNum) {
                    isDuplicate = true;
                    break;
                }
            }
    
            // Add the number if it's not a duplicate
            if (!isDuplicate) {
                result[count++] = randomNum;
            }
        }
    
        return result;
    }
    
    JPet(Animal petA, Animal petB) {
        super();

        lblName = new JLabel(petB.getName());
        lblAge = new JLabel("Age: " + petB.getAge());
        lblGender = new JLabel("Gender: " + petB.getGender());

        lblTitle = JPetCreator.createImageIcon(petB.getUrl(), 400, 400);

        setLayout(new GridLayout(1, 2));

        ArrayList<String> possibilities = getValidFlags(petA, petB);
        int[] randomIndices = generateUniqueRandomInts(0, possibilities.size() - 1, Math.min(3, possibilities.size()));

        lblA = randomIndices.length > 0 ? new JLabel(possibilities.get(randomIndices[0])) : new JLabel("No common interests");
        lblB = randomIndices.length > 1 ? new JLabel(possibilities.get(randomIndices[1])) : new JLabel("");
        lblC = randomIndices.length > 2 ? new JLabel(possibilities.get(randomIndices[2])) : new JLabel("");

        panelA.setLayout(new GridLayout(6, 1));

        panelA.add(lblName);
        panelA.add(lblAge);
        panelA.add(lblGender);

        panelA.add(lblA);
        panelA.add(lblB);
        panelA.add(lblC);

        JLabel lbl = new JLabel(lblTitle);

        add(lbl);
        add(panelA);

        BORDER = BorderFactory.createTitledBorder(petB.getName() + "'s Profile"); 

        setBorder(BORDER);
    }

    public JPet(Animal petA) {
        super();

        lblName = new JLabel(petA.getName());
        lblAge = new JLabel("Age: " + petA.getAge());
        lblGender = new JLabel("Gender: " + petA.getGender());

        lblTitle = JPetCreator.createImageIcon(petA.getUrl(), 400, 400);

        setLayout(new GridLayout(1, 2));

        panelA.setLayout(new GridLayout(3, 1));


        panelA.add(lblName);
        panelA.add(lblAge);
        panelA.add(lblGender);

        JLabel lbl = new JLabel(lblTitle);

        add(lbl);
        add(panelA);

        BORDER = BorderFactory.createTitledBorder(petA.getName() + "'s Profile"); 

        setBorder(BORDER);

    }
}
