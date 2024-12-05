import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.prefs.BackingStoreException;
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

    private final Border BORDER;

    private final JPanel panelA = new JPanel();

    private final ImageIcon lblTitle;

    // Consistent font sizing and styling
    private final Font labelFont = new Font("Arial", Font.PLAIN, 12);

    private static ArrayList<String> getValidFlags(Animal a, Animal b) {
        ArrayList<String> validFlags = new ArrayList<>();
        String[] flagDescriptions = {
            "adventurous",
            "enjoy baths",
            "enjoy car rides", 
            "enjoy cosplay",
            "enjoy eating",
            "have high energy",
            "are friendly",
            "enjoy running",
            "enjoy sleeping",
            "enjoy playing",
            "enjoy walks"
        };
    
        for (int i = 1; i < Math.min(flagDescriptions.length, a.getFlags().length); i++) {
            if (a.getFlags()[i] && b.getFlags()[i]) {
                String description = String.format(
                    "The pet %s and pet %s both %s.", 
                    a.getName(), 
                    b.getName(), 
                    flagDescriptions[i]
                );
                validFlags.add(description);
            }
        }
        return validFlags;
    }
public static int[] generateUniqueRandomInts(int min, int max, int count) {
    if (count > (max - min + 1)) {
        throw new IllegalArgumentException("Cannot generate more unique integers than available range");
    }
    
    Random random = new Random();
    Set<Integer> uniqueIndices = new HashSet<>();
    
    while (uniqueIndices.size() < count) {
        int randomIndex = random.nextInt(max - min + 1) + min;
        uniqueIndices.add(randomIndex);
    }
    
    return uniqueIndices.stream().mapToInt(Integer::intValue).toArray();
}
   
JPet(Animal petA, Animal petB) {
        super();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create a panel for pet details
        panelA.setLayout(new GridBagLayout());

        ArrayList<String> possibilities = getValidFlags(petA, petB);

        System.out.println(possibilities.size());


        int[] randomIndices;
        if (possibilities.isEmpty()) {
            randomIndices = new int[0]; // No indices if no possibilities
        } else {
            int numIndices = Math.min(3, possibilities.size());
            randomIndices = generateUniqueRandomInts(0, possibilities.size() - 1, numIndices);
        }


        panelA.setLayout(new GridLayout(6, 1));

        // Name Label
        lblName = new JLabel(petB.getName());
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelA.add(lblName, gbc);

        // Age Label
        lblAge = new JLabel("Age: " + petB.getAge());
        lblAge.setFont(labelFont);
        gbc.gridy = 2;
        panelA.add(lblAge, gbc);

        // Gender Label
        lblGender = new JLabel("Gender: " + petB.getGender());
        lblGender.setFont(labelFont);

        gbc.gridy = 3;
        panelA.add(lblGender, gbc);

        lblTitle = JPetCreator.createImageIcon(petB.getUrl(), 250, 250);
        JLabel lbl = new JLabel(lblTitle);

        if (randomIndices.length == 0) {
            lblA = new JLabel("No interests found");
            lblA.setForeground(Color.RED);
            lblB = new JLabel("No interests found");
            lblB.setForeground(Color.RED);
            lblC = new JLabel("No interests found");
            lblC.setForeground(Color.RED);
        } else {
            // Safely access indices based on available random indices
            lblA = new JLabel(randomIndices.length > 0 ? possibilities.get(randomIndices[0]) : "No interest found");
            lblB = new JLabel(randomIndices.length > 1 ? possibilities.get(randomIndices[1]) : "No interest found");
            lblC = new JLabel(randomIndices.length > 2 ? possibilities.get(randomIndices[2]) : "No interest found");
            
        }

        panelA.add(lblA);
        panelA.add(lblB);
        panelA.add(lblC);

        add(lbl);
        add(panelA);

        BORDER = BorderFactory.createTitledBorder(petB.getName() + "'s Profile");

        setBorder(BORDER);
    }

    public JPet(Animal petA) {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create a panel for pet details
        panelA.setLayout(new GridBagLayout());

        // Name Label
        lblName = new JLabel(petA.getName());
        lblName.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelA.add(lblName, gbc);

        // Age Label
        lblAge = new JLabel("Age: " + petA.getAge());
        lblAge.setFont(labelFont);
        gbc.gridy = 2;
        panelA.add(lblAge, gbc);

        // Gender Label
        lblGender = new JLabel("Gender: " + petA.getGender());
        lblGender.setFont(labelFont);

        gbc.gridy = 3;
        panelA.add(lblGender, gbc);

        // Image Label
        lblTitle = JPetCreator.createImageIcon(petA.getUrl(), 200, 200);
        JLabel lblImage = new JLabel(lblTitle);
        add(lblImage, gbc);

        // Reset constraints for details panel
        gbc.gridx = 1;
        gbc.gridheight = 1;
        add(panelA, gbc);

        BORDER = BorderFactory.createTitledBorder(petA.getName() + "'s Profile");
        setBorder(BORDER);
    }

    /*
     * public JPet(Animal petA) {
     * 
     * super();
     * 
     * setLayout(new GridBagLayout());
     * GridBagConstraints gbc = new GridBagConstraints();
     * 
     * gbc.insets = new Insets(5, 5, 5, 5);
     * gbc.fill = GridBagConstraints.HORIZONTAL;
     * gbc.weightx = 1.0;
     * 
     * 
     * lblName = new JLabel(petA.getName());
     * 
     * lblName.setFont(new Font("Arial", Font.PLAIN, 20));
     * 
     * gbc.gridx = 1;
     * gbc.gridy = 1;
     * gbc.gridwidth = 2;
     * 
     * panelA.add(lblName);
     * 
     * 
     * lblAge = new JLabel("Age: " + petA.getAge());
     * 
     * lblAge.setFont(new Font("Arial", Font.PLAIN, 18));
     * 
     * 
     * gbc.gridx = 1;
     * gbc.gridy = 2;
     * gbc.gridwidth = 2;
     * 
     * panelA.add(lblAge);
     * 
     * 
     * 
     * lblGender = new JLabel("Gender: " + petA.getGender());
     * 
     * lblGender.setFont(new Font("Arial", Font.PLAIN, 18));
     * 
     * gbc.gridx = 1;
     * gbc.gridy = 3;
     * gbc.gridwidth = 2;
     * 
     * panelA.add(lblGender);
     * 
     * lblTitle = JPetCreator.createImageIcon(petA.getUrl(), 100, 100);
     * 
     * JLabel lbl = new JLabel(lblTitle);
     * 
     * gbc.gridx = 0;
     * gbc.gridy = 1;
     * gbc.gridwidth = 5;
     * 
     * add(lbl);
     * 
     * 
     * add(panelA);
     * 
     * BORDER = BorderFactory.createTitledBorder(petA.getName() + "'s Profile");
     * 
     * setBorder(BORDER);
     * }
     */
}
