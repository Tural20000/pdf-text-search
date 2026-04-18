package com.turalabdullayev.pdf_text_search.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.turalabdullayev.pdf_text_search.model.PdfDocument;

public interface PdfRepository extends ElasticsearchRepository<PdfDocument, String> {
	List<PdfDocument> findByContentContaining(String keyword);

	@Query("{\"match\": {\"content\": \"?0\"}}")
	Page<PdfDocument> searchByContent(String query, Pageable pageable);

}
