package com.awatef.spring_boot;

import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public void modifySoftwareEngineer(SoftwareEngineer update) {

     getSoftEngineerByID(update.getId());
     repository.save(update);
    }


    public void partialUpdateSoftwareEngineerV1(Integer id, Map<String, Object> updates) {
        findSoftwareEngineerById(id).map(softwareEngineer ->
        {updates.forEach((key, value)->{
            switch (key){
                case "name": softwareEngineer.setName((String) value);break;
                case "techStack": softwareEngineer.setTechStack((String) value);break;
                default:
                    throw new IllegalArgumentException("Invalid field: "+key);
            }
        });
            return repository.save(softwareEngineer);
        });
    }

    private Optional<SoftwareEngineer> findSoftwareEngineerById(Integer id) {
       return Optional.ofNullable(repository.findById(id) .orElseThrow(
                ()-> new IllegalArgumentException("software Engineer " +id+" not found")
       ));
    }
}



