package com.javastudio.cdi;

import com.javastudio.cdi.api.ProductService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Inject
    ProductService productService;

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Application application = container.instance().select(Application.class).get();
        application.run();
        weld.shutdown();
    }

    void run() {
        LOGGER.info("Weld standalone java application started!");
        productService.ok();
    }
}
