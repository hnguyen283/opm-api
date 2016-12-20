//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.dao;

import com.chick.opm.model.object.Data;

public interface DAOInter {
	public Object getCollection(String collectionName);
	public Object saveCollection(Object object);
	public Data getById(String id, String collectionName);
}
