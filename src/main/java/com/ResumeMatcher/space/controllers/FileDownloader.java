package com.ResumeMatcher.space.controllers;


import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/file")
public class FileDownloader {
	@GetMapping("/download")
	public void downloadFile ( @RequestParam String fileName , HttpServletResponse res) throws Exception {
		
		res.setHeader("Content-Disposition", "attachment;filename="+ fileName);
		res.getOutputStream().write(contentOf(fileName));
		
	}
	
	private byte[] contentOf (String fileName) throws Exception {
		return Files.readAllBytes ( Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
	}

}
