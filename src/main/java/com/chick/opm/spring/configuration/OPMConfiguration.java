//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.spring.configuration;

import java.net.InetAddress;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author Hung Dong Nguyen
 *
 */
@Configuration
public class OPMConfiguration{
	
	private static final Logger logger = Logger.getLogger(OPMConfiguration.class);
	
	private static final String mongoUser = "hnguyen283";
	private static final String databaseName = "opmdrive";
	private static final String mongoPass = "langthuy";
	
	private static final String mongoHostServer = "10.1.79.17";
	private static final String mongoHostLocal = "localhost";
	private static final int mongoPort = 27017;
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		// Mongo DB Factory
	    SimpleMongoDbFactory simpleMongoDbFactory;
	    InetAddress inet = InetAddress.getByName(mongoHostServer);

	    logger.info("Sending Ping Request to " + mongoHostServer);
	    logger.info(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
	    
	    if(inet.isReachable(5000)){
	    	// Set credentials      
	    	MongoCredential credential = MongoCredential.createCredential(mongoUser, databaseName, mongoPass.toCharArray());
	    	ServerAddress serverAddress = new ServerAddress(mongoHostServer, mongoPort);
	    	
	    	// Mongo Client
	    	MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential)); 
	    	simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, databaseName);
	    	
	    }else{
	    	simpleMongoDbFactory = new SimpleMongoDbFactory(new MongoClient(mongoHostLocal,mongoPort), databaseName);
	    }
	    return simpleMongoDbFactory;
	}
	
	@Bean
	public	MongoTemplate mongoTemplate() throws Exception {
		
		return new MongoTemplate(mongoDbFactory());
		
	}
}
