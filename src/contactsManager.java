
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
// prints out the table in p Path
        List<String> r = Arrays.asList("Name       | Phone Number\n" + "--------------------------");
        Path p = Paths.get("src/contacts.txt");
        Files.write(p,r);

        String choice;
        do {
//            ✅✅✅✅✅✅✅✅✅
//            Displaying menu
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
//            ✅✅✅✅✅✅✅✅✅
//           Scanning for user input and
            Scanner s = new Scanner(System.in);
            int userInput = s.nextInt();
//            ✅✅✅✅✅✅✅✅✅
//            Running the method based on userInput
            if (userInput == 1) {
                viewContacts();//🟨🟨🟨🟨🟨🟨🟨
            } else if (userInput == 2) {
                addContact();//⬜⬜⬜⬜⬜⬜⬜⬜
            } else if (userInput == 3) {
                searchName();//️🟪️🟪️🟪️🟪️🟪️🟪️🟪
            } else if (userInput == 4) {
                deleteContact();//❌❌❌❌❌❌❌
            } else {
                System.out.println("Thank you and Have a good day!");
                break;
            }
            System.out.println("Would you like to continue? Y/N");
            choice = s.next();
        } while (choice.equalsIgnoreCase("y"));
    }

    public static void viewContacts(){//🟨🟨🟨🟨🟨🟨🟨
        try {
//            getting path and assigning it to p
            Path p = Paths.get("src/contacts.txt");

//            Read all lines in p and assigning to array list of data
            List<String> data = Files.readAllLines(p);

            for (String s : data) {
//                Printing out all strings in data
                System.out.println(s);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addContact() {//⬜⬜⬜⬜⬜⬜⬜⬜
        List<String> contactList = new ArrayList<>();
//        Adding a scanner
        Scanner s = new Scanner(System.in);
        try {
//            getting path and assigning it to p
            Path p = Paths.get("src/contacts.txt");
            System.out.println("Enter new contact name?");
//            getting user input and assigning it to newContact
            String newContact = s.nextLine();

            try {
//                getting path and assigning it to np
                Path np = Paths.get("src/contacts.txt");
                List<String> data = Files.readAllLines(np);

//                String n in data
                for (String n : data) {
//                    if n matches newContact
                    if (n.contains(newContact)) {
//                        prints newContact + " already exists! try again" closes program
                        System.out.println(newContact + " already exists! try again");
                        System.exit(0);
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Enter new contact phone number?");
//            Assigns user number to newNumber
            String newNumber = s.nextLine();
//            Giving newNumbers tac lines assigning sNumber
            String sNumber = newNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
//            adding Pipes to newContact & sNumber
            contactList.add(String.format("%1$-10s |%2$-15s |", newContact,sNumber));
//            Appending newContact & sNumber to p
            Files.write(p, contactList, StandardOpenOption.APPEND);
            System.out.printf("Added %s \n", newContact);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchName(){//️🟪️🟪️🟪️🟪️🟪️🟪️🟪
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Which contact would you like to see?");
//            Assigns user input to the String contact
            String contact = s.nextLine();
//                getting path and assigning it to np
            Path p = Paths.get("src/contacts.txt");
//          List<String> newArray = new ArrayList<>();
            List<String> data = Files.readAllLines(p);

//            if i matches contact, prints data.get(i)
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
    public static void deleteContact(){//❌❌❌❌❌❌❌
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter the contact by name to delete?");
//            gets user input and assigns it delStr
            String delStr = s.nextLine();
//                getting path and assigning it to p
            Path p = Paths.get("src/contacts.txt");

//            Read all lines in p and assigning to array list of data
            List<String> data = Files.readAllLines(p);

//            Made new Array list called newList
            List<String> newList = new ArrayList<>();
//            for line in data
            for (String line: data) {
//                if line matches delStr
                if(line.contains(delStr)){
//                    adding an empty string
                    newList.add(" ");
                    continue;
                }
//
                newList.add(line);
            }
//            Adding an empty String to p
            Files.write(p, newList);
//            Printing out delStr was deleted
            System.out.println(delStr + " was deleted");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

