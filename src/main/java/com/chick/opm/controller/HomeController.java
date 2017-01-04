//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("HomeController")
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String AdminUser(ModelMap model) {	
		return "home/index";
	}
	
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String Service(ModelMap model) {	
		return "service/service";
	}
}
