package com.uwindsor.clinic.models.map;

import com.uwindsor.clinic.models.BaseEntity;
import com.uwindsor.clinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends  Long> implements CrudService<T, ID> {
    protected Map<ID,T> map = new HashMap<>();



    @Override
    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

@Override
    public T findById(ID id){
        return map.get(id);
    }


    public T save( T object){
        if(object != null){
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put((ID) object.getId(),object);
        }else {
            throw new RuntimeException("object cannot be null");
        }

        return object;
    }
@Override
    public void deleteById(ID id){
        map.remove(id);
    }

@Override
    public void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object) );
    }

    private Long getNextId(){

        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()).longValue() + 1;

        }catch (NoSuchElementException e){
            nextId = 1000L;
        }

        return nextId;
    }



}
