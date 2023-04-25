package com.example.Mobile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MobileModel {
	@Id
	private int modelnumber;
	private String name;
	private String battery;
	private String storage;
	private int cost;
	MobileModel(){}
	public int getModelnumber() {
		return modelnumber;
	}
	public void setModelnumber(int modelnumber) {
		this.modelnumber = modelnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
