package com.test.test_app.service.impl;

import java.util.ArrayList;
import java.util.List;

public class DataServiceImpl { //implements DataService

	// used as a storage layer 
	private final static List<Object> data = new ArrayList<>();
	
	private ExternalServiceImpl externalServiceImpl = new ExternalServiceImpl();
}
