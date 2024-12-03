import java.awt.BorderLayout;
import javax.swing.JFrame;

public class App {
    private static JPetFull jpf;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("JPetFull");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for simplicity

        // Initialize Popup
        Popup popup = new Popup();

        // Example animal
        boolean[] flags = { true, false, true, false, true, false, true, false, true, false, true, false };
        Animal pet = new Cat("Buddy", "male", 3, flags, "");

        // Set Popup's close listener
        popup.setCloseListener((dicAge, dicGender) -> {
            System.out.println("DicAge: " + dicAge + ", DicGender: " + dicGender);

            // Create JPetFull with settings from Popup
            jpf = new JPetFull(pet, dicAge, dicGender);

            frame.getContentPane().removeAll(); 
            frame.add(jpf, BorderLayout.CENTER); 
            frame.repaint();  
        });

        // Show the Popup
        popup.setVisible(true);

        // Show the main frame
        frame.setVisible(true);
    }
}
