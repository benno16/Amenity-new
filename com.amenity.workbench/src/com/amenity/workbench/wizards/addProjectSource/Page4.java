package com.amenity.workbench.wizards.addProjectSource;

import general.Connection;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;

public class Page4 extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public Page4(Connection connection) {
		super("wizardPage");
		setTitle("Wizard Sumary");
		setDescription("Please review your settings and finish");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 100, 15);
		lblNewLabel.setText("Review settings");
		
		TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setBounds(10, 31, 554, 241);
		
	}
}
