package com.cajasmota.jcconf.common.interceptor;

import lombok.Data;

@Data
public class StandardResponse {

    private boolean success;
    private String message;
    private Object data;

}
