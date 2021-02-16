package com.javastudio.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            // Fire synchronous event that triggers the code in App class.
            Application application = container.select(Application.class).get();

            application.run();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    void run() {
        LOGGER.info("Cdi se container started!");
    }
}
