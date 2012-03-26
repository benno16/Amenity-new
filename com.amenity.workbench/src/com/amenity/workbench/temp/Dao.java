package com.amenity.workbench.temp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.amenity.workbench.SessionSourceProvider;

public class Dao extends AbstractHandler {
	
	public Dao() {
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System.out.println("start logging");
		Logger log = LogManager.getLogger(Dao.class);
		
//		Event e = GeneralFactory.eINSTANCE.createEvent();
//		e.setDate(new Date());
//		e.setMessage("test Event");
//		e.setType("ERROR");
//		e.setUser(SessionSourceProvider.USER);
//		e.setUserRelevant(true);
//		GenericDao gd = DaoFactory.eINSTANCE.createGenericDao();
//		gd.create(e);
		
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		
		log.info("info log#1");
		log.error("error log#0");
		log.warn("warn log#1");
		log.fatal("fatal log#1");
		
		System.out.println("end logging");
		
		return null;
	}

}
