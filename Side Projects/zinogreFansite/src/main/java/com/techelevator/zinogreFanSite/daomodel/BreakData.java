package com.techelevator.zinogreFanSite.daomodel;

public class BreakData {

	// Attributes
	private int id;
	private String part;
	private int breakValue;
	private int severValue;
	private String extractColor;
	
	// Gets and Sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getBreakValue() {
		return breakValue;
	}
	public void setBreakValue(int breakValue) {
		this.breakValue = breakValue;
	}
	public int getSeverValue() {
		return severValue;
	}
	public void setSeverValue(int severValue) {
		this.severValue = severValue;
	}
	public String getExtractColor() {
		return extractColor;
	}
	public void setExtractColor(String extractColor) {
		this.extractColor = extractColor;
	}
}
