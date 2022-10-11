package com.test.test_app.constants;

public final  class CoinDeskUrlConstant {
	private CoinDeskUrlConstant() {
		
	}
	public static final String URL_DOMAIN="https://api.coindesk.com/";
	public static final String HISTORICAL_PRICE_PATH="v1/bpi/historical/close.json?start=%1$s&end=%2$s&currency=%3$s";
	public static final String CURRENT_PRICE_PATH="v1/bpi/currentprice/%1$s.json";

	public static String getHistoricalPriceUrl(String startDate, String endDate, String currency) {
		return String.format(URL_DOMAIN+HISTORICAL_PRICE_PATH, startDate, endDate, currency.toLowerCase());  
	}
	public static String getCurrentPriceUrl(String currency) {
		return String.format(URL_DOMAIN+CURRENT_PRICE_PATH, currency.toLowerCase());  
	}
}
