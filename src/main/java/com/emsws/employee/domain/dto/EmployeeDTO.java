package com.emsws.employee.domain.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * 
 * @author edelacruz
 *
 */
public class EmployeeDTO implements Serializable {
	
	private Long id;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	private String middlename;
	@NotNull
	private Double  generalWeightedAverage;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date birthDate;
	@NotNull
	private String gender;
	
	@NotNull
	private Boolean employed = Boolean.FALSE;
	
	private Set<RoleDTO> roles;
	
	
	private String contactType;
	private String contactNumber;
	
	@NotNull
	private String street;
	@NotNull
	
	private String barangay;
	@NotNull
	private String city;
	@NotNull
	private String houseNumber;
	
	private String subdivision;
	@NotNull
	private String zipCode;
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	

	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getEmployed() {
		return employed;
	}

	public void setEmployed(Boolean employed) {
		this.employed = employed;
	}

	

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getGeneralWeightedAverage() {
		return generalWeightedAverage;
	}

	public void setGeneralWeightedAverage(Double generalWeightedAverage) {
		this.generalWeightedAverage = generalWeightedAverage;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}
	
	

}
