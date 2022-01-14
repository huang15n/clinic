package com.uwindsor.clinic.services;

import com.uwindsor.clinic.models.BaseEntity;
import com.uwindsor.clinic.models.PetType;

public interface PetTypeService<P extends BaseEntity, L extends Number> extends  CrudService<PetType,Long>{
}
