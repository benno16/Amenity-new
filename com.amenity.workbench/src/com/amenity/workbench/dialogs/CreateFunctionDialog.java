package com.amenity.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.amenity.workbench.views.AssignFunctionsView;

public class CreateFunctionDialog extends Dialog {
	Text text;
	String newFn;
	private String snapshotName;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CreateFunctionDialog(Shell parentShell, String newFn, String snapshotName) {
		super(parentShell);
		
		this.newFn = newFn;
		this.snapshotName = snapshotName;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		Label lblSnapshot = new Label(container, SWT.NONE);
		lblSnapshot.setBounds(10, 10, 100, 15);
		lblSnapshot.setText("Snapshot");
		
		Label lblSnaphostId = new Label(container, SWT.NONE);
		lblSnaphostId.setBounds(116, 10, 318, 15);
		lblSnaphostId.setText(snapshotName);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 31, 318, 21);
		
		Label lblFunctionName = new Label(container, SWT.NONE);
		lblFunctionName.setBounds(10, 34, 100, 15);
		lblFunctionName.setText("Function Name");
		
		Label lblEnterTheFunction = new Label(container, SWT.NONE);
		lblEnterTheFunction.setBounds(229, 58, 205, 15);
		lblEnterTheFunction.setText("Enter the function name and press OK");

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
		return new Point(450, 186);
	}
	
	@Override
	protected void okPressed()  {
		newFn = text.getText();
		AssignFunctionsView.newFn = text.getText();
		super.okPressed();
	}
}
