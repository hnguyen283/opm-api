//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.object;

import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.chick.opm.model.ab.File;
import com.chick.opm.model.inter.ProfileInter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Image extends File{
	private String width;
	private String height;	
	
	public Image() {
	}	
	
	public Image(String width, String height,String size, String location) {		
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
}
