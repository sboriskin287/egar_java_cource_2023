package org.example.service;

import org.example.annotation.PortalTransactional;
import org.springframework.stereotype.Service;

@Service
@PortalTransactional
public class ProfileService {

    @PortalTransactional
    public String someWorkWithDbInTx() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("executing tx");
        return "result in tx";
    }

    public String someWorkWithDb() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "result";
    }
}
