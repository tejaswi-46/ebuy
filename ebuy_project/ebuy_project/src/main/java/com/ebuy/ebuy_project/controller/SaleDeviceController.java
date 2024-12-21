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
import com.ebuy.ebuy_project.model.SaleDevice;
import com.ebuy.ebuy_project.repository.SaleDeviceRepository;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/saledevice/")
public class SaleDeviceController {
	
	@Autowired
	@Qualifier("saleDeviceRepo")
	SaleDeviceRepository saleDeviceRepo;
	
private FileStorageService fileStorageService;
	
	
	@RequestMapping("/saledevices")
	public ArrayList<SaleDevice> getAll()
	{
		ArrayList<SaleDevice> ls=(ArrayList<SaleDevice>)saleDeviceRepo.findAll();
		return ls;
		
	}
	@PostMapping(value= {"/saledevices"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public SaleDevice insertrecord(@RequestPart("saledevice") SaleDevice e,@RequestPart("imageFile") MultipartFile[] files)
	{
		try {
			Set<ImageModel> images=uploadImages(files);
			e.setSaleDeviceImages(images);
			return saleDeviceRepo.save(e);
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
	@DeleteMapping("/saledevices/{id}")
	public void delete(@PathVariable("id") int id)
	{
		saleDeviceRepo.deleteById(id);
		
		
	}
	 @GetMapping("/downloadFile3/{fileName:.+}")
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
