package com.f1.sim;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class SimApplication {

	public static void main(String[] args) {
		String projectRoot = Paths.get(System.getProperty("user.dir")).toString();
		System.out.println(projectRoot);
		Path envPath = Paths.get(projectRoot, ".env");
		System.out.println("Exists: " + Files.exists(envPath));
		Dotenv dotenv = Dotenv.configure().directory(projectRoot).ignoreIfMissing().load();
		System.out.println(dotenv.get("DB_URL"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(SimApplication.class, args);
	}

}
