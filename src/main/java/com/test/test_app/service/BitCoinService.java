package com.test.test_app.service;

import com.test.test_app.dto.response.BitCoinHistoricalDateResponse;

public interface BitCoinService {

	Double getMinbitCoinPrice(BitCoinHistoricalDateResponse bitCoinHistoricalDateResponse);

	Double getMaxBitCoinPrice(BitCoinHistoricalDateResponse bitCoinHistoricalDateResponse);

	BitCoinHistoricalDateResponse bitCoinHistoryApiCall(String currency, String startDate, String endDate);

	//BitCoinCurrentpriceResponse bitCoinCurrentPriceApiCall(String currency);

	Double getBitCoinCurrentPrice(String currency);


}
