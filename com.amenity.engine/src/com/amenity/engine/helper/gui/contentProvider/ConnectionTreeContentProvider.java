package com.amenity.engine.helper.gui.contentProvider;

import java.util.List;

import general.Connection;
import general.Container;
import general.Snapshot;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dao.ConnectionDao;
import dao.DaoFactory;
import dao.SnapshotDao;

public class ConnectionTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		System.out.println("Input changed");
	}

	// only accept container as input
	@Override
	public Object[] getElements(Object inputElement) {
		if ( inputElement instanceof Container ) {
			ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
			return connectionDao.getListByContainer((Container)inputElement).toArray();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getChildren(Object parentElement) {
		if ( parentElement instanceof Connection ) {
			Connection connection = (Connection) parentElement;
			SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
			/**
			 * TODO: Implement VIA! (HIGH Priority)
			 */
			List<Snapshot> snapshots = (List<Snapshot>) 
					snapshotDao.getByQuery("from " + Snapshot.class.getName().toString() + 
							" where via = '" + connection.getConnectionId() + "' and deleted = false" );
			
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
		if ( element instanceof Connection ) {
			return true;
		}
		return false;
	}

}
