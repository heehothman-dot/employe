package com.example.devops.repository;

import com.example.devops.entite.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe, Integer> {
}
