package com.example.repit;
 
import com.example.repit.entities.*;
import com.example.repit.methods.*;
import com.example.repit.repositories.AuthenticationRepository;
import com.example.repit.repositories.TutorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class RepitApplication implements ApplicationRunner {
	@Autowired
	AuthenticationMethods authenticationMethods;

	@Autowired
	LessonMethods lessonMethods;

	@Autowired
	StudentMethods studentMethods;

	@Autowired
	TutorMethods tutorMethods;

	@Autowired
	AdvertisementMethods advertisementMethods;

	public static void main(String[] args) {
		SpringApplication.run(RepitApplication.class, args);
	}
	public void run(ApplicationArguments args) {
		Tutor tutor;
		tutor = tutorMethods.getByID(3);
		Advertisement advertisement=new Advertisement(1000,new Date(),"math");
		advertisement.setTutor(tutor);
		tutor.getAdvertisements().add(advertisement);
		tutorMethods.save(tutor);

	}
}
