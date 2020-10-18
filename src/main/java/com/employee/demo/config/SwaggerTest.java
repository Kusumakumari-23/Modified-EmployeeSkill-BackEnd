package com.employee.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerTest {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(pathDetails())
				.build();
	}
	
	private Predicate<String> pathDetails(){
		return PathSelectors.regex("/.*");
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Employee and Skills API Documentation")
				.description("Employee and Skills Details")
				.termsOfServiceUrl("http://www.kumari.com")
				.contact(new Contact("KusumaKumari", "https://google.com", "kumarikusuma@gmail.com"))
				.license("Standard API License")
				.licenseUrl("https://google.com")
				.version("1.0")
				.build();
	}
}

