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
        //create owner ("parent")
        Owner owner = new Owner();
        owner.setName("Martha");
        owner.setPosition("Mom");

        //create pet ("child")
        Pet pet = new Pet();
        pet.setName("Flipper");
        pet.setType("fish");

        //create set for pets, add "pet"
        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);

        //add pet-set to owner and save owner to repo
        owner.setPetSet(petSet);
        ownerRepository.save(owner);

//        pet.setOwnerSet(ownerSet);
//        petRepository.save(pet);


/////////////////////////////// IGNORE /////////////////////////////////////
/*

        Set<Pet> petSet = new HashSet<>();
//        Set<Owner> ownerSet = new HashSet<>();
        owner.setPetSet(petSet);
        owner.getPetSet().add(pet);
//        petSet.add(pet);
//        pet.setOwnerSet(ownerSet);
        petRepository.save(pet);
        ownerRepository.save(owner);
*/
////////////////////////////////////////////////////////////////////////////


        model.addAttribute("owners", ownerRepository.findAll());
        return "index";
    }

}
