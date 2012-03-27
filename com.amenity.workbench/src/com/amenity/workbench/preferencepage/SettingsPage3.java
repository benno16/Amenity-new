package com.amenity.workbench.preferencepage;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amenity.workbench.Activator;
import com.amenity.workbench.supporter.WorkbenchConstants;

public class SettingsPage3 extends FieldEditorPreferencePage implements
IWorkbenchPreferencePage {

	private StringFieldEditor fileType, fileExtn;
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore ( Activator.getDefault().getPreferenceStore());
		setDescription ("File Type Settings");
	}

	@Override
	protected void createFieldEditors() {

		fileType = new StringFieldEditor (WorkbenchConstants.FILETYPE,
				"&File Names:", getFieldEditorParent());
		addField (fileType);
		
		fileExtn = new StringFieldEditor (WorkbenchConstants.FILEEXTN,
				"&File Extensions:", getFieldEditorParent());
		addField (fileExtn);
	}
	
}
