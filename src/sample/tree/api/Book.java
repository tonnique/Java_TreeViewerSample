package sample.tree.api;

public class Book {
	
	String title;
	String ISBN;
	int year;
	Publisher publisher;
	

	public Book(String title, String isdn, int year) {
		this.title = title;
		this.ISBN = isdn;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}	
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return title;
	}
	

}
