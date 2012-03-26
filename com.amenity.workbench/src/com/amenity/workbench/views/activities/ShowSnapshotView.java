package com.amenity.workbench.views.activities;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

public class ShowSnapshotView extends AbstractHandler  {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//				.openPage("com.amenity.workbench.ShowSnapshotPerspective", null);
					.getActivePage().showView("com.amenity.workbench.views.SnapshotView");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
