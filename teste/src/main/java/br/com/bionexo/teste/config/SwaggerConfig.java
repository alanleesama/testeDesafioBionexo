package br.com.bionexo.teste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bionexo.teste.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(metaData());

	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("API UBS - Localidades mais próximas")
				.description("API que traz os hospitais mais próximos das coordenadas passadas").version("1.0")
				.contact(new Contact("Alan Ricarte Salomão", "", "ricartealan@hotmail.com")).build();
	}

}
