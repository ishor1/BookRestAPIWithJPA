package com.book.api.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	static path
//	public final String upload_Dir = "C:\\Users\\Mr Ishor\\Documents\\workspace-spring-tool-suite-4-4.18.1.RELEASE\\BookRestAPIWithJPA\\src\\main\\resources\\static\\img";

	
	//dynamic Path
	public final String upload_Dir=new ClassPathResource("static/img/").getFile().getAbsolutePath();
	public FileUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
			Files.copy(file.getInputStream(), Paths.get(upload_Dir + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f=true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
