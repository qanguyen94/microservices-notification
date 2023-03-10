package quocnguyen.demo.microservices.notification;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import quocnguyen.demo.microservices.notification.config.WebSecurityConfiguration;

@Slf4j
@Import({WebSecurityConfiguration.class})
@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication application = new SpringApplication(NotificationApplication.class);
		printStartupInfo(application.run(args).getEnvironment());
	}

	static void printStartupInfo(Environment environment) throws IOException {
	}

}
