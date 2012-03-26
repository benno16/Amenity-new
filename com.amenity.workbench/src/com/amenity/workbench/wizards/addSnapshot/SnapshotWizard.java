package com.amenity.workbench.wizards.addSnapshot;

import general.GeneralFactory;
import general.Snapshot;

import org.eclipse.jface.wizard.Wizard;

public class SnapshotWizard extends Wizard {

	Page1 one;
	Snapshot snapshot;
	
	public SnapshotWizard() {
		setWindowTitle("New Snapshot");
		snapshot = GeneralFactory.eINSTANCE.createSnapshot();
		one = new Page1();
	}

	@Override
	public void addPages() {
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
