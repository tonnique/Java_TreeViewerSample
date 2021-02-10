package sample.tree.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;

import sample.tree.api.Article;
import sample.tree.api.Author;
import sample.tree.api.Book;

public class AuthorContentProvider implements ITreeContentProvider {
	
	public Object[] getElements(Object parent) {
		if (parent instanceof ArrayList) {
			ArrayList<?> authors = (ArrayList<?>) parent;
			if (authors.get(0) instanceof Author) {				
				return authors.toArray();	
			}						
		}
		return getChildren(parent);
	}
	
	public Object getParent(Object child) {
		return null;
	}
	
	public Object [] getChildren(Object parent) {
		List<Object> children = new ArrayList<>();
		if (parent instanceof Author) {
			Author author = (Author) parent;
			if (author.getArticles().size() > 0) {
				for (Article article : author.getArticles()) {
					children.add(article);	
				}					
			}
			if (author.getBooks().size() > 0) {
				for (Book book : author.getBooks()) {
					children.add(book);	
				}					
			}
			children.add("-=-");
			return children.toArray();
		}
		if (parent instanceof ArrayList) {
			return ((ArrayList<?>) parent).toArray();
		}
		if (parent instanceof Book) {
			Book book = (Book) parent;
			children.add(book.getISDN());
			children.add(book.getYear());
			children.add(book.getPublisher());			
			return children.toArray();
		}
		if (parent instanceof Article) {
			Article article = (Article) parent;
			children.add(article.getYear());						
			return children.toArray();
		}		
		return new Object[0];
	}
	
	public boolean hasChildren(Object parent) {
		
		boolean hasChildren = false;
		if (parent instanceof Author) {
			Author author = ((Author)parent); 
			hasChildren = author.getBooks().size() > 0 || author.getArticles().size() > 0;			
		} 
		if (parent instanceof Book) {
			hasChildren = true;			
		}
		if (parent instanceof Article) {
			hasChildren = true;			
		} 
		if (parent instanceof ArrayList) {
			ArrayList<?> list = (ArrayList<?>) parent;
			hasChildren = list.size() > 0;
		}
		return hasChildren;		
	}

}
