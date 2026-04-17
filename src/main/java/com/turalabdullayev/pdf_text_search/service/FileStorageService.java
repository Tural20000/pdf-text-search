package com.turalabdullayev.pdf_text_search.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
	@Value("${app.upload.dir}")
	private String uploadDir;

	public String saveFile(MultipartFile file) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		String originalFileName = file.getOriginalFilename();
		String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

		Path filePath = uploadPath.resolve(uniqueFileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		return uniqueFileName;

	}

}
