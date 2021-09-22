package com.organization.enitity;

import java.io.Serializable;

import com.organization.common.JdbcEntity;

public class Organization implements Serializable, JdbcEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String origName;
	private Integer isActive;
	private Boolean activeStatus;

	public Organization() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String getTableName() {
		return "ORIGINATION_DETAILS";
	}

	@Override
	public String getEntityIdColumn() {
		return "id";
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

}
