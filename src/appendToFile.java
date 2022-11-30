
import java.nio.file.*;
import java.util.*;
import java.util.Scanner;
public class appendToFile {

        //     ✅ appending to file
        public static void main(String[] args) {
            List<String> contactList = new ArrayList<>();
            Scanner s = new Scanner(System.in);
            try {
                Path p = Paths.get("src/contacts.txt");
                System.out.println("Enter your name?");
                String x = s.nextLine();
                System.out.println("Enter your phone number?");
                String z = s.nextLine();
                contactList.add(x + " | " + z);
                System.out.println(contactList);
                Files.write(p, contactList, StandardOpenOption.APPEND);
                
                

//                for (int i=0;i<=5;i++) {
//                    String content = "content string" + "-->" + i;
                    
//                    Files.write(p, System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
//                }
                System.out.println("Data written as byte array");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//✅
//THIS IS APPENDED TO   DataSet/appendTestFile.txt:

//content string-->0
//content string-->1
//content string-->2
//content string-->3
//content string-->4
//content string-->5



}
