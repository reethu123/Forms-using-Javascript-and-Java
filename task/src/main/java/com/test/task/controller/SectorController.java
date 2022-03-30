package com.test.task.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.task.entities.SectorType;
import com.test.task.model.SectorModel;
import com.test.task.model.SectorResponse;
import com.test.task.service.SectorService;
import com.test.task.service.TemplateService;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class SectorController {

	@Autowired
	SectorService sectorService;

	@Autowired
	TemplateService templateService;

	@PostMapping(value = "sectors", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public void createSector(HttpServletRequest request, SectorModel sectorModel) throws Exception {
		sectorService.createSector(sectorModel.getName(), sectorModel.getType());
	}

	@GetMapping(value = "sectors/{id}", produces = "application/json")
	public SectorResponse getSectorById(HttpServletRequest request, @PathVariable Long id) {
		return sectorService.getSectorById(id);
	}

	@GetMapping(value = "sectorTypes/{id}", produces = "application/json")
	public SectorType getSectorTypeById(HttpServletRequest request, @PathVariable Long id) {
		return sectorService.getSectorTypeById(id);
	}

	@GetMapping(value = "sectorTypes", produces = "application/json")
	public String getAllSectorTypes(HttpServletRequest request) throws Exception {
		return sectorService.getSectorTypeMenu();
	}

	@GetMapping(value = "sectorTypes/menu", produces = "application/json")
	public String getAllSectorTypesForMenu(HttpServletRequest request) throws Exception {
		return sectorService.getSectorTypeDropDown();
	}

	@GetMapping(value = "sectors", produces = "application/json")
	public String getAllSectors(HttpServletRequest request) throws Exception {
		return sectorService.getSectorList();
	}

	@PostMapping(value = "sectors/update/{id}", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public void updateSectorById(HttpServletRequest request, @PathVariable Long id, SectorModel sectorModel) {
		sectorService.updateSector(sectorModel.getName(), id, sectorModel.getType());
	}

	@DeleteMapping(value = "sectors/{id}", produces = "application/json")
	public void deleteSectorById(HttpServletRequest request, @PathVariable Long id) {
		sectorService.deleteSector(id);
	}

}
