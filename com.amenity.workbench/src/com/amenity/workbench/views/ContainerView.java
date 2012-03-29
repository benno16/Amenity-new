package com.amenity.workbench.views;

import java.util.Comparator;
import java.util.Iterator;

import general.Connection;
import general.Container;
import general.Snapshot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

import com.amenity.engine.helper.gui.contentProvider.ConnectionTreeContentProvider;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.workbench.Activator;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.ModifyContainerDialog;
import com.amenity.workbench.supporter.WorkbenchConstants;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;
import com.amenity.workbench.wizards.addProjectSource.ProjectWizard;
import com.amenity.workbench.wizards.addSnapshot.SnapshotWizard;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.DaoFactory;
import dao.SnapshotDao;

import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ContainerView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.ContainerView"; //$NON-NLS-1$
	private ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
	@SuppressWarnings("unused")
	private Composite parent;
	private Button btnDelete;
	private Button btnCreate;
	private ListViewer listViewer;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private TreeViewer detailTreeViewer;
	private Tree detailTree;
	private EContentAdapter adapter;
	private Label label;
	private Menu menu;
	private MenuItem mntmNewSnapshot;
	private MenuItem mntmDeleteSelectedItem;
	private MenuItem mntmNewConnection;
	@SuppressWarnings("unused")
	private Object currentObject;
	private Label lblRefresh;
	
	
	public ContainerView() {
		PlatformUI.getWorkbench();
		adapter = new EContentAdapter () {
			public void notifyChanged ( Notification not) {
				super.notifyChanged(not);
				detailTreeViewer.refresh();
				detailTreeViewer.setAutoExpandLevel(2);
			}
		};
		
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(final Composite parent) {
		this.parent =parent;
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, true, true, 3, 10);
		gd_label.widthHint = 287;
		parent.setLayout(new GridLayout(3, true));
		
		
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		preferenceStore.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if ( event.getProperty() == WorkbenchConstants.DBUSERNAME ) {
					System.out.println( "USER: " + event.getNewValue().toString() );
				} else {
					System.out.println( "OTHER: " + event.getNewValue().toString() );
				}
			}
			
		});
		
		Label lblAvailableContainer = new Label(parent, SWT.NONE);
		lblAvailableContainer.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblAvailableContainer.setText("Available Container");
		
		lblRefresh = new Label(parent, SWT.NONE);
		lblRefresh.setToolTipText("manually refresh the container view");
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				refreshContainerList();
			}
		});
		lblRefresh.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/refresh.png"));
		GridData gd_lblRefresh = new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1);
		gd_lblRefresh.widthHint = 16;
		gd_lblRefresh.minimumHeight = 16;
		lblRefresh.setLayoutData(gd_lblRefresh);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		listViewer = new ListViewer(parent, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setToolTipText("Select your container here");
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				ModifyContainerDialog dialog = new ModifyContainerDialog ( parent.getShell()); 
				if ( dialog.open() == Window.OK) {
					
					containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
					containerDao.setOwner(SessionSourceProvider.USER);
				}
			}
		});
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
		gd_list.heightHint = 80;
		gd_list.minimumHeight = 100;
		list.setLayoutData(gd_list);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectSelection = listViewer.getSelection();
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

		    public void selectionChanged(SelectionChangedEvent event) {
		        // Handle selection changed event here
		    	objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        			(Container) structuredSelection.getFirstElement(); 
		        		detailTreeViewer.setInput(SessionSourceProvider.CURRENT_CONTAINER);
		        	}
		        }
			}
		});
		
		listViewer.setContentProvider(new ArrayContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		listViewer.setLabelProvider(new GenericNameLabelProvider() ); //ContainerLabelProvider());
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
		getSite().setSelectionProvider(listViewer);
		
		Menu menu_1 = new Menu(list);
		list.setMenu(menu_1);
		
		MenuItem mntmCreateContainer = new MenuItem(menu_1, SWT.NONE);
		mntmCreateContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerWizard wizard = new ContainerWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				enableButtons();
			}
		});
		mntmCreateContainer.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		mntmCreateContainer.setText("Create Container");
		
		MenuItem mntmModifyContainer = new MenuItem(menu_1, SWT.NONE);
		mntmModifyContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ModifyContainerDialog dialog = new ModifyContainerDialog ( parent.getShell()); 
				if ( dialog.open() == Window.OK) {
					containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
					containerDao.setOwner(SessionSourceProvider.USER);
					refreshContainerList();
				}
			}
		});
		mntmModifyContainer.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/database_edit.png"));
		mntmModifyContainer.setText("Modify Container");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmDeleteContainer = new MenuItem(menu_1, SWT.NONE);
		mntmDeleteContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog msg = new MessageDialog ( parent.getShell(), 
						"Warning", null, 
						"Are you sure you want to delete the CONTAINER '" 
						+ SessionSourceProvider.CURRENT_CONTAINER.getName() + "'? \n" +
						"This operation cannot be reversed!", 
						MessageDialog.ERROR, 
						new String[] {"Delete", "Keep"}, 1);
				if ( msg.open() == 0 ) {
					Container c = null;
					for ( Iterator<Container> iter = SessionSourceProvider.CONTAINER_LIST.iterator(); iter.hasNext(); ) {
						c = iter.next();
						if ( c.equals(SessionSourceProvider.CURRENT_CONTAINER )) {
							iter.remove();
							SessionSourceProvider.CURRENT_CONTAINER = null;
							break;
						}
					}
					containerDao.delete(c);
				}
				enableButtons();
			}
		});
		mntmDeleteContainer.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
		mntmDeleteContainer.setText("Delete Container");
		
		btnCreate = new Button(parent, SWT.NONE);
		btnCreate.setToolTipText("Create a new Container");
		btnCreate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnCreate.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		btnCreate.setText("Create");
		
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		//				ContainerWizard wizard = new ContainerWizard(SessionSourceProvider.CONTAINER_LIST);
				ContainerWizard wizard = new ContainerWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				enableButtons();
			}
		});
		
		// Delete Button
		btnDelete = new Button(parent, SWT.NONE);
		btnDelete.setToolTipText("Delete the selected Container");
		btnDelete.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		btnDelete.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
		btnDelete.setText("Delete Container");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog msg = new MessageDialog ( parent.getShell(), 
						"Warning", null, 
						"Are you sure you want to delete the container '" 
						+ SessionSourceProvider.CURRENT_CONTAINER.getName() + "'? \n" +
						"This operation cannot be reversed!", 
						MessageDialog.WARNING, 
						new String[] {"Delete", "Keep"}, 1);
				if ( msg.open() == 0 ) {
					Container c = null;
					for ( Iterator<Container> iter = SessionSourceProvider.CONTAINER_LIST.iterator(); iter.hasNext(); ) {
						c = iter.next();
						if ( c.equals(SessionSourceProvider.CURRENT_CONTAINER )) {
							iter.remove();
							SessionSourceProvider.CURRENT_CONTAINER = null;
							break;
						}
					}
					containerDao.delete(c);
				}
				enableButtons();
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.CENTER);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblConnectionsAndSnapshots = new Label(parent, SWT.NONE);
		lblConnectionsAndSnapshots.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblConnectionsAndSnapshots.setText("Connections and Snapshots");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		detailTreeViewer = new TreeViewer(parent, SWT.BORDER);
		detailTreeViewer.setAutoExpandLevel(2);
		detailTree = detailTreeViewer.getTree();
		detailTree.setToolTipText("Select the object to modify its properties");

		GridData gd_detailTree = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_detailTree.minimumHeight = 100;
		detailTree.setLayoutData(gd_detailTree);
		detailTreeViewer.setLabelProvider(new GenericNameLabelProvider());
		detailTreeViewer.setContentProvider(new ConnectionTreeContentProvider());
		getSite().setSelectionProvider(detailTreeViewer);
		
		menu = new Menu(detailTree);
		detailTree.setMenu(menu);

		mntmNewConnection = new MenuItem(menu, SWT.NONE);
		mntmNewConnection.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		mntmNewConnection.setText("Add Connection");
		mntmNewConnection.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ProjectWizard wizard = new ProjectWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
				listViewer.refresh();
			}
			
		});

		mntmNewSnapshot = new MenuItem(menu, SWT.NONE);
		mntmNewSnapshot.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gnome-dev-computer.png"));
		mntmNewSnapshot.setText("Add Snapshot");
		mntmNewSnapshot.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				SnapshotWizard wizard = new SnapshotWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
				listViewer.refresh();
				
//				detailTreeViewer.setInput(SessionSourceProvider.CURRENT_CONTAINER);
				detailTreeViewer.refresh();
			}
			
		});
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		mntmDeleteSelectedItem = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedItem.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
		mntmDeleteSelectedItem.setText("Delete Selected Item");
		mntmDeleteSelectedItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				objectSelection = detailTreeViewer.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				
				if ( !structuredSelection.isEmpty() ) {
					if ( structuredSelection.getFirstElement() instanceof Connection ) {
						MessageDialog msg = new MessageDialog ( parent.getShell(), 
								"Warning", null, 
								"Are you sure you want to delete the object '" 
								+ ((Connection)structuredSelection.getFirstElement())
								.getAddInfo1() + "'? \n" +
								"This operation cannot be reversed!", 
								MessageDialog.WARNING, 
								new String[] {"Delete", "Keep"}, 1);
						
						if ( msg.open() == 0 ) {
							ConnectionDao cDao = DaoFactory.eINSTANCE.createConnectionDao();
							cDao.delete(structuredSelection.getFirstElement());
						}
					} else if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
						MessageDialog msg = new MessageDialog ( parent.getShell(), 
								"Warning", null, 
								"Are you sure you want to delete the object '" 
								+ ((Snapshot)structuredSelection.getFirstElement())
								.getName() + "'? \n" +
								"This operation cannot be reversed!", 
								MessageDialog.WARNING, 
								new String[] {"Delete", "Keep"}, 1);
						
						if ( msg.open() == 0 ) {
							SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
							sDao.delete(structuredSelection.getFirstElement());
						}
					}
					detailTreeViewer.refresh();
					
				}
			}
			
		});
		
		detailTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				if ( !structuredSelection.isEmpty()) {
					currentObject = structuredSelection.getFirstElement();
					mntmDeleteSelectedItem.setEnabled(true);
					
					if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
						SessionSourceProvider.CURRENT_SNAPSHOT = 
								(Snapshot) structuredSelection.getFirstElement();
						SessionSourceProvider.CURRENT_SNAPSHOT.eAdapters().add(adapter);
					} 
				}
			}
		});
		
		mntmDeleteSelectedItem.setEnabled(false);

	}
	
	protected static Comparator<Container> newAscStringComparator() {
	    return new Comparator<Container>() {
	    	@Override
			public int compare(Container first , Container second) {
	    		return String.valueOf(first.getName()).compareTo(String.valueOf(second.getName()));
	    	}
	    };
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	@SuppressWarnings("unchecked")
	private void refreshContainerList() {
		SessionSourceProvider.CONTAINER_LIST = 
				containerDao.getListByOwner(Container.class, SessionSourceProvider.USER);
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
		listViewer.refresh();
	}
	
	
	private void enableButtons() {

		btnDelete.setEnabled(!(SessionSourceProvider.CONTAINER_LIST.size() < 1));
		refreshContainerList();
	}
}
