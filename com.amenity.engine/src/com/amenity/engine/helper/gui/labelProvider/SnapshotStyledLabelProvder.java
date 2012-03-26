package com.amenity.engine.helper.gui.labelProvider;

import general.ContentObject;
import general.File;
import general.Folder;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.hibernate.Session;

import dao.impl.HibernateUtilImpl;

public class SnapshotStyledLabelProvder extends StyledCellLabelProvider  {

	public java.util.List<ContentObject> contentObjects;
	
	public SnapshotStyledLabelProvder (  ){
		contentObjects = null;
	}
	public SnapshotStyledLabelProvder ( java.util.List<ContentObject> fileList ){
		contentObjects = fileList;
	}
	
	@Override
	public void update(ViewerCell cell) {
		// fetch cell element
		Object element = cell.getElement();
		StyledString text = new StyledString();
		if ( contentObjects == null ) {
			Session s = HibernateUtilImpl.getSessionFactoryEdefault().openSession();
			
			if (element instanceof Folder) {
				// if element is a file set its name and style if it is part of a function
				Folder folder = (Folder) element;
				s.beginTransaction();
				s.load(folder, folder.getObjectId());
				
				text.append(folder.getName());
				cell.setImage(PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_FOLDER));

				if ( ((Folder)element).isDummy() ) {
					
					colorErrorCell(cell);
					cell.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
					
				}else 
				if ( ((Folder) element).getFunction().size() > 0  ) {
					
					colorCell(cell);
					
				}
			} else {
				File file = (File) element;
				s.beginTransaction();
				s.load(file, file.getObjectId());
				
				text.append(file.getName());
				cell.setImage(PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_FILE));
				
				if ( ((File)element).isDummy() ) {
					cell.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
					colorErrorCell(cell);
					
				}else 
					if ( ((File)element).getFunction().size() > 0 ) {
					
					colorCell(cell);
				
				}
			}
			s.close();
		} else {
			if ( element instanceof Folder ) {
				Folder folder = (Folder) element;
				for ( ContentObject co : contentObjects ) {
					if ( co.getObjectId().equals(folder.getObjectId())) {
						text.append(co.getName());
						cell.setImage(PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FOLDER));
						break;
					}
				}
				if ( ((Folder)element).isDummy() ) {
					
					colorErrorCell(cell);
					cell.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
					
				}else 
					if ( ((Folder) element).getFunction().size() > 0  ) 
						
					colorCell(cell);
				
			} else {
				File file = (File) element;
				for ( ContentObject co : contentObjects ) {
					if ( co.getObjectId().equals(file.getObjectId())) {
						text.append(co.getName());
						cell.setImage(PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FILE));
						break;
					}
				}
				if ( ((File)element).isDummy() ) {
					
					colorErrorCell(cell);
					cell.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
					
				}else 
					if ( ((File) element).getFunction().size() > 0  ) 
						
					colorCell(cell);
				
			}
		}
		
		
		cell.setText(text.toString());
		
		cell.setStyleRanges(text.getStyleRanges());
		
		super.update(cell);
	}
	
	private void colorCell ( ViewerCell cell ) {
		
		cell.setForeground(new Color(Display.getCurrent(), 243, 255, 255));
		cell.setBackground(new Color(Display.getCurrent(), 165, 165, 165));
		
	}
	
	private void colorErrorCell ( ViewerCell cell ) {
		
		cell.setForeground(new Color(Display.getCurrent(), 156, 0, 6));
		cell.setBackground(new Color(Display.getCurrent(), 255, 199, 206));
		
	}
}
