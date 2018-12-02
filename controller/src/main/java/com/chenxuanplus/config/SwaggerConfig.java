package com.chenxuanplus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @Author chenxuan
 * @Description  Swagger配置
 * @Date 3:29 PM 2018/12/2
 * @Param 
 * @return 
 **/
@Configuration
@ConditionalOnProperty(prefix = "swagger", value = {"enable"}, havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.application.version}")
    String applicationVersion;
	/*
        @Value("${swagger.appId}")
        String appId;

        @Value("${swagger.publicKey}")
        String publicKey;

        @Value("${swagger.privateKey}")
        String privateKey;

        @Value("${swagger.platformPublicKey}")
        String platformPublicKey;

        @Value("${openApiInterceptor.urlPatterns}")
        String pattern;
    */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.chenxuanplus"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("sleeperframework APIS")
				.description("test by swigger")
				.termsOfServiceUrl("http://www.baidu.com")
				.version(applicationVersion)
				.build();
	}

/*	@Bean
	@Order(5)
	public FilterRegistrationBean swaggerFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.addUrlPatterns(pattern);
		registration.setName("swaggerFilter");
		registration.setOrder(Integer.MIN_VALUE + 100);
		return registration;
	}*/
}
