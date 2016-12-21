//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.spring.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author Hung Dong Nguyen
 *
 */
@Configuration
public class OPMConfiguration{
	private static final String mongoUser = "hnguyen283";
	private static final String databaseName = "opmdrive";
	private static final String mongoPass = "langthuy";
	
	private static final String mongoHost = "10.1.79.17";
	private static final int mongoPort = 27017;
	
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(mappingJackson2HttpMessageConverter());
//	}
//
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setObjectMapper(
//				new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
//		return converter;
//	}
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

	    // Set credentials      
	    MongoCredential credential = MongoCredential.createCredential(mongoUser, databaseName, mongoPass.toCharArray());
	    ServerAddress serverAddress = new ServerAddress(mongoHost, mongoPort);

	    // Mongo Client
	    MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential)); 

	    // Mongo DB Factory
	    SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
	            mongoClient, databaseName);

	    return simpleMongoDbFactory;
	}
	
	@Bean
	public	MongoTemplate mongoTemplate() throws Exception {
		
		return new MongoTemplate(mongoDbFactory());
		
	}
}
