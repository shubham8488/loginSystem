package loginSystem.loginSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class MyConfig {

	@Bean
	public BCryptPasswordEncoder pe() {
		return new BCryptPasswordEncoder();
	}

	// @Bean
	// public UserDetailsService userDetailsService() {
	// return new CustomUserDetailsService();
	// }
	
	@Bean
	public SecurityFilterChain filterChin(HttpSecurity http) throws Exception {
	
//		  
//		  http.csrf().disable(). authorizeHttpRequests() .requestMatchers("/contact/**")
//		  .hasRole("USER") .requestMatchers("/admin/**") .hasRole("ADMIN")
//		  .anyRequest() .permitAll() .and() .formLogin();
		 
		  http.csrf().disable(). authorizeHttpRequests((auth) -> 
		  
		  {
			try {
					auth .requestMatchers("/user/**") .authenticated(). anyRequest().permitAll().and().formLogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		  
		  
		  
//
//		http.csrf().disable().cors().disable().authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER")
//				.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.exceptionHandling().authenticationEntryPoint(entryPoint);

//		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailService();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setUserDetailsService(this.userDetailsService());
		dap.setPasswordEncoder(this.pe());
		return dap;
		
	}

}
