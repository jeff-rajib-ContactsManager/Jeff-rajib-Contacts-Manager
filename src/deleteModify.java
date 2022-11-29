
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deleteModify {

    public static void main(String[] args) throws IOException {
        //Manipulating files - Find line and REPLACE, could be a 'delete' method if we replace with a blank (empty) string [D]

        String directory = "./src";

        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);

        Path dataFile = Paths.get(directory, filename);

        System.out.println("dataDirectory = " + dataDirectory);
        System.out.println("dataFile = " + dataFile);



        Path groceryListPath = Paths.get(directory, filename);

        System.out.println("Files.exists(groceryListPath) = " + Files.exists(groceryListPath));

        //How about some update operations [U]?
        //We need to tell Java we want to USE THE SAME FILE
        //UPDATE that FILE
        //But not literally create a new file




        List<String> printListFromFile = Files.readAllLines(groceryListPath);
        System.out.println(printListFromFile);

        printListFromFile = Files.readAllLines(groceryListPath);

        for(int i = 0; i < printListFromFile.size(); i++){
            System.out.println(printListFromFile.get(i));
        }

        //Manipulating files - Find line and REPLACE, could be a 'delete' method if we replace with a blank (empty) string [D]

        printListFromFile = Files.readAllLines(groceryListPath);

        List<String> newList = new ArrayList<>();

        for(String line : printListFromFile){
            if(line.equalsIgnoreCase("New contact")){
                newList.add(" ");
                continue;
            }

            newList.add(line);
        }

        System.out.println(printListFromFile);
        System.out.println("~~~~~");
        System.out.println(newList);

        //Nice - we replaced that boring cheese with some nice fancy cheese; let's get it into our File

        Files.write(groceryListPath, newList);

    }

    }



