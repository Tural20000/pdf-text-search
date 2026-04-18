package com.turalabdullayev.pdf_text_search.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.turalabdullayev.pdf_text_search.service.FileStorageService;
import com.turalabdullayev.pdf_text_search.service.PdfIndexingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class PdfUploadController {
	private final FileStorageService fileStorageService;
	private final PdfIndexingService pdfIndexingService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("Zehmet olmasa bir fayl secin!");
			}
			String contentType = file.getContentType();
			if (contentType == null || !contentType.equals("application/pdf")) {
				return ResponseEntity.badRequest().body("Sehv format! Yalniz PDF yukleye bilersiniz.");
			}

			String uniqueFileName = fileStorageService.saveFile(file);

			pdfIndexingService.indexPdf(uniqueFileName, file);

			return ResponseEntity.ok("Fayl qebul edildi ve emal olunur: " + uniqueFileName);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Fayl yuklenerken xeta bas verdi: " + e.getMessage());

		}

	}

}
