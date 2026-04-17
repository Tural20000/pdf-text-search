package com.turalabdullayev.pdf_text_search.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "pdf_documents")
public class PdfDocument {
	@Id
	private String id;
	@Field(type = FieldType.Text, name = "file_name")
	private String fileName;

	@Field(type = FieldType.Text, name = "content")
	private String content;

	@Field(type = FieldType.Long, name = "file_size")
	private Long fileSize;

	@Field(type = FieldType.Date, name = "upload_time", format = DateFormat.date_hour_minute_second_millis)
	private LocalDateTime uploadTime;

}
