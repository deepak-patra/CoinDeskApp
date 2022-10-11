package com.test.test_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskBitCoinDetails {
	private Double peackValue;
	private Double bottomValue;
	private Double currentBitCoinPrice;
	private String currency;
	private String startdate;
	private String enddate;

	@Override
	public String toString() {
		return "For  startdate=" + startdate + ", enddate=" + enddate + " The bitCoin peackValue=" + peackValue
				+ ", bottomValue=" + bottomValue + ", currentBitCoinPrice=" + currentBitCoinPrice + ", in currency="
				+ currency + "]";
	}

}
