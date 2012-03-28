package com.amenity.workbench.views;

import java.util.List;

import general.Connection;
import general.ConnectionType;
import general.ContentObject;
import general.File;
import general.Snapshot;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import dao.ConnectionDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.GenericDao;

import com.amenity.engine.helper.compare.SnapshotComparator;
import com.amenity.engine.helper.gui.ContainerContentProvider;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.mks.MksGetFile;
import com.amenity.workbench.SessionSourceProvider;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class CompareSnapshotsView extends ViewPart {

	
	// general
	private GenericDao genericDao;
	private Grid grid;
	private TreeViewer containerTreeViewer;
	
	// Viewer Selection
	private Composite container;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private Button btnCompare;
	private Label label_1;
	private Label label_2;
	private Snapshot snapshot1;
	private Snapshot snapshot2;
	
	public CompareSnapshotsView() {
		
		
	}

	@Override
	public void createPartControl(Composite parent) {
//		Shell shell = parent.getShell();
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		container = parent;
		parent.setLayout(new GridLayout(2, true));
		
		Composite compositeTop = new Composite(parent, SWT.NONE);
		compositeTop.setLayout(null);
		compositeTop.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				false, 2, 1));
		
		Label lblContainer = new Label(compositeTop, SWT.NONE);
		lblContainer.setBounds(10, 10, 55, 15);
		lblContainer.setText("Container");
		
		Label label = new Label(compositeTop, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(258, 10, 2, 133);
		
		containerTreeViewer = new TreeViewer(compositeTop, SWT.BORDER | SWT.MULTI);
		Tree tree = containerTreeViewer.getTree();
		tree.setToolTipText("Press 'CTRL' and select two items");
		tree.setLinesVisible(true);
		
		containerTreeViewer.setContentProvider(new ContainerContentProvider());
		containerTreeViewer.setLabelProvider(new GenericNameLabelProvider());
		containerTreeViewer.setAutoExpandLevel(0);
		containerTreeViewer.setInput(SessionSourceProvider.USER);
		containerTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
						
						if ( structuredSelection.size() == 2 ) {
							btnCompare.setEnabled(true);
							snapshot1 = ((Snapshot)structuredSelection.toArray()[1]);
							label_1.setText(snapshot1.getName());
							snapshot2 = ((Snapshot)structuredSelection.toArray()[0]);
							label_2.setText(snapshot2.getName());
						} else if ( structuredSelection.size() == 1 ) {
							snapshot1 = ((Snapshot)structuredSelection.getFirstElement());
							label_1.setText(snapshot1.getName());
							snapshot2 = null;
							label_2.setText("");
							btnCompare.setEnabled(false);
						} else 
							notReady();
						
					} else {
						notReady ();
					}
				} else {
					notReady ();
				}
			}
			
		});
		
		tree.setBounds(10, 31, 242, 112);
		
		Label lblSnapshot = new Label(compositeTop, SWT.NONE);
		lblSnapshot.setToolTipText("Snapshot showing left");
		lblSnapshot.setBounds(266, 10, 101, 15);
		lblSnapshot.setText("Snapshot Left");
		
		Label lblSnapshot_1 = new Label(compositeTop, SWT.NONE);
		lblSnapshot_1.setToolTipText("Snapshot showing right");
		lblSnapshot_1.setBounds(266, 31, 101, 15);
		lblSnapshot_1.setText("Snapshot Right");
		
		label_1 = new Label(compositeTop, SWT.NONE);
		label_1.setBounds(373, 10, 150, 15);
		
		label_2 = new Label(compositeTop, SWT.NONE);
		label_2.setBounds(373, 31, 150, 15);
		
		btnCompare = new Button(compositeTop, SWT.NONE);
		btnCompare.setToolTipText("Compare the two selected snapshots");
		btnCompare.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/list.png"));
		btnCompare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				grid.clearAll(true);
				grid.removeAll();
				if ( snapshot1.getVia().getPartOf() != snapshot2.getVia().getPartOf() ) {
					MessageDialog.openError(container.getShell(), "Incompatible Container", 
							"The snapshots you are trying to compare belong of different containers. \n" +
							"Please select two compatible snapshots! \n\n" +
							"The operation will be cancelled");
				} else 
					paintGrid(snapshot1, snapshot2);
			}
		});
		btnCompare.setBounds(448, 52, 85, 25);
		btnCompare.setText("Compare");
		
		Label lblRefresh = new Label(compositeTop, SWT.NONE);
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				containerTreeViewer.setInput(SessionSourceProvider.USER);
				containerTreeViewer.refresh();
			}
		});
		lblRefresh.setToolTipText("Refresh the overview");
		lblRefresh.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/refresh.png"));
		lblRefresh.setBounds(236, 10, 16, 16);
		
		grid = new Grid(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		grid.setLayoutData(new GridData(GridData.FILL, SWT.FILL, true,
				true, 2, 1));
		grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("Name");
	    column.setWidth(250);
	    column.setTree(true);
	    GridColumn column1 = new GridColumn(grid,SWT.NONE);
	    column1.setText("Version");
	    column1.setWidth(70);
	    column1.setSummary(false);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Modified");
	    column2.setWidth(100);
	    column2.setSummary(false);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("<OID>");
	    column3.setWidth(100);
	    column3.setSummary(false);
	    column3.setVisible(false);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Difference");
	    column4.setWidth(70);
	    column4.setSummary(false);
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("Name");
	    column5.setWidth(250);
	    column5.setTree(true);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Version");
	    column6.setWidth(70);
	    column6.setSummary(false);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("Modified");
	    column7.setWidth(100);
	    column7.setSummary(false);
	    GridColumn column8 = new GridColumn(grid,SWT.NONE);
	    column8.setText("<OID>");
	    column8.setWidth(100);
	    column8.setSummary(false);
	    column8.setVisible(false);
	    
	    grid.addMouseListener(new MouseAdapter() {

	    	/*
	    	 * TODO: Compare Method for Snyergy
	    	 * 
	    	 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				GridItem gi = null;
				try {
					gi = grid.getSelection()[0];
					System.out.println("Double Click Event " + gi.getText(3) );
					FileDao fileDao = DaoFactory.eINSTANCE.createFileDao();
					File file1 = (File) fileDao.getById(gi.getText(3));
					File file2 = (File) fileDao.getById(gi.getText(8));
					
					ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
					Connection connection1 = null;
					connection1 = (Connection) connectionDao.getByQuery("from " + 
							Connection.class.getName().toString() + 
							" where connectionId = '" + 
							snapshot1.getVia().getConnectionId() + "'").get(0);
					
					Connection connection2 = null;
					connection2 = (Connection) connectionDao.getByQuery("from " + 
							Connection.class.getName().toString() + 
							" where connectionId = '" + 
							snapshot1.getVia().getConnectionId() + "'").get(0);
					if ( connection1.getConnectionType() == ConnectionType.MKS && 
							connection2.getConnectionType() == ConnectionType.MKS )
						new MksGetFile(connection1, file1, connection2, file2);
					
				} catch (Exception ex) {
					if ( gi == null )
						MessageDialog.openError(container.getShell(), 
								"Error", 
								"Am error occured while opening the file");
				}
			}
	    });
	    
	}
	
	private void notReady () {

		label_1.setText("");
		label_2.setText("");
		btnCompare.setEnabled(false);
	}
	
	@SuppressWarnings("unchecked")
	private void paintGrid ( Snapshot s1, Snapshot s2) {
		
		String query1 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + s1.getSnapshotId() + "'";

		String query2 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + s2.getSnapshotId() + "'";
		
		SnapshotComparator compare = new SnapshotComparator( (List<ContentObject>) genericDao.getByQuery(query1), 
	    		(List<ContentObject>) genericDao.getByQuery(query2));
	    compare.getComparableGrid(grid);
	    
	}

	@Override
	public void setFocus() {
	}
}
