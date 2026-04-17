package com.turalabdullayev.pdf_text_search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;

public interface PdfRepository extends ElasticsearchRepository<PdfDocument, String> {
	List<PdfDocument> findByContentContaining(String keyword);

	@Query("{\"match\": {\"content\": \"?0\"}}")
	List<PdfDocument> searchByContent(String query);

}
