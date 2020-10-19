package cn.codewoo.config;

import cn.codewoo.constant.Constants;
import io.swagger.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
        List<Parameter> parameters = new ArrayList<>();
        Parameter parameter = new ParameterBuilder()
                .name(Constants.AUTHENTICATED_TOKEN.toString())
                .description("用户凭证")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(parameter);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(true)
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.codewoo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
