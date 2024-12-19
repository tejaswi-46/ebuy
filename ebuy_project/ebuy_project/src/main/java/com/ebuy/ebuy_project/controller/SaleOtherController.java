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
import com.ebuy.ebuy_project.model.SaleOther;
import com.ebuy.ebuy_project.repository.SaleOtherRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/saleother/")
public class SaleOtherController {
	@Autowired
	@Qualifier("saleOtherRepo")
	SaleOtherRepository saleOtherRepo;
	
    private FileStorageService fileStorageService;
    
    @RequestMapping("/saleothers")
	public ArrayList<SaleOther> getAll()
	{
		ArrayList<SaleOther> ls=(ArrayList<SaleOther>)saleOtherRepo.findAll();
		return ls;
		
	}
	@PostMapping(value= {"/saleothers"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public SaleOther insertrecord(@RequestPart("saleothers") SaleOther e,@RequestPart("imageFile") MultipartFile[] files)
	{
		try {
			Set<ImageModel> images=uploadImages(files);
			e.setSaleOtherImages(images);
			return saleOtherRepo.save(e);
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
	@DeleteMapping("/saleothers/{id}")
	public void delete(@PathVariable("id") int id)
	{
		saleOtherRepo.deleteById(id);
		
		
	}
	 @GetMapping("/downloadFile4/{fileName:.+}")
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
