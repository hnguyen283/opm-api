//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chick.opm.model.object.Data;
import com.chick.opm.service.common.CommonService;
import com.chick.opm.service.common.RouterService;
import com.chick.opm.service.partial.CollectionService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/**
 * @author Hung Dong Nguyen
 *
 */
@RestController("DropAPI")
@RequestMapping("/drop")
public class DropAPI {
	private static final Logger logger = Logger.getLogger(DropAPI.class);
	@Autowired
	@Qualifier("CollectionService")
	private CollectionService collectionService;
	
	@Autowired
	@Qualifier("RouterService")
	private RouterService routerService;
	
	@Autowired
	@Qualifier("CommonService")
	private CommonService commonService;
	
	@RequestMapping(value = "/byId/{dataName}/{id}", method = RequestMethod.GET)
	public Object Byid(ModelMap model,@PathVariable("id") String id,@PathVariable("dataName") String dataName) {
		Date Start = new Date();  
		Map map = ((Data) collectionService.dropById(id, dataName)).exportData().toMap();
		Date End = new Date();
		logger.debug("time done process : " + (End.getTime() - Start.getTime()));
		return map;
	}
	
	@RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
	public Object ByName(ModelMap model,@PathVariable("name") String name) {
		Date Start = new Date();  
		List<Data> arrayData = (List<Data>)collectionService.get(name);
		BasicDBList datas = new BasicDBList();
		for(int i = 0; i < arrayData.size();i++){
			datas.add(arrayData.get(i).exportData().toMap());
		}
		Date End = new Date();
		logger.debug("time done process : " + (End.getTime() - Start.getTime()));
		return datas;
	}
}
