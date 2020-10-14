package cn.codewoo.config;

import io.swagger.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author kehong
 * swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfo("在线课堂", "在线课堂",
                "1.0", "codewoo.cn",
                ApiInfo.DEFAULT_CONTACT,
                " ","codewoo.cn",new ArrayList<>());
    }

    @Bean
    @Autowired
    public Docket docket(ApiInfo apiInfo){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.codewoo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
