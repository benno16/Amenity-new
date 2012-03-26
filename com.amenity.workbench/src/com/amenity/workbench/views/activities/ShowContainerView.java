package com.amenity.workbench.views.activities;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ShowContainerView extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbenchActivitySupport activitySupport = HandlerUtil
//				.getActiveWorkbenchWindow(event).getWorkbench()
//				.getActivitySupport();
//		IActivityManager activityManager = activitySupport.getActivityManager();
//		Set<String> enabledActivities = new HashSet<String>();
//		String id = "com.amenity.rcp.ui.views.ContainerView";
//		if (activityManager.getActivity(id).isDefined()) {
//			enabledActivities.add(id);
//		}
//		activitySupport.setEnabledActivityIds(enabledActivities);
//		HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().resetPerspective();
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().showView("com.amenity.workbench.views.ContainerView");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
