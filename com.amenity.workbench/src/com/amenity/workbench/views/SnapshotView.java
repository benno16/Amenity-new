package com.amenity.workbench.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.ContentObject;
import general.File;
import general.Folder;
import general.Snapshot;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.mks.MksGetFile;
import com.amenity.engine.helper.synergy.SynergyGetFile;
import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.GenericDao;
import dao.SnapshotDao;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;

public class SnapshotView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.SnapshotView"; //$NON-NLS-1$
	
	private Composite container;
	private Grid grid;
	private GenericDao genericDao;
	private List<GridItem> gridItems;
	private List<Folder> folders;
	private List<File> files;
	private List<ContentObject> contentObjects;
	private Composite compositeWest;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label label_5;
	private Label label_6;
	private Label lblRefresh;
	private Button btnView;
	private org.eclipse.swt.widgets.List containerJList;
	private ListViewer containerListViewer;
	private ISelection jfaceSelection;
	private IStructuredSelection structuredSelection;
	private TreeViewer treeViewer;
	
	public SnapshotView() {
		gridItems = new ArrayList<GridItem>();
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
		SessionSourceProvider.CONTAINER_LIST = new ArrayList<Container>();
		SessionSourceProvider.SNAPSHOT_LIST = new ArrayList<Snapshot>();
		contentObjects = new ArrayList<ContentObject>();
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = parent;
		parent.setLayout(new GridLayout(2, false));
		
		compositeWest = new Composite(parent, SWT.NONE);
		compositeWest.setLayout(null);
		
		Label lblSelectProject = new Label(compositeWest, SWT.NONE);
		lblSelectProject.setBounds(10, 10, 90, 13);
		lblSelectProject.setText("Select Container");
		
		Label lblSelectSnapshot = new Label(compositeWest, SWT.NONE);
		lblSelectSnapshot.setBounds(10, 135, 100, 13);
		lblSelectSnapshot.setText("Select Snapshot");
		
		btnView = new Button(compositeWest, SWT.NONE);
		btnView.setToolTipText("Opens the Snapshot file browser");
		btnView.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/edit-find-replace.png"));
		btnView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					grid.clearAll(true);	// defaults the grid items
					grid.remove(0);
				} catch (Exception ee) {
					
				}
				visualizeSnapshot();
			}
		});
		btnView.setBounds(10, 260, 158, 23);
		btnView.setText("View selected Snapshot");
		btnView.setEnabled(false);
		
		Label label = new Label(compositeWest, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 289, 176, 2);
		
		Group grpSnaptshotDetails = new Group(compositeWest, SWT.NONE);
		grpSnaptshotDetails.setToolTipText("Details of selected Snapshot");
		grpSnaptshotDetails.setText("Snaptshot Details");
		grpSnaptshotDetails.setBounds(10, 302, 158, 167);
		
		Label lblContainer = new Label(grpSnaptshotDetails, SWT.NONE);
		lblContainer.setBounds(10, 20, 49, 13);
		lblContainer.setText("Container");
		
		Label lblProject = new Label(grpSnaptshotDetails, SWT.NONE);
		lblProject.setBounds(10, 39, 49, 13);
		lblProject.setText("Project");
		
		Label lblCreated = new Label(grpSnaptshotDetails, SWT.NONE);
		lblCreated.setBounds(10, 58, 49, 13);
		lblCreated.setText("Created");
		
		Label lblOwner = new Label(grpSnaptshotDetails, SWT.NONE);
		lblOwner.setBounds(10, 77, 49, 13);
		lblOwner.setText("Owner");
		
		Label lblComment = new Label(grpSnaptshotDetails, SWT.NONE);
		lblComment.setBounds(10, 96, 49, 13);
		lblComment.setText("Comment");
		
		label_1 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_1.setBounds(65, 20, 75, 13);
		
		label_2 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_2.setBounds(65, 39, 75, 13);
		
		label_3 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_3.setBounds(65, 58, 75, 13);
		
		label_4 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_4.setBounds(65, 77, 75, 13);
		
		label_5 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_5.setBounds(65, 96, 75, 13);
		
		Label lblConnection = new Label(grpSnaptshotDetails, SWT.NONE);
		lblConnection.setBounds(10, 115, 61, 13);
		lblConnection.setText("Connection");
		
		label_6 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_6.setBounds(65, 115, 75, 13);
		
		Button btnRemoveDummyObjects = new Button(grpSnaptshotDetails, SWT.NONE);
		btnRemoveDummyObjects.setToolTipText("Deletes duplicate Dummy Objects created by Assign Function Merge");
		btnRemoveDummyObjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
				coDao.deleteDummyObjects(SessionSourceProvider.CURRENT_SNAPSHOT);
				try {
					grid.clearAll(true);	// defaults the grid items
					grid.remove(0);
				} catch (Exception ee) {
					
				}
				visualizeSnapshot();
			}
		});
		btnRemoveDummyObjects.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-delete.png"));
		btnRemoveDummyObjects.setBounds(10, 134, 138, 23);
		btnRemoveDummyObjects.setText("Remove Dummies");
		
		Label lblSpaceHolder = new Label(compositeWest, SWT.NONE);
		lblSpaceHolder.setBounds(10, 433, 158, 13);
		
		lblRefresh = new Label(compositeWest, SWT.NONE);
		lblRefresh.setToolTipText("Refresh Container List");
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblRefresh.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/refresh_rotate.png"));

				treeViewer.setInput(null);
				fillContainerList();
				lblRefresh.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/refresh.png"));
			}
		});
		lblRefresh.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/refresh.png"));
		lblRefresh.setBounds(150, 10, 16, 16);
		
		/*
		 * JFace Container
		 */
		containerListViewer = new ListViewer(compositeWest, SWT.BORDER | SWT.V_SCROLL);
		containerJList = containerListViewer.getList();
		containerJList.setToolTipText("Select your Container");
		containerJList.setBounds(10, 29, 158, 100);
		
		treeViewer = new TreeViewer(compositeWest, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setToolTipText("Select the Snapshot or double click to view");
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					grid.clearAll(true);	// defaults the grid items
					grid.remove(0);
				} catch (Exception ee) {
					
				}
				visualizeSnapshot();
			}
		});
		tree.setBounds(10, 154, 158, 100);
		
		treeViewer.setLabelProvider(new GenericNameLabelProvider());
		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				return SessionSourceProvider.SNAPSHOT_LIST.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return null;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				return false;
			}
			
		});
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
						SessionSourceProvider.CURRENT_SNAPSHOT = 
								(Snapshot) structuredSelection.getFirstElement();
						clearSnapshotDetails();
						btnView.setEnabled(true);
						label_1.setText(SessionSourceProvider.CURRENT_CONTAINER.getName());
						label_2.setText("");
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						label_3.setText(df.format(SessionSourceProvider.CURRENT_SNAPSHOT.getCreated()));
						label_4.setText(SessionSourceProvider.USER.getUsername());
						label_5.setText(SessionSourceProvider.CURRENT_SNAPSHOT.getComment() == null ? 
								"-" : SessionSourceProvider.CURRENT_SNAPSHOT.getComment());
					}
				}
			}
		});
		
		
		containerListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Container ) {
						SessionSourceProvider.CURRENT_CONTAINER = 
								(Container) structuredSelection.getFirstElement();
						fillSnapshotList();
					}
				}
			}
		});
		containerListViewer.setLabelProvider(new GenericNameLabelProvider());
		containerListViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements ( Object inputElement ) {
				return ((java.util.List<Container>) inputElement ).toArray();
			}
		});
		
		/*
		 * JFace Snapshot
		 */
		
		fillContainerList();
		
		setHeader();

	}

	private void setContent(Snapshot snapshot) {
		
		for ( ContentObject c : contentObjects ) {
			if ( c instanceof File ) {
				// its a file! 
				files.add((File)c);
			} else {
				// its a folder! 
				folders.add((Folder) c);
			}
		}
		
		createGridItems();
	}
	
	private void createGridItems() {
		GridItem gridItem;
		/**
		 * create grid folder items
		 */
		int i = 0;
		int noLevelResult = 0;
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		for ( i = 0; i < 999 ; i++ ) { 
			int itemsFound = 0;
			if ( noLevelResult > 2) {
				break;
			}
			for ( Folder f : folders ) {
				if ( f.getLevel() == i ) {
		//			gridItem = new GridItem ( grid, SWT.NONE );
					if ( f.getRootDirectory() == null ) {
						System.out.println(">> Root Grid to be Created");
						gridItem = new GridItem ( grid, SWT.NONE );
						gridItem.setExpanded(true);
					} else {
						gridItem = new GridItem ( getParentGrid(f.getRootDirectory()), 
								SWT.NONE );
					}
					gridItem.setText(f.getName());
				    gridItem.setText(1, "");
				    gridItem.setText(2, "");
				    gridItem.setText(3, "");
				    gridItem.setText(4, f.getObjectId());
				    gridItem.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER));
				    gridItem.setText(4, f.getObjectId());
				    gridItems.add(gridItem);
				    itemsFound++;
				}
			}
		    if ( itemsFound < 1 ) 
		    	noLevelResult++;
			
		}
		for ( i = 0; i < 999 ; i++ ) { 
			int itemsFound = 0;
			for ( File f : files ) {
				if ( f.getLevel() == i ) {
					gridItem = new GridItem ( getParentGrid(f.getRootDir()), 
								SWT.NONE );
					
					gridItem.setText(f.getName());
				    gridItem.setText(1, f.getVersion());
				    gridItem.setText(2, f.getStatus());
				    gridItem.setText(3, df.format(f.getModfiedDate()));
				    gridItem.setText(4, f.getObjectId());
				    if ( f.getSuffix().equals("-") )
				    	gridItem.setImage(PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FILE));
				    else 
				    	gridItem.setImage(getImageIcon(f.getSuffix()));
				    gridItems.add(gridItem);
				    itemsFound++;
				}
			}
		    if ( itemsFound < 1 ) 
		    	noLevelResult++;
			
			if ( noLevelResult > 10) break;
		}
	}
	
	private Image getImageIcon(String suffix) {
		
		return PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_FILE);
		
		// not working with Java 1.6 - switch on Strings a new feature of Java 1.7
//		switch (suffix.toLowerCase()) {
//		case ("-"):
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_FILE);
//		case (".ppt"):
//			return IconFactory.getInstance().getPPTIco();
//		case (".c"):
//			return IconFactory.getInstance().getCIco();
//		case (".h"):
//			return IconFactory.getInstance().getHIco();
//		case (".jpg"):
//			return IconFactory.getInstance().getImageIco();
//		case (".pdf"):
//			return IconFactory.getInstance().getPdfIco();
//		case (".doc"):
//			return IconFactory.getInstance().getWordIco();
//		case (".zip"):
//			return IconFactory.getInstance().getCompressedIco();
//		case (".java"):
//			return IconFactory.getInstance().getCIco();
//		case (".txt"):
//			return IconFactory.getInstance().getWordIco();
//		case (".docx"):
//			return IconFactory.getInstance().getWordIco();
//		default:
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_FILE);
//		}
	}

	public GridItem getParentGrid(Folder rootDirectory) {
		for ( GridItem gi : gridItems ) 
			if ( gi.getText(4).equals(rootDirectory.getObjectId() ))
				return gi;
		System.err.println("--- Grid does not exist");
		return null;
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	private void setHeader() {
		grid = new Grid(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		grid.setToolTipText("Double click the file to open it");
		grid.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
//		banner, SWT.BORDER
		grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("Name");
	    column.setWidth(300);
	    column.setTree(true);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Version");
	    column2.setWidth(100);
	    column2.setSummary(false);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("Status");
	    column3.setWidth(100);
	    column3.setSummary(false);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Last Modified");
	    column4.setWidth(150);
	    column4.setSummary(false);
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("ObjectId");
	    column5.setWidth(100);
	    column5.setVisible(false);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Release");
	    column6.setWidth(100);
	    column6.setVisible(false);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("rootDir");
	    column7.setWidth(100);
	    column7.setVisible(false);
	    GridColumn column8 = new GridColumn(grid,SWT.NONE);
	    column8.setText("spare");
	    column8.setWidth(100);
	    column8.setVisible(false);
	    
	    grid.addDragDetectListener(new DragDetectListener(){

			@Override
			public void dragDetected(DragDetectEvent e) {
				System.out.println("Dragged Object" + 
						grid.getSelection()[0].getText(4).toString() );
				
			}
	    	
	    });
	    grid.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				GridItem gi = null;
				try {
					gi = grid.getSelection()[0];
					System.out.println("Double Click Event " + gi.getText(4) );
					FileDao fileDao = DaoFactory.eINSTANCE.createFileDao();
					File file = (File) fileDao.getById(gi.getText(4));
					ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
					Connection connection = null;
					connection = (Connection) connectionDao.getByQuery("from " + 
							Connection.class.getName().toString() + 
							" where connectionId = '" + 
							SessionSourceProvider.CURRENT_SNAPSHOT.getVia().getConnectionId() + "'").get(0);
					if ( connection.getConnectionType() == ConnectionType.MKS ) {
						System.out.println("its a mks connection");
						MksGetFile mksGetFile = new MksGetFile(connection, file);
						mksGetFile.openFile();
					} else if ( connection.getConnectionType() == ConnectionType.SYNERGY ){
						System.out.println("its a synergy connection");
						if ( SessionSourceProvider.SYNERGY_SID == null ) {
							SessionSourceProvider.SYNERGY_SID = new SynergyLogin().getSynergySessionId();
						}
						SynergyGetFile synergyGetFile = new SynergyGetFile
								( SessionSourceProvider.SYNERGY_SID );
						synergyGetFile.openFile(file);
					}
				} catch (Exception ex) {
					if ( gi == null )
						MessageDialog.openError(container.getShell(), 
								"Error", 
								"Am error occured while opening the file");
				}
			}
	    });
	}
	
	@SuppressWarnings("unchecked")
	private void fillContainerList() {
		
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		
		SessionSourceProvider.CONTAINER_LIST = containerDao.getListByOwner(Container.class, SessionSourceProvider.USER);
		containerListViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
	}

	@SuppressWarnings("unchecked")
	private void fillSnapshotList() {
		
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		SessionSourceProvider.SNAPSHOT_LIST = snapshotDao.getListByContainer(
				SessionSourceProvider.CURRENT_CONTAINER);

		treeViewer.setInput(SessionSourceProvider.SNAPSHOT_LIST);
	}

	@SuppressWarnings("unchecked")
	private void visualizeSnapshot() {
		
		long start = System.currentTimeMillis();
	
		String query = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + SessionSourceProvider.CURRENT_SNAPSHOT.getSnapshotId() + "'";
		
		files.clear();
		folders.clear();
		gridItems.clear();
		contentObjects.clear();
		
		contentObjects = (List<ContentObject>) genericDao.getByQuery(query);
		
		
		System.out.println("there are " + contentObjects.size() + 
				" items within snapshot: " + SessionSourceProvider.CURRENT_SNAPSHOT.getSnapshotId());
			
		setContent(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		System.out.println(" >>>>> The creation of the view took: " + 
				(System.currentTimeMillis() - start) + " ms");
	}
	
	private void clearSnapshotDetails() {
		label_1.setText("");
		label_2.setText("");
		label_3.setText("");
		label_4.setText("");
		label_5.setText("");
		label_6.setText("");
	}
}
