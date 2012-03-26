package com.amenity.workbench;

import general.ContentObject;
import general.File;
import general.Folder;
import general.Snapshot;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.SnapshotDao;

public class ViewSnapshot extends ViewPart {

	private TreeViewer treeViewerSnapshot;
	private Tree treeSnapshot;
	private static java.util.List<ContentObject> CURRENT_FILE_LIST;
	
	
	
	public ViewSnapshot() {
		CURRENT_FILE_LIST = new ArrayList<ContentObject>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
		
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
		CURRENT_FILE_LIST = coDao
				.getListBySnapshot((Snapshot) sDao.getById("ae4b07b5-9bad-4d5e-b006-1bc515cb9686"));
		
		treeViewerSnapshot = new TreeViewer(parent, SWT.BORDER);
		treeSnapshot = treeViewerSnapshot.getTree();
		treeSnapshot.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewerSnapshot, SWT.NONE);
		TreeColumn trclmnNewColumn = treeViewerColumn.getColumn();
		trclmnNewColumn.setWidth(100);
		trclmnNewColumn.setText("Name");
		
		TreeViewerColumn treeViewerColumn_3 = new TreeViewerColumn(treeViewerSnapshot, SWT.NONE);
		TreeColumn trclmnNewColumn_3 = treeViewerColumn_3.getColumn();
		trclmnNewColumn_3.setWidth(100);
		trclmnNewColumn_3.setText("Version");
		
		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(treeViewerSnapshot, SWT.NONE);
		TreeColumn trclmnNewColumn_2 = treeViewerColumn_2.getColumn();
		trclmnNewColumn_2.setWidth(100);
		trclmnNewColumn_2.setText("Status");
		
		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewerSnapshot, SWT.NONE);
		TreeColumn trclmnNewColumn_1 = treeViewerColumn_1.getColumn();
		trclmnNewColumn_1.setWidth(100);
		trclmnNewColumn_1.setText("Last Modified");
		treeViewerSnapshot.setAutoExpandLevel(1);
		treeViewerSnapshot.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				java.util.List<ContentObject> children = new ArrayList<ContentObject>();
				if ( inputElement instanceof File ) {
					children.add((File)inputElement);
				} else {
					for ( ContentObject co : CURRENT_FILE_LIST ) {
						if ( co instanceof Folder ) {

							if (((Folder)co).getRootDirectory() != null )
							if (((Folder) co).getRootDirectory().getObjectId().equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
						if ( co instanceof File ) {
							if (((File) co).getRootDir().getObjectId().equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
					}
				}
				return children.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				/*
				 * TODO: put this into own method
				 */
				
				return getFolderChildren((ContentObject)parentElement).toArray();
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof Folder;
			}
			
		});
		
//		treeViewerSnapshot.setLabelProvider(new GenericNameLabelProvider());
		treeViewerSnapshot.setLabelProvider(new ITableLabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				System.out.println(element.toString() + " with " + columnIndex);
				if ( element instanceof File ) {
					if ( columnIndex == 0 ) {
						return ((File)element).getName();
					} else if ( columnIndex == 1 ) {
						return ((File)element).getVersion();
					} else if ( columnIndex == 2 ) {
						return ((File)element).getRelease();
					} else if ( columnIndex == 3 ) {
						return ((File)element).getModfiedDate().toString();
					} 
				} else if ( element instanceof Folder ) {
					if ( columnIndex == 0 ) {
						return ((Folder)element).getName();
					} else if ( columnIndex == 1 ) {
						return "";
					} else if ( columnIndex == 2 ) {
						return "";
					} else if ( columnIndex == 3 ) {
						return "";
					} 
				}
				return null;
			}
			
		});
		
		
		
		
		for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
			
			if ( CURRENT_FILE_LIST.get(i) instanceof Folder ) {
				
				if ( ((Folder)CURRENT_FILE_LIST.get(i)).getRootDirectory() == null  ) {
					
					treeViewerSnapshot.setInput(((Folder)CURRENT_FILE_LIST.get(i)));
					
				}
				
			}
			
		}

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	
	public java.util.List<ContentObject> getFolderChildren ( ContentObject parentElement ) {
		

		java.util.List<ContentObject> children = new ArrayList<ContentObject>();
		for ( ContentObject co : CURRENT_FILE_LIST ) {
			if ( co instanceof Folder ) {
				if (((Folder)co).getRootDirectory() != null )
				if (((Folder) co).getRootDirectory().equals(((Folder)parentElement)))
					children.add(co);
			}
			if ( co instanceof File ) {
				if (((File) co).getRootDir().equals(((Folder)parentElement)))
					children.add(co);
			}
		}
		
		return children;
	}

}
