package com.test.task.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.task.model.FormDataModel;
import com.test.task.model.FormDataResponse;
import com.test.task.service.FormDataService;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class FormDataController {

	@Autowired
	FormDataService formDataService;

	@PostMapping(value = "formData", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public FormDataResponse createFormData(HttpServletRequest request, FormDataModel formDataModel) throws Exception {
		return formDataService.createFormData(formDataModel.getName(), formDataModel.getAgreeToTerms(), formDataModel.getSectors());
	}

	@PostMapping(value = "formData/{id}", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public FormDataResponse updateFormData(HttpServletRequest request, FormDataModel formDataModel, @PathVariable Long id)
			throws Exception {
		return formDataService.updateFormData(formDataModel.getName(), formDataModel.getAgreeToTerms(), formDataModel.getSectors(), id);
	}

}
