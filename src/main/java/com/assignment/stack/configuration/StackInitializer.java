package com.assignment.stack.configuration;

import com.assignment.stack.configuration.env.StackConfiguration;
import com.assignment.stack.model.SimpleStack;
import com.assignment.stack.model.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author adarshbajpai
 * created 19/02/2021
 */

@Configuration
public class StackInitializer {

    @Autowired
    private StackConfiguration stackConfiguration;


    @Bean
    public Stack<Integer> integerStack(){
        return new SimpleStack<>(stackConfiguration.getSize());
    }

}
