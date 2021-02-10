package sample.tree.views;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class ViewLabelProvider extends LabelProvider {
	private final ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
	
	public String getText(Object obj) {		
		return obj.toString();
	}
	
	public Image getImage(Object obj) {		
		if (obj instanceof List) {
			return images.getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		return images.getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
}