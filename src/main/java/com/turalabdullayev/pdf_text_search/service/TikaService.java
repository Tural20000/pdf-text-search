package com.turalabdullayev.pdf_text_search.service;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TikaService {
	private final Tika tika = new Tika();

	public String extractText(MultipartFile file) {
		try {
			return tika.parseToString(file.getInputStream());
		} catch (Exception e) {
			System.err.println("Metn cixarilarken xeta: " + e.getMessage());
			return "Metn cixarila bilmedi.";
		}
	}

}
