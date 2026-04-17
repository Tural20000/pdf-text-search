package com.turalabdullayev.pdf_text_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PdfTextSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfTextSearchApplication.class, args);
	}

}
