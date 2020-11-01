package com.suraj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/** created by @author suraj on 23/05/20 */
/** updated by @author danielepelleg on 01/11/20 */
@EnableSwagger2
@Configuration
public class HeaderConfig {

    // -- Global Request Parameter (Headers) List --
    //  This parameter header-type will get automatically
    //  added in all APIS (in Swagger)
    private List<RequestParameter> globalParameterList() {

        RequestParameter host  =
                new RequestParameterBuilder()
                        .name("Host")
                        .in(ParameterType.HEADER)
                        .required(true)
                        .description("Specifies the host and port number of the server to which the request is being sent.\n" +
                                        "If no port is included, the default port for the service requested " +
                                        "(e.g., 443 for an HTTPS URL, and 80 for an HTTP URL) is implied.")
                        .build();

        RequestParameter xForwardedFor  =
                new RequestParameterBuilder()
                        .name("x-Forwarded-For")
                        .in(ParameterType.HEADER)
                        .required(true)
                        .description("Identify the originating IP address of a client connecting to a web server " +
                                        "through an HTTP proxy or a load balance")
                        .build();

        return Arrays.asList(host, xForwardedFor);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .globalRequestParameters(globalParameterList())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
