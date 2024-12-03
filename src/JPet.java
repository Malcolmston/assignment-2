
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPet extends JPanel {
    private final JLabel lblName;
    private final JLabel lblAge;
    private final JLabel lblGender;

    private final JLabel lblA;
    private final JLabel lblB;
    private final JLabel lblC;

    private final JPanel panelA = new JPanel();

    private ImageIcon lblTitle;

    private static ArrayList<String> getValidFlags (Animal a, Animal b) {
        ArrayList<String> validFlags = new ArrayList<String>();
        
        for (int i = 0; i < a.getFlags().length; i++) {
            if (a.getFlags()[i] && b.getFlags()[i]) {
                String s = switch (i) {
                    case 1 ->  String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.adventurous());
                    case 2 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.baths());
                    case 3 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.cars());

                    case 4 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.cosplay());
                    case 5 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.eating());
                    case 6 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.energy());
                    case 7 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.friendly());
                    case 8 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.running());
                    case 9 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.sleeping());
                    case 10 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.playing());
                    case 11 -> String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                                a.walks());
                    default -> "";
                };
                validFlags.add(s);
               
            }
        }

        return validFlags;
    }

    private static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    JPet(Animal petA, Animal petB) {
        super();

        lblName = new JLabel(petB.getName());
        lblAge = new JLabel("Age " + String.valueOf(petB.getAge()));
        lblGender = new JLabel("Gender " + petB.getGender());

        lblTitle = JPetCreator.createImageIcon(petB.getUrl(), 400, 400);


        setLayout(new GridLayout(1, 2));

        int a = JPet.getRandom(1, 11);
        int b = JPet.getRandom(1, 11);
        int c = JPet.getRandom(1, 11);

        lblA = getLabelOut(a, petA, petB);
        lblB = getLabelOut(b, petA, petB);
        lblC = getLabelOut(c, petA, petB);

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

        
    }

    public final JLabel getLabelOut (int randVal, Animal a, Animal b) {
        return new JLabel( JPet.getValidFlags(a,b).get(randVal) );
    }

    public static void main(String[] args) {

       boolean[] flags = {true, false, true, false, true, false, true, false, true, false, true, false};

        Animal pet = new Cat("1", "male", 1, flags, "");
        Animal pet2 = new Cat("2", "femail", 2, flags, "");

        JPet jPet = new JPet(pet, pet2);

        JFrame frame = new JFrame("JPet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
        frame.add(jPet);
        frame.setVisible(true);

        
    }
}
