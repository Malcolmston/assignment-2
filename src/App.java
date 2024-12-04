import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static JPanel createPet () {
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPetCreator jp = new JPetCreator();
        mainPanel.add(jp, "Creator");

        jp.setCreateListener(pet -> {
            // Show Popup
            PreferencesDialog popup = new PreferencesDialog();
            popup.setCloseListener((dicAge, dicGender) -> {
                System.out.println("DicAge: " + dicAge + ", DicGender: " + dicGender);

                JPetFull jpf = new JPetFull(pet, dicAge, dicGender);

                mainPanel.add(jpf, "Matches");

                cardLayout.show(mainPanel, "Matches");
            });

            popup.setVisible(true);
        });

        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPetFull");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

  

        frame.add( createPet() , BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
