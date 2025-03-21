package com.example.assment.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title="Process and Analyze Data",
                description = "A Spring Boot application to process, analyze, and expose location metadata via REST APIs",
                summary = "This script processes the provided JSON files, merges data, analyzes valid location points per type, "
                		+ "calculates average ratings, finds the location with the highest reviews, and identifies any incomplete data entries. "
                		+ "Let me know if you need any refinements ",
                termsOfService = "Term and Condition",
                contact = @Contact(
                name = "Nitesh Pandey",
                email = "nkpandey7759@gmail.com"
                ),
                license = @License(
                name ="your License No"
                ),
                version ="3.2.1"
                ),
        servers = {
            @Server(
            description ="Dev",
                    url="http://localhost:8080"
            ),
            @Server(
            description ="test",
                    url="http://localhost:8080"
            )
        },
      security =   @SecurityRequirement(name = "authBearer")
)
@SecurityScheme(
        name ="authBearer",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        description = "Security desc",
        scheme = "bearer"
)
public class SwggerConfig {
    
}

