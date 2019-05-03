package com.michaelcgood;

import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.michaelcgood.dao.SystemRepository;
import com.michaelcgood.model.SystemExample;

@SpringBootApplication
@EnableJpaRepositories("com.michaelcgood.dao")
public class MysqlJdbcDriverApplication implements CommandLineRunner {


	@Autowired
	DataSource dataSource;

	@Autowired
	SystemRepository systemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MysqlJdbcDriverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// add windows server
		//systemExampleWindows.setName("Selva");
		//systemExampleWindows.setLastaudit("2017-08-11");
		//systemRepository.findByname("Selva");
		//System.out.println(systemRepository.findByname("Selva"));
		//systemRepository.deleteAll();

		
		// add rhel
		//systemExampleRhel.setName("RHEL 7");
		//systemExampleRhel.setLastaudit("2017-07-21");
		//systemRepository.save(systemExampleRhel);
		// add solaris
		//systemExampleSolaris.setName("Solaris 11");
		//systemExampleSolaris.setName("Paul Walker");
		//systemExampleSolaris.setLastaudit("2017-08-13");
			

	}
	

}
