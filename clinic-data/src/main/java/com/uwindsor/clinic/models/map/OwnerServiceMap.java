package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.Owner;
import com.uwindsor.clinic.models.Pet;
import com.uwindsor.clinic.models.PetType;
import com.uwindsor.clinic.services.OwnerService;
import com.uwindsor.clinic.services.PetService;
import com.uwindsor.clinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if(object != null) {
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType((PetType) petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException(" no pets here");
                    }
                });
            }
            return super.save(object);


        }else{
            return null;
        }
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
}
