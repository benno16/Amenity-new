package com.amenity.workbench.wizards.addProjectSource;

import java.util.List;

import general.Connection;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.engine.helper.mks.MksLogin;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.DaoFactory;
import org.eclipse.wb.swt.ResourceManager;

public class Page2_MKS extends WizardPage implements Listener {
	Text text;
	Text text_1;
	private MksLogin mksLogin;
	Combo combo;
	private boolean loginOK = false;
	List<String> projects;

	/**
	 * Create the wizard.
	 */
	public Page2_MKS(Connection connection) {
		super("wizardPage");
		setTitle("MKS Data Source Profile");
		setDescription("Please enter your MKS Integrity account details");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblUsername = new Label(container, SWT.NONE);
		lblUsername.setBounds(32, 13, 78, 15);
		lblUsername.setText("Username");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 10, 448, 21);
		text.setText(SessionSourceProvider.USER.getUsername());
		text.addListener(SWT.Modify, this);
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setBounds(32, 40, 78, 15);
		lblPassword.setText("Password");
		
		text_1 = new Text(container, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(116, 37, 448, 21);
//		text_1.addListener(SWT.Modify, this);
		ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
		text_1.setText(connectionDao.findMksPassword(SessionSourceProvider.USER));
		
		combo = new Combo(container, SWT.NONE);
		combo.setBounds(116, 64, 448, 23);
		combo.add("mks-bs",0);	// default entry - but modifyable
		combo.select(0);
		combo.addListener(SWT.Modify, this);
		
		Label lblMksServer = new Label(container, SWT.NONE);
		lblMksServer.setBounds(32, 67, 78, 15);
		lblMksServer.setText("MKS Server");
		
		Button btnTest = new Button(container, SWT.NONE);
		btnTest.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/test.png"));
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if ( loginWorking() ) {
					MessageDialog.openInformation(container.getShell(), "MKS Login Test", "Test successful!");
				} else {
					MessageDialog.openError(container.getShell(), "MKS Login Test", "Login not successful! ");
				}
			}
		});
		btnTest.setBounds(245, 149, 100, 25);
		btnTest.setText("Test Settings");
		
		Label lblImg = new Label(container, SWT.NONE);
		lblImg.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/user.png"));
		lblImg.setBounds(10, 13, 16, 16);
		
		Label label = new Label(container, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/password.png"));
		label.setBounds(10, 40, 16, 16);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/server.png"));
		label_1.setBounds(10, 64, 16, 16);
		btnTest.addListener(SWT.PUSH, this);
	}
	
	public boolean isPageComplete() {
		if ( !loginOK ) {
			return false;
		}
//		saveDataToModel();
		return true;
	}
	
	public void handleEvent ( Event e ) {
		if ( loginOK ) {
			setPageComplete(true);
			setDescription("Please enter your MKS Integrity account details");
		} else {
			setPageComplete(false);
			setErrorMessage("You have to test the login credentials");
		}
		getWizard().getContainer().updateButtons();
	}
	
	public boolean loginWorking() {
		if ( loginOK ) 
			return true;
		mksLogin = new MksLogin (text.getText(), text_1.getText(), 
				combo.getItem(combo.getSelectionIndex()), false);
		projects = mksLogin.showProjects();
		
		if ( projects == null )
			return false;
		
		if ( projects.size() > 0 ) {
			loginOK = true;
			SessionSourceProvider.SESSION_STATUS.setMksStatus(true);
			setPageComplete(true);
			for ( String s : projects )
				System.out.println(s);
			return true;
		} else {
			setErrorMessage("The user credentials are not correct! ");
			loginOK = false;
			setPageComplete(false);
			return false;
		}
	}
	
}
