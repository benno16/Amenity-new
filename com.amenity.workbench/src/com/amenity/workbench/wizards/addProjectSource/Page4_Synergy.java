package com.amenity.workbench.wizards.addProjectSource;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class Page4_Synergy extends WizardPage {
	/**
	 * Create the wizard.
	 */
	public Page4_Synergy() {
		super("wizardPage");
		setTitle("Synergy Data Source Profile");
		setDescription("Please connect to Synergy");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
	}
}
