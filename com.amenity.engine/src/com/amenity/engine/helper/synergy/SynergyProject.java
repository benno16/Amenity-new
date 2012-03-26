package com.amenity.engine.helper.synergy;

import java.util.ArrayList;
import java.util.List;

public class SynergyProject {

	private String shortName;
	private String fullName;
	private List<String> release;
	
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<String> getRelease() {
		return release;
	}
	public void setRelease(List<String> release) {
		this.release = release;
	}
	
	public SynergyProject() {
		release = new ArrayList<String>();
	}
	public SynergyProject(String line) {
		release = new ArrayList<String>();
	}
	
}
