package com.amenity.workbench.wizards.addContainer;

import java.util.Date;

import general.Container;
import general.GeneralFactory;
import general.GeneralPackage;
import general.User;

import org.eclipse.jface.wizard.Wizard;

import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.DaoFactory;
import dao.UserDao;

public class ContainerWizard extends Wizard {

	private Page1 one;
	
	
	public ContainerWizard() {
		setWindowTitle("New Project Container");
	}

	@Override
	public void addPages() {
		one = new Page1();
		addPage ( one );
	}

	@Override
	public boolean performFinish() {
		Container container = GeneralFactory.eINSTANCE.createContainer();
		container.eSet(GeneralPackage.Literals.CONTAINER__NAME, one.getTxtContainerName());
		container.setName(one.getTxtContainerName());
		container.setAddInfo1(one.getTxtDescription());
		container.setCreated(new Date());
		container.setOwnerId(SessionSourceProvider.USERID);
		
		// update hibernate user object
		UserDao uDao = DaoFactory.eINSTANCE.createUserDao();
		SessionSourceProvider.USER = (User) uDao.getById(SessionSourceProvider.USERID);
		
		container.setOwner(SessionSourceProvider.USER);
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		containerDao.create(container);
		SessionSourceProvider.CONTAINER_LIST.add(container);
		SessionSourceProvider.CURRENT_CONTAINER = container;
		return true;
	}

}
