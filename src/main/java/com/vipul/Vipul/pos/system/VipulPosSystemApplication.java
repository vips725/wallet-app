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

		String username = dotenv.get("BREVO_SMTP_USERNAME");
		String password = dotenv.get("BREVO_SMTP_PASSWORD");
		String fromEmail = dotenv.get("BREVO_FROM_EMAIL");

		// Debug: never print the actual SMTP password
		System.out.println("SMTP username = " + username);
		System.out.println("SMTP password loaded = "
				+ (password != null && !password.isBlank()));
		System.out.println("From email = " + fromEmail);

		System.setProperty(
				"BREVO_SMTP_USERNAME",
				username
		);

		System.setProperty(
				"BREVO_SMTP_PASSWORD",
				password
		);

		System.setProperty(
				"BREVO_FROM_EMAIL",
				fromEmail
		);

		SpringApplication.run(
				VipulPosSystemApplication.class,
				args
		);
	}
}