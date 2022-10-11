package com.test.test_app;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.test.test_app.constants.CoinDeskUrlConstant;
import com.test.test_app.constants.TestAppDateFormatter;
import com.test.test_app.util.Utils;

public class CoinDeskUrlConstantTest {
	@Test
	void GetCurrentPriceUrl_Pass_LowerCaseInput() {
		final Calendar date = Calendar.getInstance();
		// calendar month starts from 0
		date.set(Calendar.MONTH, 10-1); 
		date.set(Calendar.DAY_OF_MONTH, 30); 
		date.set(Calendar.YEAR, 2022); 
		String url = CoinDeskUrlConstant.getCurrentPriceUrl("eur");
		Assertions.assertEquals("https://api.coindesk.com/v1/bpi/currentprice/eur.json",url);
	}
	@Test
	void GetCurrentPriceUrl_Pass_UpperCaseInput() {
		final Calendar date = Calendar.getInstance();
		// calendar month starts from 0
		date.set(Calendar.MONTH, 10-1); 
		date.set(Calendar.DAY_OF_MONTH, 30); 
		date.set(Calendar.YEAR, 2022); 
		String url = CoinDeskUrlConstant.getCurrentPriceUrl("EUR");
		Assertions.assertEquals("https://api.coindesk.com/v1/bpi/currentprice/eur.json",url);
	}
	@Test
	void GetHistoricalPriceUrl_Pass_UrlFormation() {
		final Calendar date = Calendar.getInstance();
		String endDate = Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, date);
		String url = CoinDeskUrlConstant.getHistoricalPriceUrl(Utils.getPreviousDate(90, TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME),endDate, "EUR");
		System.out.println(url);
		Assertions.assertEquals("https://api.coindesk.com/v1/bpi/historical/close.json?start="+Utils.getPreviousDate(90, TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME)+"&end="+Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, date)+"&currency=eur",url);
	}
	
}
