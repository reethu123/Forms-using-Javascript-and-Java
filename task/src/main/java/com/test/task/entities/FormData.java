package com.test.task.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@Entity
@Table(name = "form_data")
public class FormData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "name")
	public String name;
	
	@Column(name = "agree_to_terms")
	public Boolean agreeToTerms;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "form_data_sector", joinColumns = { @JoinColumn(name = "form_data_id") }, inverseJoinColumns = {
			@JoinColumn(name = "sector_id") })
	private Set<Sector> sectors = new HashSet<Sector>();

}
