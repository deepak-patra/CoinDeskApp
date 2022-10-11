package com.test.test_app.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface ExternalService {


	<T> ResponseEntity<T> callExternalService(String endPoint, HttpEntity<Object> httpEntity, HttpMethod method,
			ParameterizedTypeReference<T> clazz);

}
