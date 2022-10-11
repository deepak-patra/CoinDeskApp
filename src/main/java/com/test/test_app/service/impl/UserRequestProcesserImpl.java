package com.test.test_app.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test_app.constants.TestAppConstant;
import com.test.test_app.constants.TestAppDateFormatter;
import com.test.test_app.dto.response.BitCoinHistoricalDateResponse;
import com.test.test_app.dto.response.CoinDeskBitCoinDetailResponse;
import com.test.test_app.dto.response.CoinDeskBitCoinDetails;
import com.test.test_app.exception.BusinessException;
import com.test.test_app.exception.RequestValidationException;
import com.test.test_app.service.BitCoinService;
import com.test.test_app.service.UserRequestProcesser;
import com.test.test_app.util.Utils;
@Service
public class UserRequestProcesserImpl implements UserRequestProcesser {
	@Autowired
	private BitCoinService bitCoinService;
	@Override
	public String processRequest(final String currencyParam) {
		if(null == currencyParam || currencyParam.length()==0) {
			System.out.println("Currency type cant be empty.");
			return "";
		}
	    final String currency = currencyParam.trim();
		final CoinDeskBitCoinDetailResponse response = new CoinDeskBitCoinDetailResponse();
		try {
			final Calendar date = Calendar.getInstance();
			// -365is there cause, recent data is not available 
			date.add(Calendar.DAY_OF_MONTH, TestAppConstant.MINUS_NO_DAYS);
			String endDate = Utils.convertDateToString(TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME, date);
			String startDate = Utils.getPreviousDate(90, TestAppDateFormatter.ISO_DATE_FORMATER_WITH_OUT_TIME);
			final BitCoinHistoricalDateResponse bitCoinHistoricalDateResponse = bitCoinService
					.bitCoinHistoryApiCall(currency, startDate, endDate);
			final Double maxValue = bitCoinService.getMaxBitCoinPrice(bitCoinHistoricalDateResponse);
			final Double bottomValue = bitCoinService.getMinbitCoinPrice(bitCoinHistoricalDateResponse);
			final Double currentPrice = bitCoinService.getBitCoinCurrentPrice(currency);
			response.setBitCoinDetails(
					new CoinDeskBitCoinDetails(maxValue, bottomValue, currentPrice, currency, startDate, endDate));
		} catch (BusinessException | RequestValidationException e) {
			response.setErrorMsg(e.getMessage());
		}
		System.out.println("__+++______");
		System.out.println(response.toString());
		return response.toString();
	}


}
