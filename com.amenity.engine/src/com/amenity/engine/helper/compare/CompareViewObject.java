package com.amenity.engine.helper.compare;

import general.File;
import general.Folder;

public class CompareViewObject {
	
	private Folder folder1;
	private File file1;
	private Folder folder2;
	private File file2;
	private String differenciator;
	
	
	public CompareViewObject() {
	}
	
	public CompareViewObject( Folder folder1, 
			Folder folder2, String differenciator) {
		this.folder1 = folder1;
		this.folder2 = folder2;
		this.differenciator = differenciator;
	} 


	public CompareViewObject( File file1, 
			File file2, String differenciator) {
		this.file1 = file1;
		this.file2 = file2;
		this.differenciator = differenciator;
	}

	public Folder getFolder1() {
		return folder1;
	}

	public File getFile1() {
		return file1;
	}

	public Folder getFolder2() {
		return folder2;
	}

	public File getFile2() {
		return file2;
	}

	public String getDifferenciator() {
		return differenciator;
	}

	public void setFolder1(Folder folder1) {
		this.folder1 = folder1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public void setFolder2(Folder folder2) {
		this.folder2 = folder2;
	}

	public void setFile2(File file2) {
		this.file2 = file2;
	} 
}
