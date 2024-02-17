package com.tobeto.pair9.core.utilities.results;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataResult<T> extends BaseResponse {


    private T data;

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public DataResult(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data) {
        super();
        this.data = data;
    }
}
