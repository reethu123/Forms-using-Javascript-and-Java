package com.test.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.task.entities.Sector;
import com.test.task.entities.SectorType;

@Repository
public interface SectorDAO extends JpaRepository<Sector, Long>{

	List<Sector> findByType(SectorType type);
}
