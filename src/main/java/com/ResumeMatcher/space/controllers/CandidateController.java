package com.ResumeMatcher.space.controllers;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ResumeMatcher.space.entities.Candidat;
import com.ResumeMatcher.space.repositories.CandidatRepo;
import com.ResumeMatcher.space.services.CandidatService;
import com.ResumeMatcher.space.services.PythonService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CandidateController {
	
	@Autowired
	private CandidatRepo candidatRepo;
	
	@PostMapping("/process-pdf")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<Candidat> processPdf(@RequestParam("file") MultipartFile file) {
	    // Extract data from PDF file using Apache PDFBox or iText
	    // Save candidate data to database using Spring Data JPA
	    Candidat candidat = new Candidat();
	    // Your code to extract data from PDF file and populate the candidat object goes here
	    Candidat savedCandidat = candidatRepo.save(candidat);
	    return ResponseEntity.ok().body(savedCandidat);
	}
    

	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private CandidatService candidatService;
  
	@PostMapping("/create")
    public Candidat createCandidate(@Valid @RequestBody Candidat candidate) {
		return candidatRepo.save(candidate);
		
	}
	
	@GetMapping("/candidats")
	public List<Candidat> getAllCandidates() {
		return candidatRepo.findAll();
	}

	
	private final Path rootLocation = Paths.get("C:\\Users\\hp\\Desktop\\candidats");	
	
	@PostMapping("/createcandidate")
    public ResponseEntity<?> createCandidate(@RequestPart("candidate") String candidate, @RequestParam("cv_file") 
    MultipartFile file1,@RequestParam("motiv_letter_file") MultipartFile file2) throws JsonParseException, JsonMappingException, IOException {
		
		
			
				Candidat candidate1 = new ObjectMapper().readValue(candidate , Candidat.class);
				System.out.println(candidate1);
				
				candidate1.setPathCv(file1.getOriginalFilename());
				candidate1.setPathMotivationLetter(file2.getOriginalFilename());
				Candidat candidat2 = candidatRepo.save(candidate1);
				if (candidat2!=null) {
				return  ResponseEntity.status(HttpStatus.ACCEPTED).body("User is saved");
				}else {
					return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not saved");
			}	
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {
		
        // Load file as Resource
        Resource resource = candidatService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
	@GetMapping("/candidat/{id}")
	public ResponseEntity<Candidat> findById(@PathVariable("id") Long id) {
		Optional<Candidat> emp = candidatRepo.findById(id);
		if (emp.isPresent())
			return new ResponseEntity<Candidat>(emp.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Candidat>(HttpStatus.NO_CONTENT);

	}
	
	 @DeleteMapping("/candidate/{id}")
		void deleteNote(@PathVariable Long id) {
			candidatRepo.deleteById(id);
		  }

}
        
	
	

