package com.tobeto.pair9.core.utilities.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {


    @JsonProperty("isSuccess")
    private boolean success;

    private String message ="Success";

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public BaseResponse() {

    }
}
