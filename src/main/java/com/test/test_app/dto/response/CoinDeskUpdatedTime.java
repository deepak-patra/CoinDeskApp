package com.test.test_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDeskUpdatedTime {
	private String updated;
	private String updatedISO;
}
