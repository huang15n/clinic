package com.uwindsor.clinic.services;

import com.uwindsor.clinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
