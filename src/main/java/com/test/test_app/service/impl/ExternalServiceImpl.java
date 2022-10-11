package com.test.test_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.test.test_app.constants.ErrorConstant;
import com.test.test_app.constants.TestAppConstant;
import com.test.test_app.exception.BusinessException;
import com.test.test_app.exception.RequestValidationException;
import com.test.test_app.service.ExternalService;
@Service
public class ExternalServiceImpl  implements ExternalService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public <T> ResponseEntity<T> callExternalService(final String endPoint,
            final HttpEntity<Object> httpEntity, final HttpMethod method,
            final ParameterizedTypeReference<T> clazz) {
        ResponseEntity<T> responseEntity = null;
        if (null == restTemplate) {
            throw new BusinessException("restTemplate is empty" +
                    ErrorConstant.SERVER_ERROR);
        }
        try {
            responseEntity = restTemplate.exchange(endPoint, method, httpEntity, clazz);
        } catch (HttpStatusCodeException ex) {

            HttpStatus statusCode = ex.getStatusCode();
            // TestAppConstant.RETRY_ERROR_CODE
            if (TestAppConstant.REQUEST_VALIDATION_ERROR_CODE.contains(statusCode.value())) {
            	throw new RequestValidationException(ex.getMessage());
            }

            throw new BusinessException(TestAppConstant.UNEXPECTED_ERROR);
        }
        return responseEntity;
    }
}
