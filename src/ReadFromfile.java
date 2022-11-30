
import java.nio.file.*;
import java.util.*;

public class ReadFromfile {

    public static void main(String[] args) {
        try {
            Path p = Paths.get("src/contacts.txt");

            List<String> data = Files.readAllLines(p);

            for (String s : data) {
                System.out.println(s);

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}