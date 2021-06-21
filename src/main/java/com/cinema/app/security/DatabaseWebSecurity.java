package com.cinema.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("SELECT u.userName, u.pass, u.status  FROM users u WHERE userName=?")
		.authoritiesByUsernameQuery("SELECT u.userName, r.role FROM users u "+
									"INNER JOIN roles r ON u.idRole = r.id "+
								    "WHERE u.userName =?");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/cinema/**").hasAuthority("ADMIN")
		.antMatchers("/cinema").hasAuthority("ADMIN")
		.antMatchers("/user/**").hasAuthority("ADMIN")
		.antMatchers("/user").hasAuthority("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
