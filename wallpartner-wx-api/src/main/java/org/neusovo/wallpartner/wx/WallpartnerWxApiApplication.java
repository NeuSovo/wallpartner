package org.neusovo.wallpartner.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"org.neusovo.wallpartner"})
@EnableJpaAuditing
public class WallpartnerWxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WallpartnerWxApiApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.neusovo.wallpartner.wx.controller")) //过滤的接口
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(apiKey()));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger")
                .version("0.0.1")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }
}
