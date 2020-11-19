package com.cajasmota.jcconf.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WSError {

    @NonNull
    private String message;

    private Object data;
}
