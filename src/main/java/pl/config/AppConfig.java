package pl.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.model.Addon;
import pl.model.Authorities;
import pl.model.Dish;
import pl.model.DishAddon;
import pl.model.Drink;
import pl.model.History;
import pl.model.HistoryItem;
import pl.model.Pizza;
import pl.model.PizzaAddon;
import pl.model.Soup;
import pl.model.User;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("pl.dao"), @ComponentScan("pl.service") })
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {        
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
		
	    props.put(DRIVER, env.getProperty("mysql.driver"));
	    props.put(URL, env.getProperty("mysql.jdbcUrl"));
	    props.put(USER, env.getProperty("mysql.username"));
	    props.put(PASS, env.getProperty("mysql.password"));

	    // Setting Hibernate properties
	    props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

	    // Setting C3P0 properties
	    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
	    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

	    factoryBean.setHibernateProperties(props);
	    factoryBean.setAnnotatedClasses(User.class, Authorities.class, Pizza.class, Addon.class, PizzaAddon.class, Dish.class, DishAddon.class, Soup.class, Drink.class, History.class, HistoryItem.class);
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
}
