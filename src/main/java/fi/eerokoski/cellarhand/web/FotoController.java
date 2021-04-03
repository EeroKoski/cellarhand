package fi.eerokoski.cellarhand.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FotoController {
	
	

	    @Value("${upload.path}")
	    private String uploadFolder;
	    
	    

	    @PostMapping("/upload")
	    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
	    	// Image Base64.getEncoder().encodeToString(file.file)
	    	// <img  th:src="@{'data:image/jpeg;base64,'+${file.file}}" />
	       
	        try {
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
	            Files.write(path, bytes);
	        	model.addAttribute("msg", "File " + file.getOriginalFilename() + " uploaded");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "uploadstatus";
	    }
	}