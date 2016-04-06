package com.vito16.dubbo.model;

import java.io.Serializable;

/**
 * Created by vito on 15-1-29.
 */
public class User implements Serializable {
	private int id;
	
	private String name;

	private String base;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
