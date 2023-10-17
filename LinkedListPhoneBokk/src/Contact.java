public class Contact implements Comparable<Contact> {
	

	public void setContact(LinkedList<Contact> contact) {
		this.contact = contact;
	}

	private LinkedList<Contact> contact;
	private LinkedList<Event> event;
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private String birthday;
	private String notes;
	private String firstName;

	public Contact() {

	}

	public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
			String notes) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		this.event = new LinkedList<>();
		firstName=this.findFirstName(this.name);
		
	}
	
		
		public String findFirstName(String name) {
		    String[] names = name.split(" ");
		    return names[0];
		
		}
	@Override
	public int compareTo(Contact other) {

		int diff = this.name.compareTo(other.getName());
		return diff;
	}

	public LinkedList<Contact> getContact() {
		return contact;
	}

	public LinkedList<Event> getEvents() {
		return event;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
