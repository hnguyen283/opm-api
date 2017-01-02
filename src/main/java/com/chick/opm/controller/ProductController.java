//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Hung Dong Nguyen
 *
 */
@Controller("ProductController")
@RequestMapping("/product")
public class ProductController {
	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public String AdminUser(ModelMap model,@PathVariable("type") String type) {	
		return "products/dashboard";
	}
}
