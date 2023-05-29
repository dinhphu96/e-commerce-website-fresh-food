package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.poly.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig{

	@Autowired
	UserService userService;
	
	//mã hóa mât khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	
	
	//DỮ LIỆU ĐĂNG NHẬP
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(getPasswordEncoder());

		return authProvider;
	}

	
	//phần quyền sử dụng và hình thúc đăng nhập
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// tắt CSRF, CORS
		http.csrf().disable().cors().disable();
		
		
		//phân quyền sự dụng
		http.authorizeHttpRequests()
		.antMatchers("/rest/authorities").hasRole("DIRE")
		.antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
		.antMatchers("/order/**").authenticated()
		.anyRequest().permitAll();
		
		
		//Điều khiển lỗi không đúng vai trò
		http.exceptionHandling()
		.accessDeniedPage("/auth/access/denied");
		
		
		//GIAO DIỆN ĐĂNG NHẬP
//		http.httpBasic(); //của web
		
		
		//Giao diện đăng nhập form tự thiết kế
		http.formLogin()
		.loginPage("/security/login/form") //địa chỉ form
		.loginProcessingUrl("/security/login") //mặc định /login //submit form
		.defaultSuccessUrl("/product/list", false)  //form khi đăng nhập thành công(false: quay lại form ban đâù)
		.failureUrl("/security/login/error")  //form đăng nhâp thất baij
		.usernameParameter("username")
		.passwordParameter("password");
		
		http.rememberMe()
		.rememberMeParameter("remember")
		.tokenValiditySeconds(86400);
		
		//đăng xuất
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
		
		
		
				
				
				
		//OAuth2 - ĐĂNG NHẬP TỪ MẠNG XÃ HỘI
//		http.oauth2Login()
//			.loginPage("/auth/login/form")
//			.defaultSuccessUrl("/oauth2/login/success", true)
//			.failureUrl("/auth/login/error")
//			.authorizationEndpoint()
//				.baseUri("/oauth2/authorization");
		
		return http.build();
	}
	
	@Bean
	 public WebSecurityCustomizer webSecurityCustomizer() {
	     return (web) -> web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	 }

	
//	@Bean
//	public IgnoredRequestConfigurer configu(WebSecurity web) {
//		return web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
//	}
}
