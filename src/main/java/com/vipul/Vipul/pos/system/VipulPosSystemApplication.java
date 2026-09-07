package com.vipul.Vipul.pos.system;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VipulPosSystemApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure()
				.directory("./Vipul-pos-system")
				.load();

		System.setProperty("BREVO_USERNAME", dotenv.get("BREVO_SMTP_USERNAME"));
		System.setProperty("BREVO_PASSWORD", dotenv.get("BREVO_SMTP_PASSWORD"));
		System.setProperty("BREVO_FROM_EMAIL", dotenv.get("BREVO_FROM_EMAIL"));

		SpringApplication.run(VipulPosSystemApplication.class, args);
	}
}