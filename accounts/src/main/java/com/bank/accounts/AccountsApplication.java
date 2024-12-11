package com.bank.accounts;

import com.bank.accounts.dto.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.*;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts API",
				version = "1.0",
				description = "Accounts API",
				contact = @Contact(
						name = "VishnuRaajan",
						email = "vishnuraajan1995@gmail.com",
						url = "https://github.com/vishnuraajan1995"
				),
				license = @License(
					name = "Apache 2.0",
					url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
				externalDocs = @ExternalDocumentation(
					description = "Accounts API Documentation",
					url = "https://github.com/vishnuraajan1995"
				)
		)

public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
