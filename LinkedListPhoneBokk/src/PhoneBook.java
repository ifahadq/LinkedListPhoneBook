import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PhoneBook {
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Linked Tree Phonebook!");
		int choise = 0;
		while (true) {

			System.out.println("Please choose an option:\r\n" + "1. Add a contact\r\n" + "2. Search for a contact\r\n"
					+ "3. Delete a contact\r\n" + "4. Schedule an event\r\n" + "5. Print event details\r\n"
					+ "6. Print contacts by first name\r\n" + "7. Print all events alphabetically\r\n" + "8. Exit");
			System.out.println("Enter your choice : ");
			try {
				choise = input.nextInt();
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Something bad happened");
				continue;

			}
			switch (choise) {

			case 1:

				int i;
				String s1;
				String s2;
				String s3;
				String s4;
				String s5;
				String s6;
				input.nextLine();
				System.out.println("Enter the contact's name:");
				s1 = input.nextLine();

				System.out.println("Enter the contact's phone number:");
				s2 = input.nextLine();
				System.out.println("Enter the contact's email address:");
				s3 = input.nextLine();

				System.out.println("Enter the contact's address:");
				s4 = input.nextLine();
				System.out.println("Enter the contact's birthday:");
				s5 = input.nextLine();
				System.out.println("Enter any notes for the contact:");
				s6 = input.nextLine();
				if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")
						|| s6.equals("")) {
					System.out.println("you entered a blanked value");
					break;
				}
				Contact con = new Contact(s1, s2, s3, s4, s5, s6);
				book.addContact(con);
				break;

			case 2:

				book.searchcontact();

				break;
			case 3:

				System.out.println("Delete by:\n1-Name:\n2-Phone number:");
				i = input.nextInt();

				String g;
				while (i > 0 && i < 3) {

					if (i == 1) {
						System.out.println("Please enter the contact's name:");
//						
						input.nextLine();

						i = 10;
						book.deleteContact(input.nextLine());
					} else {
						System.out.println("Please enter the contact's number");

						input.nextLine();

						i = 10;
						book.deleteContact(input.nextLine());
					}

				}
				break;
			case 4:
				
				input.nextLine();
				System.out.println("Enter the event title;");
				s1 = input.nextLine();

				System.out.println("Enter contact name:");
				s2 = input.nextLine();
				
				
				 
			        

			        System.out.print("Enter the date for the event (yyyy-MM-dd): ");
			        String date = input.nextLine();
			        String format = "yyyy-MM-dd";

			        if (!isValidDate(date, format)) {
			        	System.out.println("Invalid date or date is in the past. Please try again.");
			            // Further code to handle the event creation
			        	break;
			        }
				
				System.out.println("Enter event location:");
				s4 = input.nextLine();
				if (s1.equals("") || s2.equals("") || date.equals("") || s4.equals("")) {
					System.out.println("you entered a blanked value");
					break;}
				book.scheduleEvent(s1, s2, date, s4);
				break;
			case 5:
				System.out.println("Enter search criteria:\r\n" + "1. contact name\r\n" + "2. Event tittle");
				try {
					i = input.nextInt();
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("Something bad happened");
					continue;

				}
				if (i == 1) {
					System.out.println("Enter the contact name:");
					input.nextLine();
					s1 = input.nextLine();

					book.printEventDetail(s1);
				} else if (i == 2) {
					System.out.println("Enter the event title:");

					input.nextLine();
					book.printEventDetail(input.nextLine());
				}
				break;
			case 6:
				System.out.println("Enter the first name:");
				input.nextLine();

				book.printcontactByFirstName(input.nextLine());
				break;
			case 7:
				book.printAllevent();
				break;
			case 8:
				System.out.println("Good bye");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input.");

			}
		}
	}


	private LinkedList<Contact> contact;
	private LinkedList<Event> event;

	public PhoneBook() {
		contact = new LinkedList<>();
		event = new LinkedList<>();
	}

	public void addContact(Contact c) {

		if (contact.empty()) {
			contact.add(c);
			return;
		}

		Node<Contact> current = contact.getHead();
		while (current != null) {
			if (c.getName().equalsIgnoreCase(current.getData().getName())
					|| c.getPhoneNumber().equalsIgnoreCase(current.getData().getPhoneNumber())
					|| c.getEmailAddress().equalsIgnoreCase(current.getData().getEmailAddress())) {
				System.out.println("Contact already exist");
				return;
			}
			current = current.getNext();
		}
		contact.add(c);

	}

	public void deleteContact(String value) {

		if (contact.searchContact(value) == null) {
			System.out.println("No contact found.");

			return;
		}
		Event event = this.event.searchContact(value);
		if (this.contact.delete(this.contact.searchContact(value))) {
			while (event != null) {
				this.event.delete(event);
				event = this.event.searchContact(value);
			}
			System.out.println("Contact deleted");

		}

	}

	public void searchcontact() {
		try {
			Scanner input = new Scanner(System.in);

			System.out.println("Enter search criteria:");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email Address");
			System.out.println("4. Address");
			System.out.println("5. Birthday");

			System.out.print("Enter your choice: ");

			int criteria = input.nextInt();

			String value;
			switch (criteria) {
			case 1:
				input.nextLine();
				System.out.print("Enter the contact's name: ");
				value = input.nextLine();
				printContact(contact.SearchContactsByCriteria(1, value));
				break;
			case 2:
				System.out.print("Enter the contact's phone number: ");
				input.nextLine();
				value = input.nextLine();
				printContact(contact.SearchContactsByCriteria(2, value));
				break;
			case 3:
				System.out.print("Enter the contact's email address: ");
				input.nextLine();
				value = input.nextLine();
				printContact(contact.SearchContactsByCriteria(3, value));
				break;
			case 4:
				System.out.print("Enter the contact's address: ");
				input.nextLine();
				value = input.nextLine();
				printContact(contact.SearchContactsByCriteria(4, value));
				break;
			case 5:
				System.out.print("Enter the contact's birthday: ");
				input.nextLine();
				value = input.nextLine();
				printContact(contact.SearchContactsByCriteria(5, value));
				break;
			default:
				System.out.println("Wrong choice, please enter a choice again.");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ops somthing went wrong!");
		}
	}

	private void printContact(LinkedList<Contact> value) {

		if (value.getHead() == null) {
			System.out.println("No contact found.");
			return;
		}
		Node<Contact> current = value.getHead();

		while (current != null) {
			Contact contact = current.getData();
			System.out.println("Name: " + contact.getName());
			System.out.println("Phone Number: " + contact.getPhoneNumber());
			System.out.println("Email Address: " + contact.getEmailAddress());
			System.out.println("Address: " + contact.getAddress());
			System.out.println("Birthday: " + contact.getBirthday());
			System.out.println("Notes: " + contact.getNotes());
			current = current.getNext();
		}

	}

	public void printcontactByFirstName(String firstName) {
		Node<Contact> current = contact.getHead();
		LinkedList<Contact> list = new LinkedList<>();

		while (current != null) {
			if (firstName.equalsIgnoreCase(current.getData().getFirstName())) {
				list.addToLinkedList(current.getData());
			}
			current = current.getNext();
		}
		printContact(list);
	}

	public void scheduleEvent(String title, String name, String date, String location) {
		Contact userName = contact.searchContact(name);
		event.scheduleEvent(title, name, date, location, userName);
	}

	public void printAllevent() {
		event.printAllEvents();
		;
	}

	public void printEventDetail(String value) {
		event.printEventDetails(value);
	}
	 
	   public static boolean isValidDate(String dateStr, String format) {
	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	            LocalDate date1 = LocalDate.parse(dateStr, formatter);
	            LocalDate currentDate = LocalDate.now();

	            // Check if the parsed date is valid and in the future
	            return !date1.isBefore(currentDate);
	        } catch (DateTimeParseException e) {
	            return false;
	        }}}
