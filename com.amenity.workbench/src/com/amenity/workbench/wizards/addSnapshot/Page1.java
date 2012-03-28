package com.amenity.workbench.wizards.addSnapshot;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.GeneralFactory;
import general.Snapshot;

import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.mks.MksReader;
import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.engine.helper.synergy.SynergyReader;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.DaoFactory;
import dao.GenericDao;
import dao.SnapshotDao;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.hibernate.Session;
import org.eclipse.wb.swt.ResourceManager;

public class Page1 extends WizardPage {
	private Text text_name;
	private Text text_comment;
	private Button btnCreate;
	private ProgressBar progressBar;
	private Composite container;
	private ComboViewer containerComboViewer;
	private ComboViewer connectionComboViewer;
	private Connection current_connection;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private Snapshot snapshot;

	private Job job;
	private Job job2;
	private Job job3;
	
	/**
	 * Create the wizard.
	 */
	public Page1() {
		super("wizardPage");
		setTitle("New Snapshot Wizard");
		setMessage("Select your container, connection and name and hit create", INFORMATION);
		snapshot = GeneralFactory.eINSTANCE.createSnapshot();
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblContainer = new Label(container, SWT.NONE);
		lblContainer.setBounds(32, 13, 78, 15);
		lblContainer.setText("Container");
		
		Label lblConnection = new Label(container, SWT.NONE);
		lblConnection.setBounds(32, 42, 78, 15);
		lblConnection.setText("Connection");
		
		text_name = new Text(container, SWT.BORDER);
		text_name.setBounds(116, 68, 448, 21);
		text_name.addKeyListener(new KeyAdapter() {
			public void keyPressed ( KeyEvent e) {
				if ( text_name.getText().length()>1) 
					setMessage("Press create to read Information ", INFORMATION);
				
				btnCreate.setEnabled(true);
			}
		});
		Label lblName = new Label(container, SWT.NONE);
		lblName.setBounds(32, 71, 78, 15);
		lblName.setText("Name");
		
		text_comment = new Text(container, SWT.BORDER);
		text_comment.setBounds(116, 95, 448, 21);
		
		Label lblComment = new Label(container, SWT.NONE);
		lblComment.setBounds(32, 98, 78, 15);
		lblComment.setText("Comment");
		
		btnCreate = new Button(container, SWT.NONE);
		btnCreate.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/star.png"));
		btnCreate.setBounds(464, 175, 100, 25);
		btnCreate.setText("Create");
		btnCreate.setEnabled(false);
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( text_name.getText().length()< 1 ) {

					setMessage("no name entered", ERROR);
					
				} else {
					
					job2 = new Job("bar update") {
						protected IStatus run(IProgressMonitor monitor ) {
							startProgressBar();

							return Status.OK_STATUS;
						};
					};
					job3 = new Job("bar update") {
						protected IStatus run(IProgressMonitor monitor ) {
							stopProgressBar();

							return Status.OK_STATUS;
						};
					};
					
					job = new Job("Fetch Content") {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							// start progressbar
							job2.schedule();
//							try {
//								Thread.sleep(500);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//							fetchMetaInformation(current_connection);
							
							
							
							
							
							readData();
							
							
							
							
							
							
							
							
							// inform about finish status
							job3.schedule();
							return Status.OK_STATUS;
						}
					};
					job.setUser(true);
					job.schedule();
				}
				
			}
		});
		
		progressBar = new ProgressBar(container, SWT.INDETERMINATE | SWT.HORIZONTAL);
		progressBar.setBounds(10, 255, 554, 17);
		progressBar.setVisible(false);
		
		containerComboViewer = new ComboViewer(container, SWT.NONE);
		Combo containerCombo = containerComboViewer.getCombo();
		containerCombo.setBounds(116, 10, 448, 21);
		
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        			(Container) structuredSelection.getFirstElement();
		        		getConnectionList();
		        	}
		        }
			}
			
		});

		connectionComboViewer = new ComboViewer(container, SWT.NONE);
		Combo connectionCombo = connectionComboViewer.getCombo();
		connectionCombo.setBounds(116, 39, 448, 21);
		
		Label lblImg = new Label(container, SWT.NONE);
		lblImg.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/drive-harddisk.png"));
		lblImg.setBounds(10, 13, 16, 16);
		
		Label label = new Label(container, SWT.NONE);
		label.setImage(PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_ELCL_SYNCED));
		label.setBounds(10, 41, 16, 16);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/drive_rename.png"));
		label_1.setBounds(10, 71, 16, 16);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/comment.png"));
		label_2.setBounds(10, 95, 16, 16);

		connectionComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		connectionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Connection>)inputElement ) .toArray();
			}
		});
		
		connectionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Connection ) {
		        		if ( text_name.getText().length() > 1 ) {
		        			btnCreate.setEnabled(true);
		        		} else {
							setMessage("please enter a name", WARNING);
							btnCreate.setEnabled(false);
		        		}
		        		current_connection = (Connection) structuredSelection.getFirstElement();
	        			
		        	}
		        }
			}
			
		});
		
		
		getContainerList();
		setPageComplete(false);
	}
	
	protected boolean fetchMetaInformation( Connection connection ) {

		if ( current_connection.getConnectionType() == ConnectionType.MKS) {
			
			MksReader mksReader = new MksReader( current_connection, 
					SessionSourceProvider.CURRENT_SNAPSHOT );
			if ( current_connection.getAddInfo4().equals("Sandbox"))
				mksReader.getSandboxFiles();
			else
				mksReader.getProjectFiles();
			
		} else if ( current_connection.getConnectionType() == ConnectionType.SYNERGY ) {
			
			if ( SessionSourceProvider.SYNERGY_SID == null ) {
				SessionSourceProvider.SYNERGY_SID = new SynergyLogin().getSynergySessionId();
			}
			
			System.out.println("Its a sgy session " + SessionSourceProvider.SYNERGY_SID);
			
			SynergyReader synergyReader = new SynergyReader (SessionSourceProvider.SYNERGY_SID,
					current_connection, SessionSourceProvider.CURRENT_SNAPSHOT );
			
			synergyReader.getProjectFiles();
			
		}
		return true;
	}

	protected void getConnectionList() {
		if ( SessionSourceProvider.CURRENT_CONTAINER != null ) {
			ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
			connectionComboViewer.setInput( connectionDao
					.getListByContainer( SessionSourceProvider.CURRENT_CONTAINER ) );

		} else {
			setMessage("No container selected", ERROR);
			System.out.println("No container selected");
		}
	}

	// used to fetch container list if not yet available
	@SuppressWarnings("unchecked")
	protected void getContainerList() {
		if ( SessionSourceProvider.CONTAINER_LIST.size() < 1) {
			ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
			SessionSourceProvider.CONTAINER_LIST = containerDao.getListByOwner(Container.class, 
					SessionSourceProvider.USER);
		} 
		containerComboViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
	}
	

	
	private void startProgressBar() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				
				progressBar.setVisible(true);
				progressBar.setState(SWT.NORMAL);
				
			}
		});
	}
	
	private void readData() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {


				snapshot.setCreated(new Date());
				snapshot.setName(text_name.getText().length() < 1 ? "-" : text_name.getText() );
				snapshot.setComment(text_comment.getText().length() < 1 ? "-" : text_comment.getText() );
				snapshot.setVia(current_connection);
				SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
				snapshotDao.create(snapshot);
				SessionSourceProvider.CURRENT_SNAPSHOT = snapshot;
				btnCreate.setEnabled(false);
				
				if ( current_connection.getConnectionType() == ConnectionType.MKS) {
					
					MksReader mksReader = new MksReader( current_connection, 
							SessionSourceProvider.CURRENT_SNAPSHOT );
					if ( current_connection.getAddInfo4().equals("Sandbox"))
						mksReader.getSandboxFiles();
					else
						mksReader.getProjectFiles();
					
				} else if ( current_connection.getConnectionType() == ConnectionType.SYNERGY ) {
					
					if ( SessionSourceProvider.SYNERGY_SID == null ) {
						SessionSourceProvider.SYNERGY_SID = new SynergyLogin().getSynergySessionId();
					}
					
					System.out.println("Its a sgy session " + SessionSourceProvider.SYNERGY_SID);
					
					SynergyReader synergyReader = new SynergyReader (SessionSourceProvider.SYNERGY_SID,
							current_connection, SessionSourceProvider.CURRENT_SNAPSHOT );
					
					synergyReader.getProjectFiles();
					
				}
				
			}
		});
	}
	
	private void stopProgressBar() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				
				progressBar.setState(SWT.PAUSED);
				progressBar.setVisible(false);
				setPageComplete(true);
				btnCreate.setEnabled(false);
				GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
				Session session = gDao.getSession();
				session.beginTransaction();
				SessionSourceProvider.CURRENT_CONTAINER = (Container) session.createQuery(
						"from " + Container.class.getName().toString() +
						" where containerId = '" + SessionSourceProvider
						.CURRENT_CONTAINER.getContainerId() + "'").list().get(0);
				SessionSourceProvider.CURRENT_CONTAINER.setOwner(SessionSourceProvider.USER);
				session.update(SessionSourceProvider.CURRENT_CONTAINER);
				session.close();
			}
		});
	}
}
