package com.amenity.engine.helper.mks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.response.Response;
import com.mks.api.response.WorkItem;
import com.mks.api.response.WorkItemIterator;
import com.mks.api.util.ResponseUtil;

public class MksLogin {

	private String username;
	private String password;
	private String database;
	private int port = 7001;
	private boolean isSandbox = false;
	private Session mySession = null;
	
	@SuppressWarnings("unused")
	private MksLogin () {
		// hidden constructor
	}
	
	public MksLogin ( String username, String password, String database, boolean isSandbox ) {
		this.username = username;
		this.password = password;
		this.database = database;
		this.isSandbox = isSandbox;
	}
	
	@SuppressWarnings("deprecation")
	public List<String> showProjects() {
		
		if ( username.length() < 1 || password.length() < 1 || database.length() < 1 )
			return null;
		
		List<String> projects = new ArrayList<String>();
		try {
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			IntegrationPoint ip;
			if ( isSandbox )
				ip = ipf.createLocalIntegrationPoint();
			else
				ip = ipf.createIntegrationPoint(database, 
						port, false , 4 , 10);
			mySession = ip.createSession(username, password);
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			
			myCmdRunner.setDefaultHostname(database);
			myCmdRunner.setDefaultUsername(username);
			myCmdRunner.setDefaultPassword(password);
			myCmdRunner.setDefaultPort(port);
			Command myCmd = null;
			if ( isSandbox ) {
				myCmd = new Command ( Command.SI , "sandboxes" );
			} else {
				myCmd = new Command ( Command.SI , "projects" );
			}
			
			Response myResponse = myCmdRunner.execute(myCmd);
			
			WorkItemIterator wii = myResponse.getWorkItems();
			
			while ( wii.hasNext() ) {
				WorkItem wi = wii.next();
				if ( wi.contains("projectName")) {
					projects.add(wi.getField("projectName").getValue().toString()); 
				}
			}
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
//	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        return null;
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
		
		return projects;
	}
}
