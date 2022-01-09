package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.Vet;
import com.uwindsor.clinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default","map"})

public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
}
