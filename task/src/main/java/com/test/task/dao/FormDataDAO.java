package com.test.task.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.task.entities.FormData;

@Repository
public interface FormDataDAO extends CrudRepository<FormData, Long>{

}
