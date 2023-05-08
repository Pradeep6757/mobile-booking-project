package com.example.Mobile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FeaturesModel {
	@Id
	private int fid;
	private String colour;
	private String displaysize;
	private String cam;
	FeaturesModel(){}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDisplaysize() {
		return displaysize;
	}
	public void setDisplaysize(String displaysize) {
		this.displaysize = displaysize;
	}
	public String getCam() {
		return cam;
	}
	public void setCam(String cam) {
		this.cam = cam;
	}
	
	
	

}
