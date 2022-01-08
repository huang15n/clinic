package com.uwindsor.clinic.models;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private PetType petType;
    private Owner owners;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwners() {
        return owners;
    }
}
