package com.qcmall.order.facade;

import javax.jws.WebService;

@WebService(targetNamespace = "http://order.api.ws.qcmall.com")
public interface TestFacade {
    
    String sayHi();

}
