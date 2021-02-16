package com.javastudio.cdi;

import com.javastudio.cdi.api.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Inject
    private ProductService productService;

    public static void main(String[] args) {
        SeContainer container = null;
        try {
            SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
            container = containerInit.initialize();

            // Fire synchronous event that triggers the code in App class.
            Application application = container.select(Application.class).get();

            application.run();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (container != null)
                container.close();
        }
    }

    void run() {
        LOGGER.info("Cdi se container started!");
        productService.ok();
    }
}
