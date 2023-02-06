package com.devmountain.noteApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Create a public Java Class file called 'Config'. Then annotate the class with  '@Configuration'
@Configuration
public class Config {
    //Create a public field (aka public member variable) called 'passwordEncoder' with Type 'PasswordEncoder' w/ the '@Bean' annotation
    //Have the class return a 'new BCryptPasswordEncoder()'
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
