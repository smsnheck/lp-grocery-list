package de.heckmann.lp_grocery_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseConfigurer;

@Configuration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = {EmbeddedDatabaseConfigurer.class})
public class Application {

	public static void main(String[] args) {

				SpringApplication.run(Application.class, args);

		System.out.println("Application has started.");
	}
}
