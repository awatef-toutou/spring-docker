package com.awatef.spring_boot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerServices service;


    @GetMapping("/hello")
    public String helloWord(){
        return "helloWord";
    }
    public SoftwareEngineerController(SoftwareEngineerServices service) {
        this.service = service;
    }

    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineer() {
        return service.getAllSoftwareEngineer();
                /*
                return List.of(
                        new SoftwareEngineer(1,"frank","Java,Spring Boot"),
                        new SoftwareEngineer(2,"Jim","PHP,Spring Boot"),
                        new SoftwareEngineer(3,"Liz","React, Spring Boot")


                ); */
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getSoftEngineerByID(@PathVariable Integer id)
    //ON RECUPERER D PARES L URL SUR POST MAN
    {
        return service.getSoftEngineerByID(id);

    }

    @PostMapping
    public void addSoftwareEngineer(
      @RequestBody   SoftwareEngineer softwareEngineer
    ) {
        service.createANewSoftwareEngineer(softwareEngineer);
    }


}


