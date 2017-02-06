//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chick.opm.dao.CollectionDAO;
import com.chick.opm.model.object.Data;
import com.chick.opm.service.common.CommonService;
import com.chick.opm.service.common.ResponeMessageServiceImpl;
import com.chick.opm.service.common.RouterService;
import com.chick.opm.service.inter.ResponeMessageService;
import com.chick.opm.service.partial.CollectionService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

@RestController("SaveAPI")
@RequestMapping("/save")
public class SaveAPI {	
	private static final Logger logger = Logger.getLogger(SaveAPI.class);
	@Autowired
	@Qualifier("CollectionService")
	private CollectionService collectionService;
	
	@Autowired
	@Qualifier("RouterService")
	private RouterService routerService;
	
	@Autowired
	@Qualifier("CommonService")
	private CommonService commonService;
	
	@Autowired
	@Qualifier("ResponeMessageService")
	private ResponeMessageService responeMessageService;
	
	@RequestMapping(value = "/byName/{name}", method = RequestMethod.POST)
	public Object ByName(@RequestBody Object dataReq,@PathVariable("name") String name) {
		if(dataReq != null){
			Date Start = new Date();  
			if(dataReq instanceof HashMap){
				BasicDBObject data = new BasicDBObject();
				data.putAll(((HashMap)dataReq));				
				Data dataOb = commonService.ReadConverter(data, name);
				Object ob = collectionService.save(dataOb);
				Date End = new Date();
				logger.debug((End.getTime() - Start.getTime()));
				if(ob instanceof Data){
					return ((Data) ob).toMap();
				}else return ob;
			}else if(dataReq instanceof ArrayList) {
				ArrayList data = (ArrayList) dataReq;
				BasicDBList result = new BasicDBList();
				try{
					for(Object object :  data){
						if(object instanceof HashMap){					
							BasicDBObject dataEle = new BasicDBObject();
							dataEle.putAll(((HashMap) object));
							Data dataOb = commonService.ReadConverter(dataEle, name);
							Object ob = collectionService.save(dataOb);
							if(ob instanceof Data){
								Data responseData = (Data) ob;
								if(responseData.getId().equalsIgnoreCase(ResponeMessageServiceImpl.ID) ){
									if(((String) responseData.get(ResponeMessageServiceImpl.DETAIL)).equalsIgnoreCase(CollectionDAO.SUCCESS)){
										result.add(dataOb.getId());
									}									
								}
							}else result.add(dataOb.getId());
						}
					}
					Date End = new Date();
					logger.debug("time done process : " + (End.getTime() - Start.getTime()));					
					return result;
				}catch (Exception e){
					return responeMessageService.toErrorMessage(e.getMessage()).toMap();
				}
			}else {
				return responeMessageService.toErrorMessage("DATA TYPE NOT SUPPORT").toMap();
			}			
		}else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);	
	}
}
