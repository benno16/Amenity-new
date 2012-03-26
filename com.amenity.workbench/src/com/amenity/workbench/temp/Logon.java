package com.amenity.workbench.temp;

import general.GeneralFactory;
import general.User;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import com.amenity.workbench.SessionSourceProvider;

import dao.DaoFactory;
import dao.UserDao;

public class Logon extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		
		ISourceProviderService service = 
				(ISourceProviderService) 
				window.getService(ISourceProviderService.class);
		SessionSourceProvider sessionSourceProvider = (SessionSourceProvider)
				service.getSourceProvider(SessionSourceProvider.SESSION_STATE);

		User tempUser = GeneralFactory.eINSTANCE.createUser();
		tempUser.setUsername(System.getenv("username"));
		UserDao userDao = DaoFactory.eINSTANCE.createUserDao();
		tempUser = userDao.findByUsername(tempUser);

		sessionSourceProvider.setLoggedIn(true);
		SessionSourceProvider.USERID = tempUser.getUserId();
		return null;
	}

}
