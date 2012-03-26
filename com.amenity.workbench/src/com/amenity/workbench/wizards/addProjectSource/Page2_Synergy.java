package com.amenity.workbench.wizards.addProjectSource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import general.Connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.StyledText;

public class Page2_Synergy extends WizardPage {
	
	private ProgressBar progressBar;
	private Label lblNewLabel;
	private Button btnConnect;
	private Logger log;
	private Composite container;
	private Job job;
	private Job job2;
	private Job job3;
	private StyledText styledText;
	private PmpeIoManager pmp;
	private String text;
	
	
	/**
	 * Create the wizard.
	 */
	public Page2_Synergy(Connection connection) {
		super("wizardPage");
		setTitle("Synergy Data Source Profile");
		setDescription("Please connect to Synergy");
		/*
		 * logger creation and initialization
		 */
		log = LogManager.getLogger(Page2_Synergy.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(null);
		
		Label lblEstablishSynergyConnection = new Label(container, SWT.NONE);
		lblEstablishSynergyConnection.setBounds(5, 10, 382, 13);
		lblEstablishSynergyConnection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblEstablishSynergyConnection.setText("Establish Synergy Connection");
		
		btnConnect = new Button(container, SWT.NONE);
		btnConnect.setToolTipText("Connect to Synergy");
		btnConnect.setBounds(422, 74, 150, 26);
		btnConnect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnConnect.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/connect_creating.png"));
		
		
		btnConnect.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected ( SelectionEvent e ) {
				
				connectButtonAction ();
			}
			
		});
		btnConnect.setText("Connect");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 240, 582, 8);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(5, 254, 567, 13);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("-");
		
		//		progressBar = new ProgressBar(container, SWT.NONE);
				
		progressBar = new ProgressBar(container, SWT.INDETERMINATE | SWT.HORIZONTAL);
		progressBar.setBounds(10, 273, 562, 18);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		progressBar.setVisible(false);
		
		progressBar.setState(SWT.PAUSED);
		
		Button btnSetDatabase = new Button(container, SWT.NONE);
		btnSetDatabase.setToolTipText("Enter the database name after database = /appl/telelogic/ccmdb71/");
		btnSetDatabase.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String ccmIniFile = Platform.getPreferencesService().getString( 
						"com.amenity.workbench" , 
						"SGYINI_FILE" , System.getenv("userprofile")
						.replace('\\', '/') + "\\ccm71.ini" , null );
				
				java.io.File ini = new java.io.File(ccmIniFile);
				
				if ( ini.exists() && ini.isFile() ) {
					styledText.setVisible(true);
					pmp = new PmpeIoManager();
					text = "";
					
					try {
						text = pmp.getFile(ccmIniFile);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					
					styledText.setText(text);
					
				} else {
					MessageDialog.openWarning(getShell(), "Warning", 
							"The Synergy ini is missing. Please adjust the properties");
				}
			}
		});
		btnSetDatabase.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/database_edit.png"));
		btnSetDatabase.setBounds(422, 10, 150, 26);
		btnSetDatabase.setText("Set Database");
		
		styledText = new StyledText(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		styledText.setToolTipText("Enter the database name after database = /appl/telelogic/ccmdb71/");
		
		styledText.setBounds(5, 29, 411, 205);
		styledText.setVisible(false);
		
		connectButtonStatus();
		
	}

	
	void buttonPressed( int buttonId ) {
		System.out.println("button pressed" + buttonId);
	}
	
	void nextPressed() {
		ProjectWizard wizard = (ProjectWizard)getWizard();
		wizard.three_sgy.createProjectList(wizard.projectList);
	}

	@SuppressWarnings("unused")
	private void doConnect() {
		btnConnect.setEnabled(false);
		
		SynergyLogin sgyLogin = new SynergyLogin();
		
		SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
		
		SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );
		if ( SessionSourceProvider.SYNERGY_SID == null ) {
			System.out.println("Error while creating SID");
			btnConnect.setEnabled(true);
		} else {
			if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null )
				SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin
				.getRawProjectList(SessionSourceProvider.SYNERGY_SID);
			if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
				System.out.println(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
				ProjectWizard wizard = (ProjectWizard)getWizard();
				wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
				lblNewLabel.setText("Connected with ID: " + 
						SessionSourceProvider.SYNERGY_SID);
				setPageComplete(true);
			}
        
	        lblNewLabel.getDisplay().asyncExec(new Runnable() {
	        	public void run() {
	        	lblNewLabel.setText("Connected with ID: " + 
						SessionSourceProvider.SYNERGY_SID);
	        	}
	        });
		}
	}
	
	
	private void syncWithUi() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(container.getShell(), "Status Message",
						"The Synergy Connection is established");

				if ( SessionSourceProvider.SYNERGY_SID == null ) {
					log.error("Error while creating SID");
					btnConnect.setEnabled(true);
				} else 
					if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
						log.info(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
						ProjectWizard wizard = (ProjectWizard)getWizard();
						wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
						lblNewLabel.setText("Connected with ID: " + 
								SessionSourceProvider.SYNERGY_SID);
						SessionSourceProvider.SESSION_STATUS
							.setSynergySession(SessionSourceProvider.SYNERGY_SID);
						setPageComplete(true);
				} else {
						/*
						 * TODO: Nicer error messages
						 */
						log.error("Error while reading projects");
					
				}
			}
		});
	}
	
	private void connectButtonStatus() {
		
		if ( SessionSourceProvider.SYNERGY_SID == null || 
				SessionSourceProvider.SYNERGY_SID.length() < 1 ) {
			setPageComplete(false);
			btnConnect.setEnabled(true);
			btnConnect.setText("Connect");
		} else {
			setPageComplete(true);
			btnConnect.setEnabled(true);
			btnConnect.setText("Disconnect");
		}
		
	}
	
	private void connectButtonAction ( ) {
		
		if ( SessionSourceProvider.SYNERGY_SID == null || 
				SessionSourceProvider.SYNERGY_SID.length() < 1 ) {
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
			
			job = new Job("Synergy Connect") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// start progressbar
					job2.schedule();
					
					SynergyLogin sgyLogin = new SynergyLogin();

					SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
					
					if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null && 
							SessionSourceProvider.SYNERGY_SID != null )
						SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin.getRawProjectList(
								SessionSourceProvider.SYNERGY_SID);
					/*
					 *  Synergy connection ends here
					 */
					
					// inform about finish status
					job3.schedule();
					syncWithUi();
					return Status.OK_STATUS;
				}
			};

			job.setUser(true);
			job.schedule();
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
			
			job = new Job("Synergy Connect") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// start progressbar
					job2.schedule();
					
					SynergyLogin sgyLogin = new SynergyLogin();

					sgyLogin.closeSynergySession(SessionSourceProvider.SYNERGY_SID);
					SessionSourceProvider.SYNERGY_SID = null;
					
					// inform about finish status
					job3.schedule();
					syncWithUi();
					return Status.OK_STATUS;
				}
			};

			job.setUser(true);
			job.schedule();
		}
		
	}
	
	private void startProgressBar() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				
				// save file
				if ( pmp != null ) {
					try {
						pmp.saveFile(text, styledText.getText().getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				
				progressBar.setVisible(true);
				progressBar.setState(SWT.NORMAL);
			}
		});
	}
	private void stopProgressBar() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				
				progressBar.setState(SWT.PAUSED);
				progressBar.setVisible(false);

				SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );

				connectButtonStatus();
			}
		});
	}
	
	class PmpeIoManager {
		  public String getFile(String filename) throws IOException {
			  InputStream in = new BufferedInputStream(new FileInputStream(filename));
			  StringBuffer buf = new StringBuffer();
			  int c;
			  while ((c = in.read()) != -1) {
				  buf.append((char) c);
			  }
			  return buf.toString();
		  }

		  public void saveFile(String filename, byte[] data) throws IOException {
			  File outputFile = new File(filename);
			  FileOutputStream out = new FileOutputStream(outputFile);
			  out.write(data);
			  out.close();
		  }
	}
}
