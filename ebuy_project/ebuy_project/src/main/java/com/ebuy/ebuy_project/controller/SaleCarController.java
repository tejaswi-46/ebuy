package com.ebuy.ebuy_project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebuy.ebuy_project.filework.FileStorageService;
import com.ebuy.ebuy_project.model.ImageModel;
import com.ebuy.ebuy_project.model.SaleCar;
import com.ebuy.ebuy_project.repository.SaleCarRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/salecar/")
public class SaleCarController {
	@Autowired
	@Qualifier("saleCarRepo")
	SaleCarRepository saleCarRepo;
	@Autowired
	private FileStorageService fileStorageService;
	
	
	@RequestMapping("/salecars")
	public ArrayList<SaleCar> getAll()
	{
		ArrayList<SaleCar> ls=(ArrayList<SaleCar>)saleCarRepo.findAll();
		return ls;
		
	}
	@PostMapping(value= {"/salecars"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public SaleCar insertrecord(@RequestPart("salecars") SaleCar e,@RequestPart("imageFile") MultipartFile[] files)
	{
		try {
			Set<ImageModel> images=uploadImages(files);
			e.setSaleCarImages(images);
			return saleCarRepo.save(e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return null;
		
	}
	public Set<ImageModel> uploadImages(MultipartFile[] files) throws Exception
	{
		Set<ImageModel> images=new HashSet<>();
		for(MultipartFile file:files)
		{
			ImageModel m=new ImageModel(file.getOriginalFilename(),file.getBytes());
			images.add(m);
			String fileName = fileStorageService.storeFile(file);
		}
		return images;
	}
	@DeleteMapping("/salecars/{id}")
	public void delete(@PathVariable("id") int id)
	{
		saleCarRepo.deleteById(id);
		
		
	}
	 @GetMapping("/downloadFile2/{fileName:.+}")
	    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) throws FileNotFoundException {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	           
	        }

	        // Fallback to the default content type if type could not be determined
	        if (contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(contentType))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	            .body(resource);
	    }


}
