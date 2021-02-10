package sample.tree.api;

import java.util.ArrayList;
import java.util.List;

public class Author {
	String name;
	String testField = "xxx";
	List<Book> books = new ArrayList<>();
	List<Article> articles = new ArrayList<>();

	public Author(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return new ArrayList<>(books);
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Article> getArticles() {
		return new ArrayList<Article>(articles);
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void addArticle(Article article) {
		this.articles.add(article);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
