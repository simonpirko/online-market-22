package by.tms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Simon Pirko on 19.11.23
 */

@Configuration
@ComponentScan("by.tms")
@EnableWebMvc
@EnableTransactionManagement
public class SpringConfiguration {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/pages/");
		internalResourceViewResolver.setSuffix(".html");
		return internalResourceViewResolver;
	}


}
