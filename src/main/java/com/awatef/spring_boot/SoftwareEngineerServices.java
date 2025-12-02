package com.awatef.spring_boot;

import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SoftwareEngineerServices {
    private final SoftwareEngineerRepository repository;
     //constructeur surchargé
    public SoftwareEngineerServices(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }


    public List<SoftwareEngineer> getAllSoftwareEngineer() {

        return repository.findAll(); //retourne toutes les listes
    }

    public SoftwareEngineer getSoftEngineerByID(Integer id) {

        return repository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("software Engineer " +id+" not found")
                );
    }

    public void createANewSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        //@requestbody pour recuperer l objet
        repository.save(softwareEngineer);
    }

    public SoftwareEngineer modifySoftwareEngineer(Integer id,SoftwareEngineer softwareEngineer) {

        SoftwareEngineer existingEngineer = getSoftEngineerByID(id);

        existingEngineer.setName(softwareEngineer.getName());
        existingEngineer.setTechStack(softwareEngineer.getTechStack());
        return repository.save(existingEngineer);
    }
}
/*
        SoftwareEngineer existingEngineer = getSoftwareEngineerById(id);
        existingEngineer.setName(updatedEngineer.getName());
        existingEngineer.setTechStack(updatedEngineer.getTechStack());
        return repository.save(existingEngineer); */