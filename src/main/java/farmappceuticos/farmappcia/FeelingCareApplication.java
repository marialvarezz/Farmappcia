package farmappceuticos.farmappcia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeelingCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeelingCareApplication.class, args);
	}

	@SpringBootApplication
	public static class Version1Application {

		public static void main(String[] args) {
			SpringApplication.run(Version1Application.class, args);
		}

	}
}
