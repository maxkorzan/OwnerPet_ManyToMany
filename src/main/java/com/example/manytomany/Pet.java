package com.example.manytomany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;

    @ManyToMany(mappedBy = "petSet")
    private Set<Owner> ownerSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Owner> getOwnerSet() {
        return ownerSet;
    }

    public void setOwnerSet(Set<Owner> ownerSet) {
        this.ownerSet = ownerSet;
    }
}
