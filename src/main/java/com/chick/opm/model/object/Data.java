//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.object;

import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chick.opm.model.ab.Profile;
import com.chick.opm.service.common.CommonService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mongodb.BasicDBList;

@JsonInclude(Include.NON_NULL)
@Document
public class Data extends Profile  {
	
	private static final Logger logger = Logger.getLogger(Data.class);
	
	@Transient
	private Data parent = null;
	@Transient
	private LinkedList<Data> childs = null;
	@Transient
	private LinkedList<Data> brothers = null;	
	@Transient
	private String action = null;
	@Transient
	private int range = CommonService.DEFAULT_RANGE_FIELD;
		
	public Data() {
		this.childs = new LinkedList<Data>();
		this.brothers = new LinkedList<Data>();
	}
	
	public Data(String obName) {
		super(null, obName, null);
		this.childs = new LinkedList<Data>();
		this.brothers = new LinkedList<Data>();
	}	
		
	public Data(Data parent, LinkedList<Data> childs, LinkedList<Data> brothers) {
		super();
		this.parent = parent;
		this.childs = childs;
		this.brothers = brothers;
	}

	public boolean isEmpty(){
		return (this.parent==null && (this.childs==null || this.childs.size()==0) &&  (this.brothers==null ||this.brothers.size()==0));
	}
	
	public boolean isLeaf(){
		return (this.childs==null || this.childs.size()==0);
	}
	
	public boolean isRoot(){
		return this.parent==null;
	}
	
	
	public boolean addChild(Data child){
		try{
			ObjectId IdOb = null;
			if(child.getId()!=null){
				IdOb = new ObjectId(child.getId());
			}else{
				IdOb = new ObjectId();
				child.setId(IdOb.toHexString());
			}
			if(this.range!=CommonService.DEFAULT_RANGE_FIELD){
				this.append(child.getObName(),child);
			}else this.append(child.getObName(),IdOb);
			child.setParent(this);
			Boolean result = this.childs.add(child);	
			for(Data brother : this.childs){
				child.addBrother(brother);
			}
			if(result){
				logger.debug("Added child: " + this.getObName() + "'s " + child.getObName() + " / " + child.getId() + " / " +  IdOb.toHexString());
				return true;
			}else 
			return false;
		} catch(Exception e){
			logger.error("ERROR Add child: " + this.getObName() + "'s " + child.getObName() + " / " + child.getId());
			logger.error(e.getMessage());
			return false;
		}
	}
	
	public boolean removeChild(Data child){
		try{
			this.remove(child.getObName());
			Boolean result = this.childs.remove(child);
			for(Data brother : this.childs){
				brother.getBrothers().remove(child);
			}
			if(result){
				logger.debug("Remove child: " + this.getObName() + "'s " + child.getObName() + " / " + child.getId() + " / " +  child.getId());
				return true;
			}else 
			return false;
		} catch(Exception e){
			logger.error("ERROR Remove child: " + this.getObName() + "'s " + child.getObName() + " / " + child.getId());
			logger.error(e.getMessage());
			return false;
		}
	}
	
	public boolean addChild(Object [] childs){
		String objectName = isSameObjectType(childs);
		// If all of elements have same object name, result is that name, otherwise is null 
		if(objectName != null){
			BasicDBList dbList = new BasicDBList();
			for(Object childObs : childs){
				ObjectId IdOb = null;
				if(childObs instanceof Data){
					Data child = (Data) childObs;
					if(child.getId()!=null){
						IdOb = new ObjectId(child.getId());
					}else{
						IdOb = new ObjectId();
						child.setId(IdOb.toHexString());
					}
					if(this.range!=CommonService.DEFAULT_RANGE_FIELD){
						dbList.add(child);
					}else dbList.add(IdOb);
					child.setParent(this);
					this.childs.add(child);	
					logger.debug("Added child: " + this.getObName() + "'s " + child.getObName() + " / " + child.getId() + " / " +  IdOb.toHexString());
					for(Data brother : this.childs){
						child.addBrother(brother);
					}
				}else {
					dbList.add(childObs);
				}
			}
			this.append(objectName, dbList);
			return true;
		}else return false;
	}
	
	private String isSameObjectType(Object [] childsObs){
		String result = null;
		for(int i = 0; i < childsObs.length; i++){
			if(childsObs[i] instanceof Data){				
				Data child = (Data) childsObs[i];
				if(result == null) result = child.getObName();
				else{					
					if(!(child.getObName().equalsIgnoreCase(result)))
						return null;
					else result = child.getObName();
				}
			}
		}
		return result;
	}
		
	public boolean addBrother(Data brother){
		//Check is parent exist 
		if(brother.getParent() == null){
			brother.setParent(this.parent);
		}else if (!brother.getParent().equals(this.parent)){
			if(brother.getParent() == null && this.parent != null){
				brother.setParent(this.parent);
			}else if(brother.getParent() != null && this.parent == null){
				this.setParent(brother.getParent());
			}else{				
				logger.debug("Don't know parent or different parent");
				return false;
			}
		}		
		//check is register to parent
		if(!this.parent.getChilds().contains(brother)){
			if(!this.parent.addChild(brother)) return false;
		}
		this.brothers.add(brother);		
		//check is register to brother
		if(!brother.getBrothers().contains(this)){
			if(!brother.addBrother(this)) return false;
			else return true;
		}else return true;
	}
		
	public ArrayList<Data> prepareToSave(ArrayList<Data> list){
		if(this.isLeaf()){
			list.add(this);
			return list;
		} else {
			for(Data node: this.getChilds()){
				node.prepareToSave(list);
			}
			list.add(this);
			if(this.isRoot())
				list.add(this);
			return list;
		} 
	}
	
	public ArrayList<Data> getListObjectInData(ArrayList<Data> list, int Range, boolean fromRoot){
		if(Range < 0){
			return list;
		}else{			
			if(fromRoot){
				if(this.isRoot()){
					list.add(this);
					return list;
				} else {
					for(Data node: this.getBrothers()){
						node.getListObjectInData(list, --Range, fromRoot);
					}
					list.add(this);
					if(this.isLeaf())
						list.add(this);
					return list;
				} 
			}else{			
				if(this.isLeaf()){
					list.add(this);
					return list;
				} else {
					for(Data node: this.getChilds()){
						node.getListObjectInData(list, --Range, fromRoot);
					}
					list.add(this);
					if(this.isRoot())
						list.add(this);
					return list;
				} 
			}
		}
	}

	public Data getParent() {
		return parent;
	}

	public void setParent(Data parent) {
		this.parentId = parent.getId();
		this.put(CommonService.PARENT_FIELD, new ObjectId(this.parentId));
		this.parent = parent;
	}

	public LinkedList<Data> getChilds() {
		return childs;
	}

	public void setChilds(LinkedList<Data> childs) {
		this.childs = childs;
	}

	public LinkedList<Data> getBrothers() {
		return brothers;
	}

	public void setBrothers(LinkedList<Data> brothers) {
		this.brothers = brothers;
	}

	@Override
	public void setId(String id) {
		try{
			this.put(CommonService.ID_FIELD, new ObjectId(id));
		}catch(java.lang.IllegalArgumentException ex){
			this.put(CommonService.ID_FIELD, id);
		}
		super.setId(id);
	}	
	
	@Override
	public void setParentId(String parentId) {
		try{
			this.put(CommonService.PARENT_FIELD, new ObjectId(parentId));
		}catch(java.lang.IllegalArgumentException ex){
			this.put(CommonService.PARENT_FIELD, parentId);
		}
		super.setParentId(parentId);
	}

	public Data exportData(){
		Data dataRoot = this;
		if(dataRoot.isLeaf()){
			
			dataRoot.put(CommonService.ID_FIELD,objectToStringId(dataRoot.get(CommonService.ID_FIELD)));
			dataRoot.put(CommonService.PARENT_FIELD,objectToStringId(dataRoot.get(CommonService.PARENT_FIELD)));

			return dataRoot;
		}else {
			ArrayList<String> listNameOfArrays = this.getListNameOfArrays();
			for(String nameKeySet : this.keySet()){
				Object objValue = dataRoot.get(nameKeySet);
				if(listNameOfArrays.contains(nameKeySet)){
					if(objValue instanceof BasicDBList){
						BasicDBList basicList = (BasicDBList) objValue;
						for (int i = 0; i < basicList.size();i++){
							if(basicList.get(i) instanceof ObjectId){
								ObjectId objElementId = (ObjectId) basicList.get(i);
								Data dataElement = dataRoot.getDataById(objElementId.toHexString(), dataRoot.getChilds());
								if(dataElement!=null){
									basicList.put(i, dataElement.exportData());
								}else{
									logger.debug("Can't find Element ID: " + objElementId.toHexString() + " In " + nameKeySet);										
								}										
							}
						}
						dataRoot.put(nameKeySet, basicList);						
					} else if(objValue instanceof ObjectId){
						try{							
							dataRoot.put(nameKeySet,dataRoot.getDataByName(nameKeySet, dataRoot.getChilds()).exportData());
						}catch (NullPointerException e){
							logger.error(e.getMessage());
						}
					}
				}else{					
					if(objValue instanceof ObjectId && !nameKeySet.equalsIgnoreCase(CommonService.ID_FIELD)){
						try{
							dataRoot.put(nameKeySet,dataRoot.getDataByName(nameKeySet, dataRoot.getChilds()).exportData());							
						}catch (NullPointerException e){
							logger.error(e.getMessage());
						}						
					}
				}
			}
			
			dataRoot.put(CommonService.ID_FIELD,objectToStringId(dataRoot.get(CommonService.ID_FIELD)));
			dataRoot.put(CommonService.PARENT_FIELD,objectToStringId(dataRoot.get(CommonService.PARENT_FIELD)));
			
			return dataRoot;
		}
		
	}
	
	private ArrayList<String> getListNameOfArrays(){
		ArrayList<String> arrayLists = new ArrayList<>();
		for(String keySetChild : this.keySet()){
			Object objValue = this.get(keySetChild);
			if(objValue instanceof ArrayList){
				arrayLists.add(keySetChild);
			}	
		}
		return arrayLists;
	}
	
	private Data getDataById(String id, LinkedList<Data> datas){
		for(int i = 0; i < datas.size();i++){
			if(datas.get(i).getId().equalsIgnoreCase(id))return datas.get(i);
		}
		return null;
	}
	
	private Data getDataByName(String name, LinkedList<Data> datas){
		for(int i = 0; i < datas.size();i++){
			if(datas.get(i).getObName().equalsIgnoreCase(name))return datas.get(i);
		}
		return null;
	}
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.append(CommonService.RANGE_FIELD, range);
		this.range = range;
	}
	
//	public boolean isSame(Data data){
//		for(String dataElement : data.keySet()){
//			Object objElement = this.get(dataElement);
//			if(objElement instanceof ArrayList){
//				arrayLists.add(keySetChild);
//			}else{
//				
//			}
//		}
//	}
	
	public ArrayList<Data> getLeafs(ArrayList<Data> list){
		if(this.isLeaf()){
			list.add(this);
			return list;
		} else {
			for(Data node: this.getChilds()){
				node.getLeafs(list);
			}
			return list;
		} 
	}
	
	public ArrayList<Data> removeLeafs(ArrayList<Data> list){
		if(this.isLeaf()){
			return list;
		} else {
			for(Data node: this.getChilds()){
				node.removeLeafs(list);
			}
			list.add(this);
			if(this.isRoot())
				list.add(this);
			return list;
		} 
	}
	
	public Data getQuerry(boolean isNeedId){
		if(this.isLeaf()){
			if(this.getId()!=null && !isNeedId){
				this.remove(CommonService.ID_FIELD);
				this.setId(null);
			}
			return this;
		} else {
			for(Data node: this.getChilds()){
				node.getQuerry(isNeedId);
			}
			return this;
		} 
	}		
	
	private String objectToStringId(Object obj){
		try{
			ObjectId objId = (ObjectId) obj;
			return objId.toHexString();			
		}catch(java.lang.ClassCastException castException){
			logger.error(castException.getMessage());
			return null;
		}catch(java.lang.NullPointerException nullException){
			logger.warn(nullException.getMessage());
			return null;
		}
	}
	
}
