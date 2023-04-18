package com.Homework_11;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactManager {

    private ArrayList<Contact> contacts;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts to display.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContacts(String query) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }

    public void deleteContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void editContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Enter new name (leave blank to keep current name):");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    contact.setName(name);
                }
                System.out.println("Enter new email (leave blank to keep current email):");
                String email = scanner.nextLine();
                if (!email.isEmpty()) {
                    contact.setEmail(email);
                }
                System.out.println("Enter new date of birth in dd/MM/yyyy format (leave blank to keep current date of birth):");
                String dateOfBirthString = scanner.nextLine();
                if (!dateOfBirthString.isEmpty()) {
                    try {
                        Date dateOfBirth = dateFormat.parse(dateOfBirthString);
                        contact.setDateOfBirth(dateOfBirth);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Date not updated.");
                    }
                }
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("\nCONTACT MANAGER\n");
            System.out.println("1. Add contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Search contacts");
            System.out.println("4. Delete contact");
            System.out.println("5. Edit contact");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = Integer.parseInt(contactManager.scanner.nextLine());

            switch (choice) {
            case 1:
                System.out.print("\nEnter name: ");
                String name = contactManager.scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = contactManager.scanner.nextLine();
                System.out.print("Enter email: ");
                String email = contactManager.scanner.nextLine();
                System.out.print("Enter date of birth in dd/MM/yyyy format: ");
                String dateOfBirthString = contactManager.scanner.nextLine();

                try {
                    Date dateOfBirth = contactManager.dateFormat.parse(dateOfBirthString);
                    Contact contact = new Contact(name, phoneNumber, email, dateOfBirth);
                    contactManager.addContact(contact);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Contact not added.");
                }
                break;

            case 2:
                contactManager.displayContacts();
                break;

            case 3:
                System.out.print("\nEnter search query: ");
                String query = contactManager.scanner.nextLine();
                contactManager.searchContacts(query);
                break;

            case 4:
                System.out.print("\nEnter phone number of contact to delete: ");
                String phoneNumberToDelete = contactManager.scanner.nextLine();
                contactManager.deleteContact(phoneNumberToDelete);
                break;

            case 5:
                System.out.print("\nEnter phone number of contact to edit: ");
                String phoneNumberToEdit = contactManager.scanner.nextLine();
                contactManager.editContact(phoneNumberToEdit);
                break;

            case 6:
                System.out.println("\nGoodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("\nInvalid choice. Please enter a number between 1 and 6.");
                break;
            }
        }
    }
}
