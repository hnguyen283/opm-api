//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.chick.opm.api.LoadAPI;
import com.chick.opm.model.object.Data;
import com.chick.opm.service.common.CommonService;
import com.chick.opm.service.inter.ResponeMessageService;
import com.mongodb.BasicDBObject;

@Repository("CollectionDAO")
public class CollectionDAO extends DAOAbtract implements DAOInter {

	public static final String COLLECTION_NOT_EXISTS="NOT EXISTS";
	public static final String CAN_NOT_GET_COLLECTION="CAN NOT GET";
	
	public static final String SUCCESS="SUCCESS";
	public static final String FAIL="FAIL";
	
	private static final Logger logger = Logger.getLogger(LoadAPI.class);
	private static CollectionDAO collectionDAO;
	
	@Autowired
	@Qualifier("CommonService")
	private CommonService commonService;
	
	@Autowired
	@Qualifier("ResponeMessageService")
	private ResponeMessageService responeMessageService;
	
	public CollectionDAO(){
		CollectionDAO.collectionDAO = this;
	}
	
	public static CollectionDAO getInstance(){
		if(CollectionDAO.collectionDAO==null){
			CollectionDAO.collectionDAO = new CollectionDAO();
		}
		return CollectionDAO.collectionDAO;
	}
	
	/* 
	 * Description: This function to get collections from database by collection name
	 * 
	 * @parameter: 
	 * <String> collectionName (the name of collection)
	 * 
	 * @return: Object instance of List<Data>
	 * 
	 * @see com.chick.opm.model.object.Data
	 */
	@Override
	public Object getCollection(String collectionName) {
		List<Data> db = new ArrayList<Data>();
		List<BasicDBObject> dbs = getCurrentMongoOperations().findAll(BasicDBObject.class, collectionName);
		for(BasicDBObject data: dbs){
			db.add((Data)commonService.ReadConverter(data, collectionName));
		}
		return db;
	}
	
	/* 
	 * Description: This function to get a collection from database by id and collection name
	 * 
	 * @parameter: 
	 * <String> id (the id of collection)
	 * <String> collectionName (the name of collection)
	 * 
	 * @return: Data
	 * 
	 * @see com.chick.opm.model.object.Data
	 */
	public Data getById(String id, String collectionName) {
		BasicDBObject basicDBObject = null;
		try{
			basicDBObject = getCurrentMongoOperations().findById(new ObjectId(id), Data.class, collectionName);
			
		}catch(java.lang.IllegalArgumentException illegalArgumentException){
			return deepGetById(id,collectionName);
		}
		if(basicDBObject!= null)return ((Data)commonService.ReadConverter(basicDBObject, collectionName));
		else return deepGetById(id,collectionName);
	}
	
	private Data deepGetById(String id, String collectionName){
		BasicDBObject basicDBObject = null;
		Query query = new Query();
		query.addCriteria(Criteria.where(CommonService.ID_FIELD).is(new ObjectId(id)));
		if(!getCurrentMongoOperations().exists(query, collectionName)){
			return responeMessageService.toErrorMessage(CollectionDAO.COLLECTION_NOT_EXISTS);
		}else{
			return ((Data)commonService.ReadConverter(getCurrentMongoOperations().findOne(query, BasicDBObject.class, collectionName), collectionName));
		}
	}

	/* 
	 * Description: This function to save the collection down to database
	 * 
	 * @parameter: object, which is instance of
	 * ArrayList<Data> (a collection of Data has been order by function prepareToSave in Data)
	 * 
	 * @return: Object of ResponeMessage instance of Data, provide by ResponseMessageService  
	 * 
	 * @see com.chick.dao.DAOInter#saveCollection(java.lang.Object)
	 * @see com.chick.opm.model.object.Data#prepareToSave(java.util.ArrayList)
	 */
	@Override
	public Object saveCollection(Object object) {
		try{
			if(object instanceof ArrayList){				
				ArrayList<Data> result = (ArrayList<Data>) object;				
				for(Data dataOb: result){
					logger.info("Save : " + dataOb.toJson() );
					getCurrentMongoOperations().save(dataOb,dataOb.getObName());
				}
				
				return responeMessageService.toInformationMessage(CollectionDAO.SUCCESS);
			}else{
				return responeMessageService.toErrorMessage(CollectionDAO.FAIL);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return responeMessageService.toErrorMessage(e.getMessage());
		}
	}	

	/* (non-Javadoc)
	 * @see com.chick.opm.dao.DAOInter#dropteCollection(java.lang.String)
	 */
	@Override
	public Object dropCollection(Object collection) {
		try{
			if(collection instanceof ArrayList){				
				ArrayList<Data> result = (ArrayList<Data>) collection;				
				for(Data dataOb: result){
					logger.info("Remove : " + dataOb.toJson() );
					Query query = new Query();
					query.addCriteria(Criteria.where(CommonService.ID_FIELD).is(new ObjectId(dataOb.getId())));
					getCurrentMongoOperations().remove(query, dataOb.getObName());
				}
				
				return responeMessageService.toInformationMessage("Success");
			}else{
				return responeMessageService.toErrorMessage("");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return responeMessageService.toErrorMessage(e.getMessage());
		}
	}
	
}
