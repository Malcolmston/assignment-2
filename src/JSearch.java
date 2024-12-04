import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JSearch extends JPanel {
    private JLabel searchLabel = new JLabel("Search: ");
    private JTextField searchField = new JTextField(20);
    private JButton searchButton = new JButton("Search");

    private String[][] data;
    private String[] columnNames = {"Username", "Type", "Name", "Gender", "Age"};
    private JTable table;

    // Convert String[] to ArrayList<String>
    private ArrayList<String> getDataBetter(String[] inputData) {
        return new ArrayList<>(Arrays.asList(inputData));
    }

    // Convert String[][] to ArrayList<ArrayList<String>>
    private ArrayList<ArrayList<String>> getDataBetter(String[][] inputData) {
        ArrayList<ArrayList<String>> out = new ArrayList<>();
        for (String[] row : inputData) {
            out.add(getDataBetter(row));
        }
        return out;
    }

    // Additional method to convert Animal[] to ArrayList<Animal>
    private ArrayList<Animal> getDataBetter(Animal[] animals) {
        return new ArrayList<>(Arrays.asList(animals));
    }

    private void initData() {
        try (Scanner scanner = FileReader.getScanner()) {
            data = FileReader.readFile(scanner);

            // replce any _ with a space
            for (String[] data1 : data) {
                for (int j = 0; j < data1.length; j++) {
                    data1[j] = data1[j].replace("_", " ");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error loading file: " + e.getMessage());
            data = new String[0][0]; // Prevent null pointer exceptions
        }
    }

    private int getSearchType(String search) {
        String searchLower = search.toLowerCase();
        
        ArrayList<ArrayList<String>> dataList = getDataBetter(this.data);
        
        for (ArrayList<String> row : dataList) {
            for (int colIndex = 0; colIndex < row.size(); colIndex++) {
                String cellValue = row.get(colIndex).toLowerCase();
                
                if (cellValue.contains(searchLower)) {
                    return colIndex;
                }
            }
        }
        
        return -1;
    }

    private Animal getAnimal(String searchText) {
        ArrayList<Animal> animals;
        ArrayList<ArrayList<String>> out = getDataBetter(this.data);


        for (ArrayList<String> row : out) {
            if ( row.get(2).equalsIgnoreCase(searchText) ) {   

                String type = row.get(1);
                String name = row.get(2);
                String gender = row.get(3);
                int age = Integer.parseInt(row.get(4));
                boolean[] flags = FileReader.parseFlags(row.get(5));  // Flags (binary string)
                String url = row.get(6);
                
                return switch (type) {
                    case "cat" -> new Cat(name, gender, age, flags,url);
                    case "dog" -> new Dog(name, gender, age, flags,url);
                    case "hamster" -> new Hamster(name, gender, age, flags,url);
                    case "monster" -> new Monster(name, gender, age, flags,url);
                    default -> null;
                };
                            
            }
        }

        return null;
        
    }

    private Animal[] getMyAnimals(String searchText) {
        String[][] out = FileReader.findAllOf(data, searchText);
        ArrayList<Animal> animals = FileReader.parseAnimals(out);
        
        return animals.toArray(Animal[]::new);
    }

    public JSearch() {
        setLayout(new GridLayout(2, 1));
        initData();

        // Create search panel
        JPanel sp = new JPanel();
        sp.add(searchLabel);
        sp.add(searchField);
        sp.add(searchButton);

        // Create table
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        // Make table not editable
        table.setDefaultEditor(Object.class, null);

        // Add scroll panel to table
        JScrollPane scrollPane = new JScrollPane(table);
        add(sp);
        add(scrollPane);

        // Add search functionality
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim();

            if (!searchText.isEmpty()) {
                int searchColumn = getSearchType(searchText);

                switch (searchColumn) {
                    case 0 -> {
                        // Username column
                        Animal[] usernameAnimals = getMyAnimals(searchText);
                        if (usernameAnimals.length > 0) {

                              int result = JOptionPane.showConfirmDialog(this,"Show User or Just show there pets", "Swing Tester",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null);




                                if(result == JOptionPane.YES_OPTION){
                                    Account account = new Account(searchText, usernameAnimals.length, usernameAnimals);
                                    account.show();
                                }else if (result == JOptionPane.NO_OPTION){
                                    ArrayList<Animal> als = new ArrayList<>(Arrays.asList(usernameAnimals) );
                                    Popup p = new Popup(als);
                                    p.setVisible(true);

                                }else {
                                }

                            
                        }
                    }

                    case 2 -> {
                        // Name column
                        Animal namedAnimal = getAnimal(searchText);

                        if (namedAnimal != null) {

                            namedAnimal.show();
                        }
                    }

                    default -> System.out.println("No matching results found");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Use SwingUtilities for thread-safe Swing initialization
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Search");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JSearch());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}