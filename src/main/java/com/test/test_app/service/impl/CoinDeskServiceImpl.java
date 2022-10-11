package com.test.test_app.service.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.test_app.constants.CoinDeskUrlConstant;
import com.test.test_app.constants.TestAppConstant;
import com.test.test_app.dto.response.BitCoinHistoricalDateResponse;
import com.test.test_app.dto.response.CoinDeskBitCoinCurrencyDetailResponse;
import com.test.test_app.dto.response.CoinDeskCurrentpriceResponse;
import com.test.test_app.dto.response.CoinDeskHistoricalDateResponse;
import com.test.test_app.exception.BusinessException;
import com.test.test_app.service.BitCoinService;
import com.test.test_app.service.ExternalService;
@Service
public class CoinDeskServiceImpl implements BitCoinService {
	@Autowired
	private ExternalService externalService;

	// we should return Custom Object so that when required to pass multiple it will
	// be less change
	@Override
	public Double getMinbitCoinPrice(final BitCoinHistoricalDateResponse bitCoinHistoricalDateResponse) {
		final CoinDeskHistoricalDateResponse coinDeskHistoricalDateResponse = (CoinDeskHistoricalDateResponse) bitCoinHistoricalDateResponse;
		Optional<Entry<String, Double>> minOptional = coinDeskHistoricalDateResponse.getBpi().entrySet().stream()
				.min(Map.Entry.comparingByValue());
		return minOptional.isPresent() ? minOptional.get().getValue() : TestAppConstant.ZERO;
	}

	// we should return Custom Object so that when required to pass multiple it will
	// be less change
	@Override
	public Double getMaxBitCoinPrice(final BitCoinHistoricalDateResponse bitCoinHistoricalDateResponse) {
		final CoinDeskHistoricalDateResponse coinDeskHistoricalDateResponse = (CoinDeskHistoricalDateResponse) bitCoinHistoricalDateResponse;
		Optional<Entry<String, Double>> maxOptional = coinDeskHistoricalDateResponse.getBpi().entrySet().stream()
				.max(Map.Entry.comparingByValue());
		return maxOptional.isPresent() ? maxOptional.get().getValue() : TestAppConstant.ZERO;
	}

	@Override
	public CoinDeskHistoricalDateResponse bitCoinHistoryApiCall(final String currency, final String startDate,
			final String endDate) {

		String url = CoinDeskUrlConstant.getHistoricalPriceUrl(startDate, endDate, currency);
		ResponseEntity<CoinDeskHistoricalDateResponse> response = externalService.callExternalService(url, new HttpEntity<Object>(null),
				HttpMethod.GET, new ParameterizedTypeReference<CoinDeskHistoricalDateResponse>() {
				});
		if (null == response || null == response.getBody() || null == response.getBody().getBpi()) {
			// for current days api is returning empty response
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}

		return response.getBody();

	}

	private CoinDeskCurrentpriceResponse bitCoinCurrentPriceApiCall(final String currency) {

		String url = CoinDeskUrlConstant.getCurrentPriceUrl(currency);
		ResponseEntity<CoinDeskCurrentpriceResponse> response = externalService.callExternalService(url, null,
				HttpMethod.GET, new ParameterizedTypeReference<CoinDeskCurrentpriceResponse>() {
				});
		if (null == response || null == response.getBody() || null == response.getBody().getBpi()) {
			// for current days api is returning empty response
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}

		return response.getBody();

	}

	@Override
	public Double getBitCoinCurrentPrice(final String currency) {
		CoinDeskCurrentpriceResponse coinDeskCurrentpriceResponse = bitCoinCurrentPriceApiCall(currency);
		if (null == coinDeskCurrentpriceResponse) {
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}
		Map<String, CoinDeskBitCoinCurrencyDetailResponse> bpiResponse = coinDeskCurrentpriceResponse.getBpi();
		if (null == bpiResponse || bpiResponse.size() == 0) {
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}
		CoinDeskBitCoinCurrencyDetailResponse coinDeskBitCoinCurrencyDetailResponse = bpiResponse
				.get(currency.toUpperCase());
		if (null == coinDeskBitCoinCurrencyDetailResponse) {
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}
		Double rateFloat = coinDeskBitCoinCurrencyDetailResponse.getRateFloat();
		if (null == rateFloat) {
			throw new BusinessException(TestAppConstant.EMPTY_RESPONSE);
		}
		return rateFloat;
	}

}
