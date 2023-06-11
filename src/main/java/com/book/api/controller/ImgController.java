package com.book.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.api.helper.FileUploadHelper;

@RestController
public class ImgController {
	@Autowired
	private FileUploadHelper fileUp;

	@PostMapping("/img")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		boolean f = false;
		try {
			// validation of image
			if (file.isEmpty()) {
				// return
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is epty");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				// return
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file only support jpeg");
			}

//		otherwise upload file
			fileUp.uploadFile(file);
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/")
					.path(file.getOriginalFilename()).toUriString());
	

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file not found");
		}

	}
}
