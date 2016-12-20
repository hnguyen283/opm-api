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

	private static final Logger logger = Logger.getLogger(LoadAPI.class);
	
	@Autowired
	@Qualifier("CommonService")
	private CommonService commonService;
	
	@Autowired
	@Qualifier("ResponeMessageService")
	private ResponeMessageService responeMessageService;
	
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
			Query query = new Query();
			query.addCriteria(Criteria.where(CommonService.ID_FIELD).is(new ObjectId(id)));
			if(!getCurrentMongoOperations().exists(query, collectionName)){
				return responeMessageService.toErrorMessage("");
			}else{
				basicDBObject = getCurrentMongoOperations().findOne(query, BasicDBObject.class, collectionName);
			}
		}
		if(basicDBObject!= null)return ((Data)commonService.ReadConverter(basicDBObject, collectionName));
		else return responeMessageService.toErrorMessage("");
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
					System.out.println("Save : " + dataOb.toJson() );
					getCurrentMongoOperations().save(dataOb,dataOb.getObName());
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
