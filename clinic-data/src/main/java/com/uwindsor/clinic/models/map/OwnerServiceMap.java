package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.Owner;
import com.uwindsor.clinic.services.CrudService;
import com.uwindsor.clinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

}
