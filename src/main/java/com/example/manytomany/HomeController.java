package com.example.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model){
        Owner owner = new Owner();
        owner.setName("Martha");
        owner.setPosition("Mom");

        Pet pet = new Pet();
        pet.setName("Flipper");
        pet.setType("fish");

        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);
        ownerRepository.save(owner);

        model.addAttribute("ownerSet", ownerRepository.findAll());
        return "index";
    }

}
