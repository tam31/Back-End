package com.ssafy.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//Swagger-UI 확인
//http://localhost/swagger-ui.html

//@OpenAPIDefinition(
//	    info = @Info(
//	        title = "SSAFY Board API 명세서",
//	        description = "<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 Board API<br><img src=\"/assets/img/ssafy_logo.png\" width=\"150\">",
//	        version = "v1",
//	        contact = @Contact(
//	            name = "hissam",
//	            email = "hissam@ssafy.com",
//	            url = "http://edu.ssafy.com"
//	        )
//	    )
//	)

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info().title("Project API 명세서").description(
				"<h3>Project API Reference for Developers</h3>Project API<br>")
				.version("v1").contact(new io.swagger.v3.oas.models.info.Contact().name("태민, 영서")
						.url("https://lab.ssafy.com/anijam12/pjt_daejeon_11th_class8_spring_team3"));

		return new OpenAPI().components(new Components()).info(info);
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("Board").pathsToMatch("/board/**").build();
	}

	@Bean
	public GroupedOpenApi commentApi() {
		return GroupedOpenApi.builder().group("User").pathsToMatch("/user/**").build();
	}
	
	@Bean
	public GroupedOpenApi userApi() {
		return GroupedOpenApi.builder().group("Comment").pathsToMatch("/comment/**").build();
	}
	
	@Bean
	public GroupedOpenApi planApi() {
		return GroupedOpenApi.builder().group("Plan").pathsToMatch("/plan/**").build();
	}
}