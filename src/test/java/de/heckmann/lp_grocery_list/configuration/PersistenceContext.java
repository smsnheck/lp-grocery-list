package de.heckmann.lp_grocery_list.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath:persistence.properties")
@ImportResource(value={	"classpath:applicationContext.xml" })
public class PersistenceContext {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource datasource() {

		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("db.driver"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("db.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.password"));

		return dataSource;
	}

}
