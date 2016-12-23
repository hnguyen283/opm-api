//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chick.opm.dao.CollectionDAO;
import com.chick.opm.model.object.Data;
import com.chick.opm.service.inter.ResponeMessageService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/**
 * @author Hung Dong Nguyen
 *
 */
@Service("CommonService")
public class CommonService {
	private static final Logger logger = Logger.getLogger(CommonService.class);
	
	@Autowired
	@Qualifier("CollectionDAO")
	private CollectionDAO dao;
	
	public static final String ID_FIELD = "_id";
	public static final String CLASS_FIELD = "_class";
	public static final String RANGE_FIELD = "_range";
	
	public static final int DEFAULT_RANGE_FIELD = 0;
	
	public Data ReadConverter (BasicDBObject basicDBObject, String ObName){
		try {
			if(this.dao==null){
				this.dao=CollectionDAO.getInstance();
			}
			Data data = new Data();
			data.setObName(ObName);
			if (basicDBObject.containsKey(CLASS_FIELD)){
				basicDBObject.remove(CLASS_FIELD);				
			}
			if (basicDBObject.containsKey(RANGE_FIELD)){
				data.setRange(Integer.parseInt(String.valueOf(basicDBObject.get(RANGE_FIELD))));
			}else{
				data.setRange(CommonService.DEFAULT_RANGE_FIELD);
			}
			for(String keyName : basicDBObject.keySet()){
				Object obj = basicDBObject.get(keyName);
				if(keyName.equalsIgnoreCase(CommonService.ID_FIELD)){	
					try{
						data.setId(((ObjectId)obj).toHexString());						
					}catch(java.lang.ClassCastException castException){
						ObjectId objId = null;
						if(obj instanceof HashMap){
							HashMap<String,String> objBasicId =(HashMap<String, String>) obj;
							objId = new ObjectId(Integer.parseInt(String.valueOf(objBasicId.get("timestamp"))), Integer.parseInt(String.valueOf(objBasicId.get("machineIdentifier"))),Short.parseShort(String.valueOf(objBasicId.get("processIdentifier"))),Integer.parseInt(String.valueOf(objBasicId.get("counter"))));
						}if(obj instanceof String){
							objId = new ObjectId(String.valueOf(obj));
						}else{
							BasicDBObject objBasicId = BasicDBObject.parse(obj.toString().replaceAll("=", ":"));
							objId = new ObjectId(Integer.parseInt(String.valueOf(objBasicId.get("timestamp"))), Integer.parseInt(String.valueOf(objBasicId.get("machineIdentifier"))),Short.parseShort(String.valueOf(objBasicId.get("processIdentifier"))),Integer.parseInt(String.valueOf(objBasicId.get("counter"))));
						}
						if(objId == null){
							logger.error("Can not get ID from this field: " + obj.toString() + " in " +  ObName + "collection");
							objId = new ObjectId();
							logger.warn("Auto set new id : " + objId.toHexString() + " in " +  ObName + "collection");
						}
						data.setId(objId.toHexString());
					}
				} else if(obj instanceof ArrayList){
					BasicDBList list = null;
					try{						
						list = new BasicDBList();
						list.addAll((ArrayList) basicDBObject.get(keyName));
						if(list.size() != 0){
							
							ArrayList<Object> dataHolder = new ArrayList<Object>();
							if(list.get(0) instanceof ObjectId){
								for(int i = 0; i < list.size(); i++){				
									Data child = dao.getById(((ObjectId)list.get(i)).toHexString(), keyName);
									if(child.getId().equalsIgnoreCase(ResponeMessageServiceImpl.ID)){
										if(!((String) child.get(ResponeMessageServiceImpl.DETAIL)).equalsIgnoreCase(CollectionDAO.COLLECTION_NOT_EXISTS)){											
											dataHolder.add(list.get(i));
										}
									}else dataHolder.add(child);
								}
								data.addChild(dataHolder.toArray());	
							}else if (list.get(0) instanceof HashMap){
								for(int i = 0; i < list.size(); i++){
									BasicDBObject objBasic = new BasicDBObject();
									objBasic.putAll((HashMap) list.get(i));
									dataHolder.add(new CommonService().ReadConverter(objBasic,keyName));
								}
								data.addChild(dataHolder.toArray());	
							}else{
								data.append(keyName,(BasicDBList) basicDBObject.get(keyName));
							}
							
						}
					}catch(java.lang.ClassCastException castException){
						data.append(keyName,(ArrayList) basicDBObject.get(keyName));
					}catch(java.lang.IndexOutOfBoundsException arrayException){
						data.append(keyName,basicDBObject.get(keyName));
					}
				}else if (obj instanceof ObjectId){
					Data child = dao.getById(((ObjectId)obj).toHexString(), keyName);
					//If this collection is not exists, We remove it in data
					if(child.getId().equalsIgnoreCase(ResponeMessageServiceImpl.ID)){
						if(!((String) child.get(ResponeMessageServiceImpl.DETAIL)).equalsIgnoreCase(CollectionDAO.COLLECTION_NOT_EXISTS)){
							data.append(keyName, basicDBObject.get(keyName));
						}
					}else data.addChild(child);		
				}else if (obj instanceof HashMap){					
					BasicDBObject objBasic = new BasicDBObject();
					objBasic.putAll((HashMap) obj);
					Data child = new CommonService().ReadConverter(objBasic,keyName);
					if(data.getRange()!=DEFAULT_RANGE_FIELD){
						if(child.getRange()!=(data.getRange()-1)){
							child.setRange(data.getRange()-1);
						}
					}
					data.addChild(child);
				}else{
					data.append(keyName, basicDBObject.get(keyName));
				}
			}				
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	

}
