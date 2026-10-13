package com.example.devops.service;

import com.example.devops.entite.Employe;
import com.example.devops.reponse.EmployeReponse;
import com.example.devops.repository.EmployeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeService {

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    private ModelMapper mapper;

    public EmployeReponse getEmployeById(int id) {
        Employe employe = employeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe " + id + " introuvable"));
        return mapper.map(employe, EmployeReponse.class);
    }
}
