package com.test.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.task.entities.SectorType;

@Repository
public interface SectorTypeDAO extends JpaRepository<SectorType, Long> {

}
