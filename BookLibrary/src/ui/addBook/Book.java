package ui.addBook;

public class Book {
	private String title;
	private String id;
	private String author;
	private String publisher;
	private Boolean availability;
	
	public Book(String title, String id, String author, String publisher, Boolean availability) {
		this.title = title;
		this.id = id;
		this.author = author;
		this.publisher = publisher;
		this.availability = availability;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public Boolean getAvailability() {
		return availability;
	}
	
	public String toString() {
		return "" + getTitle() + 
				"\n" + getId() +
				"\n" + getAuthor() +
				"\n" + getPublisher() +
				"\n" + getAvailability();
	}
	
}
