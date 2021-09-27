package com.organization.common.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({"classpath:oracleApplication.properties","classpath:application.yml","classpath:oraclePROD.properties"})
//@PropertySource("classpath:h2DBApplication.properties")
public class JDBCDataBaseConfiguration {

	// 1- Reading values from file

	@Autowired
	Environment env;

	// 2- creating bean for the DataSouce by assign to DB details by using
	// DataSoureBuilder

	@Bean
	//@Primary
	@Profile("dev")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("db.driverName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.userName"));
		dataSource.setPassword(env.getProperty("db.password"));
		// dataSource.setConnectionProperties(getProperties());

		return dataSource;
	}
	
	@Bean
	@Profile("prod")
	
	public DataSource getDataSource_Prod() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl(env.getProperty("prod.url"));
		String property = env.getProperty("prod.driverName");
		dataSource.setDriverClassName(property);
		dataSource.setUsername(env.getProperty("prod.userName"));
		dataSource.setPassword(env.getProperty("prod.password"));
		// dataSource.setConnectionProperties(getProperties());

		return dataSource;
	}

	/*
	 * @Bean public DataSource getDataSourceForH2DataBase() {
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * 
	 * dataSource.setDriverClassName(env.getProperty("h2.datasource.driverClassName"
	 * )); dataSource.setUrl(env.getProperty("h2.datasource.url"));
	 * dataSource.setUsername(env.getProperty("h2.datasource.username"));
	 * dataSource.setPassword(env.getProperty("h2.datasource.password")); //
	 * dataSource.setConnectionProperties(getProperties());
	 * 
	 * return dataSource; }
	 */

}
