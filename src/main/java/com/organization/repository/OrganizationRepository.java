package com.organization.repository;

import java.util.List;

import com.organization.enitity.Organization;

public interface OrganizationRepository {

	public List<Organization> getOrganizations();
	public Integer saveOrganization(Organization organization);
	
	public Organization getOrganizationById(Integer orgId);
}
