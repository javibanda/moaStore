package moa.store.person.controller.service;

import moa.store.person.model.entity.BaseEntity;
import moa.store.person.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

abstract public class BaseService< T extends BaseEntity> {

    protected JpaRepository<T, Long> repository;

    public List<T> getAll(){
        return repository.findAll();
    }

    public T getOne(Long id){
        if(null==id){
            return null;
        }
        return repository.findById(id).orElse(null);
    }

    public T create(T entity){
        return repository.save(entity);
    }

    public T delete(Long id){
        T entityDb = getOne(id);
        if(null==entityDb){
            return null;
        }
        repository.delete(entityDb);
        return entityDb;
    }





}
