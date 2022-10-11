package com.test.test_app.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskBitCoinCurrencyDetailResponse {
	
	private String code;
	private String rate;
	private String description;
	@JsonProperty("rate_float")
	private Double rateFloat;
}
