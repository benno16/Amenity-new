package com.amenity.engine.helper.gui.contentProvider;

import general.File;
import general.Folder;
import general.Snapshot;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dao.DaoFactory;
import dao.FileDao;
import dao.FolderDao;

public class ComponentObjectTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if ( inputElement instanceof Snapshot ) {
			java.util.List<Folder> folders = new java.util.ArrayList<Folder>();
			FolderDao folderObjectDao = DaoFactory.eINSTANCE.createFolderDao();
			Folder folder = 
					folderObjectDao.getRootFolderBySnapshot((Snapshot)inputElement);
			folders.add(folder);
			return folders.toArray();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getChildren(Object parentElement) {
		if ( parentElement instanceof Folder ) {
			FileDao fileDao = DaoFactory.eINSTANCE.createFileDao();
			java.util.List<File> files = fileDao.getByQuery("from " + 
					Folder.class.getName().toString() + 
					" where rootDir = '" + 
					((Folder)parentElement).getObjectId() + "'");
			return files.toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if ( element instanceof Folder )
			return true; 
		return false;
	}

}
