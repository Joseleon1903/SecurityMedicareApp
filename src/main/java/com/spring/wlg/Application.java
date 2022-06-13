package com.spring.wlg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * = Application
 *
 * Project version: {projectVersion}.
 *
 * Sample Java application in project *{projectName}* 
 * to show Asciidoclet as replacement for the
 * default Javadoclet.
 *
 * include::README.adoc[]
 *
 * We can apply Asciidoc syntax in our Javadoclet comments, like:
 *
 *  - `code`
 *  - **bold**
 *  - _italics_
 *
 * @author eruiz
 */
@SpringBootApplication(exclude = {ServletWebServerFactoryAutoConfiguration.class})
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
