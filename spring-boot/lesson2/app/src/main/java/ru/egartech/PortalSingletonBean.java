package ru.egartech;

import java.util.function.Supplier;

public class PortalSingletonBean {

    private final Supplier<PortalPrototypeBean> protoFactory;

    public PortalSingletonBean(
            Supplier<PortalPrototypeBean> protoFactory) {
        this.protoFactory = protoFactory;
    }

    public void printCurrCourse() {
        try {
            System.out.println(protoFactory
                    .get()
                    .getCurrencyCource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
