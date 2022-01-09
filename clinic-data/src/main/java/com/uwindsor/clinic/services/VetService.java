package com.uwindsor.clinic.services;

import com.uwindsor.clinic.models.Vet;
import org.springframework.stereotype.Service;

@Service
public interface VetService extends CrudService<Vet, Long> {
}
