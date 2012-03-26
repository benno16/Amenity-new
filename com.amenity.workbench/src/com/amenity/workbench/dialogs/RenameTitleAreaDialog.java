package com.amenity.workbench.dialogs;

import general.Container;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RenameTitleAreaDialog extends TitleAreaDialog {
	private Text text;
	private Container c;
	private Label lblCurrent;
	private boolean exists;
	private java.util.List<Container> containers;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public RenameTitleAreaDialog(Shell parentShell, Container itemToModify, java.util.List<Container> containers) {
		super(parentShell);
		this.c = itemToModify;
		this.containers = containers;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(null);
		setTitle("Rename Dialog");
		lblCurrent = new Label(container, SWT.NONE);
		lblCurrent.setBounds(10, 13, 100, 15);
		lblCurrent.setText("New Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 10, 200, 21);
		text.setText(c.getName());
		text.setToolTipText("Enter the new name here");
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (text.getText().length() > 0 ) {
					exists = false;
					for ( Container c : containers) {
						if ( c.getName().equals(text.getText()) ) {
							exists = true;
							lblCurrent.setToolTipText("Container does already exist");
							setErrorMessage("Duplicate Entry! \nPlease chose a different one!");
						} 
					}
					if ( !exists ) {
						lblCurrent.setToolTipText("");
						setErrorMessage(null);
					}
					
				} 
			}
		});

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      super.setHelpAvailable(false);
	      shell.setText("Rename... ");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(330, 192);
	}


	protected void buttonPressed ( int buttonId ) {
		if ( buttonId == 0 ) {
			if ( !exists ) 
				c.setName(text.getText());
			super.buttonPressed(buttonId);
		} else { //cancel and stuff
			super.buttonPressed(buttonId);
		}
	}
}
