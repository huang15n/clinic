package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.Vet;
import com.uwindsor.clinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

}
