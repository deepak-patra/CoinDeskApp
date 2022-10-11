package com.test.test_app.dto.request;

import java.util.UUID;
public class BaseRequestObject {
   protected final String requestId = UUID.randomUUID().toString(); 
}
