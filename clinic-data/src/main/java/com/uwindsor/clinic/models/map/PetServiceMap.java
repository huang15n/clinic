package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.Pet;
import com.uwindsor.clinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
