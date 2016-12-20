//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public abstract class DAOAbtract {
	
	private static MongoOperations mongoOperation ;
	private static ApplicationContext ctx;
	
	protected DAOAbtract(){
		if(DAOAbtract.ctx == null){
			DAOAbtract.ctx = new GenericXmlApplicationContext("config/spring-config.xml");
		}
	}
	
	protected MongoOperations getCurrentMongoOperations() {
		if(DAOAbtract.mongoOperation == null){
			DAOAbtract.mongoOperation = (MongoOperations)ctx.getBean("mongoOperation");
		}
		return DAOAbtract.mongoOperation;
	}
	

}
