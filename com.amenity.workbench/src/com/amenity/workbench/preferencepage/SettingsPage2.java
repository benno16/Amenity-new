package com.amenity.workbench.preferencepage;

import java.io.File;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amenity.workbench.Activator;
import com.amenity.workbench.supporter.WorkbenchConstants;

public class SettingsPage2 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private BooleanFieldEditor setDir;
	
	private FileFieldEditor sgyExe;
	private StringFieldEditor sgyProject;
	private DirectoryFieldEditor sgyFolder;
	private FileFieldEditor sgyIni;
	
	public SettingsPage2 () {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore ( Activator.getDefault().getPreferenceStore());
		setDescription ("Data Source");
	}
	@Override
	public void propertyChange ( PropertyChangeEvent event) {
		if ( event.getNewValue().toString() == "true" ) 
			setEnabled(true);
		else
			setEnabled(false);
		
	}
	
	private void setEnabled ( boolean isSet ) {
		sgyExe.setEnabled(isSet, getFieldEditorParent());
		sgyProject.setEnabled(true, getFieldEditorParent());
		sgyFolder.setEnabled(isSet, getFieldEditorParent());
		sgyIni.setEnabled(isSet, getFieldEditorParent());
	}
	
	@Override
	protected void createFieldEditors() {

		sgyProject = new StringFieldEditor (WorkbenchConstants.SGYPROJECT,
				"&Synergy Project:", getFieldEditorParent());
		addField (sgyProject);
		
		
		setDir = new BooleanFieldEditor (
				"SGYCHANGE", "&Change Default",
				1, getFieldEditorParent());
		addField ( setDir );
		
		// select synergy EXE 
		sgyExe = new FileFieldEditor  ( 
				WorkbenchConstants.SGYCCM_EXE, "&Synergy Client Executable", true, 
				getFieldEditorParent());

		String[] fileNames = {"*.exe","*.*"};
		sgyExe.setFileExtensions(fileNames);
		File sgyExeUrl = new File("M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\");
		sgyExe.setFilterPath(sgyExeUrl);
		
		addField ( sgyExe );
		
		// set synergy root directory
		sgyFolder = new DirectoryFieldEditor  ( 
				WorkbenchConstants.SGYCCM_DIR, "&Synergy Client Directory", 
				getFieldEditorParent());

		File sgyFolderURL = new File("M:\\pmtqtools\\Synergy71\\Synergy_client7105");
		sgyFolder.setFilterPath(sgyFolderURL);
		
		addField ( sgyFolder );
		
		
		sgyIni = new FileFieldEditor  ( 
				WorkbenchConstants.SGYINI_FILE, "&Synergy Client executable", true, 
				getFieldEditorParent());

		String[] iniNames = {"*.ini","*.*"};
		sgyIni.setFileExtensions(iniNames);
		File sgyIniUrl = new File(System.getenv("userprofile").replace('\\', '/'));
		sgyIni.setFilterPath(sgyIniUrl);
		
		addField ( sgyIni );
		
		

		if ( Activator.getDefault().getPreferenceStore().getBoolean("SGYCHANGE") ) {
			setEnabled(true);
		} else
			setEnabled(false);
	}

}
