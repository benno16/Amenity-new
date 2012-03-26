package com.amenity.workbench.views;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.ResourceManager;

public class StartupView extends ViewPart {

	public static final String ID = "com.amenity.workbench.views.StartupView"; //$NON-NLS-1$

	private Label lblLastLogin;
	private Label lblTimesUsed;
	private Label lblSynergyStatus;
	private Label lblMksStatus;
	private Label lblDatabaseStatus;

	public StartupView() {

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged ( Notification notification ) {
				
				lblLastLogin.setText(buildDate(SessionSourceProvider
						.USER.getLastUsed()));
				lblTimesUsed.setText("Times Used: " + 
						SessionSourceProvider.USER.getTimesUsed());
			}
		};
		SessionSourceProvider.USER.eAdapters().add(adapter);
		
		Adapter statusAdapter = new AdapterImpl() {
			public void notifyChanged ( Notification notification ) {
				checkSessionState();
			}
		};
		SessionSourceProvider.SESSION_STATUS.eAdapters().add(statusAdapter);
	}
	
	protected void checkSessionState() {

		System.out.println("--- New Session Status ---" );
		if ( SessionSourceProvider.SESSION_STATUS.isDbStatus() )
			lblDatabaseStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/hypersql_on.png"));
		else 
			lblDatabaseStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/hypersql_off.png"));
		
		if ( SessionSourceProvider.SESSION_STATUS.isMksStatus() )
			lblSynergyStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/mks_on.png"));
		else 
			lblSynergyStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/mks_off.png"));
		
		if ( SessionSourceProvider.SESSION_STATUS.getSynergySession() == null ||
				SessionSourceProvider.SESSION_STATUS.getSynergySession().length() < 9) {
			lblSynergyStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/sgy_off.png"));
		} else 
			lblSynergyStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/sgy_on.png"));
	
	}

	/**
	 * Save selection! 
	 * TODO: http://blog.eclipse-tips.com/2009/08/remember-state.html
	 */
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite compInfo = new Composite(composite, SWT.LEFT);
		
		lblLastLogin = new Label(compInfo, SWT.NONE);
		lblLastLogin.setBounds(10, 10, 304, 15);
		lblLastLogin.setText( buildDate(SessionSourceProvider
				.USER.getLastUsed()) );
		
		lblTimesUsed = new Label(compInfo, SWT.NONE);
		lblTimesUsed.setBounds(10, 31, 304, 15);
		lblTimesUsed.setText("Times Used: " + SessionSourceProvider
				.USER.getTimesUsed() );
		
		Label label = new Label(compInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 52, 304, 2);
		
		Composite compError = new Composite(composite, SWT.LEFT);
		compError.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		Composite compStatus = new Composite(composite, SWT.BOTTOM |SWT.LEFT);
		compStatus.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		compStatus.setLayout(new GridLayout(3, false));
		
		lblMksStatus = new Label(compStatus, SWT.NONE);
		lblMksStatus.setToolTipText("MKS Session Status");
		lblMksStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/mks_off.png"));
		
		lblSynergyStatus = new Label(compStatus, SWT.NONE);
		lblSynergyStatus.setToolTipText("Synergy Session Status");
		lblSynergyStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/sgy_off.png"));
		
		lblDatabaseStatus = new Label(compStatus, SWT.NONE);
		lblDatabaseStatus.setToolTipText("Database Session Status");
		lblDatabaseStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/status/hypersql_off.png"));
		
			
		checkSessionState();
		createActions();
		
	}
	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	private String buildDate(Date date) {
		String lastLogin = "Last Login: ";
		SimpleDateFormat formater = new SimpleDateFormat("EEEE, dd. MMMM yyyy HH:mm");
		lastLogin = lastLogin + formater.format(date);
		
		return lastLogin;
	}
}
