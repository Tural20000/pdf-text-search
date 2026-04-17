package com.turalabdullayev.pdf_text_search.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;
import com.turalabdullayev.pdf_text_search.repository.PdfRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PdfIndexingService {
	private final TikaService tikaService;
	private final PdfRepository pdfRepository;

	@Async
	public void indexPdf(String uniqueFileName, MultipartFile file) {
		try {
			String extractedText = tikaService.extractText(file);

			PdfDocument pdfDoc = PdfDocument.builder().fileName(uniqueFileName).content(extractedText)
					.fileSize(file.getSize()).uploadTime(LocalDateTime.now()).build();

			pdfRepository.save(pdfDoc);

			System.out.println("Ugurla indekslendi: " + uniqueFileName);
		} catch (Exception e) {
			System.out.println("Indekslenme xetasi: " + e.getMessage());
		}
	}

}
