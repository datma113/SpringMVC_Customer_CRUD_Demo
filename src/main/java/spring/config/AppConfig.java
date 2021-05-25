package spring.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("spring")
public class AppConfig implements WebMvcConfigurer{
	
	
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource myDatasource = new BasicDataSource();
		
		myDatasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		myDatasource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=spring_customer_tk");
		myDatasource.setUsername("sa");
		myDatasource.setPassword("sapassword");
		
		return myDatasource;
	}
	
	@Bean
	public LocalSessionFactoryBean factoryBean() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		
		factory.setDataSource(basicDataSource());
		factory.setPackagesToScan("spring.entity");
		factory.setHibernateProperties(getHibernateProps());
		
		return factory;
	}

	private Properties getHibernateProps() {
		Properties p = new Properties();
		
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return p;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory factory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(factory);
		return txManager;
	}
	
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/views/");
		
		return resolver;
	}
	
	
	
}
