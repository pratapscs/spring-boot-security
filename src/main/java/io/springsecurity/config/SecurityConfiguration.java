package io.springsecurity.config;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired DataSource dataSourse;
	 */

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Set your configuration on the auth object - for in Memory Authentication
		/*
		 * auth.inMemoryAuthentication().withUser("vinay").password("vinay").roles(
		 * "USER").and().withUser("pratap") .password("pratap").roles("ADMIN");
		 */

		// for JDBC authentication
		/*
		 * auth.jdbcAuthentication().dataSource(dataSourse).withDefaultSchema()
		 * .withUser(User.withUsername("user").password("pratap").roles("USER"))
		 * .withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
		 */

		// for JDBC authentication - with query
		/*
		 * auth.jdbcAuthentication().dataSource(dataSourse)
		 * .usersByUsernameQuery("select username,password, enabled from users where username = ?"
		 * )
		 * .authoritiesByUsernameQuery("select username, authority from authorities where username = ?"
		 * );
		 */

		// for JPA authentication
		// auth.userDetailsService(userDetailsService);

		// for LDAP authentication
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
				.url("ldap://localhost:8389/dc=springframework,dc=org").and().passwordCompare()
				.passwordEncoder(new BCryptPasswordEncoder()).passwordAttribute("userPassword");
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers(
	 * "/user").hasAnyRole("ADMIN", "USER")
	 * .antMatchers("/").permitAll().and().formLogin(); }
	 */

	/*
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	// for LDAP authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}
}