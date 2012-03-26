package com.amenity.engine.helper.mks;

import general.Connection;
import general.File;

import java.io.IOException;
import java.util.UUID;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Option;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.util.ResponseUtil;

public class MksGetFile {

	private Connection connection;
	private int port = 7001;
	@SuppressWarnings("unused")
	/*
	 * TODO: implement Sandbox FETCH
	 */
	private boolean isSandbox = false;
	private Session mySession = null;
	private File file = null;
	private String fileName;
	private String amenityTempFolder = "D:\\temp\\amenity\\";
	
	@SuppressWarnings("unused")
	private MksGetFile () {
	}
	
	public MksGetFile ( Connection connection, File file ) {
		this.connection = connection;
		this.file = file;
	}

	public MksGetFile ( Connection connection1, File file1, 
			Connection connection2, File file2) throws IOException {
		this.connection = connection1;
		this.file = file1;
		String fileName1 = openFile().substring(9);
		this.connection = connection2;
		this.file = file2;
		String fileName2 = openFile().substring(9);
		
		compareFiles(fileName1,fileName2);
		
	}
	
	public String openFile() throws IOException {
		
		try {
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), 
					port, false , 4 , 10);
			
			mySession = ip.createSession(connection.getUsername(),connection.getPassword());
			
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			myCmdRunner.setDefaultHostname(connection.getDatabase());
			myCmdRunner.setDefaultPort(port);
			myCmdRunner.setDefaultUsername(connection.getUsername());
			myCmdRunner.setDefaultPassword(connection.getPassword());

			java.io.File f = new java.io.File(amenityTempFolder);
			
			if ( !f.isDirectory() ) {
				String amo = "cmd /C mkdir " + amenityTempFolder;
				Runtime.getRuntime().exec(amo);
			}
			
			String pj = file.getFullName();
			int j = 0;
			for ( int i = 0 ; i < pj.length() ; i++ ) {
				if ( pj.charAt(i) == '/')
					j = i;
			}
			
			pj = pj.subSequence(0, j+1) + "project.pj";

			fileName = "remote://" + amenityTempFolder + 
					UUID.randomUUID().toString() + "_" +file.getName();
			
			Command myCmd = new Command ( Command.SI , "projectco");
//			myCmd.addOption( new Option( "project" , connection.getProject() ) );
			myCmd.addOption( new Option( "project" , pj ) );
			myCmd.addOption( new Option( "targetfile", fileName ) );
			myCmd.addOption( new Option( "cpid", ":none" ) );
			myCmd.addOption( new Option( "revision", file.getVersion() ) );
			myCmd.addOption( new Option( "nolock" ) );
			myCmd.addSelection(file.getName());
			myCmdRunner.execute(myCmd);
			
			
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	    } finally {
	        try {
	            if(mySession!=null){
	                mySession.release();
	            }
	        } catch (APIException ae){
	            System.out.println("--[ Exception ]---------------------------");
	            ResponseUtil.printAPIException(ae, 1, System.out);
	            System.out.println("--[ Response In Which It Occured ]--------");
	            ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		openLocalFile();
		return fileName;
	}
	
	private void openLocalFile() {
		// strip of remote://
		String openFileAmo = "cmd /C \"" + fileName.substring(9) + "\"";
		try {
			Runtime.getRuntime().exec(openFileAmo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void compareFiles( String file1, String file2) {
		// M:\pmtqtools\Admin\BeyondCompare\Beyond Compare 3\BCompare.exe file1 file2
		try {
			ProcessBuilder builder = new ProcessBuilder (
					"M:\\pmtqtools\\Admin\\Beyond" +
					"Compare\\Beyond Compare 3\\BCompare.exe", file1, file2);
			Process p = builder.start(); 
			System.err.println(p.exitValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
