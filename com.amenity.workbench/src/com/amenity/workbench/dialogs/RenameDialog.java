package com.amenity.workbench.dialogs;

import general.Container;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class RenameDialog extends Dialog {
	private Text text;
	private Container c;
	private Label lblCurrent;
	private java.util.List<Container> containers;
	
	public Text getText() {
		return text;
	}

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public RenameDialog(Shell parentShell ) {
		super(parentShell);
	}

	public RenameDialog(Shell shell, Container itemToModify, java.util.List<Container> containers) {
		super(shell);
		this.c = itemToModify;
		this.containers = containers;
	}

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Rename... ");
	}
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
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
					boolean exists = false;
					for ( Container c : containers) {
						if ( c.getName().equals(text.getText()) ) {
							exists = true;
							lblCurrent.setToolTipText("Container does already exist");
						} 
					}
					if ( !exists ) {
						lblCurrent.setToolTipText("");
						
					}
					
				} 
			}
		});

		return container;
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

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(329, 118);
	}

	protected void buttonPressed ( int buttonId ) {
		if ( buttonId == 0 ) {
//			for ( Container container : containers ) {
//				if (container.getName().equals(text.getText())) {
//					
//				} else {
//					c.setName(text.getText());
//					super.buttonPressed(buttonId);
//				}
//					
//			}
			c.setName(text.getText());
			super.buttonPressed(buttonId);
		} else { //cancel and stuff
			super.buttonPressed(buttonId);
		}
	}
}
