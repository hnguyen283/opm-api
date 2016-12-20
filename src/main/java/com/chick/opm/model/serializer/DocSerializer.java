//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.model.serializer;

import java.io.IOException;

import com.chick.opm.model.object.Data;
import com.chick.opm.model.object.Doc;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Hung Dong Nguyen
 *
 */
public class DocSerializer extends JsonSerializer<Doc> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
	 * com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Doc doc, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		JsonFactory jfactory = new JsonFactory();
		Data data = (Data)doc.getData();
		/*** read from file ***/
		JsonParser jParser = jfactory.createJsonParser(data.toJson());
		
		// loop until token equal to "}"
		while (jParser.nextToken() != JsonToken.END_OBJECT) {

			String fieldname = jParser.getCurrentName();
			
			if(data.containsKey(fieldname)){
				
			}
			
			if ("name".equals(fieldname)) {

			  // current token is "name",
	                  // move to next, which is "name"'s value
			  jParser.nextToken();
			  System.out.println(jParser.getText()); // display mkyong

			}
			
			if ("messages".equals(fieldname)) {

			  jParser.nextToken(); // current token is "[", move next

			  // messages is array, loop until token equal to "]"
			  while (jParser.nextToken() != JsonToken.END_ARRAY) {

	                     // display msg1, msg2, msg3
			     System.out.println(jParser.getText());

			  }

			}

		  }
		  jParser.close();
		gen.writeObjectField("data",null);
		gen.writeEndObject();
	}

}
