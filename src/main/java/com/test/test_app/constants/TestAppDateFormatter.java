package com.test.test_app.constants;

public enum TestAppDateFormatter {

	ISO_DATE_FORMATER_WITH_OUT_TIME("yyyy-MM-dd");

	TestAppDateFormatter(String dateFormatparam) {
		this.dateFormat = dateFormatparam;
	}

	public final String dateFormat;

	public String getDateFormat() {
		return dateFormat;
	}
}
