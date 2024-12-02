import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class JPetCreator extends JPanel implements ActionListener, ItemListener {
    private final GridLayout TOP_LAYOUT = new GridLayout(4,2);
    private JPanel inputJPanel = new JPanel(); // this will hold all inputs

    private final GridLayout ATTR_LAYOUT;


    private final JLabel NAME_TITLE = new JLabel("Name: ");
    private JTextField nameField; // name field takes a text input

    private final String[] SPECIES = new String[]{"Cat", "Dog", "Parrot", "Hamster", "Monster"}; 

    private final JLabel SPECIES_TITLE = new JLabel("Species: ");
    private JComboBox<String> speciesField = new JComboBox<>(SPECIES); // this is like html <select>

    // this creates a range for the age range, and controls the steps for the age range
    private final SpinnerModel MODEL = new SpinnerNumberModel(0, 0, 999, 1);     

    private final JLabel AGE_TITLE = new JLabel("Age: ");  // age title label
    private JSpinner ageModel = new JSpinner(MODEL); // this is like html <input type="number">

    private JPanel attributes = new JPanel(); // this will hold all the checkboxes for a pets attributes

    private ArrayList<JCheckBox> checks = new ArrayList<>(); // will hold all the checkboxes for a pets attributes

    private Border BORDER = BorderFactory.createTitledBorder("Attributes"); // this creates a border around the checkboxes


    private JButton button = new JButton("Enter");

    JPetCreator () {
        inputJPanel.add(NAME_TITLE);   
        nameField = new JTextField(10);
        inputJPanel.add(nameField);

        inputJPanel.add(SPECIES_TITLE);
        inputJPanel.add(speciesField);

        inputJPanel.add(AGE_TITLE);
        inputJPanel.add(ageModel);

        inputJPanel.setLayout(TOP_LAYOUT);

        ImageIcon icon = createImageIcon("dog.jpeg", 100, 100);
        
        JLabel image = new JLabel(icon);
        add(image);
       

        // add checkboxes for different pet attributes
        checks.add(new JCheckBox("Is adventurous"));
        checks.add(new JCheckBox("Likes taking baths"));
        checks.add(new JCheckBox("Loves cars rides"));
        checks.add(new JCheckBox("Enjoys cosplay"));
        checks.add(new JCheckBox("Likes to eat"));
        checks.add(new JCheckBox("Has lots of energy"));
        checks.add(new JCheckBox("Is very friendly"));
        checks.add(new JCheckBox("Loves running around"));
        checks.add(new JCheckBox("Likes to sleep"));
        checks.add(new JCheckBox("Likes to be pet"));
        checks.add(new JCheckBox("Likes to play"));
        checks.add(new JCheckBox("Likes to walk"));
        
        attributes.setBorder(BORDER);


        checks.forEach(attributes::add); // this is the same as a for loop; however, it is more concise.

        ATTR_LAYOUT = new GridLayout( checks.size(), 1);

        
        attributes.setLayout(ATTR_LAYOUT); 

        add(inputJPanel);
        add(attributes);

        button.addActionListener(this::actionPerformed);

        speciesField.addItemListener(this::itemStateChanged);

        add(button);

    }

    /**
     * This method will create an ImageIcon object from a path and scale it to the desired width and height.
     * @param path the path to the image
     * @param width the desired width
     * @param height the desired height
     * @return an ImageIcon object that has been scaled to the desired width and height
     */
    public static ImageIcon createImageIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        return imageIcon;
    }

    /**
     * This method will create an ImageIcon object from a URL and scale it to the desired width and height.
     * @param path the URL to the image
     * @param width the desired width
     * @param height the desired height
     * @return an ImageIcon object that has
     */
    public static ImageIcon createImageIcon(URL path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        return imageIcon;
    }


    @Override
    public final void actionPerformed(ActionEvent e) {
        System.out.println("Output");
    }

    @Override
    public final void itemStateChanged(ItemEvent e) {
         // if the state combobox 1is changed
         if (e.getSource() == speciesField) {
            System.out.println( speciesField.getSelectedItem() );
        } 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPetCreator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new JPetCreator());
        frame.setVisible(true);
    }

}
