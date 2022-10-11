package com.test.test_app.dto.response;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskCurrentpriceResponse extends BitCoinCurrentpriceResponse{
private CoinDeskCurrentPriceUpdatedTime time;
private String disclaimer;
private Map<String, CoinDeskBitCoinCurrencyDetailResponse> bpi;
}
