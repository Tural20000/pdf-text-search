package com.turalabdullayev.pdf_text_search.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;
import com.turalabdullayev.pdf_text_search.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class PdfSearchController {
	private final SearchService searchService;

	@GetMapping("/search")
	public Page<PdfDocument> search(@RequestParam(name = "query") String query,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return searchService.searchContent(query, page, size);
	}

}
