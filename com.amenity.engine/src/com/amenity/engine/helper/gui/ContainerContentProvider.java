package com.amenity.engine.helper.gui;

import java.util.List;

import general.Container;
import general.Snapshot;
import general.User;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dao.ContainerDao;
import dao.DaoFactory;
import dao.SnapshotDao;

public class ContainerContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if ( inputElement instanceof User ) {
			ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
			
			return containerDao.getListByOwner(Container.class, (User)inputElement).toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if ( parentElement instanceof Container ) {
			Container container = (Container) parentElement;
			SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
			
			@SuppressWarnings("unchecked")
			List<Snapshot> snapshots = (List<Snapshot>) snapshotDao.getListByContainer(container);
			
			return snapshots.toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if ( element instanceof Container ) {
			return true;
		}
		return false;
	}

}
