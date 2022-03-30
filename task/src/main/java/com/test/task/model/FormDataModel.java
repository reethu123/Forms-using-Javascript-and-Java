package com.test.task.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FormDataModel {
	
	String name;
	
	List<Long> sectors = new ArrayList<Long>();
	
	Boolean agreeToTerms;

}
