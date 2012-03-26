package com.amenity.engine.helper.status;

import java.io.File;

import dao.DaoFactory;
import dao.GeneralQueries;

public class SessionStatus {

	public long getDatabaseFileSize() {
		String rootDir = System.getenv("userprofile");
		rootDir = rootDir.replace('\\', '/');
		rootDir = "file:" + rootDir + "/temp/database/amenity.script";
		
		File file = new File ( rootDir );
		if ( !file.exists() || !file.isFile() )
			return -1;
		return file.length();
	}
	
	public boolean isDatabaseAlive() {
		GeneralQueries generalQueries = DaoFactory.eINSTANCE.createGeneralQueries();
		return generalQueries.dbAlive();
	}
}
