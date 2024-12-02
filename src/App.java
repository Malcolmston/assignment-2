import java.io.FileNotFoundException;
import java.util.Scanner;


public class app {
public static void main(String[] args) {
        try (Scanner scanner = FileReader.getScanner()) {

                String[][] arr = FileReader.readFile(scanner);


               System.out.println( FileReader.parse(arr) );
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
