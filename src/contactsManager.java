
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class contactsManager {



    public static void main(String[] args) throws IOException {

        List<String> r = Arrays.asList("Name       | Phone Number\n" + "--------------------------");
        Path p = Paths.get("src/contacts.txt");
        Files.write(p,r);

        String choice;
        do {
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
            Scanner s = new Scanner(System.in);
            int userInput = s.nextInt();

            if (userInput == 1) {
                viewContacts();
            } else if (userInput == 2) {
                addContact();
            } else if (userInput == 3) {
                searchName();
            } else if (userInput == 4) {
                deleteContact();
            } else {
                System.out.println("Thank you and Have a good day!");
                break;
            }
            System.out.println("Would you like to continue? Y/N");
            choice = s.next();
        } while (choice.equalsIgnoreCase("y"));
    }

    public static void addContact() {
        List<String> contactList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        try {
            Path p = Paths.get("src/contacts.txt");
            System.out.println("Enter new contact name?");
            String newContact = s.nextLine();
            System.out.println("Enter new contact phone number?");
            String newNumber = s.nextLine();
            String w = newNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            contactList.add(String.format("%1$-10s |%2$-15s |", newContact,w));
            Files.write(p, contactList, StandardOpenOption.APPEND);
            System.out.printf("Added %s \n", newContact);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewContacts(){
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

    public static void searchName(){
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Which contact do you like to see?");
            String contact = s.nextLine();
            Path p = Paths.get("src/contacts.txt");
//          List<String> newArray = new ArrayList<>();
            List<String> data = Files.readAllLines(p);

            for (int i = 0; i < data.size(); i += 1) {
                if(data.get(i).contains(contact)){
                    System.out.println(data.get(i));
//                  newArray.add(data.get(i));
//                  Files.write(p, newArray);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteContact(){
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter the contact by name to delete?");
            String delStr = s.nextLine();
            Path p = Paths.get("src/contacts.txt");

            List<String> data = Files.readAllLines(p);
            List<String> newList = new ArrayList<>();
            for (String line: data) {
                if(line.contains(delStr)){
                    newList.add(" ");
                    continue;
                }
                newList.add(line);
            }
            Files.write(p, newList);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

