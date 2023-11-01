package ru.egartech.config;

import ru.egartech.PortalPrototypeBean;

@FunctionalInterface
public interface PortalPrototypeBeanSupplier {

    PortalPrototypeBean supplyPortalPrototypeBean();
}
