
import java.awt.GridLayout;
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

    private ImageIcon lblTitle = JPetCreator.createImageIcon("./dog.jpeg", 400, 400);


    private static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    JPet(Animal petA, Animal petB) {
        super();

        lblName = new JLabel(petB.getName());
        lblAge = new JLabel("Age " + String.valueOf(petB.getAge()));
        lblGender = new JLabel("Gender " + petB.getGender());


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
        String f = "";

        switch (randVal) {
            case 1:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.adventurous());
                break;
            case 2:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.baths());
                break;
            case 3:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.cars());
                break;
            case 4:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.cosplay());
                break;
            case 5:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.eating());
                break;
            case 6:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.energy());
                break;
            case 7:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.friendly());
                break;
            case 8:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.running());
                break;
            case 9:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.sleeping());
                break;
            case 10:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.playing());
                break;
            case 11:
                f = String.format("The pet %s and pet %s were both %s", a.getName(), b.getName(),
                        a.walks());
            default:
                break;
        }
        return new JLabel(f);

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
