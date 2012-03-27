package com.amenity.workbench.views;


import java.util.ArrayList;
import java.util.Date;

import general.Container;
import general.ContentObject;
import general.File;
import general.FileFunctionStatus;
import general.Folder;
import general.Function;
import general.GeneralFactory;
import general.Snapshot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.editingSupport.DataTypeEditingSupport;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.gui.labelProvider.SnapshotStyledLabelProvder;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.CreateFunctionDialog;
import com.amenity.workbench.supporter.AssignFunctionViewFilters;
import com.amenity.workbench.supporter.AssignFunctionViewMethods;
import com.amenity.workbench.supporter.WorkbenchConstants;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.GenericDao;
import dao.SnapshotDao;
import edu.emory.mathcs.backport.java.util.Arrays;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.hibernate.Session;
import org.eclipse.swt.events.MouseTrackAdapter;

public class AssignFunctionsView extends ViewPart {
	
	public static String newFn = null;
	
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	
	private ComboViewer containerComboViewer;
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private TreeViewer functionTreeViewer;
	private Tree snapshotTree;
	private Tree functionTree;
	private Composite composite;
	private TableViewer tableViewer;
	
	private Button btnAdd;
	private Button btnSave;
	private Label lblDate;
	private Text functionNameText;
	private Table table;
	private Combo containerCombo;
	private GenericDao gDao;
	
//	private java.util.List<ContentObject> contentObjects;
	private Logger log;
	// stores the total snapshot content
	private static java.util.List<ContentObject> CURRENT_FILE_LIST;
	// stores the total snapshot content
	private static java.util.List<ContentObject> CURRENT_FILE_LIST_WITH_FUNCTION;
	// stores the current function content
	private static java.util.List<Function> CURRENT_FUNCTION_LIST;
	// stores the originally read function content
	private static java.util.List<Function> ORIGINAL_FUNCTION_LIST;
	// stores the current function content objects
	private static java.util.List<ContentObject> CURRENT_FUNCTION_FILE_LIST;
	// stores the originally read function content objects
	private static java.util.List<ContentObject> ORIGINAL_FUNCTION_FILE_LIST;
	// stores the originally read function content objects
	private static java.util.List<FileFunctionStatus> CURRENT_FUNCTION_FILE_STATUS_LIST;
	// stores the originally read function content objects
	private static java.util.List<FileFunctionStatus> ORIGINAL_FUNCTION_FILE_STATUS_LIST;

	public AssignFunctionsView() {
//		contentObjects = new ArrayList<ContentObject>();
		log = LogManager.getLogger(AssignFunctionsView.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		PlatformUI.getWorkbench();
		CURRENT_FILE_LIST = new ArrayList<ContentObject>();
		
		CURRENT_FUNCTION_LIST = new ArrayList<Function>();
		CURRENT_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		
		ORIGINAL_FUNCTION_LIST = new ArrayList<Function>();
		ORIGINAL_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		CURRENT_FILE_LIST_WITH_FUNCTION = new ArrayList<ContentObject>();
		
		CURRENT_FUNCTION_FILE_STATUS_LIST = new ArrayList<FileFunctionStatus>();
		ORIGINAL_FUNCTION_FILE_STATUS_LIST = new ArrayList<FileFunctionStatus>();
		
		gDao = DaoFactory.eINSTANCE.createGenericDao();
		
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		log.info("Assign Function view openend");
	}

	@SuppressWarnings("unused")
	@Override
	public void createPartControl(Composite parent) {
		this.composite = parent;
		
		GridLayout gridLayout = new GridLayout(8,false);
		
		parent.setLayout(gridLayout);

		/*
		 * Container drop down starts here
		 */
		containerComboViewer = new ComboViewer(parent, SWT.NONE);
		
		containerCombo = containerComboViewer.getCombo();
		containerCombo.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				// refresh container list on selection
				containerComboViewer.setInput(AssignFunctionViewMethods.getInstance().getContainerList(SessionSourceProvider.USER) );
				try {
					containerCombo.setText(SessionSourceProvider.CURRENT_CONTAINER.getName());
				} catch (NullPointerException npe ) {}
			}
		});
		
		containerCombo.setToolTipText("Select Container");
		
		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		// Container Combo JFace Settings - reviewed 14.03.2012
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		// reviewed 14.03.2012
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
		        structuredSelection = (IStructuredSelection) event.getSelection();
		        
		        if ( !structuredSelection.isEmpty() ) {
		        	
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        				(Container) structuredSelection.getFirstElement();
		        		// clear everything
		        		clearSnapshotTree();
		        		// get container list and refresh
		        		snapshotComboViewer.setInput( AssignFunctionViewMethods.getInstance()
		        			.getSnapshots(SessionSourceProvider.CURRENT_CONTAINER) );
		        		snapshotComboViewer.refresh();
		        		
		        	}
		        	
		        }
		        
			}
			
		});
		
		
		/*
		 * Snapshot drop down starts here
		 */
		snapshotComboViewer = new ComboViewer(parent, SWT.NONE);
		
		// reviewed 14.03.2012
		snapshotComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		
		// reviewed 14.03.2012
		snapshotComboViewer.setLabelProvider(new GenericNameLabelProvider());

		// reviewed 14.03.2012
		snapshotComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
				objectSelection = event.getSelection();
				
		        structuredSelection = (IStructuredSelection) objectSelection;
		        
		        if ( !structuredSelection.isEmpty() ) {
		        	
		        	if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
		        		// set global variable
		        		SessionSourceProvider.CURRENT_SNAPSHOT = 
		        				(Snapshot) structuredSelection.getFirstElement();
		        		
		        		// reads functions and fills snapshot tree
		        		initializeSnapshotTree();
		        		
		        	}
		        	
		        }
		        
			}
			
		});
		
		snapshotCombo = snapshotComboViewer.getCombo();
		snapshotCombo.setToolTipText("Select Snapshot");
		snapshotCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		functionComboViewer = new ComboViewer(parent, SWT.NONE);
		functionCombo = functionComboViewer.getCombo();
		functionCombo.setToolTipText("Select Function");
		functionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// reviewed 14.03.2012
		functionComboViewer.setLabelProvider(new GenericNameLabelProvider());

		// reviewed 14.03.2012
		functionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});

		// reviewed 14.03.2012
		functionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * If selection is changed the current snapshot content object list is iterated
			 * and in case the CO is part of the current function the file will be added
			 * to the current function list. if not next object
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				
				if ( !structuredSelection.isEmpty()) {
						
					if ( structuredSelection.getFirstElement() instanceof Function) {
						
						// empty function tree
						clearFunctionTree();
								
						// start rebuilding here
						// set selected function
						SessionSourceProvider.CURRENT_FUNCTION = (Function) 
								structuredSelection.getFirstElement();
						
						// Add the static existent file function status objects to Table
						tableViewer.setInput(AssignFunctionViewMethods.getInstance()
								.getFileFunctionStatus(SessionSourceProvider.CURRENT_FUNCTION) );
								
						// set additional labels
						functionNameText.setText(SessionSourceProvider.CURRENT_FUNCTION.getName());
						lblDate.setText(SessionSourceProvider.CURRENT_FUNCTION.getModified().toString());
						
						
						// get all content objects part of this function
						functionTreeViewer.setInput( CURRENT_FUNCTION_FILE_LIST = AssignFunctionViewMethods.getInstance()
								.getContentObjectsWithFunction( SessionSourceProvider.CURRENT_FUNCTION ) );
						
					}
				}
			}
		});
		
		/*
		 * TODO: Testing
		 */
		// reviewed 14.03.2012
		btnAdd = new Button(parent, SWT.NONE);
		btnAdd.setToolTipText("Add new Function to List");
		btnAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAdd.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-add.png"));
		// reviewed 14.03.2012
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( SessionSourceProvider.CURRENT_SNAPSHOT != null ) {
					CreateFunctionDialog dialog = new CreateFunctionDialog(composite.getShell(), 
							newFn, SessionSourceProvider.CURRENT_SNAPSHOT.getName());
					if ( dialog.open() == Window.OK) {
						// create object
						Function function = GeneralFactory.eINSTANCE.createFunction();
						function.setCreated(new Date());
						function.setSnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
						function.setName(newFn);
						function.setModified(new Date());
						// store object in database and get ID
						SessionSourceProvider.CURRENT_FUNCTION = AssignFunctionViewMethods.getInstance().addFunction(function);
						// add function object to list
						CURRENT_FUNCTION_LIST.add(SessionSourceProvider.CURRENT_FUNCTION);
						functionNameText.setText(SessionSourceProvider.CURRENT_FUNCTION.getName());
						lblDate.setText(SessionSourceProvider.CURRENT_FUNCTION.getModified().toString());
						// add to combobox and refresh it
						functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
						functionComboViewer.refresh();
					}
					
				}
				
			}
		});
		btnAdd.setText("Add");
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnDeleteDocument = new Button(parent, SWT.NONE);
		btnDeleteDocument.setToolTipText("Delete Document Type (DEL)");
		btnDeleteDocument.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.keyCode == SWT.DEL) {

					objectSelection = tableViewer.getSelection();
					structuredSelection = (IStructuredSelection) objectSelection;
					moveFileTypeToFunction(structuredSelection.getFirstElement());
				}
			}
		});
		btnDeleteDocument.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectSelection = tableViewer.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				moveFileTypeToFunction(structuredSelection.getFirstElement());
			}
		});
		btnDeleteDocument.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-delete.png"));
		btnDeleteDocument.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnDeleteDocument.setText("Delete Document");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		/*
		 * TODO: implement multi select
		 * SWT.MULTI
		 */
		new Label(parent, SWT.NONE);
		snapshotTreeViewer = new TreeViewer( parent, SWT.BORDER );
		snapshotTree = snapshotTreeViewer.getTree();
		snapshotTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
		        objectSelection = snapshotTreeViewer.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( structuredSelection.getFirstElement() instanceof File ) 
					AssignFunctionViewMethods.getInstance()
						.openFileFromCM((File)structuredSelection.getFirstElement());
			}
		});
		snapshotTree.setToolTipText("Items of selected snapshot");
		snapshotTree.setLinesVisible(true);
		snapshotTree.setHeaderVisible(true);
		snapshotTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		// reviewed 14.03.2012
		snapshotTreeViewer.setContentProvider(new ITreeContentProvider() {

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
								if (((Folder) co).getRootDirectory().getObjectId()
										.equals(((Folder)inputElement).getObjectId()))
									children.add(co);
						}
						if ( co instanceof File ) {
							if (((File) co).getRootDir().getObjectId()
									.equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
					}
				}
				return children.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				
				return AssignFunctionViewMethods.getInstance()
						.getFolderChildren( (Folder)parentElement , 
								SessionSourceProvider.CURRENT_SNAPSHOT ).toArray();
				
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

		// reviewed 14.03.2012
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder ());
		
		
		/*
		 * TODO: Temp sorter implementation
		 * Issue here its basically sorting strictly by name not type! 
		 */
		snapshotTreeViewer.setSorter(new ViewerSorter() {
			public int compare ( TreeViewer snapshotTreeViewer, Object obj1, Object obj2) {
				if ( obj1 instanceof File && obj2 instanceof File ) {
					return ((File) obj1).getName().compareTo(((File) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof Folder ) {
					return ((Folder) obj1).getName().compareTo(((Folder) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof File ) {
					return 1;
				} 
				return 0;
			}	
		});
		
		// static filter!
//		snapshotTreeViewer.addFilter(new FunctionAssigned());
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };
		Transfer[] transfers2 = new Transfer[] { TextTransfer.getInstance() };

		// reviewed 14.03.2012
	    snapshotTreeViewer.addDragSupport(operations, transfers, new DragSourceListener() {

			@Override
			public void dragFinished(DragSourceEvent event) {
			}
			@Override
			public void dragSetData(DragSourceEvent event) {
				// Here you do the convertion to the type which is expected.
				IStructuredSelection selection = (IStructuredSelection) snapshotTreeViewer.getSelection();
				ContentObject firstElement = (ContentObject) selection.getFirstElement();
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					// drags the ID of the Content Object 
					event.data = firstElement.getObjectId();
					
				}
				AssignFunctionViewFilters.getInstance().setIsSnapshotItem();
			}
			
			@Override
			public void dragStart(DragSourceEvent event) {
			}

		});
		/*
		 * Review to be checked 14.03.
		 * TODO: übersprungen
		 */
		snapshotTreeViewer.addDropSupport(operations, transfers2, new ViewerDropAdapter ( snapshotTreeViewer ) {
			
			public void drop ( DropTargetEvent event ) {
				determineTarget(event);
				super.drop(event);
			}
			
			@Override
			public boolean validateDrop ( Object target, int operation, 
					TransferData transferType ) {
				return AssignFunctionViewFilters.getInstance().isFunctionItem();
			}

			@Override
			public boolean performDrop(Object data) {
				
				moveFunctionToSnapshot((String) data);
				
				return false;
			}
		});
		
		TreeColumn trclmnAllItems = new TreeColumn(snapshotTree, SWT.NONE);
		trclmnAllItems.setWidth(200);
		trclmnAllItems.setText("All Items");

		// reviewed 14.03.2012
		snapshotTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
	    		AssignFunctionViewFilters.getInstance().setIsSnapshotItem();
	    	}
	    });
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftLeft = new Button(composite_1, SWT.NONE);
		arrowLeftLeft.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/1leftarrow.png"));
		arrowLeftLeft.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)  {
				
				try {
					IStructuredSelection selection = (IStructuredSelection) functionTreeViewer.getSelection();
					ContentObject firstElement = (ContentObject) selection.getFirstElement();
					
					
					moveFunctionToSnapshot( firstElement.getObjectId() );
				} catch ( Exception ex ) {}
			}
		});
		arrowLeftLeft.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftRight = new Button(composite_1, SWT.NONE);
		arrowLeftRight.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/1rightarrow.png"));
		
		arrowLeftRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				try {
					IStructuredSelection selection = (IStructuredSelection) snapshotTreeViewer.getSelection();
					ContentObject firstElement = (ContentObject) selection.getFirstElement();
					
					if ( !moveSnapshotToFunction( firstElement.getObjectId() ) ) {
						getViewSite().getActionBars().getStatusLineManager().setMessage ("item already in function");
					}
				} catch ( Exception ex ) {}
				
			}
		});
		
		functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		functionTree = functionTreeViewer.getTree();
		functionTree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.keyCode == SWT.DEL ) {

					try {
						IStructuredSelection selection = (IStructuredSelection) functionTreeViewer.getSelection();
						ContentObject firstElement = (ContentObject) selection.getFirstElement();
						
						
						moveFunctionToSnapshot( firstElement.getObjectId() );
					} catch ( Exception ex ) {}
				}
				
			}
		});
		functionTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				objectSelection = functionTreeViewer.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( structuredSelection.getFirstElement() instanceof File ) 
					AssignFunctionViewMethods.getInstance()
						.openFileFromCM((File)structuredSelection.getFirstElement());
			}
		});
		functionTree.setLinesVisible(true);
		functionTree.setHeaderVisible(true);
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TreeColumn trclmnFilesOfFunction = new TreeColumn(functionTree, SWT.NONE);
		trclmnFilesOfFunction.setWidth(200);
		trclmnFilesOfFunction.setText("Files of Function");
		
		functionTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				/*
				 *  the input elements are just allowed to be the lowest level elements
				 *  this means if a content object has a root folder it should
				 *  not be displayed within the root but this specific folder
				 *  
				 */
				java.util.List<ContentObject> retObj = new ArrayList<ContentObject>();
				
				for ( ContentObject coOuter : CURRENT_FUNCTION_FILE_LIST ) {
					boolean isRoot = true;
					for ( ContentObject coInner : CURRENT_FUNCTION_FILE_LIST ) {
						if ( coInner instanceof Folder ) {
							if ( coOuter instanceof Folder ) {
								
								if ( ((Folder)coOuter).getRootDirectory()
										.getObjectId().equals(((Folder)coInner).getObjectId()) ) {
									isRoot = false;
									break;
								}
								
							} else if ( coOuter instanceof File ) {
								
								if ( ((File)coOuter).getRootDir()
										.getObjectId().equals(((Folder)coInner).getObjectId()) ) {
									isRoot = false;
									break;
								}
								
							}
						}
					}
					if ( isRoot ) 
						retObj.add(coOuter);
				}
				return retObj.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {

				return AssignFunctionViewMethods.getInstance()
						.getFolderChildren( (Folder)parentElement, 
								SessionSourceProvider.CURRENT_SNAPSHOT ).toArray();
				
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
		functionTreeViewer.setLabelProvider(new GenericNameLabelProvider());

		functionTreeViewer.addDragSupport(operations, transfers2, new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {}

			@Override
			public void dragSetData(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) functionTreeViewer.getSelection();
				ContentObject firstElement = (ContentObject) selection.getFirstElement();
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = firstElement.getObjectId();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent event) {}
			
		});
		
	    functionTreeViewer.addDropSupport(operations, transfers, new ViewerDropAdapter(functionTreeViewer) {

			public void drop ( DropTargetEvent event ) {
				int location = this.determineLocation(event);
				determineTarget ( event ) ;
				btnSave.setEnabled(true);
				btnSave.setText("Apply *");
				super.drop(event); 
			}
			
			@Override
			public boolean performDrop(Object data) {
				/*
				 * TODO: getting content right
				 * refreshing the snapshottreeviewer
				 */
				if ( !moveSnapshotToFunction( (String) data ) ) {
					getViewSite().getActionBars().getStatusLineManager().setMessage ("item already in function");
				}
				
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				if ( functionComboViewer.getSelection().isEmpty() )
					return false;
				
				return AssignFunctionViewFilters.getInstance().isSnapshotItem();
			}
			
		});
	    
	    functionTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
	    		AssignFunctionViewFilters.getInstance().setIsFunctionItem();
	    	}
	    });
	    
		Composite compositeM = new Composite(parent, SWT.NONE);
		compositeM.setLayout(new GridLayout(2, false));
		compositeM.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowRightLeft = new Button(compositeM, SWT.NONE);
		arrowRightLeft.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectSelection = tableViewer.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				moveFileTypeToFunction(structuredSelection.getFirstElement());
			}
		});
		arrowRightLeft.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/1leftarrow.png"));
		arrowRightLeft.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Button arrowRightRight = new Button(compositeM, SWT.NONE);
		arrowRightRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					IStructuredSelection selection = (IStructuredSelection) functionTreeViewer.getSelection();
					ContentObject firstElement = (ContentObject) selection.getFirstElement();
					
					
					moveFunctionToFileType( firstElement.getObjectId() );
				} catch ( Exception ex ) {}
			}
		});
		arrowRightRight.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/1rightarrow.png"));
		
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setToolTipText("Double click file to open properties");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.views.PropertySheet");
				} catch (PartInitException e1) {}
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.keyCode == SWT.DEL) {

					objectSelection = tableViewer.getSelection();
					structuredSelection = (IStructuredSelection) objectSelection;
					moveFileTypeToFunction(structuredSelection.getFirstElement());
					
				}
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		/*
		 * TODO: Table viewer
		 */
		tableViewer.addDropSupport(operations, transfers2, new ViewerDropAdapter(tableViewer){

			@Override
			public boolean performDrop(Object data) {
				
				moveFunctionToFileType( (String)data);
				
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				return AssignFunctionViewFilters.getInstance().isFunctionItem();
			}
			
		});
		tableViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<FileFunctionStatus>)inputElement ) .toArray();
			}
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		        // fired when cell content changes
		    }
		});
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFileType = tableViewerColumn.getColumn();
		
		tableViewerColumn.setEditingSupport(new DataTypeEditingSupport(tableViewerColumn.getViewer()));
		tableViewer.getColumnViewerEditor().addEditorActivationListener(
				new ColumnViewerEditorActivationListener() {

					@Override
					public void beforeEditorActivated(
							ColumnViewerEditorActivationEvent event) {}

					@Override
					public void afterEditorActivated(
							ColumnViewerEditorActivationEvent event) {}

					@Override
					public void beforeEditorDeactivated(
							ColumnViewerEditorDeactivationEvent event) {}

					@Override
					public void afterEditorDeactivated(
							ColumnViewerEditorDeactivationEvent event) {
						tableViewer.refresh();
					}
			
		});
		getSite().setSelectionProvider(tableViewer);
		
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : ((FileFunctionStatus)element).getType().getLiteral();
			}
		});
		tblclmnFileType.setWidth(100);
		tblclmnFileType.setText("File Type");
		
		ComboBoxViewerCellEditor typeEditor = 
				new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);

		
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFileName = tableViewerColumn_1.getColumn();
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : ((FileFunctionStatus)element).getOfFile().getName();
			}
		});
		
		tblclmnFileName.setWidth(100);
		tblclmnFileName.setText("File Name");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFunctionName = new Label(parent, SWT.NONE);
		GridData gd_lblFunctionName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunctionName.widthHint = 85;
		lblFunctionName.setLayoutData(gd_lblFunctionName);
		lblFunctionName.setText("Function Name");
		
		functionNameText = new Text(parent, SWT.BORDER);
		functionNameText.setToolTipText("You can change the function name here");
		functionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnCompareTo = new Button(parent, SWT.NONE);
		btnCompareTo.setToolTipText("Compares Snapshot to Former One");
		btnCompareTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if ( SessionSourceProvider.CURRENT_CONTAINER == null ||
						SessionSourceProvider.CURRENT_SNAPSHOT == null ) {
					
					MessageDialog.openWarning(composite.getShell(), "Warning", 
							"No container or snapshot selected");
					
				} else {
					
					boolean doModify = false;
					
					if ( CURRENT_FUNCTION_LIST.size() > 0 ) {
						MessageDialog question = new MessageDialog(composite.getShell(), "Question"
								, null,  
								"Your current snapshot has already functions assigned. \n" +
								"Continuing this operation may create duplicate entries! \n\n" +
								"Are you sure you want to continue? ", MessageDialog.WARNING, 
								new String[] {"Continue", "Cancel"} , 1);
						if ( question.open() == 0 ) {
							doModify = true;
						}
						
					} else {
						
						doModify = true;
						
					}
					if ( doModify ) {
						
						ListDialog listDialog = new ListDialog(composite.getShell());
						listDialog.setTitle("Select Snapshot");
						listDialog.setMessage("Select the snapshot you wish to copy the information from");
						listDialog.setContentProvider(ArrayContentProvider.getInstance());
						listDialog.setLabelProvider(new GenericNameLabelProvider());
						SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
						
						// list every snapshot that has one or more functions assigned within the same container
						listDialog.setInput(
								sDao.getSnapshotsWithFunction(
										SessionSourceProvider.CURRENT_CONTAINER) );
						
						if ( listDialog.open() == Dialog.OK ){
							
							/*
							 * TODO: Put the relevant link to the function in here
							 */
							
							// at first get the old functions and create new ones
							functionComboViewer.setInput( CURRENT_FUNCTION_LIST =
									ORIGINAL_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
									.copyFunctionInfo( (Snapshot)listDialog.getResult()[0], 
									SessionSourceProvider.CURRENT_SNAPSHOT ) );
							
							functionComboViewer.refresh();
							log.info("fetched " + CURRENT_FUNCTION_LIST.size() + " functions#1");
							
							// next we get the file ist
							CURRENT_FILE_LIST = 
									AssignFunctionViewMethods.getInstance().getContentObjectWithFunctionAssigned( 
									(Snapshot)listDialog.getResult()[0], 
									SessionSourceProvider.CURRENT_SNAPSHOT, CURRENT_FUNCTION_LIST);
							
							initializeSnapshotTree();
						}
						
					}
					
				}
			}
		});
		btnCompareTo.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/splash green.png"));
		btnCompareTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		btnCompareTo.setText("Compare To...");
		new Label(parent, SWT.NONE);
		
		Label lblOverallStatus = new Label(parent, SWT.NONE);
		lblOverallStatus.setText("Overall Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnSetStatus = new Button(parent, SWT.NONE);
		btnSetStatus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.views.PropertySheet");
				} catch (PartInitException e1) {}
				
			}
		});
		btnSetStatus.setToolTipText("Open Properties Window");
		btnSetStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/up.png"));
		btnSetStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSetStatus.setText("Set Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblConfigured = new Label(parent, SWT.NONE);
		lblConfigured.setText("Configured");
		
		lblDate = new Label(parent, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblDate.setText("");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		btnSave = new Button(parent, SWT.NONE);
		btnSave.setToolTipText("Save Function Content");
		btnSave.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Apply ");

		btnSave.setEnabled(false);
		btnSave.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if ( MessageDialog.openQuestion(composite.getShell(), "" +
						"Confirmation Required", "Are you sure you want to add " +
								"the files to the selected function?") ) {
					
					AssignFunctionViewMethods.getInstance().saveFunctionAssignment(CURRENT_FUNCTION_FILE_LIST, 
							functionNameText.getText(), SessionSourceProvider.CURRENT_FUNCTION );

					btnSave.setEnabled(false);
					btnSave.setText("Apply");

					ContainerDao cDao = DaoFactory.eINSTANCE.createContainerDao();
					cDao.setOwner(SessionSourceProvider.USER);
					
				}
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		containerComboViewer.setInput(AssignFunctionViewMethods.getInstance().getContainerList(SessionSourceProvider.USER) );
		
		new Label(parent, SWT.NONE);
		
		AssignFunctionViewFilters.getInstance().createFiltersAndSorters();
		AssignFunctionViewFilters.getInstance().createActions(snapshotTreeViewer);
		AssignFunctionViewFilters.getInstance().createMenus(getViewSite().getActionBars().getMenuManager());
		
	}
	

	protected void initializeSnapshotTree() {

		// delete all the old content and lists
		clearSnapshotTree();

		// this one also adds the colors for used and dummy objects
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder ());
		
		// get snapshot functions and add to combo and List
		CURRENT_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
			.getFunctions(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		ORIGINAL_FUNCTION_LIST = CURRENT_FUNCTION_LIST;
		
		functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
		functionComboViewer.refresh();

		// now get all the file and folder information
		CURRENT_FILE_LIST = AssignFunctionViewMethods.getInstance()
				.getContentObjects(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
				.getRootFolder(CURRENT_FILE_LIST));
		
		snapshotTreeViewer.refresh();
		
	}

	private void clearFunctionTree() {
		// clears every information related to a selected function 
		SessionSourceProvider.CURRENT_FUNCTION = null;
		CURRENT_FUNCTION_FILE_LIST.clear();
		ORIGINAL_FUNCTION_FILE_LIST.clear();
		CURRENT_FUNCTION_FILE_STATUS_LIST.clear();
		ORIGINAL_FUNCTION_FILE_STATUS_LIST.clear();
		functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
		tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
		functionNameText.setText("");
		lblDate.setText("");
	}
	
	private void clearSnapshotTree() {
		clearFunctionTree();
		CURRENT_FILE_LIST.clear();
		CURRENT_FILE_LIST_WITH_FUNCTION.clear();
		CURRENT_FUNCTION_LIST.clear();
		ORIGINAL_FUNCTION_LIST.clear();
		snapshotTreeViewer.setInput(CURRENT_FILE_LIST);
		snapshotTreeViewer.refresh();
	}

	@SuppressWarnings("unchecked")
	protected void storeFunctionInfoInFile( ContentObject co ) {
		if ( co instanceof File || co instanceof Folder ) {
			
			for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
				
				if ( CURRENT_FILE_LIST.get(i).getObjectId().equals(co.getObjectId())) {
					
					boolean functionAlreadyInPlace = false;
					
					for ( Function f : CURRENT_FILE_LIST.get(i).getFunction() ) {
						
						if ( f.getFunctionId().equals(SessionSourceProvider
								.CURRENT_FUNCTION.getFunctionId() )) {

							functionAlreadyInPlace = true;
							break; 
							
						}
						
					}
					if ( !functionAlreadyInPlace ) 
						CURRENT_FILE_LIST.get(i).getFunction()
						.add(SessionSourceProvider.CURRENT_FUNCTION);
					
					co = CURRENT_FILE_LIST.get(i);
					break;
					
				}
				
			}
			
			if ( co instanceof File ) {
				
				java.util.List<String> fileTypes = Arrays.asList(Platform
						.getPreferencesService().getString( 
								"com.amenity.workbench" , 
								WorkbenchConstants.FILETYPE , 
								"scs,scsrm,srs,srsrm,sddrm,scrm,Lint,smts," +
								"smtsrm,smtr,smtl,sits,sitsrm,sitl,sitr,svts,svtsrm", 
								null ).split(","));
				java.util.List<String> fileExtns = Arrays.asList(Platform
						.getPreferencesService().getString( 
								"com.amenity.workbench" , 
								WorkbenchConstants.FILEEXTN , 
								"doc,xls,rtf,pdf,htm,html,chm,vsd,ppt,txt", null ).split(","));

				for ( String extn : fileExtns ) {
					if ( ("." + extn).equals(((File) co).getSuffix())) {
						for ( String type : fileTypes ) {

							if ( ((File)co).getName().contains(type)) {
								
								// Add it to FFS
								System.out.println("I found a match");
								FileFunctionStatus ffs = GeneralFactory.eINSTANCE.createFileFunctionStatus();
								ffs.setOfFile(co);
								ffs.setOfFunction(SessionSourceProvider.CURRENT_FUNCTION);
								ffs.setSetOn(new Date());
								GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
								Session session = gDao.getSession();
								session.beginTransaction();
								try {
									session.merge(ffs);
								} catch ( Exception ex ) {}
								session.getTransaction().commit();
								session.close();
								
								CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods.getInstance()
										.getFileFunctionStatus(SessionSourceProvider.CURRENT_FUNCTION);
								ORIGINAL_FUNCTION_FILE_STATUS_LIST = CURRENT_FUNCTION_FILE_STATUS_LIST;
								tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
								
								break;
							}
						}
						
						break;
					}
				}
			}
			
//			co.getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
			CURRENT_FUNCTION_FILE_LIST.add(co);
			CURRENT_FILE_LIST_WITH_FUNCTION.add(co);
		}
		// if its a folder fetch children and perform same operation
		if ( co instanceof Folder ) {
			java.util.List<ContentObject> coList = AssignFunctionViewMethods.getInstance()
					.getFolderChildren( (Folder)co , SessionSourceProvider.CURRENT_SNAPSHOT );
			for ( ContentObject subCo : coList ) {
				storeFunctionInfoInFile(subCo);
			}
		}
	}

	
	/*
	 * New drag and drop stuff
	 */
	
	private void moveFileTypeToFunction(Object obj) {
		// delete function! 
		if ( !structuredSelection.isEmpty()) {
			CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods
					.getInstance().deleteFileFunctionStatus((FileFunctionStatus) 
							obj, 
							CURRENT_FUNCTION_FILE_STATUS_LIST);
			getViewSite().getActionBars().getStatusLineManager().setMessage ("item deleted");
			
			// refreshing table
			CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods.getInstance()
					.getFileFunctionStatus(SessionSourceProvider.CURRENT_FUNCTION);
			ORIGINAL_FUNCTION_FILE_STATUS_LIST = CURRENT_FUNCTION_FILE_STATUS_LIST;
			tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
//			tableViewer.refresh();
		}
		
	}
	
	public void moveFunctionToFileType ( String data ) {
		FileFunctionStatus ffs = GeneralFactory.eINSTANCE.createFileFunctionStatus();

		FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();

		ffs = (FileFunctionStatus) ffsDao.createFfsWithFunctionIdObjectId(
				(File)coDao.getById(data.toString()), 
				SessionSourceProvider.CURRENT_FUNCTION, 
				ffs);
		
		CURRENT_FUNCTION_FILE_STATUS_LIST.add(ffs);
		
		tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
		tableViewer.refresh();
	}
	
	public boolean moveSnapshotToFunction ( String data ) {
		
		for ( ContentObject co : CURRENT_FUNCTION_FILE_LIST) {
			if ( co.getObjectId().equals(data)) {
				
				btnSave.setEnabled(false);
				btnSave.setText("Apply");
				return false;
				
			}
		}
		
		if ( SessionSourceProvider.CURRENT_FUNCTION != null ) {
			for ( ContentObject co : CURRENT_FILE_LIST )
				if ( co.getObjectId().equals(data.toString() )) {
					
					storeFunctionInfoInFile(co);
					
					break;
				}
			
			snapshotTree.removeAll();
			
			snapshotTreeViewer.setLabelProvider( new SnapshotStyledLabelProvder(CURRENT_FILE_LIST) );
			snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance().getRootFolder(CURRENT_FILE_LIST) );

			functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
		} else {
			MessageDialog.openInformation(composite.getShell(), 
					"Information", "Please select or create a function first");
			return true;
		}
		AssignFunctionViewFilters.getInstance().setUndefinedItem();
		

		btnSave.setEnabled(true);
		btnSave.setText("Apply *");
		
		return true;
	}
	
//	@SuppressWarnings("unchecked")
//	private void removeFromFunction ( ContentObject co, Session session ) {
//		
//		session.load(co, co.getObjectId());
//		if ( co instanceof Folder ) {
//			co.getFunction().remove(SessionSourceProvider.CURRENT_FUNCTION);
//			for ( ContentObject co2 : (java.util.List<ContentObject> )session.createQuery(
//					"from ContentObject where rootDir = :mother or rootDirectory = :mother" )
//					.setParameter("mother", co).list() ) {
//				removeFromFunction( co2, session);
//			}
//		} else {
//			co = AssignFunctionViewMethods.getInstance().getContentObject(session, co);
//			
//			ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
//			
//			coDao.deleteFunctionFromCo(SessionSourceProvider.CURRENT_FUNCTION, co);
//			
//			co.getFunction().remove(SessionSourceProvider.CURRENT_FUNCTION);
//			session.merge(co);
//			System.out.println("no delete");
//			session.createQuery("delete from FileFunctionStatus where ofFile = :file " +
//					"and ofFunction = :function")
//					.setParameter("file", co)
//					.setParameter("function", SessionSourceProvider.CURRENT_FUNCTION)
//					.executeUpdate();
//			session.getTransaction().commit();
//		}
//	}
	
	
	public void moveFunctionToSnapshot ( String data ) {
		Session session = gDao.getSession();
		session.beginTransaction();
		
		// look in full file list for object
		for ( ContentObject co : CURRENT_FILE_LIST ){
			
			if ( co.getObjectId().equals(data) ) {
				
//				if ( co instanceof File ) {
					co = AssignFunctionViewMethods.getInstance().getContentObject(session, co);
					
					ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
					
					coDao.deleteFunctionFromCo(SessionSourceProvider.CURRENT_FUNCTION, co);
					
					co.getFunction().remove(SessionSourceProvider.CURRENT_FUNCTION);
					session.merge(co);
					System.out.println("no delete");
					session.createQuery("delete from FileFunctionStatus where ofFile = :file " +
							"and ofFunction = :function")
							.setParameter("file", co)
							.setParameter("function", SessionSourceProvider.CURRENT_FUNCTION)
							.executeUpdate();
					session.getTransaction().commit();
					break;
//				} else if ( co instanceof Folder ) {
//					
//					removeFromFunction ( co, session);
//					
//				}
				
				
			}
			
		}
		
		CURRENT_FUNCTION_LIST.clear();
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder ());
		// now fill the other static variables
		CURRENT_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
				.getFunctions(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		CURRENT_FILE_LIST_WITH_FUNCTION = AssignFunctionViewMethods.getInstance()
				.getContentObjectsFunctions(CURRENT_FILE_LIST);

		CURRENT_FUNCTION_FILE_LIST = AssignFunctionViewMethods.getInstance()
				.getContentObjectsWithFunction( CURRENT_FILE_LIST_WITH_FUNCTION );
		
		// now fill the views
		snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
				.getRootFolder(CURRENT_FILE_LIST));
		snapshotTreeViewer.refresh();
		
		functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
		
		functionTreeViewer.refresh();
		session.close();

		CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods.getInstance()
				.getFileFunctionStatus(SessionSourceProvider.CURRENT_FUNCTION);
		ORIGINAL_FUNCTION_FILE_STATUS_LIST = CURRENT_FUNCTION_FILE_STATUS_LIST;
		tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
		
	}
	
	
	@Override
	public void setFocus() {}
}
