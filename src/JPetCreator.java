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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose a jpanel to allow users to create pets. This panel will take the newly created pet and handle events allowing the code to be interacted with via event handles
 */

public class JPetCreator extends JPanel implements ActionListener, ItemListener {
    private final GridLayout TOP_LAYOUT = new GridLayout(4, 2);
    private final JPanel inputJPanel = new JPanel(); // this will hold all inputs

    private final GridLayout ATTR_LAYOUT;

    private final JLabel NAME_TITLE = new JLabel("Name: ");
    private final JTextField nameField; // name field takes a text input

    private final String[] SPECIES = new String[] { "Cat", "Dog", "Hamster", "Monster" };
    private final String[] URLS = new String[] { "images/che.jpg", "images/Bobert.jpeg", "images/Bacon.jpeg", "images/Joe.jpeg" };

    private final JLabel SPECIES_TITLE = new JLabel("Species: ");
    private final JComboBox<String> speciesField = new JComboBox<>(SPECIES); // this is like html <select>

    private final JLabel GENDER_TITLE = new JLabel("Gender: ");

    private final String[] POS_GENDERS = {"Male", "Female"};
    private final JComboBox<String> genderField = new JComboBox<>(POS_GENDERS);

    // this creates a range for the age range, and controls the steps for the age
    // range
    private final SpinnerModel MODEL = new SpinnerNumberModel(0, 0, 999, 1);

    private final JLabel AGE_TITLE = new JLabel("Age: "); // age title label
    private final JSpinner ageModel = new JSpinner(MODEL); // this is like html <input type="number">

    private final JPanel attributes = new JPanel(); // this will hold all the checkboxes for a pets attributes

    private final ArrayList<JCheckBox> checks = new ArrayList<>(); // will hold all the checkboxes for a pets attributes

    private final Border BORDER = BorderFactory.createTitledBorder("Attributes"); // this creates a border around the
                                                                            // checkboxes

    private final JButton button = new JButton("Enter");

    private ImageIcon icon;

    private final JLabel image;

    private Animal animal;

    private CreateListener listener;

    public void setCreateListener(CreateListener listener) {
        this.listener = listener;
    }

    private void changeImg() {
        // Get the selected index of the species
        int selectedIndex = speciesField.getSelectedIndex();

        // Update the icon with the correct image
        icon = createImageIcon(URLS[selectedIndex], 250, 250);
        // Update the JLabel with the new icon
        image.setIcon(icon);

        revalidate();
        repaint();
    }

    JPetCreator() {
        inputJPanel.add(NAME_TITLE);
        nameField = new JTextField(10);
        inputJPanel.add(nameField);

        inputJPanel.add(GENDER_TITLE);
        inputJPanel.add(genderField);


        inputJPanel.add(SPECIES_TITLE);
        inputJPanel.add(speciesField);

        inputJPanel.add(AGE_TITLE);
        inputJPanel.add(ageModel);

        inputJPanel.setLayout(TOP_LAYOUT);

        icon = createImageIcon(URLS[0], 100, 100);

        image = new JLabel(icon);
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

        ATTR_LAYOUT = new GridLayout(checks.size(), 1);

        attributes.setLayout(ATTR_LAYOUT);

        add(inputJPanel);
        add(attributes);

        button.addActionListener(this::actionPerformed);

        speciesField.addItemListener(this::itemStateChanged);

        add(button);

        changeImg();

    }

    /**
     * This method will create an ImageIcon object from a path and scale it to the
     * desired width and height.
     * 
     * @param path   the path to the image
     * @param width  the desired width
     * @param height the desired height
     * @return an ImageIcon object that has been scaled to the desired width and
     *         height
     */
    public static ImageIcon createImageIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg); // transform it back

        return imageIcon;
    }

    /**
     * This method will create an ImageIcon object from a URL and scale it to the
     * desired width and height.
     * 
     * @param path   the URL to the image
     * @param width  the desired width
     * @param height the desired height
     * @return an ImageIcon object that has
     */
    public static ImageIcon createImageIcon(URL path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg); // transform it back

        return imageIcon;
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        System.out.println("Output");
        // create a pet from the given data

        String name = nameField.getText();
        String species = (String) speciesField.getSelectedItem();
        int age = (int) ageModel.getValue();
        String gender = (String) genderField.getSelectedItem();

        boolean[] flags = new boolean[12];

        String url = URLS[speciesField.getSelectedIndex()];


        for (int i = 0; i < flags.length; i++) {
            flags[i] = checks.get(i).isSelected();
        }

        if( name.isEmpty() || name.trim().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please enter a pen name",
               "Error", JOptionPane.ERROR_MESSAGE);
               
        } else if ( species.isEmpty() || species.trim().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please select a species",
               "Error", JOptionPane.ERROR_MESSAGE);
        } else if ( age < 0 ) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age",
               "Error", JOptionPane.ERROR_MESSAGE);
        } else if ( gender.isEmpty() || gender.trim().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please select a gender",
               "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            System.out.println("Creating new pet: " + name + ", " + species + ", " + age + ", " + gender);

            if( species.equalsIgnoreCase("cat") ) {
                this.animal =  new Cat(name, gender, age, flags, url);
            } else if ( species.equalsIgnoreCase("dog") ) {
                this.animal =  new Dog(name, gender, age, flags, url);
            } else if ( species.equalsIgnoreCase("hamster") ) {
                this.animal =  new Hamster(name, gender, age, flags, url);
            } else if ( species.equalsIgnoreCase("monster") ) {
                this.animal =  new Monster(name, gender, age, flags, url);
            } 
            


        if (listener != null) {
            listener.onClose(this.animal);
        }
    }

        
    }

    @Override
    public final void itemStateChanged(ItemEvent e) {
        if (e.getSource() == speciesField) {
            changeImg();
        }
    }

    public Animal getAnimal() {
        return animal;
    }


    

}
