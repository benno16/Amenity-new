package com.amenity.workbench.wizards.addSnapshot;

import general.GeneralFactory;
import general.Snapshot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.wizard.Wizard;

import com.amenity.workbench.SessionSourceProvider;

public class SnapshotWizard extends Wizard {

	Page1 one;
	Snapshot snapshot;
	Logger log;
	
	public SnapshotWizard() {
		setWindowTitle("New Snapshot");
		snapshot = GeneralFactory.eINSTANCE.createSnapshot();
		log = LogManager.getLogger(SnapshotWizard.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
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
