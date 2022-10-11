package com.test.test_app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.test.test_app.constants.TestAppConstant;
import com.test.test_app.constants.TestAppDateFormatter;

public final class Utils {
	private Utils() {
	}

	/**
	 * Gets the previous date. Pass the no of days you want to subtract from current
	 * 
	 * @param noOfDays   the no of days
	 * @param dateFormat the date format
	 * @return the previous date
	 */
	public static String getPreviousDate(int noOfDays, TestAppDateFormatter dateFormat) {
		Calendar currentDate = Calendar.getInstance(Locale.getDefault());
		currentDate.add(Calendar.DAY_OF_MONTH, TestAppConstant.MINUS_NO_DAYS);
		currentDate.add(Calendar.DAY_OF_MONTH, TestAppConstant.MINUS_ONE * Math.abs(noOfDays));
		return convertDateToString(dateFormat, currentDate);
	}

	/**
	 * Convert date to string.
	 *
	 * @param dateFormat the date format
	 * @param currentDate the current date
	 * @return the string
	 */
	public static String convertDateToString(TestAppDateFormatter dateFormat, Calendar currentDate) {
		return new SimpleDateFormat(dateFormat.getDateFormat(), Locale.getDefault()).format(currentDate.getTime());
	}

}
