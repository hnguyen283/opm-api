//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.partial;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chick.opm.dao.CollectionDAO;
import com.chick.opm.model.object.Data;
import com.chick.opm.service.inter.ServiceStructure;

@Service("CollectionService")
public class CollectionService implements ServiceStructure{

	@Autowired
	@Qualifier("CollectionDAO")
	private CollectionDAO dao;
	
	@Override
	public Object get(String obName) {
		return dao.getCollection(obName);		
	}

	@Override
	public Object search(Object obj) {		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.chick.service.ServiceStructure#save(java.lang.Object)
	 */
	@Override
	public Object save(Object obj) {
		if(obj instanceof Data){			
			return dao.saveCollection(((Data) obj).prepareToSave(new ArrayList<>()));	
		}else return null;
	}
	
	public Object getById(String id, String collectionName) {
		return dao.getById(id, collectionName);		
	}
	
}
