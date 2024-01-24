package com.ResumeMatcher.space.services;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.ResumeMatcher.space.repositories.CandidatRepo;

@Service
public class CandidatService {
	
	@Autowired
	private CandidatRepo candidatRepo ; 
	
	private final Path fileStorageLocation = Paths.get("C:\\Users\\hp\\Desktop\\candidats");

	public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = (Resource) new UrlResource(filePath.toUri());
            if(((AbstractFileResolvingResource) resource).exists()) {
                return resource;
            } else {
                throw new Exception("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new Exception("File not found " + fileName, ex);
        }
    }
	
	/*	public void runScript() {
	PythonInterpreter interpreter = new PythonInterpreter();
    interpreter.execfile("C:\\Users\\hp\\Desktop\\candidats\\python.py");
    PyFunction pyFunction = (PyFunction) interpreter.get("get_resume_job_match_percentage", PyFunction.class);
    PyObject result = pyFunction.__call__(new PyString("resume_text"), new PyString("job_description_text"));
    System.out.println(result.toString());
	
}*/

	
	
}

