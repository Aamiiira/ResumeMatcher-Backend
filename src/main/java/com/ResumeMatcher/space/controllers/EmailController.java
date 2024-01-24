package com.ResumeMatcher.space.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ResumeMatcher.space.entities.Candidat;
import com.ResumeMatcher.space.entities.Mail;
import com.ResumeMatcher.space.repositories.CandidatRepo;
import com.ResumeMatcher.space.services.EmailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {

		@Autowired
	    public EmailService emailService;
		
		@Autowired
		public CandidatRepo candidatRepo ;
		
		@GetMapping("/sendConfirmMessage/{id}")
		public String sendConfirmMessage(@PathVariable("id") Long id) {
			
			Optional<Candidat> candidat = candidatRepo.findById(id);
			Mail mail = new Mail();
			mail.setFrom("pfeamira@gmail.com");
			mail.setTo(candidat.get().getEmail());
			mail.setSubject("Invitation to an Interview at Our Company");
			mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" + 
					"\r\n" + 
					"I would like to express my gratitude for the interest you have shown in our company and for submitting your application.\r\n" + 
					"\r\n" + 
					"After carefully reviewing your profile, we are impressed with your relevant experience. Your professional background appears to align perfectly with the skills required for this position. We would now like the opportunity to discuss your application in more detail through an interview.\r\n" + 
					"\r\n" + 
					"We propose scheduling a meeting for an interview. We can accommodate your availability and find a time slot that suits you. Please provide us with your preferences in terms of dates and times so that we can arrange this meeting. \r\n" + 
					"\r\n" +
					"We also encourage you to prepare by reflecting on specific examples of your professional achievements and situations that highlight your key skills. We aim to gain a thorough understanding of your background and what you can bring to our team.\r\n" + 
					"\r\n" + 
					"Feel free to contact me by email or phone to schedule an appointment or if you have any additional questions regarding the interview. I look forward to your response.\r\n" + 
					"\r\n" +
					"\r\n" + 
					"\r\n" + 
					"Best regards,");
			emailService.sendSimpleMessage(mail);
			return "Email sent successffully";
			
		}
		
		@GetMapping("/sendDenyMessage/{id}")
		public String sendDenyMessage(@PathVariable("id") Long id) {
			
			Optional<Candidat> candidat = candidatRepo.findById(id);
			Mail mail = new Mail();
			mail.setFrom("pfeamira@gmail.com");
			mail.setTo(candidat.get().getEmail());
			mail.setSubject("Responding to your application at our company");
			mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" + 
					"\r\n" + 
					"Thank you for applying to Our Company.\r\n" + 
					"\r\n" + 
					"After reviewing your application, we regret to inform you that we are unable to proceed with your candidacy at this time.\r\n" + 
					"\r\n" + 
					"Rest assured that we will keep your information on file, and should an opportunity arise in the future, we will not hesitate to reach out to you.\r\n" + 
					"\r\n" + 
					"We wish you success in your job search and appreciate your interest in our company.\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" +
					"Best regards,");
			emailService.sendSimpleMessage(mail);
			return "Email sent successffully";
			
		}
		
		
}