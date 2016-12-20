//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.ab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public abstract class File extends Profile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8478071215687106910L;
	public String size;
	public String location;
	public String typeF;
	public File() {
		super(null, "file");		
	}
	public File(String size, String location, String typeF) {
		super(null, "file");
		this.size = size;
		this.location = location;
		this.typeF = typeF;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTypeF() {
		return typeF;
	}
	public void setTypeF(String typeF) {
		this.typeF = typeF;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	
}
