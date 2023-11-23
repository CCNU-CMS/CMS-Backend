import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.builders.PathSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("action-swagger").description("swagger实战").termsOfServiceUrl("")
                .version("1.0").build();
    }

    private List<Parameter> setHeaderToken() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder userId = new ParameterBuilder();
        userId.name("token").description("用户TOKEN").modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
        pars.add(userId.build());
        return pars;
    }
}
