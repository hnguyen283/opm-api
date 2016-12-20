//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.common;

import org.springframework.stereotype.Service;

import com.chick.opm.model.object.Data;
import com.chick.opm.service.inter.ResponeMessageService;

/**
 * @author Hung Dong Nguyen
 *
 */
@Service("ResponeMessageService")
public class ResponeMessageServiceImpl implements ResponeMessageService{
	
	private static final String ID = "MESSAGE";
	private static final String TYPE = "MESSAGE_TYPE";
	private static final String DETAIL = "MESSAGE_DETAIL";
	
	private static final String ERROR_MESSAGE_LABEL = "ERROR_MESSAGE";
	private static final String WARMING_MESSAGE_LABEL = "WARMING_MESSAGE";
	private static final String INFORMATION_MESSAGE_LABEL = "INFORMATION_MESSAGE";
	
	private static Data messageData = null;	
	
	/* (non-Javadoc)
	 * @see com.chick.opm.service.inter.ResponeMessageService#createErrorMessage(java.lang.String)
	 */
	@Override
	public Data toErrorMessage(String message) {
		message(message);
		ResponeMessageServiceImpl.messageData.setObName(ResponeMessageServiceImpl.ERROR_MESSAGE_LABEL);
		ResponeMessageServiceImpl.messageData.put(ResponeMessageServiceImpl.TYPE, ResponeMessageServiceImpl.ERROR_MESSAGE_LABEL);
		return ResponeMessageServiceImpl.messageData;
	}

	/* (non-Javadoc)
	 * @see com.chick.opm.service.inter.ResponeMessageService#createWarmingMessage(java.lang.String)
	 */
	@Override
	public Data toWarmingMessage(String message) {
		message(message);
		ResponeMessageServiceImpl.messageData.setObName(ResponeMessageServiceImpl.WARMING_MESSAGE_LABEL);
		ResponeMessageServiceImpl.messageData.put(ResponeMessageServiceImpl.TYPE, ResponeMessageServiceImpl.WARMING_MESSAGE_LABEL);
		return ResponeMessageServiceImpl.messageData;
	}

	/* (non-Javadoc)
	 * @see com.chick.opm.service.inter.ResponeMessageService#createInformationMessage(java.lang.String)
	 */
	@Override
	public Data toInformationMessage(String message){
		message(message);
		ResponeMessageServiceImpl.messageData.setObName(ResponeMessageServiceImpl.INFORMATION_MESSAGE_LABEL);
		ResponeMessageServiceImpl.messageData.put(ResponeMessageServiceImpl.TYPE, ResponeMessageServiceImpl.INFORMATION_MESSAGE_LABEL);
		return ResponeMessageServiceImpl.messageData;
	}

	/* (non-Javadoc)
	 * @see com.chick.opm.service.inter.ResponeMessageService#message(java.lang.String)
	 */
	private void message(String message) {
		ResponeMessageServiceImpl.messageData = new Data();
		ResponeMessageServiceImpl.messageData.setId(ResponeMessageServiceImpl.ID);
		ResponeMessageServiceImpl.messageData.put(ResponeMessageServiceImpl.DETAIL, message);		
	}
	
}
