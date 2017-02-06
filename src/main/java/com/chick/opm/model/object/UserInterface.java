//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.object;

import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.chick.opm.model.ab.Profile;
import com.chick.opm.model.inter.ProfileInter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserInterface extends Profile{
	
	private String typeUI;
	private Image imageCover;
	private Image imageIcon;
	private String description;	
	private Object action;
	
	public UserInterface() {
		super(null, "userInterface", null);
	}	
	public UserInterface(String typeUI, Image imageCover, Image imageIcon, String description, Object action) {
		super(null, "userInterface", null);
		this.typeUI = typeUI;
		this.imageCover = imageCover;
		this.imageIcon = imageIcon;
		this.description = description;
		this.action = action;
	}
		
	public String getTypeUI() {
		return typeUI;
	}
	public void setTypeUI(String typeUI) {
		this.typeUI = typeUI;
	}
	public Image getImageCover() {
		return imageCover;
	}
	public void setImageCover(Image imageCover) {
		this.imageCover = imageCover;
	}
	public Image getImageIcon() {
		return imageIcon;
	}
	public void setImageIcon(Image imageIcon) {
		this.imageIcon = imageIcon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public Object getAction() {
		return action;
	}
	public void setAction(Object action) {
		this.action = action;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	
}
