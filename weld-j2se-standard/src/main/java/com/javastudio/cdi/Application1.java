package com.javastudio.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.ExecutionException;

public class Application1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application1.class);

    public static void main(String[] args) {
        SeContainer container = null;
        try {
            SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
            container = containerInit.initialize();

            // Fire synchronous event that triggers the code in App class.
            Application1 application = container.select(Application1.class).get();

            application.run();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (container != null)
                container.close();
        }
    }

    void run() {
        LOGGER.info("Weld standalone java application started!");
    }
}
