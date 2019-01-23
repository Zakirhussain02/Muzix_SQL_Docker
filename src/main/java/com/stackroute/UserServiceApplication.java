/*
main class for run
 */

package com.stackroute;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class UserServiceApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

	@Autowired
	MuzixRepository muzixRepository;
	public static void main(String[] args)
	{
		SpringApplication.run(UserServiceApplication.class, args);
	}

	//ApplicationListener
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
		muzixRepository.save(new Muzix(1,"heart beat","Enrique"));
	}


	@Override
	public void run(String... args) throws Exception {
		muzixRepository.save(new Muzix(2,"lonely","Enrique"));
	}
}

