package com.test.test_app;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.test.test_app.constants.TestAppDateFormatter;
import com.test.test_app.util.Utils;

class UtilTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 33}) 
	void GetPreviousDate_Pass_YesterdayWithPositiveValue(int number) {
		final Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DATE, -1*number);
	    String yesterdaysDate = Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, currentDate);
		Assertions.assertEquals(yesterdaysDate, Utils.getPreviousDate(number, TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME));
	}
	@ParameterizedTest
	@ValueSource(ints = { -1, -2, -33}) 
	void GetPreviousDate_Pass_YesterdayWithNegetiveValue(int number) {
		final Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DATE, 1*number);
		String yesterdaysDate = Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, currentDate);
		Assertions.assertEquals(yesterdaysDate, Utils.getPreviousDate(number, TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME));
	}
	@Test
	void ConvertDateToString_Pass_DateFormatCheck() {
		final Calendar date = Calendar.getInstance();
		// calendar month starts from 0
		date.set(Calendar.MONTH, 10-1); 
		date.set(Calendar.DAY_OF_MONTH, 30); 
		date.set(Calendar.YEAR, 2022); 
		String actualDate = Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, date);
		Assertions.assertEquals("2022-10-30",actualDate);
	}

}
