package com.suraj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

/** created by @author suraj on 23/05/20 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

  // pass the global parameter list here - this will get added in all apis (in swagger)
  // automatically
  private List<Parameter> globalParameterList() {
    return Collections.singletonList(
        new ParameterBuilder()
            .name("AUTH-TOKEN")
            .modelRef(new ModelRef("string"))
            .required(true)
            .parameterType("header")
            .description("Basic Auth Token")
            .build());
  }

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .forCodeGeneration(true)
        .globalOperationParameters(globalParameterList())
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any())
        .build();
  }
}
