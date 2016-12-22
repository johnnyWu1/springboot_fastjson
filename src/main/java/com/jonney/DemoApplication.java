package com.jonney;

import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.base.Predicate;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
//@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	
	@Configuration
	public static class BeanConfiguration {
		protected BeanConfiguration() {
		}
		
		@Bean
		public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
			FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
			return converter;
		}
		
		@Bean
	    public Docket swaggerSpringMvcPlugin() {
	        ApiInfo apiInfo = new ApiInfoBuilder().title("testtitle").description("desc").build();
			return null;
	    }

		static private Predicate<String> regex(String string) {
			return new Predicate<String>() {
				@Override
				public boolean apply(String arg0) {
					return Pattern.matches(string, arg0);
				}
			};
		}
		
	}




	
}
