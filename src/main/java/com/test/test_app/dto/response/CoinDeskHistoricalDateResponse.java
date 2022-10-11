package com.test.test_app.dto.response;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskHistoricalDateResponse extends BitCoinHistoricalDateResponse {
	private Map<String, Double> bpi;
	private String disclaimer;
	private CoinDeskUpdatedTime updatedTime;
}
