package com.test.test_app.dto.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BaseResponseObject.
 */
@Data
@NoArgsConstructor
public class BaseResponseObject {
   @JsonIgnore
   protected final String requestId = UUID.randomUUID().toString(); 
}
