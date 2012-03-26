package com.amenity.engine.helper.gui.labelProvider;

import general.*;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.amenity.engine.helper.synergy.SynergyProject;

public class GenericNameLabelProvider extends LabelProvider  {
	
	@Override
	public String getText(Object element) {
		if (element instanceof Snapshot) {
			return ((Snapshot) element).getName();
		} else 
			if (element instanceof Container) {
			return ((Container) element).getName();
		} else 
			if (element instanceof Connection) {
			return ((Connection) element).getAddInfo1();
		} else 
			if (element instanceof User) {
			return ((User) element).getUsername();
		} else 
			if (element instanceof DataSource) {
			return ((DataSource) element).getName();
		} else 
			if (element instanceof File) {
			return ((File) element).getName();
		} else 
			if (element instanceof Folder) {
			return ((Folder) element).getName();
		} else 
			if (element instanceof Task) {
			return ((Task) element).getDescription();
		} else 
			if (element instanceof SynergyProject) {
			return ((SynergyProject) element).getShortName();
		} else 
			if (element instanceof Function) {
			return ((Function) element).getName();
		} else 
			return element.toString();
	}
	
	@Override
	public Image getImage(Object element) {
		if ( element instanceof Folder ) {

			if ( ((Folder)element).isDummy() ) 
				return PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
			
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER);
			
		}
		else 
			if ( element instanceof File ) {

				if ( ((File)element).isDummy() ) 
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
				
				return PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_FILE);
				
		}
		else if ( element instanceof Connection ) 
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ELCL_SYNCED);
		else if ( element instanceof Snapshot ) 
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		else if ( element instanceof Container ) 
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ETOOL_DEF_PERSPECTIVE);
		else if ( element instanceof DataSource ) 
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ADD);
		/*
		 * TODO: implement DB link for icon store! 
		 */
		return PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_FILE);
	}

}
