package cn.gotham.spring_security_01.common.config;

import io.swagger.annotations.ApiOperation;
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

/**
 * Swagger2Config 配置
 * @author tanchong
 * Create Date: 2020/3/8
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spring_security_01")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("RESTful风格接口")
                .termsOfServiceUrl("https://blog.csdn.net/qq_37707251")
                .version("1.0")
                .contact(new Contact("Tan Chong", "https://github.com/", "1097172038@qq.com"))
                .build();
    }
}
