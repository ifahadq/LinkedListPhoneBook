
public class LinkedList<T> {

	private Node head;

	public LinkedList() {
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public boolean empty() {
		return head == null;
	}

	public void add(T e) {
		if (e instanceof Event) {
			Node<Event> newNode = new Node<>((Event) e);

			if (head == null || ((Event) e).getTitle().compareToIgnoreCase(((Event) head.getData()).getTitle()) < 0) {
				newNode.setNext(head);
				head = newNode;
				System.out.println("Event added");

			} else {
				Node<Event> current = head;
				while (current.getNext() != null && ((Event) e).getTitle()
						.compareToIgnoreCase(((Event) current.getNext().getData()).getTitle()) >= 0) {
					current = current.getNext();
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				System.out.println("Event added");
			}
		} else {
			Node<Contact> newNode = new Node<>((Contact) e);

			if (head == null) {

				head = newNode;
				System.out.println("Contact added");
			} else {
				Node<Contact> current = head;
				while (current.getNext() != null && ((Contact) e).getName()
						.compareToIgnoreCase(((Contact) current.getNext().getData()).getName()) >= 0) {
					current = current.getNext();
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				System.out.println("Contact added");
			}
		}
	}

	public void addToLinkedList(T e) {
		Node<Contact> newNode = new Node<>((Contact) e);

		if (head == null) {

			head = newNode;
		} else {
			Node<Event> current = head;
			while (current.getNext() != null && ((Contact) e).getName()
					.compareToIgnoreCase(((Contact) current.getNext().getData()).getName()) >= 0) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}



	public boolean delete(T e) {
		if (empty()) {
			return false;
		} else if (head.getData().equals(e)) {
			head = head.getNext();
			return true;
		} else {
			if (e instanceof Contact) {
				Node<Contact> current = head;
				while (current != null) {
					if (current.getNext().getData().equals((Contact) e)) {
						current.setNext(current.getNext().getNext());
						return true;
					}
					current = current.getNext();
				}
			} else if (e instanceof Event) {
				Node<Event> current = head;
				while (current != null) {
					if (current.getNext().getData().equals((Event) e)) {
						current.setNext(current.getNext().getNext());

						return true;
					}
					current = current.getNext();
				}
			}
		}
		return false;
	}

	public LinkedList<Contact> SearchContactsByCriteria(int Criteria, String Value) {
		LinkedList<Contact> list = new LinkedList<>();

		Node<Contact> current = head;

		while (current != null) {
			Contact contact = (Contact) current.getData();

			if (Criteria == 1 && contact.getName().equalsIgnoreCase(Value)) {
				list.addToLinkedList(contact);
				return list;
			} else if (Criteria == 2 && contact.getPhoneNumber().equals(Value)) {
				list.addToLinkedList(contact);
				return list;
			} else if (Criteria == 3 && contact.getEmailAddress().equalsIgnoreCase(Value)) {
				list.addToLinkedList(contact);
			} else if (Criteria == 4 && contact.getAddress().equalsIgnoreCase(Value)) {
				list.addToLinkedList(contact);
			}
			if (Criteria == 5 && contact.getBirthday().equals(Value)) {
				list.addToLinkedList(contact);
			}

			current = current.getNext();
		}

		return list;
	}


	public T searchContact(String name) {
		Node<T> current = head;

		while (current != null) {
			if (current.getData() instanceof Contact) {
				Contact contact = ((Contact) current.getData());

				if (contact.getName().equalsIgnoreCase(name) || contact.getPhoneNumber().equals(name)) {

					return current.getData();
				}
			}
			else if (current.getData() instanceof Event) {
				Event event = ((Event) current.getData());

				if (event.getName().equalsIgnoreCase(name)) {

					return current.getData();
				}
			}
			current = current.getNext();
		}

		return null;
	}

	public void printEventDetails(String value) {
		Node<Event> current = head;

		while (current != null) {

			if (((Event) current.getData()).getTitle().equalsIgnoreCase(value)
					|| ((Event) current.getData()).getUserName().getName().equalsIgnoreCase(value)) {
				System.out.println(((Event) current.getData()).toString());
			}

			current = current.getNext();
		}
	}


	public void scheduleEvent(String title, String name, String date, String location, Contact UserName) {

		if (UserName != null) {
			boolean hasConflict = false;
			Event newEvent = new Event(title, name, date, location, UserName);

			Node current = head;
			while (current != null) {
				if (current.getData() instanceof Event) {
					Event existingEvent = (Event) current.getData();
					if (existingEvent.getUserName().equals(UserName)
							&& existingEvent.getDate().equals(newEvent.getDate())) {

						hasConflict = true;
						break;
					}
				}
				current = current.getNext();

			}

			if (!hasConflict) {
				add((T) newEvent);
			} else {
				System.out
						.println("We couldn't schedule an event it seems that there is already an event at this time");
			}

		} else {
			System.out.println("Contact does not exist in the phonebook.");
		}
	}

	public void printAllEvents() {
		Node<Event> current = head;

		if (head == null) {
			System.out.println("No events found.");
			return;
		}

		while (current != null) {
			System.out.println(current.getData().toString());
			current = current.getNext();
		}
	}

}
