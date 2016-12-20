//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("EndpointListAPI")
@RequestMapping("/common")
public class EndpointListAPI {

	@RequestMapping(value = "/endpoint-list", method = RequestMethod.GET)
	public Map ByName(ModelMap model) {
		Map endpointList = new HashMap<>();
		endpointList.put("ACCOUNT_LIST", "account-list");
		return endpointList;
	}
}
