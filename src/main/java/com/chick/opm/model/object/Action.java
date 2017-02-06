//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.object;

import com.chick.opm.model.ab.Profile;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Action extends Profile{
	private String type;
	private String event;
	private String rootElement;
	private String effectElement;
	
	public Action() {
		super(null,"action", null);
	}	
	public Action(String type, String event, String rootElement, String effectElement) {
		super(null,"action", null);
		this.type = type;
		this.event = event;
		this.rootElement = rootElement;
		this.effectElement = effectElement;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getRootElement() {
		return rootElement;
	}
	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}
	public String getEffectElement() {
		return effectElement;
	}
	public void setEffectElement(String effectElement) {
		this.effectElement = effectElement;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

		
}
