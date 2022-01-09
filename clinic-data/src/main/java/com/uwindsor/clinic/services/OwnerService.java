package com.uwindsor.clinic.services;

import com.uwindsor.clinic.models.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
