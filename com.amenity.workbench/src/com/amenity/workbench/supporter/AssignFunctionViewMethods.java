package com.amenity.workbench.supporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import general.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.hibernate.Session;

import com.amenity.engine.helper.compare.CompareViewObject;
import com.amenity.engine.helper.compare.SnapshotComparator;
import com.amenity.engine.helper.mks.MksGetFile;
import com.amenity.engine.helper.synergy.SynergyGetFile;
import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.FunctionDao;
import dao.GenericDao;
import dao.SnapshotDao;


public class AssignFunctionViewMethods {

	private Logger log;
	private static AssignFunctionViewMethods instance; // 
	
	/*
	 *  singleton, because the view can be opened multiple times
	 */
	private AssignFunctionViewMethods (){
		log = LogManager.getLogger(AssignFunctionViewMethods.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		log.info("Assign Function View Methods Instantiated");
	}
	
	public static synchronized AssignFunctionViewMethods getInstance() {
		if ( instance == null ) 
			instance = new AssignFunctionViewMethods();
        return instance;
    }
	
	/*
	 * File Function Status Methods
	 */
	public List<FileFunctionStatus> deleteFileFunctionStatus ( FileFunctionStatus ffs, List<FileFunctionStatus> ffss ) {
		
		FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		
		try {
			ffsDao.delete(ffs);
			ffss.remove(ffs);
			
			logInfo("item was deleted" , true );
			
		} catch ( Exception ex ) {

			logInfo("item could not be deleted" , true );
		}
		
		return ffss;
	}
	
	public FileFunctionStatus createUpdateFFS ( FileFunctionStatus ffs ) {

		FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		try {
			ffsDao.update(ffs);
			logInfo("item was added" , true);
		} catch ( Exception ex ) {
			logError("item could not be added", true);
		}
		return ffs;
	}
	
	@SuppressWarnings("unchecked")
	public List<Snapshot> getSnapshots ( Container container ) {
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		
		return snapshotDao.getListByContainer
				(SessionSourceProvider.CURRENT_CONTAINER);
	}
	
	@SuppressWarnings("unchecked")
	public List<Function> getFunctions ( Snapshot snapshot ) {
		FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
		
		return functionDao.getFunctionsBySnapshot(snapshot);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getContentObjects ( Snapshot snapshot ) {
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
		
		return coDao.getListBySnapshot( snapshot );
	}
	
	public List<ContentObject> getContentObjectsFunctions ( List<ContentObject> inboundContentObjects) {
		List<ContentObject> outboundContentObjects = new ArrayList<ContentObject>();
		
		for ( int i = 0 ; i < inboundContentObjects.size() ; i++ ) {
			// load the corresponding information!
			if ( inboundContentObjects.get(i).getFunction().size() > 0 )
				outboundContentObjects.add(inboundContentObjects.get(i));
		}
		
		return outboundContentObjects;
	}
	
	public Folder getRootFolder ( List<ContentObject> contentObjects ) {
		
		for ( int i = 0 ; i < contentObjects.size() ; i++ ) {
			
			if ( contentObjects.get(i) instanceof Folder ) {
				
				if ( ((Folder)contentObjects.get(i)).getRootDirectory() == null  ) {
					
					return (Folder)contentObjects.get(i);
					
				}
				
			}
			
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<FileFunctionStatus> getFileFunctionStatus ( Function function ) {
		FileFunctionStatusDao ffsDao = 
				DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		
		return ffsDao.getFileFunctionStatusByFunction(function);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getContentObjectsWithFunction ( Function function ) {
		
		List<ContentObject> contentObjects; // = new ArrayList<ContentObject>();
		List<ContentObject> contentObjectsWithFunction = new ArrayList<ContentObject>();
		GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
		Session session = gDao.getSession();
		session.beginTransaction();
		

//		select * from 
//			( "contentobject" co inner join "contentobject_function" cf 
//				on co."objectid" = cf."contentobject_objectid") 
//				inner join "function" f 
//				on f."functionid" = cf."function_functionid"
//				where f."functionid" = 'bf46dd71-4f87-4d9b-8e96-4a5b97a9f024'
		
//		contentObjectsWithFunction = (List<ContentObject>) session.createSQLQuery("select * from ( \"contentobject\" co inner join \"contentobject_function\" cf " +
//				"on co.\"objectid\" = cf.\"contentobject_objectid\" ) " +
//				"inner join \"function\" f " +
//				"on f.\"functionid\" = cf.\"function_functionid\" " + 
//				"where f.\"functionid\" = '" + SessionSourceProvider.CURRENT_FUNCTION.getFunctionId() + "'" ).list();
		
		contentObjects = (List<ContentObject>) session.createQuery(
				"from ContentObject contentobject where contentobject.partOf = :s")
				.setParameter("s", SessionSourceProvider.CURRENT_SNAPSHOT)
				.list();

		for ( ContentObject co : contentObjects ) {
			if ( co.getFunction() != null && co.getFunction().size() > 0 ) {
				for ( Function f : co.getFunction() ) {
					if ( f != null && f.getFunctionId().equals(function.getFunctionId())) 
						contentObjectsWithFunction.add(co);
				}
			}
		}
		
		session.close();
		return contentObjectsWithFunction;
	}
	
	public List<ContentObject> getContentObjectsWithFunction ( 
			List<ContentObject> FullcontentObjectsWithFunction ) {
		
		List<ContentObject> contentObjectsWithFunction = new ArrayList<ContentObject>();
		GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
		Session session = gDao.getSession();
		session.beginTransaction();
		
		if ( SessionSourceProvider.CURRENT_FUNCTION != null ) { 
			for ( ContentObject co : FullcontentObjectsWithFunction ) {
				co = getContentObject(session, co);
				// if the function list is not empty search through it and add
				if ( co.getFunction() != null || co.getFunction().size() > 0 ) {
					
					for ( Function f : co.getFunction() ) {
						if ( f.getFunctionId().equals(
								SessionSourceProvider.CURRENT_FUNCTION.getFunctionId())) {
							
							contentObjectsWithFunction.add(co);
							break;
					
						}
	
					}
				
				}
		
			}
		
		}
		session.close();
		return contentObjectsWithFunction;
	}
	
	public Function addFunction ( Function function ) {
		
		FunctionDao fDao = DaoFactory.eINSTANCE.createFunctionDao();
		
		fDao.update(function);
		
		function = (Function) fDao.getById(function.getFunctionId());
		
		return function;
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getFolderChildren ( Folder folder, Snapshot snapshot ) {
		
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
		
		System.out.println("get children");
		return coDao.getChildren(folder, snapshot);
	}
	
	public List<ContentObject> addFunctionToContentObject ( List<ContentObject> contentObjects, Function function, ContentObject co ) {
		
		List<ContentObject> newObjects = new ArrayList<ContentObject>();
		// for every inbound object find match and add
		for ( int i = 0 ; i < contentObjects.size() ; i++ ) {
			if ( contentObjects.get(i).getObjectId().equals(co.getObjectId() ) ) {
				boolean functionAlreadyInPlace = false;
				for ( Function f : contentObjects.get(i).getFunction() ) {
					
					if ( f.getFunctionId().equals(function.getFunctionId() )) 
						
						functionAlreadyInPlace = true;
					
				}
				if ( !functionAlreadyInPlace ) 
					contentObjects.get(i).getFunction().add(function);
				break;
			}
		}
		
		
		return newObjects;
	}
	
	@SuppressWarnings("unchecked")
	public List<Container> getContainerList ( User user ) {
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		
		return containerDao.getListByOwner(Container.class, user);
	}
	
	public void saveFunctionAssignment ( List<ContentObject> contentObjects, 
			String name, Function function ) {
		if ( contentObjects != null && contentObjects.size() > 0) {
			GenericDao genDao = DaoFactory.eINSTANCE.createGenericDao();

			SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
			sDao.getById(contentObjects.get(0).getPartOf().getSnapshotId());

			Session s = (Session) genDao.getSession();
			
			s.beginTransaction();
			
			function = (Function) s.createQuery( "from " + Function.class.getName().toString()
					+ " where functionId = '" + 
					function.getFunctionId() + "'" ).list().get(0);
			
			
			for ( ContentObject co : contentObjects ) {
				
				co = (ContentObject) s.createQuery("from " + ContentObject.class.getName().toString() + 
						" where objectId = '" + co.getObjectId() + "'").list().get(0);
				boolean set = false;
				for ( Function f: co.getFunction()) {
					if (f.getFunctionId().equals(function.getFunctionId())) {
						set = true;
						break;
					}
				}
				if (!set) {

					co.getFunction().add(function);
					s.update(co);
				}
				
			}
			
			if ( !function.getName().equals(name) ) {

				function.setName(name);
				s.update(function);
				
			}
			
			s.getTransaction().commit();
			s.close();
		}
		
	}
	
	// creates new functions from old snapshot
	@SuppressWarnings("unchecked")
	public List<Function> copyFunctionInfo ( Snapshot oldSnapshot, Snapshot newSnapshot ) {
		
		List<Function> oldFunctions = new ArrayList<Function>();
		List<Function> newFunctions = new ArrayList<Function>();
		
		
		
		FunctionDao fDao = DaoFactory.eINSTANCE.createFunctionDao();
		oldFunctions = fDao.getFunctionsBySnapshot(oldSnapshot);
		
		Function tempFunction = null;
		
		for ( Function fn : oldFunctions ) {
			
			tempFunction = GeneralFactory.eINSTANCE.createFunction();
			tempFunction.setCreated(fn.getCreated());
			tempFunction.setModified(new Date());
			tempFunction.setName(fn.getName());
			tempFunction.setOverallStatus(fn.getOverallStatus());
			tempFunction.setSnapshot(newSnapshot);
			newFunctions.add(tempFunction);
			
		}
		
		for ( Function fn : newFunctions) {
			fDao.create(fn);
		}
		
		// to ensure previously created functions are copied as well
		return fDao.getFunctionsBySnapshot( newSnapshot );
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getContentObjectWithFunctionAssigned ( Snapshot oldSnapshot, 
			Snapshot newSnapshot, List<Function> functions ) {
		
		GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
		
		Folder rootDir = null;
		boolean foundRoot = false;
		
		List<FileFunctionStatus> fileFunctionStatusList = new ArrayList<FileFunctionStatus>();
		
		String query1 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + newSnapshot.getSnapshotId() + "'";

		String query2 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + oldSnapshot.getSnapshotId() + "'";
		
		// CO1 = new <> CO2 = old
		SnapshotComparator compare = new SnapshotComparator( (List<ContentObject>) gDao.getByQuery(query1), 
	    		(List<ContentObject>) gDao.getByQuery(query2));
	    
		// now I have the list containing both snapshot's file and folder objects
		List<CompareViewObject> compareViewObjects = compare.createCompareViewObjects();
	    
	    Session session = gDao.getSession();
	    session.beginTransaction();
	    
	    List<ContentObject> returnObjects = new ArrayList<ContentObject>();
	    List<ContentObject> returnObjectsWithFunction = new ArrayList<ContentObject>();
	    
	    // persit objects
	    oldSnapshot = (Snapshot) session.createQuery("from " + 
	    		Snapshot.class.getName().toString() + 
	    		" where snapshotId='" + oldSnapshot.getSnapshotId() + 
	    		"'").list().get(0);
	    
	    newSnapshot = (Snapshot) session.createQuery("from " + 
	    		Snapshot.class.getName().toString() + 
	    		" where snapshotId='" + newSnapshot.getSnapshotId() + 
	    		"'").list().get(0);
	    
	    for ( CompareViewObject cvo : compareViewObjects ) {
	    	
	    	// first check if the file exists in both snapshots
	    	if ( cvo.getFile2() != null && cvo.getFile1() != null) {
	    		// Its a file object
	    		
    			// detach old objects with clear
    			session.clear();
    			// put object to persistent state
    			cvo.setFile1((File) getContentObject ( session, cvo.getFile1() ) );
    			cvo.setFile2((File) getContentObject ( session, cvo.getFile2() ) );

				// check if there are functions
    			if ( cvo.getFile2().getFunction() != null && 
    					cvo.getFile2().getFunction().size() > 0 ) {
    				
    				/*
    				 * Two things happen here:
    				 * 1. the file is added to the newly created function
    				 * 2. the file function status is copied across (if exists)
    				 */
    				for ( Function f : cvo.getFile2().getFunction() ) {
    					// add functions
    					f = getMatchingFunction ( f, functions );
	    				cvo.getFile1().getFunction().add(f);
    				}
    				/*
    				 * TODO: File Function association. This just applies for file objects
    				 * 
    				 */
    				session.clear();
    				List<FileFunctionStatus> ffss = new ArrayList<FileFunctionStatus>();
    				ffss = session.createQuery("from " + FileFunctionStatus.class.getName().toString() +
    						" where ofFile='" + cvo.getFile2().getObjectId() +"'").list();

    				if ( ffss != null && ffss.size() > 0 ) {
    					System.out.println("Do i get here? " + ffss.size() );
    					for ( FileFunctionStatus ffs : ffss ) {
    						FileFunctionStatus newFFS = GeneralFactory.eINSTANCE.createFileFunctionStatus();
    						
    						newFFS.setComment(ffs.getComment());
    						newFFS.setConfigurationManagement(ffs.getConfigurationManagement());
    						newFFS.setOfFile(cvo.getFile1());
    						newFFS.setOfFunction( getMatchingFunction ( ffs.getOfFunction(), functions ) );
    						newFFS.setRating(ffs.getRating());
    						newFFS.setRequired(ffs.isRequired());
    						newFFS.setReviewed(ffs.getReviewed());
    						newFFS.setSetOn(ffs.getSetOn());
    						newFFS.setType(ffs.getType());
    						newFFS.setUpToDate(ffs.getUpToDate());
//    						session.clear();
    						fileFunctionStatusList.add(newFFS);
//    						session.saveOrUpdate(newFFS);
//    						session.getTransaction().commit();
    					}
    				}
    				
    				returnObjectsWithFunction.add(cvo.getFile1());
    				
//	    			session.saveOrUpdate(cvo.getFile1());
	    			
    			}
	    		
	    	} else if ( !foundRoot && cvo.getFolder1() != null ) {
	    		// make first folder object without parent = root object
	    		
	    		if ( cvo.getFolder1().getRootDirectory() == null ) {
	    			
	    			rootDir = cvo.getFolder1();
	    			foundRoot = true;
	    			
	    		}
	    		
	    	} else if ( cvo.getFolder2() != null && cvo.getFolder1() != null) {
	    		// Its a folder object that existed already in previous snapshot
	    		
	    		// detach old objects with clear
	    		session.clear();
	    		// put object to persistent state
	    		cvo.setFolder1((Folder) getContentObject ( session, cvo.getFolder1() ) );
	    		cvo.setFolder2((Folder) getContentObject ( session, cvo.getFolder2() ) );
	    		
	    		if ( cvo.getFolder2().getFunction() != null && 
	    				cvo.getFolder2().getFunction().size() > 0 ) {
	    			// check if there are functions
	    			
	    			for ( Function f : cvo.getFolder2().getFunction() ) {
	    				// add functions
	    				f = getMatchingFunction ( f, functions );
	    				cvo.getFolder1().getFunction().add(f);
	    				
	    			}
    				returnObjectsWithFunction.add(cvo.getFolder1());
    				
//    				session.saveOrUpdate(cvo.getFolder1());
	    			
	    		}
	    		
	    	} else {
	    		/*
	    		 * TODO: dummy creation
	    		 * 
	    		 * Wrong Root Directory
	    		 */
	    		if ( cvo.getFile1() == null && cvo.getFile2() != null ) {
	    			
	    			cvo.setFile2( (File)getContentObject(session, cvo.getFile2()) );
	    			
	    			File dummyFile = GeneralFactory.eINSTANCE.createFile();
	    			dummyFile.setDummy(true);
	    			dummyFile.setFullName(cvo.getFile2().getFullName());
	    			dummyFile.setModfiedDate(new Date());
	    			dummyFile.setVersion("dummy");
	    			dummyFile.setStatus("dummy");
	    			dummyFile.setSuffix("-");
	    			dummyFile.setLevel(cvo.getFile2().getLevel());
	    			try { 
	    				dummyFile.setName(cvo.getFile2().getName() + " (fn: " + 
		    					( (cvo.getFile2().getFunction() != null) ? 
		    							 cvo.getFile2().getFunction().get(0).getName() : " - " ) + ")");
	    			} catch ( Exception exx) {
	    				dummyFile.setName(cvo.getFile2().getName());
	    			}
	    			dummyFile.setObjectName(cvo.getFile2().getObjectName());
	    			dummyFile.setPartOf(newSnapshot);
	    			dummyFile.setRootDir(rootDir);
	    			
	    			cvo.setFile2( (File) getContentObject(session,cvo.getFile2()));
	    			
	    			if ( cvo.getFile2().getFunction() != null && cvo.getFile2().getFunction().size() > 0 )
		    			dummyFile.getFunction().addAll(getNewFunctionForOld(cvo.getFile2()
		    					.getFunction(), functions));
	    			
	    			session.merge(dummyFile);
	    			returnObjects.add(dummyFile);
	    			
	    		}
	    		else if ( cvo.getFolder1() == null && cvo.getFolder2() != null ) {

	    			cvo.setFolder2( (Folder)getContentObject(session, cvo.getFolder2()) );
	    			
	    			Folder dummyFolder = GeneralFactory.eINSTANCE.createFolder();
	    			dummyFolder.setDummy(true);
	    			dummyFolder.setFullName(cvo.getFolder2().getFullName());
	    			dummyFolder.setLevel(cvo.getFolder2().getLevel());
	    			dummyFolder.setName(cvo.getFolder2().getName());
	    			dummyFolder.setPartOf(newSnapshot);
	    			dummyFolder.setRootDirectory(rootDir);

	    			cvo.setFolder2( (Folder) getContentObject(session,cvo.getFolder2()));
	    			
	    			if ( cvo.getFolder2().getFunction() != null && cvo.getFolder2().getFunction().size() > 0 )
	    					dummyFolder.getFunction().addAll(getNewFunctionForOld(cvo.getFolder2()
	    							.getFunction(), functions));
	    			
	    			session.merge(dummyFolder);
	    			
	    			returnObjects.add(dummyFolder);
	    		}
	    	}
	    	
	    	// now add the new and added content objects to return list
	    	if ( cvo.getFile1() != null ) {
	    		
	    		returnObjects.add(cvo.getFile1());
	    		
	    	} else if ( cvo.getFolder1() != null ) {
	    		
	    		returnObjects.add(cvo.getFolder1());
	    		
	    	}
	    	
	    }
	    
	    for ( ContentObject co : returnObjectsWithFunction ) {
	    	session.merge(co);
	    }

	    int i = 0;
	    
	    for ( FileFunctionStatus ffs : fileFunctionStatusList ) {
	    	System.err.println(">>> " + i++);
	    	session.merge(ffs);
	    }
	    
	    session.getTransaction().commit();
	    
	    
	    session.close();
	    
	    return returnObjects;
	    
	}
	
	private List<Function> getNewFunctionForOld(List<Function> fileFunctions, 
			List<Function> allFunctions ) {
		
		List<Function> returnFunctions = new ArrayList<Function>();
		
		for ( Function fOuter : fileFunctions ) {
			
			for ( Function fInner : allFunctions ) {
				
				if ( fInner.getName().equals(fOuter.getName() )) {
					
					returnFunctions.add(fOuter);
					
				}
				
			}
			
		}
		
		return returnFunctions;
	}

	private Function getMatchingFunction ( Function function, List<Function> functions ) {
		
		for ( Function f : functions ) {
			
			if (f.getName().equals(function.getName()) )
				
					return f;
			
		}
		
		return null;
		
	}
	
	public ContentObject getContentObject ( Session session, ContentObject co ) {
		return (ContentObject) session.createQuery("from " + 
				ContentObject.class.getName().toString() + 
				" where objectId = '" + co.getObjectId() + "'").list().get(0);
	}
	
	public void openFileFromCM ( File file ) {
		
		ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
		
		Connection connection = null;
		
		connection = (Connection) connectionDao.getByQuery("from " + 
				Connection.class.getName().toString() + 
				" where connectionId = '" + 
				SessionSourceProvider.CURRENT_SNAPSHOT.getVia().getConnectionId() + "'").get(0);
		
		if ( connection.getConnectionType() == ConnectionType.MKS ) {
			System.out.println("its a mks connection");
			MksGetFile mksGetFile = new MksGetFile(connection, file);
			try {
				mksGetFile.openFile();
			} catch (IOException e) {
				MessageDialog.openError(null, 
						"Error", 
						"Am error occured while opening the file");
			}
			
		} else if ( connection.getConnectionType() == ConnectionType.SYNERGY ){
			if ( SessionSourceProvider.SYNERGY_SID == null ) {
				SessionSourceProvider.SYNERGY_SID = new SynergyLogin().getSynergySessionId();
			}
			
			SynergyGetFile synergyGetFile = new SynergyGetFile
					( SessionSourceProvider.SYNERGY_SID );
			synergyGetFile.openFile(file);
		}
	}
	
	/*
	 * Event logging Functions
	 */
	private void logError(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.error(message);
	}
	
	@SuppressWarnings("unused")
	private void logFatal(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.fatal(message);
	}
	
	@SuppressWarnings("unused")
	private void logWarning(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.warn(message);
	}
	
	private void logInfo(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.info(message);
	}
	
	@SuppressWarnings("unused")
	private void logdeburg(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.debug(message);
	}
	
	/*
	 * End of Event logging Functions
	 */
}
