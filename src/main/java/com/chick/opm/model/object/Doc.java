//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.object;

import com.chick.opm.model.serializer.DocSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(Include.NON_NULL)
@JsonSerialize(using = DocSerializer.class)
public class Doc{
	/**
	 * 
	 */
	private Doc parentDoc;
	private String docName;
	private UserInterface ui;
	private Object data;
	private Doc childDoc;
	
	public Doc getParentDoc() {
		return parentDoc;
	}
	public void setParentDoc(Doc parentDoc) {
		this.parentDoc = parentDoc;
	}
	public UserInterface getUi() {
		return ui;
	}
	public void setUi(UserInterface ui) {
		this.ui = ui;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Doc getChildDoc() {
		return childDoc;
	}
	public void setChildDoc(Doc childDoc) {
		this.childDoc = childDoc;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}

	
}
