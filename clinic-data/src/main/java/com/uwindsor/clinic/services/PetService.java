package com.uwindsor.clinic.services;

import com.uwindsor.clinic.models.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends  CrudService<Pet, Long> {
}
