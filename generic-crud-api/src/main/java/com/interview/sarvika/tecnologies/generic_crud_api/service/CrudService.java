package com.interview.sarvika.tecnologies.generic_crud_api.service;

import java.util.List;

public interface CrudService<T,ID> {
	
	// Retrieve all records of the entity type.
	List<T> getAll(); 
	// Retrieve a single entity by its identifier.
	T getById(ID id);
	//  Create a new entity.
    T create(T entity);
    //Update an existing entity identified by its ID.
    T update(ID id, T entity);
    //Delete an entity by its identifier.
    void delete(ID id);
	
}
