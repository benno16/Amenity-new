package com.amenity.engine.helper.mks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import general.Connection;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Option;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.response.Response;
import com.mks.api.response.WorkItem;
import com.mks.api.response.WorkItemIterator;
import com.mks.api.util.ResponseUtil;

import dao.DaoFactory;
import dao.FolderDao;
import dao.FileDao;

public class MksReader {

	private int port = 7001;
	private Session mySession = null;
	private static Snapshot snapshot;
	private Connection connection;
	private List<Folder> folders;
	private List<File> files;
	private FolderDao folderDao;
	private FileDao fileDao;
	long start;
	long end;
	
	private boolean createRootObject;
	public MksReader () {
	}
	
	public MksReader ( Connection connection, Snapshot snapshot ) {
		this.connection = connection;
		MksReader.snapshot = snapshot;
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
		createRootObject = true;
	}
	/**
	 * 
	 * @return
	 * si viewproject -- displays the contents of a project
		
		===========================================================================
		
		SYNOPSIS
		
		
		si viewproject [--fields=field1[:width1],field2[:width2]...]
		[--[no]filterSubs] [--height=value] [--width=value] [-x value] [-y value]
		[(-R|--[no|confirm]recurse)] [--filter=filteroptions] [(-P
		project|--project=project)] [--[no]failOnAmbiguousProject] [(-S
		sandbox|--sandbox=sandbox)] [--devpath=path] [--projectRevision=rev]
		[--lockRecordFormat=value] [(-F file|--selectionFile=file)]
		[--hostname=server] [--port=number] [--password=password] [--user=name]
		[(-?|--usage)] [(-N|--no)] [(-Y|--yes)] [--[no]batch] [--cwd =directory]
		[--forceConfirm=[yes|no]] [(-g|--gui)] [--[no]persist] [--quiet]
		[--settingsUI=[gui|default]] [--status=[none|gui|default]]
		member/subproject...
		
		===========================================================================
		
		
		DESCRIPTION
		
		
		si viewproject displays the contents of a project and some information
		about the members, for example:
		
		
		si viewproject c:/Aurora_Program/bin/Libra/project.pj
		
		displays
		
		connect.txt 1.4 archived
		source.txt 1.3 archived
		config.c 1.3 archived
		
		
		Note: Specifying si viewproject -S sandbox does not view the Sandbox; it
		redirects through the Sandbox to view the project. Use si viewsandbox to
		view a Sandbox.
		
		Options
		
		
		This command takes the universal options available to all si commands, as
		well as some general options. See the options reference page for
		descriptions.
		
		--fields=field1[:width1],field2[:width2]... 
		
		        allows you to select fields to be printed, specified in the
		        format field1[:width1],field2[:width2].... Specifying the column
		        [:width] (in pixels) for each field is optional. Widths are only
		        available with the -g or --gui options. Under the CLI the fields
		        are separated with a space.
		
		        The fields available for printing can be one or more of the
		        following:
		
		archiveshared 
		
		        displays indicators for members that share another member’s
		        archive. This column is valid only if you are using the database
		        repository.
		
		attributes 
		
		        displays member attributes.
		
		context 
		
		        When used with the MKS API, displays the name of the project, and
		        indicates if the project is a build or variant.
		
		        Note: This field is not valid for use with the CLI.
		
		cpid 
		
		        displays the change package associated with the operation that
		        set the member revision.
		
		creationcpid 
		
		        displays the change package that created the revision that is
		        currently the member revision. This revision may be different
		        from the Member CPID if an import, add member from archive, or
		        set member revision operation was used.
		
		frozen 
		
		        displays indicators for frozen members.
		
		indent 
		
		        indents a field. For example:
		
		
		
		si viewproject --fields=ident, name, type, memberrev
		
		
		        indents the name field, followed by type and memberrev fields,
		        indenting as you recurse into subprojects.
		
		        Note: This field is not valid for use with the MKS API.
		
		labels 
		
		        displays labels.
		
		lockrecord 
		
		        a comma separated list of locks on the member. The locker and
		        lock type are displayed by default for each lock. You can
		        customize the lock information that displays by using the
		        --lockRecordFormat option.
		
		memberarchive 
		
		        displays the name and path of the member archive.
		
		memberdescription 
		
		        displays the member description.
		
		memberrev 
		
		        displays the member revision.
		
		membertimestamp 
		
		        displays the member timestamp.
		
		name 
		
		        displays the member name.
		
		newrevdelta 
		
		        displays indicators for new revisions.
		
		pendingcpid 
		
		        displays the change package associated with a pending operation.
		
		state 
		
		        displays the member state.
		
		type 
		
		        displays the type of each item in the project: project,
		        subproject, shared-subproject, shared-variant-subproject,
		        shared-build-subproject, or member.
		
		--[no]filterSubs 
		
		        controls whether to display subprojects and directories that do
		        not contain members matching the current filter.
		
		--[no]persist 
		
		        controls whether this presentation of information should continue
		        to be updated as new information becomes available. --nopersist
		        forces a static "snapshot" of information, while --persist gives
		        real-time updates.
		
		--lockRecordFormat=value 
		
		        defines the format for displaying lock information in the
		        --lockrecord field. Specify a format string using keywords to
		        represent the information you want to display. You can specify
		        any of the following keywords:
		
		{revision} 
		
		        displays the revision that is locked.
		
		{locker} 
		
		        displays the user who locked the revision.
		
		{locktype} 
		
		        displays the type of lock on the revision (exclusive or
		        non-exclusive).
		
		{locktimestamp} 
		
		        displays the time when the revision was locked.
		
		{lockcpid} 
		
		        displays the change package associated with the lock on the
		        revision.
		
		{project} 
		
		        displays the name and path of the project where the member
		        revision was locked from. If the member revision was locked from
		        a shared subproject, it is the subproject name and path that are
		        displayed.
		
		{devpath} 
		
		        displays the name of the development path where the lock on the
		        revision was made from.
		
		{sandbox} 
		
		        displays the name of the Sandbox where the lock on the revision
		        was made. This is relevant when viewing the information from the
		        locker host.
		
		{hostname} 
		
		        displays the hostname of the computer that locked the the
		        revision.
		
		{hascpid} 
		
		        displays 1 if the lock has a change package associated with it, 0
		        if there is no associated change package.
		
		{hassandbox} 
		
		        displays 1 if there is Sandbox information available for the
		        lock, 0 if no Sandbox information is available.
		
		{hasdevpath} 
		
		        displays 1 if the lock was made from a development path, 0 if it
		        wasn't.
		
		{member} 
		
		        displays the name of the locked revision.
		
		member/subproject... 
		
		        identifies a specific member or subproject; use spaces to specify
		        more than one.
		
		===========================================================================
		
		
		DIAGNOSTICS
		
		
		See the diagnostics reference page for possible exit status values.
		
		===========================================================================
		
		
		PREFERENCES
		
		
		Using si setprefs or si viewprefs, you are able to set or view the
		preference keys for this command.
		
		===========================================================================
	 * 
	 * 
	 */
	public boolean getProjectFiles() {
		boolean noError = true;
		start = System.currentTimeMillis()/1000;
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

			Command myCmd = new Command ( Command.SI , "viewproject");
			myCmd.addOption(new Option ( "-R"));	// recursive
			myCmd.addOption(new Option ( "-Y"));	// say always yes
			myCmd.addOption(new Option("project",connection.getProject()));
			myCmd.addOption(new Option("fields=name,memberrev,membertimestamp," +
					"labels,state,type,attributes,context,attributes,cpid," +
					"creationcpid,memberarchive"));
			
			Response myResponse = myCmdRunner.execute(myCmd);
			WorkItemIterator wii = myResponse.getWorkItems();
			
			folderDao = DaoFactory.eINSTANCE.createFolderDao();
			fileDao = DaoFactory.eINSTANCE.createFileDao();
			
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to fetch files --- " + 
//					(end- start ) + " seconds");
//			start = end;
			
//			createRootDirectory(connection.getProject());
//			boolean done = false;
//			int i = 0;
			while ( wii.hasNext() ) {
				WorkItem wi = wii.next();
				
				/**
				 * HELPER
				 * @author uidu1448
				 * This is a supporting class to get the attributes
				 * and names and result sets from MKS
				 */
//				i++;
//				if ( !done) {
//					Iterator fields = wi.getFields();
//					String s = "";
//					String v = "";
//					boolean doOnce = true;
//					while ( fields.hasNext() ) {
//						Field field = (Field) fields.next();
//
//						if ( doOnce ) {
//							s = s + "|getId";
//							v = v + "|" + wi.getId();
//							s = s + "|getDisplayId";
//							v = v + "|" + wi.getDisplayId();
//							s = s + "|getModelType";
//							v = v + "|" + wi.getModelType();
//							s = s + "|getContext";
//							v = v + "|" + wi.getContext();
//							doOnce = false;
//						}
//						s = s + "|" + field.getName();
//						v = v + "|" + field.getValueAsString();
//					}
//					doOnce = true;
//					System.out.println(s);
//					System.out.println(v);
//					System.out.println("--");
//					if ( i == 10)
//					done = true;
//				}
				
				generateContentObject(wi);
				
			}
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to create objects --- " + 
//					(end- start ) + " seconds");
//			start = end;
			if ( doPersist() ) {
				
				return noError;
			}
			
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        noError = false;
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
	            noError = false;
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		
		return noError;
	}

//	private void createRootDirectory(String project) {
//		Folder folder = GeneralFactory.eINSTANCE.createFolder();
//		folder.setName(project);
//		folder.setPartOf(snapshot);
//		folder.setRootDirectory(folder);
//		folder.setLevel(0);
//		folder.setModfiedDate(null);
//		folders.add(folder);
////		folderDao.create(folder);
//		folder = null;
//	}

	public boolean getSandboxFiles() {
		
		
		return false;
	}

	private boolean doPersist() {
		try {
			System.out.println("---- there are " + folders.size() + " folders");
			folderDao.massInsert(folders, Folder.class, snapshot);
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to persist folder objects --- " + 
//					( end- start ) + " seconds");
//			start = end;

			System.out.println("---- there are " + files.size() + " files");
			fileDao.massInsert(files, File.class, snapshot);
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to persist file objects --- " + 
//					( end- start ) + " seconds");
//			start = end;

			return true;
		} catch ( Exception e ) {
			return false;
		}
	}
	
	private void generateContentObject( WorkItem wi ) {
		
		String idOut = "";
		String stateOut = "";
		String nameOut = "";
		String memberrevOut = "";
		String labelsOut = "";
		String membertimestampOut = "";
		String typeOut = "";
		String parentOut ="";

		if ( true ) {
			idOut = wi.getId();
			if ( idOut.length() > 251 )
				idOut = idOut.substring(0, 250);
		}
		// set object name
		if ( wi.contains("name") ) {
			nameOut = wi.getField("name").getValue().toString();
			if ( nameOut.length() > 251 )
				nameOut = nameOut.substring(0, 250);
		}
		// sets root directory
		if ( wi.contains("parent") ) {
			parentOut = wi.getField("parent").getValue().toString();
			if ( parentOut.length() > 251 )
				parentOut = parentOut.substring(0, 250);
		}
		// sets version
		if ( wi.contains("memberrev") ) {
			memberrevOut = wi.getField("memberrev").getItem().getId();
			if ( memberrevOut.length() > 251 )
				memberrevOut = memberrevOut.substring(0, 250);
		}
		// sets the modification date
		if ( wi.contains("membertimestamp") ) {
			membertimestampOut = wi.getField("membertimestamp").getValueAsString();
		}
		// sets the release
		if ( wi.contains("labels") ) {
			for ( int i = 0 ; i < wi.getField("labels").getList().size() ; i++ ) {
				labelsOut = labelsOut + wi.getField("labels").getList().get(i).toString();
			}
			if ( labelsOut.length() > 251 )
				labelsOut = labelsOut.substring(0, 250);
		}
		// sets the file status
		if ( wi.contains("state") ) {
			stateOut = wi.getField("state").getValue().toString();
			if ( stateOut.length() > 251 )
				stateOut = stateOut.substring(0, 250);
		}
		// sets the separator
		typeOut = wi.getModelType().toLowerCase();

		/*
		 * check if the content object is of type file or folder
		 */
		if ( typeOut.contains("project") ) {
			/*
			 *  its a folder! 
			 *  the following fields are being used hence available: 
			 *  Model Type, name, parent
			 */
//			System.err.println(
//			"|" + idOut + 
//			"|" + nameOut +
//			"|" + parentOut + 
//			"|" + typeOut + 
//			"|" + labelsOut + 
//			"|" + memberrevOut + 
//			"|" + membertimestampOut + 
//			"|" + stateOut
//			);
			Folder folder = GeneralFactory.eINSTANCE.createFolder();
			folder.setPartOf(MksReader.snapshot);
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			folder.setRootDirectory(root);
			folder.setFullName(nameOut);
			if ( root == null ) {
				folder.setLevel( 1 );
				folder.setName(getFolderName(nameOut, null));
			} else {
				folder.setLevel( root.getLevel() + 1 );
				folder.setName(getFolderName(nameOut, root.getFullName()));
			}
			folder.setModfiedDate(null);
			folders.add(folder);
//			folderDao.create(folder);
			folder = null;
		} else {
			// its a file!
			File file = GeneralFactory.eINSTANCE.createFile();
			file.setCreationDate(getFileDate(membertimestampOut));
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			file.setRootDir(root);
			file.setPartOf(MksReader.snapshot);
			file.setLevel(root.getLevel() + 1);
			file.setModfiedDate(getFileDate(membertimestampOut));
			file.setName(idOut);
			file.setFullName(nameOut);
			file.setRelease(labelsOut);
			file.setStatus(stateOut);
			file.setSuffix(getFileSuffix(idOut));
			file.setVersion(memberrevOut);
//			fileDao.create(file);
			/**
			 * TODO: check if this would be possible or slow down the process to much
			 */
//			updateRootObject(root);
//			folderDao.update(root);
			files.add(file);
			file = null;
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

//	private void updateRootObject(Folder root) {
//		for ( Folder f : folders ) {
//			if ( f.getFullName().equals(root.getFullName())) {
//				f = root;
//			}
//		}
//	}

	private String getFolderName(String projectName, String rootName) {
		/*
		 * /project. p j
		 * 1234567891011
		 * => 11
		 */
		int projectLength = 10;
		if ( rootName != null ) {
			String rootShortName = rootName.substring(0, 
					rootName.length() - projectLength);
			return projectName.substring(rootShortName.length(), 
					projectName.length() - projectLength);
		}
		return projectName.substring(0, 
				projectName.length() - projectLength);
	}

	private Folder getParentFolder ( String parent ) {
		if ( folders.size() > 0 ) {
			for ( Folder f : folders ) {
				if ( f.getFullName().equals(parent) ) {
					return f;
				}
			}
		} else if ( createRootObject ) {
			System.err.println("no parent Found for parent: " + parent);
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root.setFullName(parent);
			root.setRootDirectory(null);
			root.setName("root");
			root.setPartOf(snapshot);
			root.setLevel(0);
			folders.clear();
			folders.add(root);
			createRootObject = false;
			return root;
		} else {
			System.err.println("Looking for match for: " + parent);
		}
		return null;
	}
	
	private Date getFileDate ( String date ) {
		/**
		 * example input: 
		 * Tue Aug 05 16:20:20 CEST 2008
		 */
		if ( date.length() > 1 ) {
		
			Date returnDate = null;
			DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", 
					Locale.ENGLISH);
			
			try {
				returnDate = df.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			return returnDate;
		}
//		return new Date();
		return null;
	}
	
}
