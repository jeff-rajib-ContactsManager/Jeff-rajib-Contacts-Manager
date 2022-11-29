
//        We will be building a command line application for keeping track of "contacts". A contact will be comprised of a a name and phone number combination.
//
//        The application should be able to:
//
//        Show all your contacts
//        Add a new contact
//        Search a contact by her name
//        Delete an existing contact
//        The application should keep its data in a file named contacts.txt so that the information persists between runs of the application.
//
//        How you implement the above functionality is ultimately up to you, but here are a few thoughts to get you started.
//
//        The text file should contain one contact per line.
//        When the application starts, the contact list should be read from the file.
//        Before the application exits, the contacts file should be rewritten.
//        The user interface for your application should include a main menu like the following, where the user will need to enter a number between 1 and 5:
//
//        1. View contacts.
//        2. Add a new contact.
//        3. Search a contact by name.
//        4. Delete an existing contact.
//        5. Exit.
//        Enter an option (1, 2, 3, 4 or 5):
//        The contacts information should be shown using the following format
//
//        Name | Phone number
//        ---------------
//        Jack Blank | 1231231234
//        Jane Doe | 2342342345
//        Sam Space | 3453453456
//        Here is what the code for your application might look like:
//
//        Load all of the contacts by calling a method that returns a List of Contact objects.
//        Call a method that shows the user the main menu and returns their choice of action.
//        Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of Contact objects if applicable).
//        Keep calling the method from step two until the user chooses to exit.
//        Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of Contact objects.
import java.util.Scanner;

public class contactsManager {

    public static void main(String[] args) {

        System.out.println(" 1. View contacts.\n" +
                            "2. Add a new contact.\n" +
                            "3. Search a contact by name.\n" +
                            "4. Delete an existing contact.\n" +
                            "5. Exit.\n" +
                            "Enter an option (1, 2, 3, 4 or 5):");
        Scanner s = new Scanner(System.in);
        s.nextInt();
    }
}
