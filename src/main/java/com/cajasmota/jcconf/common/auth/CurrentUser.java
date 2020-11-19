package com.cajasmota.jcconf.common.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentUser {

    private Long id;
    private String name;
    private String email;

}
