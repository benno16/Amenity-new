package com.amenity.workbench;

import general.Container;
import general.Function;
import general.SessionSatus;
import general.Snapshot;
import general.User;
import general.UserList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import com.amenity.engine.helper.synergy.SynergyProject;

/**
 * @author Ben
 * This class provides the session variables! 
 * All static and global 
 * Nice not the dirty way via activator class
 *
 */
public class SessionSourceProvider extends AbstractSourceProvider {
	
	public final static String SESSION_STATE = "com.amenity.workbench.sessionState"; 
	private final static String LOGGED_IN = "loggedIn"; 
    private final static String LOGGED_OUT = "loggedOut"; 
    
    // User Information
    public static String USERID = "-";
    public static User USER = null;
    public static UserList USERS = null;
    public static SessionSatus SESSION_STATUS = null;
    
    // User Content Information
    public static Snapshot CURRENT_SNAPSHOT = null;
    public static Container CURRENT_CONTAINER = null;
    public static Function CURRENT_FUNCTION = null;
    public static List<Container> CONTAINER_LIST;
    public static List<Snapshot> SNAPSHOT_LIST;
    
    // Session information
    public static String SYNERGY_SID = null;
    public static List<String> SYNERGY_PROJECT_LIST = null;
    public static List<SynergyProject> SYNERGY_PROJECT_LIST_OBJECT = null;
    
    
//    public static SessionFactory HIBERNATE_SESSION_FACTORY = null;
//    public static Session HIBERNATE_SESSION = null;

    public static Properties LOG4J_PROPERTIES = null;
    boolean loggedIn;
    
    public void setLoggedIn ( boolean loggedIn ) {
    	if ( this.loggedIn == loggedIn )
    		return;
    	this.loggedIn = loggedIn;
    	String currentState = loggedIn?LOGGED_IN:LOGGED_OUT;
        fireSourceChanged(ISources.WORKBENCH, SESSION_STATE, currentState);
    }
    
	@Override
	public void dispose() {
	}

	@Override
	public Map<String, String> getCurrentState() {
		Map<String, String> currentState = new HashMap<String, String>(1);
        String currentState2 =  loggedIn?LOGGED_IN:LOGGED_OUT;
        currentState.put(SESSION_STATE, currentState2);
        return currentState;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] {SESSION_STATE};
	}

}
