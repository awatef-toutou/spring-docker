package com.awatef.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {




            @GetMapping
            public List<SoftwareEngineer> getAllSoftwareEngineer()
            {

                return List.of(
                        new SoftwareEngineer(1,"frank","Java,Spring Boot"),
                        new SoftwareEngineer(2,"Jim","PHP,Spring Boot"),
                        new SoftwareEngineer(3,"Liz","React, Spring Boot")


                );
            }
        }


