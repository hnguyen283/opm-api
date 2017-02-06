//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.partial;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chick.opm.dao.CollectionDAO;
import com.chick.opm.model.object.Data;
import com.chick.opm.service.common.CommonService;
import com.chick.opm.service.inter.ServiceStructure;
import com.mongodb.BasicDBList;

@Service("CollectionService")
public class CollectionService implements ServiceStructure{
	
	private static final Logger logger = Logger.getLogger(CollectionService.class);

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
	
	public Object dropById(String id, String collectionName) {
		Data data = dao.getById(id, collectionName);	
		return dao.dropCollection(data.prepareToSave(new ArrayList<>()));	
	}
	
	public ArrayList<Data> getByNameQuerry(String obName, Data query, ArrayList<List<Data>> childsHolder) {
		ArrayList<Data> result = new ArrayList<Data>();
		ArrayList<Data> arrayData = query.getLeafs(new ArrayList<Data>());
		ArrayList<Data> nextArrayData = new ArrayList<Data>();
		for(Data elementData : arrayData){
			childsHolder.add((List<Data>) dao.getCollectionByQuery(elementData, false));
			if(!elementData.isRoot()){
				Data tempData = elementData.getParent();
				if(tempData.removeChild(elementData))
				nextArrayData.add(tempData);
				else logger.error("Cannot remove child " +  elementData.getObName() + " of " +  tempData.getObName());
			}
		}
		
		ArrayList<ArrayList<Data>> parentsHolder = new ArrayList<ArrayList<Data>>();
		if(nextArrayData.size() > 0){
			for(Data nextQuerry : nextArrayData){
				for(List<Data> itemList : childsHolder){					
					if(nextQuerry.containsKey(itemList.get(0).getObName())){
						for(Data item : itemList){
							try{
								nextQuerry.append(item.getObName(), new ObjectId(item.getId()));
								parentsHolder.add(this.getByNameQuerry(obName, nextQuerry, new ArrayList<List<Data>>()));								
							}catch(Exception e){								
								logger.error("Cannot replace element :" +  item.toJson() + " \n Item Id: "  + item.getId());
							}
						}
					}
				}
			}
		}else{
			
		}
//		Data data = dao.getById(id, collectionName);	
		return null;	
	}
	
}
