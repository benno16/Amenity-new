package com.amenity.workbench;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.amenity.workbench.supporter.WorkbenchConstants;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	public String getInitialWindowPerspectiveId() {
		return WorkbenchConstants.STARTUP_PERSPECTIVE_ID;
	}

	public void preWindowOpen() {
		IPreferenceStore prefStore = PlatformUI.getPreferenceStore();
		prefStore.setValue(IWorkbenchPreferenceConstants.ENABLE_ANIMATIONS, true);
	}
	
	
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);

		/*
		 * TODO: enable once view is finished
		 */
//		configurer.setSaveAndRestore(true);
	}

}
