package com.test.test_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskBitCoinDetailResponse {
	private  CoinDeskBitCoinDetails bitCoinDetails;
	private String errorMsg;
	@Override
	public String toString() {
		return null == errorMsg || errorMsg.length()==0 ? bitCoinDetails.toString(): errorMsg;
	}

}
