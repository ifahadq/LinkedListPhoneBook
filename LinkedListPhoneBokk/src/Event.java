
public class Event {

	private String title;
    private String date;
    private String name;
    private String location;
    private Contact UserName;
    
    public Event(String title, String name,String date, String location, Contact UserName) {
        this.title = title;
        this.date = date;
        this.name=name;
        this.location = location;
        this.UserName = UserName;
    }

    
    
   
    
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Contact getUserName() {
		return UserName;
	}

	public void setUserName(Contact UserName) {
		this.UserName = UserName;
	}
    
	 @Override
	    public String toString() {
	        return "Event title: " + title + "\n" +
	                "Contact name: " + UserName.getName() + "\n" +
	                "Event date and time (MM/DD/YYYY HH:MM): " + date + "\n" +
	                "Event location: " + location + "\n" ;
	    }
}
