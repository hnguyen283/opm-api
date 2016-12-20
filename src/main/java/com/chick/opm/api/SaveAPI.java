//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.api;

import java.util.Date;

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

import com.chick.opm.model.object.Data;
import com.chick.opm.service.common.CommonService;
import com.chick.opm.service.common.RouterService;
import com.chick.opm.service.partial.CollectionService;
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
	
	@RequestMapping(value = "/byName/{name}", method = RequestMethod.POST)
	public Object ByName(@RequestBody BasicDBObject data,@PathVariable("name") String name) {
		if(data != null){
			Date Start = new Date();  
			Data dataOb = commonService.ReadConverter(data, name);
			Object ob = collectionService.save(dataOb);
			Date End = new Date();
			logger.debug((End.getTime() - Start.getTime()));
			if(ob instanceof Data){
				return ((Data) ob).toMap();
			}else return ob;
		}else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);	
	}
}
