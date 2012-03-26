package com.amenity.engine.helper.synergy;

import general.Connection;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

import dao.DaoFactory;
import dao.FileDao;
import dao.FolderDao;

public class SynergyReader {

	private String sessionID;
	private Snapshot snapshot;
	private Connection connection;
	private List<Folder> folders;
	private List<File> files;
	private FolderDao folderDao;
	private FileDao fileDao;
//	private String ccmHomeFolder = "D:/temp/Synergy_client7103";
//	private String ccmEXEFolder = "D:/temp/Synergy_client7103/bin/ccm";

	private String ccmEXEFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_EXE" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm.exe" , null );
	
	private String ccmHomeFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_DIR" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105" , null );
	
	private String ccmIniFile = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYINI_FILE" , System.getenv("userprofile").replace('\\', '/') + "\\ccm71.ini" , null );
	
	@SuppressWarnings("unused")
	private SynergyReader() {
	}
	
	public SynergyReader ( String sessionID, Connection connection, Snapshot snapshot ) {
		this.sessionID = sessionID;
		this.connection = connection;
		this.snapshot = snapshot;
		folderDao = DaoFactory.eINSTANCE.createFolderDao();
		fileDao = DaoFactory.eINSTANCE.createFileDao();
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
	}
	
	public boolean getProjectFiles() {
		generateContentObject(connection.getDatabase(), connection.getDatabase(), null );
		if ( doPersist() )
			return true;
		else 
			return false;
	}
	private void generateContentObject( String directoryName, String projectName, Folder root ) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", 
					ccmEXEFolder,
					"query",
					"-u",
					"\"is_child_of('" + directoryName +"','" + projectName + "')\"",
					"-f",
					"\"%objectname#%type#%displayname#%modify_time#%version#%status#%release#%name\""
					);
			/*
			 * Resultset Information:
			 * %objectname#%type#%displayname#%modify_time#%version#%status#%release#%name
			 * 		0		1		2			3				4		5		6		7
			 * 
			 */
			Map<String, String> env = pb.environment();

			env.put("CCM_HOME", ccmHomeFolder);
			env.put("CCM_INI_FILE", ccmIniFile );
			env.put("CCM_ADDR", sessionID);
			env.put("PATH", "D:\\ts_mirr\\etoolset\\cw70d;" +
					"M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin;" +
					"M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\util;" +
					"M:\\pmtqtools\\ccmscripts1015;" +
					"M:\\pmtqtools\\ccmscripts1015\\perl\\bin;" +
					"M:\\pmtqtools\\ccmscripts1015\\cygwin\\bin;" +
					"C:\\Program Files\\Microsoft Office\\Office;" +
					"M:\\pmtqtools\\ts_ref\\STM_RiMC\\STMTS\\v8.5;%PATH%");

			Process pr = pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			// run through the resultset
//			if ( root == null ) {
//				Folder folder = GeneralFactory.eINSTANCE.createFolder();
//				folder.setLevel( 1 );
//				folder.setName("root");
//				folder.setModfiedDate(null);
//				folders.add(folder);
//				root = folder;
//			}
			while (( resultset = br.readLine()) != null ){

				// Create Folder Object
				String[] rsArray = resultset.split("#");
				
				String objectName = rsArray[0].toString().trim();
				String type = rsArray[1].toString().trim();
//				String displayName = rsArray[2].toString().trim();
				Date modifyTime = getFileDate(rsArray[3].toString().trim());
				String version = rsArray[4].toString().trim();
				String status = rsArray[5].toString().trim();
				String release = rsArray[6].toString().trim();
				String name = rsArray[7].toString().trim();
				
				
				if ( type.equalsIgnoreCase("dir") ) {
					// its a folder
					Folder folder = GeneralFactory.eINSTANCE.createFolder();
					folder.setLevel(( root == null ) ? 1 : root.getLevel()+1);
					folder.setName(name);
					folder.setVersion(version);
					folder.setModfiedDate(modifyTime);
					folder.setFullName(objectName);
					folder.setPartOf(snapshot);
					folder.setRootDirectory(root);
					folder.setRelease(release);
					
				    folders.add(folder);
				    
				    generateContentObject(folder.getFullName(), projectName, folder);
				} else { 
					// its a file
					File file = GeneralFactory.eINSTANCE.createFile();
					file.setLevel(root.getLevel()+1);
					file.setName(name);
					file.setVersion(version);
					file.setModfiedDate(modifyTime);
					file.setFullName(objectName);
					file.setObjectName(objectName);
					file.setPartOf(snapshot);
					file.setRootDir(root);
					file.setStatus(status);
					file.setSuffix(getFileSuffix(name));
					file.setRelease(release);
					files.add(file);
				}

			}
		
		} catch (Exception ex ){
			System.out.println(ex.getMessage());
		}
	}
	
	private Date getFileDate ( String date ) {
		/**
		 * example input: 
		 * Sat Mar 17 02:40:39 2007
		 */
		if ( date.length() > 1 ) {
		
			Date returnDate = null;
			DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", 
					Locale.ENGLISH);
			
			try {
				returnDate = df.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			return returnDate;
		}
		return null;
	}
	
	private boolean doPersist() {
		try {

			System.err.println("there are: " + folders.size() + " folders and " +
					files.size() + " files to be inserted");
			folderDao.massInsert(folders, Folder.class, snapshot);
			
			fileDao.massInsert(files, File.class, snapshot);

			return true;
		} catch ( Exception e ) {
			return false;
		}
	}
	
	private String getFileSuffix(String idOut) {
		int i = 0;
		int lastDotPosition = 0;
		for ( i = 0; i < idOut.length(); i++ ) {
			if ( idOut.charAt(i) == '.' ){
				lastDotPosition = i;
			}
		}
		if ( lastDotPosition < 1)
			return "-";
		return idOut.substring(lastDotPosition, idOut.length());
	}
}
