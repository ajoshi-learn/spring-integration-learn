package edu.arturjoshi.ex1;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class MyHelloService implements HelloService {

    @Override
    @ServiceActivator
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
