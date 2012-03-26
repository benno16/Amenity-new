package com.amenity.workbench.views.sidebar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.layout.GridData;

public class ManageContainer extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public ManageContainer(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(3, false));
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setText("New Button");
		
		Tree tree = new Tree(this, SWT.BORDER);
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_tree.widthHint = 437;
		tree.setLayoutData(gd_tree);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
