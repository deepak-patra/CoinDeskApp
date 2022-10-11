package com.test.test_app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.test_app.service.UserRequestProcesser;

@SpringBootTest
@ActiveProfiles("test")
public class TestApplication {
	public static final String CURRENCY_NOT_FOUND="404 Not Found: \"Sorry, that currency was not found\"";
	public static final String SUCCESS_FOUND="For  startdate=2021-07-13, enddate=2021-10-11 The bitCoin peackValue=49757.573, bottomValue=25295.6699, currentBitCoinPrice=18682.2522, in currency=EUR]";
	@Autowired
	private UserRequestProcesser userRequestProcesser;
	@Test
	void ProcessRequest_Pass_ValidCurrency() {
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest("eur"));
	}
	@Test
	void ProcessRequest_Pass_ValidCurrencyInUpperCase() {
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest("EUR"));
	}
	@Test
	void ProcessRequest_Pass_ValidCurrencyInLowerCase() {
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest("eUr"));
	}
	@Test
	void ProcessRequest_Pass_ValidCurrencyWithSpace() {
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest("   eur"));
	}
	@Test
	void ProcessRequest_Fail_InvalidCurrency() {
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest("t"));
	}
	@Test
	void ProcessRequest_Pass_Empty() {
		
		Assertions.assertEquals(TestApplication.CURRENCY_NOT_FOUND,userRequestProcesser.processRequest(""));
	}
}
