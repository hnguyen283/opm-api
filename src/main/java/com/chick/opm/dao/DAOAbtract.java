//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.chick.opm.spring.configuration.OPMConfiguration;

public abstract class DAOAbtract {
	
	private static MongoOperations mongoOperation ;
	private static ApplicationContext ctx;
	
	protected DAOAbtract(){
		if(DAOAbtract.ctx == null){
//			DAOAbtract.ctx = new GenericXmlApplicationContext("config/spring-config.xml");
			DAOAbtract.ctx = new AnnotationConfigApplicationContext(OPMConfiguration.class);
		}
	}
	
	protected MongoOperations getCurrentMongoOperations() {
		if(DAOAbtract.mongoOperation == null){
			DAOAbtract.mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		}
		return DAOAbtract.mongoOperation;
	}
	

}
