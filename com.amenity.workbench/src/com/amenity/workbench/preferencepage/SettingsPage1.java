package com.amenity.workbench.preferencepage;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amenity.workbench.Activator;
import com.amenity.workbench.supporter.WorkbenchConstants;

public class SettingsPage1 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private BooleanFieldEditor setDir;
	
	private BooleanFieldEditor localDB;
	private DirectoryFieldEditor dbDir;
	private StringFieldEditor dbName;
	private StringFieldEditor dbPassword;
	private StringFieldEditor dbUsername;
	private StringFieldEditor dbDriver;
	private StringFieldEditor dbUrl;
	
	public SettingsPage1 () {
		super(GRID);
		setPreferenceStore ( Activator.getDefault().getPreferenceStore());
		setDescription ("Database Settings");
	}
	
	@Override
	public void init(IWorkbench workbench) {}
	
	@Override
	public void propertyChange ( PropertyChangeEvent event) {
		if ( event.getNewValue().toString() == "true" ) {
			setEnabled(true);
		} else
			setEnabled(false);
		
	}
	
	private void setEnabled ( boolean isSet ) {
		localDB.setEnabled(isSet, getFieldEditorParent());
		dbDir.setEnabled(isSet, getFieldEditorParent());
		dbName.setEnabled(isSet, getFieldEditorParent());
		dbPassword.setEnabled(isSet, getFieldEditorParent());
		dbDriver.setEnabled(isSet, getFieldEditorParent());
		dbUsername.setEnabled(isSet, getFieldEditorParent());
		dbUrl.setEnabled(isSet, getFieldEditorParent());
	}
	
	@Override
	protected void createFieldEditors() {
		setDir = new BooleanFieldEditor (
				"DBCHANGE", "&Change Default",
				1, getFieldEditorParent());
		addField ( setDir );
		
		// HSQLDB Settings go here
		localDB =  new BooleanFieldEditor (
				WorkbenchConstants.DBISLOCALDB, "&Is local DB server",
				1, getFieldEditorParent());
		addField (localDB);
		
		dbDir = new DirectoryFieldEditor ( 
				WorkbenchConstants.DBFOLDER, "&Database Folder:", 
				getFieldEditorParent());
		addField (dbDir);
		
		dbName = new StringFieldEditor (WorkbenchConstants.DBDBNAME,
				"&Database Name:", getFieldEditorParent());
		addField (dbName);
		
		
		// Hibernate settings
		dbUsername = new StringFieldEditor (WorkbenchConstants.DBUSERNAME,
				"&Username:", getFieldEditorParent());
		addField (dbUsername);
		
		dbPassword = new StringFieldEditor (WorkbenchConstants.DBPASSWORD,
				"&Password:", getFieldEditorParent());
		addField (dbPassword);
		
		dbDriver = new StringFieldEditor (WorkbenchConstants.DBDRIVER,
				"&Driver:", getFieldEditorParent());
		addField (dbDriver);
		
		dbUrl = new StringFieldEditor (WorkbenchConstants.DBURL,
				"&Connection URL:", getFieldEditorParent());
		addField (dbUrl);

		if ( Activator.getDefault().getPreferenceStore().getBoolean("DBCHANGE") ) {
			setEnabled(true);
		} else
			setEnabled(false);
	}
	
	
	@SuppressWarnings("unused")
	private void initializeValues() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(WorkbenchConstants.DBDBNAME, "amenity" );
		store.setDefault(WorkbenchConstants.DBDRIVER, "org.hsqldb.jdbcDriver" );
		store.setDefault(WorkbenchConstants.DBFOLDER, System.getenv("userprofile")
				.replace('\\', '/') + "/temp/database" );
		store.setDefault(WorkbenchConstants.DBISLOCALDB, true );
		store.setDefault(WorkbenchConstants.DBPASSWORD, "" );
		store.setDefault(WorkbenchConstants.DBURL, "jdbc:hsqldb:hsql://localhost/amenity" );
		store.setDefault(WorkbenchConstants.DBUSERNAME, "sa" ); //$NON-NLS-1$
	}

}
