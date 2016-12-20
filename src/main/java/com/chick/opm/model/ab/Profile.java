//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.ab;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chick.opm.model.inter.ProfileInter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mongodb.BasicDBObject;

@JsonInclude(Include.NON_NULL)
@Document
public abstract class Profile extends BasicDBObject implements ProfileInter{
	
	/**
	 * 
	 */
	@Id
	public String id;
	@Transient
	public String obName;
	
	
	public Profile() {
	}
	
	public Profile(String id, String obName) {
		this.id = id;
		this.obName = obName;
	}
	public String getId() {
		return id;
	}

	public String getObName() {
		return obName;
	}

	public void setObName(String obName) {
		this.obName = obName;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
