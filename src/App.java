import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JPetFull");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPetCreator jp = new JPetCreator();
        mainPanel.add(jp, "Creator");

        jp.setCreateListener(pet -> {
            // Show Popup
            Popup popup = new Popup();
            popup.setCloseListener((dicAge, dicGender) -> {
                System.out.println("DicAge: " + dicAge + ", DicGender: " + dicGender);

                JPetFull jpf = new JPetFull(pet, dicAge, dicGender);

                mainPanel.add(jpf, "Matches");

                cardLayout.show(mainPanel, "Matches");
            });

            popup.setVisible(true);
        });

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
