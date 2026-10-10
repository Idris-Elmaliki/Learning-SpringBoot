package dev.idris.content_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContentCalendarApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ContentCalendarApplication.class, args);

		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");

		// We can also get the signature for a single bean,
		System.out.println(restTemplate);
	}
}