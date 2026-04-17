package com.turalabdullayev.pdf_text_search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;
import com.turalabdullayev.pdf_text_search.repository.PdfRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
	private final PdfRepository pdfRepository;

	public List<PdfDocument> searchContent(String keyword) {
		return pdfRepository.searchByContent(keyword);
	}

}
