package com.vadmin.config;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev000
 * @date  2021/3/11 10:33
 * @return 
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(prefix = "vadmin.swagger2", name = "enabled", havingValue = "true")
public class Swagger2Config {

    private Logger log = LoggerFactory.getLogger(Swagger2Config.class);

    @Resource
    private Swagger2Properties swagger2Properties;

    public Swagger2Config() {
        log.debug("swagger2 [{}]", swagger2Properties);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8088")
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(setHeaderToken());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title(swagger2Properties.getTitle())
                // 文档描述
                .description(swagger2Properties.getDescription())
                .version(swagger2Properties.getVersion())
                .license("MIT 协议")
                .licenseUrl("http://www.opensource.org/licenses/MIT")
                .build();
    }

    private List<RequestParameter> setHeaderToken() {
        List<RequestParameter> parameters = Lists.newArrayList();
        parameters.add(new RequestParameterBuilder()
                .in(ParameterType.HEADER)
                .name("token")
                .description("token令牌")
                .required(false)
                .build());

        return parameters;
    }
}

