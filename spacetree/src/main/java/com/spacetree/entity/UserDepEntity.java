package com.spacetree.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.spacetree.constants.Constants;

@Entity
@Table(name = Constants.TB_USERS_COMDET)
public class UserDepEntity{




	public UserDepEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	Date dob;


	@Column(name = "depId")
	private String depId;
	

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public UserDepEntity(long id, String depId, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public UserDepEntity(long id, String name, Date dob, String depId) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.depId = depId;
	}
	
	

}
