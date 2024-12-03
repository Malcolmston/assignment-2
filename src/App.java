
import javax.swing.JFrame;



public class App {


public static void main(String[] args) {
    
    boolean[] flags = {true, false, true, false, true, false, true, false, true, false, true, false};


    Animal pet = new Cat("Buddy", "male", 3, flags, "");


    JPetFull jpf = new JPetFull(pet);

    JFrame frame = new JFrame("JPetFull");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(jpf);
    frame.setSize(800, 600);
    frame.setVisible(true);


    }

}
