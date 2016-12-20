//*******************************************************************************
// * Copyright (c) 2016 Hung Dong Nguyen.
// * Copyright (C) 2016 Hung Dong Nguyen. - All rights reserved.
// *
// ******************************************************************************
package com.chick.opm.service.inter;

import com.chick.opm.model.object.Data;

/**
 * @author Hung Dong Nguyen
 *
 */
public interface ResponeMessageService {
	public Data toErrorMessage(String message);
	public Data toWarmingMessage(String message);
	public Data toInformationMessage(String message);
}
