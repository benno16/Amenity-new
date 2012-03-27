package com.amenity.workbench.wizards.addProjectSource;

import general.Connection;
import general.Container;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;

import dao.ContainerDao;
import dao.DaoFactory;
import org.eclipse.wb.swt.ResourceManager;

public class Page1 extends WizardPage {

	private Button btnIbmRationalSynergy;
	private Button btnMksIntegrity;
	private Combo combo;
	private List<Container> containers;
	private ContainerDao containerDao;
	
	public Container getSelectedContainer() {
		for ( Container c : containers ) {
			if (c.getName().equals(combo.getItem(combo.getSelectionIndex())) ) {
				return c;
			}
		}
		return null;
	}
	
	public boolean isItsMks() {
		if ( btnMksIntegrity.getSelection() ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Create the wizard.
	 */
	public Page1( Connection connection ) {
		super("wizardPage");
		setTitle("Select Data Source");
		setDescription("Please select the datasource you wish to use for your project");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	public void createControl(final Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		containerDao = DaoFactory.eINSTANCE.createContainerDao();
		containers = (List<Container>) containerDao.getListByOwner(Container.class, SessionSourceProvider.USER); 
		Label lblDataSource = new Label(container, SWT.NONE);
		lblDataSource.setBounds(32, 10, 78, 15);
		lblDataSource.setText("Data Source");
		
		btnMksIntegrity = new Button(container, SWT.RADIO);
		btnMksIntegrity.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnIbmRationalSynergy.setSelection(false);
				btnMksIntegrity.setSelection(true);
			}
		});
		btnMksIntegrity.setBounds(116, 10, 448, 16);
		btnMksIntegrity.setText("MKS Integrity");
		
		btnIbmRationalSynergy = new Button(container, SWT.RADIO);
		btnIbmRationalSynergy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnMksIntegrity.setSelection(false);
				btnIbmRationalSynergy.setSelection(true);
			}
		});
		btnIbmRationalSynergy.setSelection(true);
		btnIbmRationalSynergy.setBounds(116, 32, 448, 16);
		btnIbmRationalSynergy.setText("IBM Rational Synergy");

		combo = new Combo(container, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( combo.getSelection() != null ) {
					setPageComplete ( true );
				} else {
					// setErrorMessage("There is no stuff");
				}
			}
		});
		combo.setBounds(116, 62, 448, 23);
		if ( containers.size() < 1 ) {
			combo.setEnabled(false);
			
		} else {
			combo.setEnabled(true);
			for ( Container c : containers ) 
				combo.add(c.getName());
			combo.select(0);
		}
		
		Label lblContainer = new Label(container, SWT.NONE);
		lblContainer.setBounds(32, 65, 78, 15);
		lblContainer.setText("Container");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 54, 554, 2);
		setControl ( container );
		
		Button btnAddContainer = new Button(container, SWT.NONE);
		btnAddContainer.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		btnAddContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerWizard wizard = new ContainerWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard);
				if ( dialog.open() == Window.OK ) 
					rebuildCombo();
			}
		});
		btnAddContainer.setBounds(444, 91, 120, 25);
		btnAddContainer.setText("Add Container");
		
		Label lblImg = new Label(container, SWT.NONE);
		lblImg.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/drive-harddisk.png"));
		lblImg.setBounds(10, 65, 16, 16);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/server.png"));
		label_1.setBounds(10, 10, 16, 16);
		setPageComplete ( false );
	}
	
	
	private void rebuildCombo() {
		combo.removeAll();
		Collections.sort(containers, newAscStringComparator());
		for ( Container c : containers) {
			if ( c.getOwner().getUserId().equalsIgnoreCase(SessionSourceProvider.USERID) )
				combo.add(c.getName());
		}
		if ( combo.getItemCount() > 0 ) 
			combo.select(0);
	}
	
	protected static Comparator<Container> newAscStringComparator() {
	    return new Comparator<Container>() {
	    	@Override
	    	public int compare(Container first , Container second) {
	    		return String.valueOf(first.getName()).compareTo(String.valueOf(second.getName()));
	    	}
	    };
	}
	
}
