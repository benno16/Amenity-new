package com.amenity.workbench.wizards.addProjectSource;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class NewDataSoure extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProjectWizard wizard = new ProjectWizard();
		WizardDialog dialog = new WizardDialog ( HandlerUtil.getActiveShell(event), wizard);
		dialog.open();
		return true;
	}


}
