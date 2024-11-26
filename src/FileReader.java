import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


public final class FileReader {
    private static final String FILE_NAME = "info.txt";
    

    private static Scanner getScanner () throws FileNotFoundException {
        File f = new File(FILE_NAME);
        return new Scanner(f);
    } 

    /**
     * read a line from the file; and return the sets
     */
    private static String[] readLine(Scanner scanner) {
            String line = scanner.nextLine();
            return line.split(" ");
    }

    /**
     * Read the file and return a 2d array of the data
     * @param scanner the scanner to read the file
     * @return a 2d array of the data
     */
    public static String[][] readFile(Scanner scanner) {
        String[][] out = new String[0][0];

        while (scanner.hasNextLine()) {
            String[] arr = readLine(scanner);
            out = Arrays.copyOf(out, out.length + 1);

            out[out.length - 1] = arr;
        }

        return out;
    }

    /**
     * Remove duplicates from an arraylist
     * @param arrayList the arraylist to remove duplicates from
     * @return a cleaned arraylist without duplicates;
     */
    private static ArrayList<String> removeDupleacArrayList (ArrayList<String> arrayList) {
        ArrayList<String> out = new ArrayList<String>();

        for (String s : arrayList) {
            if (!out.contains(s)) {
                out.add(s);
            }
        }

        return out;

    }


    /** 
     * takes a tring of 11 1s and 0s and returns a boolean array
     * @param flags the string of 1s and 0s
     * @return a boolean array of the flags where 1 is true and 0 is false
     */
    private static boolean[] parseFlags (String flags) {
        boolean[] output = new boolean[12];

        String[] flagsArray = flags.split("");

        int i = 0;
        for (String flag : flagsArray) {
            output[i] = flag.equals("1");
            i++;
        }


        return output;
    }

    /**
     * Find all of a certain name in a 3d array
     * @param data the 3d array to search
     * @param name the person to search for
     * @return an list of all the lines that contain the name
     */
    public static String[][] findAllOf(String[][] data, String name) {
        String[][] out = new String[0][0];

        for (String[] line : data) {
        
            if( line[0].equals(name) ) {
                out = Arrays.copyOf(out, out.length + 1);
                out[out.length - 1] = line;
            }
        }

        return out;
    }

    /**
     * Find all accounts in a 3d array
     * @param data the 3d array to search
     * @return an list of all the account names
     */
    private static ArrayList<String> findAllAccounts (String[][] data) {
        ArrayList<String> accounts = new ArrayList<>();

        for (String[] line : data) {
            accounts.add(line[0]);
        }

        return removeDupleacArrayList(accounts);

    }

    /**
     * Parse a 2d array into an arraylist of animals
     * @param data the 2d array to parse
     * @return an arraylist of animals
     */
    private static ArrayList<Animal> parseAnimals(String[][] data) {
        ArrayList<Animal> animals = new ArrayList<>();
    
        for (String[] line : data) {
            
            try {
                String type = line[1];         // "cat", "dog", etc.
                String name = (line[2]).replace("_", " ");         // Animal name
                String gender = line[3];       // "male" or "female"
                int age = Integer.parseInt(line[4]); // Age (must be an integer)
                boolean[] flags = parseFlags(line[5]); // Flags (binary string)
    
                switch (type) {
                    case "cat" -> animals.add(new Cat(name, gender, age, flags));
                    case "dog" -> animals.add(new Dog(name, gender, age, flags));
                    case "hamster" -> animals.add(new Hamster(name, gender, age, flags));
                    case "monster" -> animals.add(new Monster(name, gender, age, flags));
                    default -> System.err.println("Unknown animal type: " + type);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing age for line: " + Arrays.toString(line) + " - Skipping this line." + " " + line[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Malformed line: " + Arrays.toString(line) + " - Skipping this line.");
            }
        }
    
        return animals;
    }
    
    private static Account parseAccount( String username, Animal[] animals) {
        return new Account(username, animals.length, animals);
    }

    public static ArrayList<Account> parse (String[][] arr) {
        ArrayList<Account> accounts = new ArrayList<>();

        ArrayList<String> uniqueAccounts = findAllAccounts(arr); // get all unique accounts

        uniqueAccounts.forEach(username -> {
            ArrayList<Animal> a = parseAnimals( findAllOf(arr, username) );

            Animal[] animalArr = a.toArray(Animal[]::new);

            accounts.add( parseAccount(username, animalArr) );
        });

        return accounts;

    }

    

    public static void main(String[] args) {
        try (Scanner scanner = getScanner()) {

                String[][] arr = readFile(scanner);


               System.out.println( parse(arr) );
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
