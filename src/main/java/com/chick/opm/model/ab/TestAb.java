//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.ab;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.mapping.Map;
import org.hibernate.mapping.PersistentClass;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.mongodb.BasicDBObject;

/**
 * @author Hung Dong Nguyen
 *
 */
public abstract class TestAb extends BasicDBObject {
	
	/**
	 * 
	 */
	@Id
	public String id;
	@Transient
	public String obName;	
		
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
