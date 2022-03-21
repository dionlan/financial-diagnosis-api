package com.mcf.diagnosis.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	/**
	 * Deinição de permissões para executar determinado endpoint hasRole("ADMIN")
	 * Role (grupo de usuários): PERFIL(admin, rh, contabilidade, usuario final, planejador)
	 * hasAuthority("CADASTRAR_USUARIOS) (PERMISSÕES de cada perfil) 
	 * CADA perfil tem suas authorities específicas. Ex.: ADMIN pode tudo
	 * 
	 * disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/usuarios/autenticar").permitAll()
			Não exige autenticação para esse método em específico, e para todos os outros exige
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/diagnostico/salvar").permitAll()
				.anyRequest().authenticated()
		.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and();
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		List<String> allowedOriginPatterns = new ArrayList<>();
        allowedOriginPatterns.add("*");
        config.setAllowedOriginPatterns(allowedOriginPatterns);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        
		
		CorsFilter corsFilter = new CorsFilter(source);
		
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(corsFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return filter;
	}
}
