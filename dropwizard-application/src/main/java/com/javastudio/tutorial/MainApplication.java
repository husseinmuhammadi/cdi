package com.javastudio.tutorial;

import com.javastudio.tutorial.resource.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;

public class MainApplication extends Application<MainConfiguration> {

    private static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        try {
            new MainApplication().run(args);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void run(MainConfiguration configuration, Environment environment) throws Exception {
        final Client client = new JerseyClientBuilder(environment)
                .using(configuration.getJerseyClientConfiguration())
                .build(getName());

        environment.jersey().register(ProductResource.class);
    }
}
