package com.qcmall.order.facade.adapter;

import javax.jws.WebService;

import com.qcmall.order.facade.TestFacade;

@WebService(endpointInterface = "com.qcmall.order.facade.TestFacade", 
    targetNamespace = "http://order.api.ws.qcmall.com")
public class TestFacadeAdapter implements TestFacade {

    
    @Override
    public String sayHi() {
        return "hi";
    }

}
