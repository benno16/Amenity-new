package com.amenity.workbench.dialogs;

import java.util.Date;
import java.util.UUID;

import general.Container;
import general.GeneralFactory;
import general.User;
import general.UserList;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.workbench.Application;
import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.DaoFactory;
import dao.GeneralQueries;
import dao.UserDao;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

@SuppressWarnings("unused")
public class LoginDialog extends Dialog {
	/**
	 * Manning JFace Page 231
	 */
	private Text text;
	private Text text_1;
	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;
	public static Button btnRememberMyPassword;
	private GeneralQueries genericQueries;
	private boolean dbAlive = false;
	private Adapter adapter;
	private Logger log;
	private User tempUser;
	private UserDao userDao;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
		adapter = new AdapterImpl() {
			public void notifyChanged ( Notification notification ) {
				System.out.println("New database Status: " + SessionSourceProvider.SESSION_STATUS.isDbStatus());
			}
		};

		log = LogManager.getLogger(LoginDialog.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		/*
		 *  at login the database status is checked
		 */
		genericQueries = DaoFactory.eINSTANCE.createGeneralQueries();
		if ( genericQueries.dbAlive() ) {
			dbAlive = true;
			log.info("Database is running#1");
		} else {
			log.error("Database server is offline#1");
		}
	}
	
	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("I BS Q - Amenity");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
					
		Composite container = (Composite) super.createDialogArea(parent);
		
		parent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.keyCode == SWT.ESC) {
					buttonPressed(Window.CANCEL);
				}
			}
		});
		
		container.setLayout(null);

		Label lblUserName = new Label(container, SWT.NONE);
		lblUserName.setBounds(10, 10, 100, 15);
		lblUserName.setText("User Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 7, 167, 21);
		text.setText(System.getenv("username"));
		text.setEnabled(false);

		text_1 = new Text(container, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(116, 34, 167, 21);
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setBounds(10, 37, 100, 15);
		lblPassword.setText("Password");
		
		btnRememberMyPassword = new Button(container, SWT.CHECK);
		btnRememberMyPassword.setBounds(116, 61, 146, 16);
		btnRememberMyPassword.setText("Remember my password");
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			
			// simply allows to change the user name... 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				text.setEnabled(true);
				
			}
		});
		button.setBounds(289, 5, 27, 25);
		button.setText("...");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		if ( dbAlive )
			lblNewLabel.setImage(ResourceManager
					.getPluginImage("com.amenity.workbench", 
							"icons/workbench/status/hypersql_on.png"));
		else 
			lblNewLabel.setImage(ResourceManager
					.getPluginImage("com.amenity.workbench", 
							"icons/workbench/status/hypersql_off.png"));
		
		lblNewLabel.setBounds(116, 83, 16, 16);
		
		Label lblDatabaseStatus = new Label(container, SWT.NONE);
		lblDatabaseStatus.setBounds(10, 83, 100, 15);
		lblDatabaseStatus.setText("Database Status");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		createButton(parent, RESET_ID, "Reset All", false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(332, 177);
	}
	
	@SuppressWarnings("unchecked")
	protected void buttonPressed ( int buttonId ) {
		/*
		 * ID 0 : OK
		 * ID 1 : Cancel
		 */
		if ( buttonId == RESET_ID ) {
			text.setText(System.getenv("username"));
			text.setEnabled(false);
			text_1.setText("");
			
		} else if ( buttonId == 0 ){	// on OK

			
			SessionSourceProvider sessionSourceProvider = new SessionSourceProvider();
			sessionSourceProvider.setLoggedIn(true);
			SessionSourceProvider.SESSION_STATUS = GeneralFactory.eINSTANCE.createSessionSatus();
			SessionSourceProvider.SESSION_STATUS.eAdapters().add(adapter);
			SessionSourceProvider.SESSION_STATUS.setDbStatus(dbAlive);
			if ( dbAlive ) {
				try {

					if ( !userExists() ) {	// User does not exist in Database! 
						// create new user
						tempUser = GeneralFactory.eINSTANCE.createUser();
						tempUser.setUsername(System.getenv("username"));
						tempUser.setLastUsed( new Date() );
						tempUser.setTimesUsed(0);
						userDao.create(tempUser);
						log.info("user created...#1");
					} 

					// counter up
					tempUser.setTimesUsed(tempUser.getTimesUsed() + 1);
					tempUser.setLastUsed(new Date());
					userDao.update(tempUser);
					// set session variables
					sessionSourceProvider.setLoggedIn(true);
					SessionSourceProvider.USERID = tempUser.getUserId();
					SessionSourceProvider.USER = tempUser;
					ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
					SessionSourceProvider.CONTAINER_LIST = containerDao
							.getListByOwner(Container.class, SessionSourceProvider.USER);
					

					PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
					MDC.put("userid", SessionSourceProvider.USER.getUserId());
					Logger log = LogManager.getLogger(LoginDialog.class);
					MDC.put("uuid",UUID.randomUUID().toString());
					log.info("user logged in");
					
					super.buttonPressed(buttonId);
					
				} catch ( Exception ex ) {
					log.error("Problem with Database Connection#1");
					ErrorDialog errorDialog = new ErrorDialog(this.getShell(),
							"Database Connection Error",
							"There is a problem with the database connection! ",
							createStatus(),
							IStatus.ERROR | IStatus.INFO );
					errorDialog.open();
				}
			} else {
				MessageDialog.openError(null, "Error", "DB Server not running");

				log.error("DB Server not running#1");
			}
			
		} else { //cancel and stuff
			super.buttonPressed(buttonId);
		}
	}

	private IStatus createStatus() {
		final String dummyPlugin = "some plugin";
		IStatus[] statuses = new IStatus[1];
		
		statuses[0] = new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Oh no! An error occurred!", new Exception());
		
//		statuses[1] = new Status(IStatus.INFO, dummyPlugin, 
//				IStatus.OK, "More errors!?!?", new Exception() );
		
//		MultiStatus multiStatus = new MultiStatus(dummyPlugin, IStatus.OK,
//				statuses, "Several errors have occurred.", new Exception() );
		
//		return multiStatus;
		return new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Please confirm your username!", new Exception());
		
	}
	
	private Boolean userExists() {
		
		tempUser = GeneralFactory.eINSTANCE.createUser();
		tempUser.setUsername( text.getText() );
		userDao = DaoFactory.eINSTANCE.createUserDao();
		tempUser = userDao.findByUsername(tempUser);
		if (tempUser == null ) {
			log.error("User does not exist in database#1");
			return false;
		} else {
			log.info("User with ID: " + tempUser.getUserId() + " found#1");
			return true;
		}
		
	}
	
}
