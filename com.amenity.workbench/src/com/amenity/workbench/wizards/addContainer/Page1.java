package com.amenity.workbench.wizards.addContainer;

import general.Container;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.wb.swt.ResourceManager;

public class Page1 extends WizardPage {
	
	private Text txtContainerName;
	private Text txtDescription;
	private Composite container;
	
	public String getTxtContainerName() {
		return txtContainerName.getText();
	}

	public String getTxtDescription() {
		return txtDescription.getText();
	}

	/**
	 * Create the wizard.
	 */
	public Page1() {
		super("Create a new Project Container");
		setTitle("Enter Details");
		setMessage("Fill in the details for your new project container", INFORMATION);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		final Label lblContainerName = new Label(container, SWT.NONE);
		lblContainerName.setBounds(32, 10, 78, 15);
		lblContainerName.setText("Container Name");
		txtContainerName = new Text(container, SWT.BORDER);
		txtContainerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtContainerName.getText().length() > 0 ) {
					setPageComplete ( true );
					boolean exists = false;
					for ( Container c : SessionSourceProvider.CONTAINER_LIST) {
						if ( c.getName().equals(txtContainerName.getText()) ) {
							exists = true;
							setPageComplete(false);
							lblContainerName.setToolTipText("Container already exists");
							setMessage("Container already exists", ERROR);
							break;
						} else {
							setMessage("Fill in the details for your new project container", INFORMATION);
						}
					}
					if ( !exists ) {
						lblContainerName.setToolTipText("");
						
					}
					
				} else {
					setPageComplete ( false );
				}
			}
		});
		txtContainerName.setBounds(116, 10, 448, 21);
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setBounds(32, 40, 78, 15);
		lblDescription.setText("Description");
		
		txtDescription = new Text(container, SWT.BORDER);
		txtDescription.setBounds(116, 37, 448, 21);
		
		setControl ( container );
		
		Label lblImg = new Label(container, SWT.NONE);
		lblImg.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/drive-harddisk.png"));
		lblImg.setBounds(10, 10, 16, 16);
		
		Label label = new Label(container, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/comment.png"));
		label.setBounds(10, 39, 16, 16);
		setPageComplete ( false );
	}
}
