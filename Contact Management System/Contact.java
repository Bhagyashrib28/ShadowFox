import java.util.ArrayList;
import java.util.Scanner;

public class Contact {

    String name;
    String phone;
    String email;

    // Shared contact list & scanner
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Constructor
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Add contact
    public static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    // View contacts
    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            System.out.println((i + 1) + ". " + c.name + " | " + c.phone + " | " + c.email);
        }
    }

    // Update contact
    public static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter New Name: ");
            contacts.get(index).name = sc.nextLine();
            System.out.print("Enter New Phone: ");
            contacts.get(index).phone = sc.nextLine();
            System.out.print("Enter New Email: ");
            contacts.get(index).email = sc.nextLine();

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }

    // Delete contact
    public static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }
}
