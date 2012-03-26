package com.amenity.workbench.interfaces;

import org.eclipse.swt.graphics.Image;

public interface IIconFactory {
	
	public Image getEventViewerIco( );
	public Image getUnknownIco( );
	public Image getProjectCotainerIco( );
	public Image getWorkbenchIco();
	public Image getManageContainerIco();
	public Image getShowSnapshotIco();
	public Image getCompareSnapshotIco();
	public Image getAssignFunctionIco();
	public Image getAssignFilesIco();
	public Image getNewContainerIco();
	
	
	
	// Generic Icons
	public Image getModifyIco();
	public Image getDeleteIco();
	public Image getHelpIco();
	
	// FileTypes
	public Image getCompressedIco();
	public Image getWordIco();
	public Image getPPTIco();
	public Image getCIco();
	public Image getHIco();
	public Image getImageIco();
	public Image getPdfIco();
	

}
