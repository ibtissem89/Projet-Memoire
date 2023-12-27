package com.BackendE.backendProject.services;

// ReclamationService.java (Service)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendE.backendProject.models.Reclamation;
import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.ReclamationRepository;
import com.BackendE.backendProject.requests.ReclamationReq;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailService emailService;

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation getReclamationById(Long id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    public Reclamation createReclamation(ReclamationReq reclamation) {
         LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Convert the date and time to a string using the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        Reclamation resRec = reclamationRepository
                .save(new Reclamation(reclamation.getSujet(), reclamation.getMessage(), reclamation.getEmail(), formattedDateTime));
        String msg = "Madame, Monsieur\n, Nous accusons réception de votre reclamation du" + formattedDateTime + " et vous confirmons qu’elle sera exécutée par notre equipe";
        emailService.sendEmail(reclamation.getEmail(), "Confirmation reception reclamation", msg);
        return resRec;
    }

}
