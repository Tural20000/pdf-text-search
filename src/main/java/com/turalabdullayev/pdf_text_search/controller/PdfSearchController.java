package com.turalabdullayev.pdf_text_search.controller;

import java.util.List;

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
	public List<PdfDocument> serach(@RequestParam("query") String query) {
		return searchService.searchContent(query);

	}

}
