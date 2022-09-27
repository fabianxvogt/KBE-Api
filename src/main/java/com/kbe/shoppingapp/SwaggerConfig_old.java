package com.kbe.shoppingapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig_old {

    /* 
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

    
	private Predicate<String> apiPaths() {
        return or(
		 or(
            regex("/user/*"), 
            regex("/product/*")
        ),
        or(
            regex("/currency/*"),
            regex("/price/*")
        ));
	}
    	/**
	 * Method to set paths to be included through swagger
	 *
	 * @return Docket
	 *
	@Bean
	public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
				.paths(apiPaths()).build();
	}


	/**
	 * Method to set swagger info
	 *
	 * @return ApiInfoBuilder
	 *
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("").description("").version("1.0").build();
	}

}

*/