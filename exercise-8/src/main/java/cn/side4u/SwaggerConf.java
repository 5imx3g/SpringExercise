package cn.side4u;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
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
public class SwaggerConf {
	@Bean
	public Docket createRestApi() {
		/*
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(Tag("ExamDef Entity", "鑰冭瘯淇℃伅"),
              Tag("ExamDefItem Entity", "鑰冭瘯绉戠洰淇℃伅"))
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.apis(RequestHandlerSelectors.any())
                .apis(or(RequestHandlerSelectors.withClassAnnotation(RepositoryRestResource::class.java),
                        RequestHandlerSelectors.withClassAnnotation(RepositoryRestController::class.java)))
                .apis(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc"))
                .apis(RequestHandlerSelectors.basePackage("com.khidi.report.server.repository"))
				.paths(PathSelectors.any())
				.build();
		*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("cn"))
                .paths(PathSelectors.any())
                .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Excercise 8 API").description("演示 Spring 和 Swagger 的集成")
				.termsOfServiceUrl("http://localhost:8080/")
				.contact(new Contact("孙亖", "http://www.side4u.cn", "techcave@foxmail.cn"))
//                .contact("瀛欎簴")
				.version("1.0").build();
	}
}
