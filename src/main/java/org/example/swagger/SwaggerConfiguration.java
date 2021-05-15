package org.example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {
    /**
     * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */

    public static final String PATH = "/spring-app";

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("org.example"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringAppB")
                .description("Learning Purpose")
                .version("v1")
                .termsOfServiceUrl("Terms of service")
                .license("example.org")
                .licenseUrl("https://swagger.io/docs/")
                .build();

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        final String apiDocs = "/v1/api-docs";
        final String configUi = "/swagger-resources/configuration/ui";
        final String configSecurity = "/swagger-resources/configuration/security";
        final String resources = "/swagger-resources";

        registry.addRedirectViewController(PATH + apiDocs, apiDocs).setKeepQueryParams(true);
        registry.addRedirectViewController(PATH + resources, resources);
        registry.addRedirectViewController(PATH + configUi, configUi);
        registry.addRedirectViewController(PATH + configSecurity, configSecurity);
        registry.addRedirectViewController(PATH, "/");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PATH + "/**").addResourceLocations("classpath:/META-INF/resources/");
    }
}
