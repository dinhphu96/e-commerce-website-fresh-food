package com.poly.impl;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	ServletContext app;
	
	@Override
	public File save(MultipartFile file, String folder) {
		File dir;
		try {
			dir = new File(new ClassPathResource("/static/img/" + folder).getFile().getAbsolutePath());
			System.out.println(dir);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		
		try {
			File savefile = new File(dir, name);
			file.transferTo(savefile);
			System.out.println(savefile.getAbsolutePath());
			return savefile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
