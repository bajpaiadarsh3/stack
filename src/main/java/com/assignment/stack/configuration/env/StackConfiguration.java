package com.assignment.stack.configuration.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author adarshbajpai
 * created 19/02/2021
 */

@Component
@ConfigurationProperties(prefix="app.stack")
public class StackConfiguration {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
