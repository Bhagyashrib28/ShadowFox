import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    Contact.addContact();
                    break;
                case 2:
                    Contact.viewContacts();
                    break;
                case 3:
                    Contact.updateContact();
                    break;
                case 4:
                    Contact.deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
