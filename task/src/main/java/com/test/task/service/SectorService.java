package com.test.task.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.task.dao.SectorDAO;
import com.test.task.dao.SectorTypeDAO;
import com.test.task.entities.Sector;
import com.test.task.entities.SectorType;
import com.test.task.model.SectorResponse;

/**
 * @author user
 *
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class SectorService {

	@Autowired
	SectorDAO sectorDAO;

	@Autowired
	SectorTypeDAO sectorTypeDAO;

	@Autowired
	TemplateService templateService;

	/**
	 * Save Sector
	 * 
	 * @param sector
	 * @return
	 */
	public Sector saveSector(Sector sector) {
		return sectorDAO.save(sector);
	}

	/**
	 * Get sector by Id
	 * 
	 * @param id
	 * @return
	 */
	public Sector getById(Long id) {
		Optional<Sector> sectorOpt = sectorDAO.findById(id);
		if (sectorOpt.isPresent())
			return sectorOpt.get();
		else
			return null;
	}

	public SectorResponse getSectorById(Long id) {
		Sector sector = getById(id);
		if (sector != null) {
			SectorResponse response = new SectorResponse();
			response.setId(sector.getId());
			response.setName(sector.getName());
			response.setType(sector.getType().getId());
			return response;
		}
		return null;
	}

	/**
	 * Get SectorType By Id
	 * 
	 * @param id
	 * @return
	 */
	public SectorType getSectorTypeById(Long id) {
		Optional<SectorType> sectorOpt = sectorTypeDAO.findById(id);
		if (sectorOpt.isPresent())
			return sectorOpt.get();
		else
			return null;
	}

	/**
	 * All List of Sectors
	 * 
	 * @return
	 */
	public List<Sector> getAllSectors() {
		List<Sector> sectors = sectorDAO.findAll();
		if (sectors == null || sectors.isEmpty()) {
			return new ArrayList<Sector>();
		}
		return sectors;
	}

	public String getSectorList() throws Exception {
		String pageType = "sectorList";
		List<Map<String, Object>> models = new ArrayList<Map<String, Object>>();
		List<Sector> sectors = getAllSectors();
		for (Sector sector : sectors) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("id", sector.getId());
			model.put("name", sector.getName());
			model.put("typeName", sector.getType().getType());
			model.put("typeId", sector.getType().getId());
			models.add(model);
		}
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelList", models);
		return templateService.getFormTemplate(root, pageType);
	}

	/**
	 * List of Sectors By Sector Type
	 * 
	 * @param typeId
	 * @return
	 */
	public List<Sector> getAllSectorsByType(Long typeId) {
		SectorType type = new SectorType();
		type.setId(typeId);
		List<Sector> sectors = sectorDAO.findByType(type);
		if (sectors == null || sectors.isEmpty()) {
			return new ArrayList<Sector>();
		}
		return sectors;
	}

	/**
	 * Get All Sector Types
	 * 
	 * @return
	 */
	public List<SectorType> getAllSectorType() {
		List<SectorType> sectorTypes = sectorTypeDAO.findAll(Sort.by(Sort.Direction.ASC, "type"));
		if (sectorTypes == null || sectorTypes.isEmpty()) {
			return new ArrayList<SectorType>();
		}
		return sectorTypes;
	}

	public String getSectorTypeMenu() throws Exception {
		String pageType = "sectorMenu";
		List<Map<String, Object>> models = new ArrayList<Map<String, Object>>();
		List<SectorType> sectorTypes = getAllSectorType();
		for (SectorType type : sectorTypes) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("id", type.getId());
			model.put("type", type.getType());
			List<Map<String, Object>> sectors = new ArrayList<Map<String, Object>>();
			for (Sector sector : type.getSectors()) {
				Map<String, Object> sectorsModel = new HashMap<String, Object>();
				sectorsModel.put("id", sector.getId());
				sectorsModel.put("name", sector.getName());
				sectors.add(sectorsModel);
			}
			model.put("sectors", sectors);
			models.add(model);
		}
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelList", models);
		return templateService.getFormTemplate(root, pageType);
	}

	public String getSectorTypeDropDown() throws Exception {
		String pageType = "sectorTypeMenu";
		List<Map<String, Object>> models = new ArrayList<Map<String, Object>>();
		List<SectorType> sectorTypes = getAllSectorType();
		for (SectorType type : sectorTypes) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("id", type.getId());
			model.put("type", type.getType());
			models.add(model);
		}
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelList", models);
		return templateService.getFormTemplate(root, pageType);
	}

	/**
	 * Create new Sector
	 * 
	 * @param sector
	 * @param typeId
	 * @return
	 */
	public Sector createSector(String name, Long typeId) {
		Sector sector = new Sector();
		SectorType type = getSectorTypeById(typeId);
		sector.setName(name);
		sector.setType(type);
		return saveSector(sector);
	}

	/**
	 * Update Sector
	 * 
	 * @param sector
	 * @param id
	 * @param typeId
	 * @return
	 */
	public Sector updateSector(String name, Long id, Long typeId) {
		Sector sector = getById(id);
		SectorType type = getSectorTypeById(typeId);
		sector.setType(type);
		sector.setName(name);
		return saveSector(sector);
	}

	/**
	 * Delete Sector
	 * 
	 * @param id
	 */
	public void deleteSector(Long id) {
		Sector sector = getById(id);
		sectorDAO.delete(sector);
	}

}
