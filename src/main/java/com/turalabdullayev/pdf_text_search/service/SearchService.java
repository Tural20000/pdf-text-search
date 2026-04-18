package com.turalabdullayev.pdf_text_search.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;
import com.turalabdullayev.pdf_text_search.repository.PdfRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
	private final PdfRepository pdfRepository;

	public Page<PdfDocument> searchContent(String keyword, int page, int size) {
		return pdfRepository.searchByContent(keyword, PageRequest.of(page, size));
	}

}
