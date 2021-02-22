package com.javastudio.tutorial;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class MainConfiguration extends Configuration {

    private final JerseyClientConfiguration jerseyClientConfiguration = new JerseyClientConfiguration();

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }
}
