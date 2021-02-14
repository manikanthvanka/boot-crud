package com.spacetree.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.spacetree.constants.Constants;

@Entity
@Table(name = Constants.TB_USERS)
public class UsersEntity {

	public UsersEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	Date dob;

	@Column(name = "activeStatus")
	private boolean activeStatus;

	@Column(name = "phone")
	private String phone;
	
	@OneToMany(targetEntity = UserDepEntity.class, cascade = CascadeType.ALL)
	@JoinColumn( name = "depId" , referencedColumnName ="id" )
	private List<UserDepEntity> userDepList;

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

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<UserDepEntity> getUserDepList() {
		return userDepList;
	}

	public void setUserDepList(List<UserDepEntity> userDepList) {
		this.userDepList = userDepList;
	}

	public UsersEntity(long id, String name, Date dob, boolean activeStatus, String phone,
			List<UserDepEntity> userDepList) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.activeStatus = activeStatus;
		this.phone = phone;
		this.userDepList = userDepList;
	}

	

}
