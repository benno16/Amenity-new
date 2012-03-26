package com.amenity.workbench.supporter;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.amenity.workbench.Activator;
import com.amenity.workbench.interfaces.IIconFactory;

public class IconFactory implements IIconFactory {
	
	private static IconFactory instance = new IconFactory();

	// private because its a singleton! 
	private IconFactory(){
	}
	
	private ImageDescriptor doesIdExist(ImageDescriptor id) {
		
		if ( id == null ) {
			return Activator.getImageDescriptor("a.png");
		} else {
			return id;
		}
	}
	
	public static IconFactory getInstance() {
        return instance;
    }
	
	public Image getEventViewerIco( ) {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/dialog-warning.png");
		id = doesIdExist(id);
		return id.createImage();
		
	}

	@Override
	public Image getUnknownIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/unknown.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getProjectCotainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/folder_green.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getWorkbenchIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/package_network.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getManageContainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/drive-harddisk.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getShowSnapshotIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/gnome-dev-computer.png");
		id = doesIdExist(id);
		return id.createImage();
	}
	
	@Override
	public Image getCompareSnapshotIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/gnome-searchtool.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getAssignFunctionIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/bookmark_add.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getAssignFilesIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/up.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getNewContainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/folder_new.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getModifyIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/stock_file-properites.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getDeleteIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/gtk-delete.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getHelpIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/general/xfce-man.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getCompressedIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/zip.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getWordIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/txt.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getPPTIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/pps.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getCIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/source c.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getHIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/source h.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getImageIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/image.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getPdfIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/workbench/filetype/pdf.png");
		id = doesIdExist(id);
		return id.createImage();
	}


}
