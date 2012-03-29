package com.amenity.workbench.dialogs;

import general.GeneralPackage;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;

public class ModifyContainerDialog extends Dialog {
	private Text text;
	private Text text_1;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ModifyContainerDialog(Shell parentShell) {
		super(parentShell);
//		parentShell.setText("Modify Container Name");
	}

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Modify Container Name");
	}


	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(124, 10, 200, 21);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(124, 37, 200, 21);
		
		DataBindingContext bindingContext = new DataBindingContext();

		bindingContext.bindValue(org.eclipse.jface.databinding.swt.WidgetProperties.text(SWT.Modify).observe(text), 
				EMFProperties.value(GeneralPackage.Literals.CONTAINER__NAME).observe(SessionSourceProvider.CURRENT_CONTAINER));
		
		Label lblContainerName = new Label(container, SWT.NONE);
		lblContainerName.setBounds(10, 13, 108, 13);
		lblContainerName.setText("Container Name");
		
		Label lblContainerDescription = new Label(container, SWT.NONE);
		lblContainerDescription.setBounds(10, 40, 108, 13);
		lblContainerDescription.setText("Container Description");
				
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		button.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/document-save.png"));
		button.setText("Save");
		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		button_1.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(336, 152);
	}
}
