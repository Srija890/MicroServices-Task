package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("bootstrap.properties")
public class MuzixApplication
{
	public static void main(String[] args)
	{
		// Starting the spring boot
		SpringApplication.run(MuzixApplication.class, args);
	}

}

