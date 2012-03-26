package com.amenity.engine.helper.synergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

public class SynergyLogin {

//	private String ccmEXEFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm";
//	private String ccmHomeFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7105";
//	private String ccmIniFile = "\"%userprofile%\\ccm71.ini\"";
	
	private String ccmEXEFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_EXE" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm.exe" , null );
	
	private String ccmHomeFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_DIR" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105" , null );
	
	private String ccmIniFile = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYINI_FILE" , System.getenv("userprofile").replace('\\', '/') + "\\ccm71.ini" , null );
	
	private String sessionID;
	
	public  SynergyLogin() {
	}
	
	public void closeSynergySession( String sessionID) {
		this.sessionID = sessionID;
		try {
			long start = System.currentTimeMillis();

			ProcessBuilder pb = new ProcessBuilder("cmd",  "/c", 
					ccmEXEFolder,
					"quit");
			
			Map<String, String> env = pb.environment();
			
			env.put("CCM_ADDR", sessionID);

			Process pr = pb.start();
			pr.waitFor();
			
			long end = System.currentTimeMillis();
			System.out.println("Session Close Time: "+(end-start)/1000+" s.");
			
		} catch (Exception ex ){
			System.out.println(ex.getMessage());
		}
	}

	public String getSynergySessionId() {
		sessionID = null;
		long start = System.currentTimeMillis();
		ProcessBuilder pb = new ProcessBuilder ( "cmd", 
				"/c" , 
				ccmEXEFolder,
				"start", "-q", "-m", "-nogui", 
				"-f", 
				ccmIniFile
				);
		Map<String, String> env = pb.environment();
		
		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", ccmIniFile );
		
		Process pr;
		try {
			pr = pb.start();
			pr.waitFor();
			sessionID = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end1 = System.currentTimeMillis();
		
		System.out.println("Session start time was "+ 
				(end1-start)/1000+" s.");
		
		return sessionID;
	}
	
	public List<String> getRawProjectList( String sessionID ) {
		this.sessionID = sessionID;
		List<String> projectList = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder ("cmd", "/c", 
				ccmEXEFolder,
				"show",
				"-p",
				"-f",
				"\"%displayname\""
				);

		Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder );
		env.put("CCM_INI_FILE", ccmIniFile );
		env.put("CCM_ADDR", sessionID);
		
		Process pr;
		try {
			pr = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			
			while (( resultset = br.readLine()) != null ){
				int index = resultset.indexOf(")");
				if ( index > 1 ){
					projectList.add(resultset.substring(index + 1).trim());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectList;
	}
}
