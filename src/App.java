import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose The driver class for our program
 */
public class App {
    public static JPanel createPet() {


        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPetCreator jp = new JPetCreator();
        mainPanel.add(jp, "Creator");

        JButton claButton = new JButton("Clear Result");


        jp.setCreateListener(pet -> {
            // Show Popup
            PreferencesDialog popup = new PreferencesDialog();
            popup.setCloseListener((dicAge, dicGender) -> {
                System.out.println("DicAge: " + dicAge + ", DicGender: " + dicGender);

                if( pet != null) {
                JPetFull jpf = new JPetFull(pet, dicAge, dicGender);

                mainPanel.add(jpf, "Matches");

                cardLayout.show(mainPanel, "Matches");

                claButton.setVisible(true);


                } else {
                    System.out.println("No pet selected.");
                }
            });

        });



        claButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "Creator");
        });


        return mainPanel;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("JPetFull");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane tabPanel = new JTabbedPane();

            tabPanel.addTab("Create Pet", createPet());
            tabPanel.addTab("Search Pet", new JSearch());

            frame.add(tabPanel, BorderLayout.CENTER);


            frame.setVisible(true);
        });
    }
}
