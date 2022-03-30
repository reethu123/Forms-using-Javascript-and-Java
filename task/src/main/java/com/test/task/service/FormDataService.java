package com.test.task.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.task.dao.FormDataDAO;
import com.test.task.entities.FormData;
import com.test.task.entities.Sector;
import com.test.task.model.FormDataResponse;

@Service
@Transactional(rollbackFor = { Exception.class })
public class FormDataService {

	@Autowired
	FormDataDAO formDataDAO;

	@Autowired
	SectorService sectorService;

	/**
	 * Save Form Data
	 * 
	 * @param formdata
	 * @return
	 */
	public FormData saveFormData(FormData formdata) {
		return formDataDAO.save(formdata);
	}

	public FormData getById(Long id) {
		Optional<FormData> formDataOpt = formDataDAO.findById(id);
		if (formDataOpt.isPresent())
			return formDataOpt.get();
		else
			return null;
	}

	/**
	 * Create New Form Data
	 * 
	 * @param name
	 * @param sectors
	 * @return
	 */
	public FormDataResponse createFormData(String name, Boolean agreeToTerms, List<Long> sectors) {
		FormData formdata = new FormData();
		formdata.setName(name);
		formdata.setAgreeToTerms(agreeToTerms);
		if (!sectors.isEmpty()) {
			Set<Sector> sectorsList = new HashSet<>();
			for (Long sectorId : sectors) {
				Sector sector = sectorService.getById(sectorId);
				sectorsList.add(sector);
			}
			formdata.setSectors(sectorsList);
		}
		formdata = saveFormData(formdata);
		FormDataResponse formDataResponse = new FormDataResponse();
		formDataResponse.setId(formdata.getId());
		formDataResponse.setName(formdata.getName());
		formDataResponse.setAgreeToTerms(formdata.getAgreeToTerms());
		List<Long> sectorIds = new ArrayList<Long>();
		for (Sector sector : formdata.getSectors()) {
			sectorIds.add(sector.getId());
		}
		formDataResponse.setSectors(sectorIds);
		return formDataResponse;
	}

	/**
	 * Update Form Data
	 * 
	 * @param formdata
	 * @param sectors
	 * @param id
	 * @return
	 */
	public FormDataResponse updateFormData(String name, Boolean agreeToTerms, List<Long> sectors, Long id) {
		FormData formdata = new FormData();
		formdata.setName(name);
		formdata.setAgreeToTerms(agreeToTerms);
		if (!sectors.isEmpty()) {
			Set<Sector> sectorsList = new HashSet<>();
			for (Long sectorId : sectors) {
				Sector sector = sectorService.getById(sectorId);
				sectorsList.add(sector);
			}
			formdata.setSectors(sectorsList);
		}
		formdata.setId(id);
		formdata = saveFormData(formdata);
		FormDataResponse formDataResponse = new FormDataResponse();
		formDataResponse.setId(formdata.getId());
		formDataResponse.setName(formdata.getName());
		formDataResponse.setAgreeToTerms(formdata.getAgreeToTerms());
		List<Long> sectorIds = new ArrayList<Long>();
		for (Sector sector : formdata.getSectors()) {
			sectorIds.add(sector.getId());
		}
		formDataResponse.setSectors(sectorIds);
		return formDataResponse;
	}

}
