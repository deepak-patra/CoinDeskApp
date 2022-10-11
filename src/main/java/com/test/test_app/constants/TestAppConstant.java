package com.test.test_app.constants;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.test.test_app.configuration.JavaScriptMessageConverter;

public final class TestAppConstant {
	public static final String EXIT = "exit";
	public static final String EMPTY_STRING = "";
	//public static final RestTemplate REST_TEMPLATE = restTemplate();
	public static final int MINUS_ONE = -1;
	public static final Double ZERO = 0.0D;
	/**
	 * The Constant retryErrorCode. 408 Request Timeout 409 Conflict - RETRY 423
	 * Locked - RETRY 429 Too Many Requests 502 Bad Gateway 503 Service Unavailable
	 * 504 Gateway Timeout
	 */
	public static final List<Integer> RETRY_ERROR_CODE = new UnmodifiableList<>(
			Arrays.asList(408, 409, 423, 429, 502, 503, 504));
	public static final List<Integer> REQUEST_VALIDATION_ERROR_CODE = new UnmodifiableList<>(Arrays.asList(404, 400));
	public static final String UNEXPECTED_ERROR = "Unexpected error has occured";
	public static final String EMPTY_RESPONSE = "Empty response returned from API";
	public static final int MINUS_NO_DAYS = -365;

	private TestAppConstant() {

	}
	

}
