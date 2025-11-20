package za.co.nedbank.configuration;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Value("${spring.application.name}")
    private String title;
    @Value("${spring.application.group}")
    private String group;
    @Value("${spring.application.version}")
    private String version;
    @Value("${spring.application.description}")
    private String description;

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group(group)
                .displayName(title)
                .addOpenApiCustomizer(e -> e
                        .info(new Info()
                                .title(title)
                                .version(version)
                                .description(description))
                )
                .build();
    }
}
