package com.cajasmota.jcconf.common.interceptor;


import com.cajasmota.jcconf.common.exceptions.WSException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Provider
public class StandardResponseInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        Object entity = context.getEntity();
        StandardResponse response = new StandardResponse();

        if(entity instanceof WSException){

            WSException ex = (WSException) entity;
            response.setSuccess(false);
            response.setMessage(ex.getMessage());

        } else {

            response.setSuccess(true);
            response.setMessage("Request executed successfully");
            response.setData(entity);
        }

        context.setEntity(response);
        context.setType(StandardResponse.class);

        context.setMediaType(MediaType.APPLICATION_JSON_TYPE);
        context.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);

        context.proceed();
    }
}
