package sample.tree.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import sample.tree.api.Article;
import sample.tree.api.Author;
import sample.tree.api.Book;
import sample.tree.api.Publisher;


public class SampleTreeViewer extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "test.tree.views.TreeViewer";

	private final IWorkbench workbench;	
	private TreeViewer viewer;
	
	public SampleTreeViewer() {
		this.workbench = PlatformUI.getWorkbench();		
	}	
	
	
	@Override
	public void createPartControl(Composite parent) {		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		//viewer.setContentProvider(new TreeObjectViewContentProvider());
		viewer.setContentProvider(new AuthorContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());		
		viewer.setInput(initializeWthAuthors());
	
		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "TestTreeViewer.viewer");
		getSite().setSelectionProvider(viewer);
				
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	
	private List<Author> initializeWthAuthors() {
		List<Author> authors = new ArrayList<>();
		
		Author turgenev = new Author("Тургенев Иван Сергеевич");
		Author pushkin = new Author("Пушкин Александр Сергеевич");
		Author petrov = new Author("Петров Петр Петрович");
		
		Book mymy = new Book("Mу-Му", "IN-12345", 2006);
		mymy.setPublisher(new Publisher("Детская литература", "Санкт-Петербург"));
		turgenev.addBook(mymy);
		
		Book eo = new Book("Евгений Онегин", "IN-21345", 2002);
		eo.setPublisher(new Publisher("ЭКСМО", "Москва"));
		
		Book mv = new Book("Медный всадник", "IN-31245", 2001);
		mv.setPublisher(new Publisher("Молодая гвардия", "Москва"));
		pushkin.addBook(eo);
		pushkin.addBook(mv);
		
		Article aboutLove = new Article("О Характерах", 2015);
		petrov.addArticle(aboutLove);
		
		authors.add(turgenev);
		authors.add(pushkin);
		authors.add(petrov);
		
		return authors;
	}
}
