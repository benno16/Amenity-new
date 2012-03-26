package com.amenity.workbench;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class StartupPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		
		layout.setEditorAreaVisible(false);

		layout.setFixed(true);
		
	}

}
