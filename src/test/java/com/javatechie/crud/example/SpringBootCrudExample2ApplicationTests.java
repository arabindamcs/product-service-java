package com.javatechie.crud.example;

import com.javatechie.crud.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.javatechie.crud.example.security.jwt.*;
import org.springframework.boot.test.context.TestConfiguration;


//@SpringBootTest
class SpringBootCrudExample2ApplicationTests {

    /*
	@Test
    void contextLoads() {
        System.out.println("Test Pass");
    }
	*/

}
