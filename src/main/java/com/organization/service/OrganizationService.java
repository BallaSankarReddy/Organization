package com.organization.service;

import java.util.List;

import com.organization.enitity.Organization;

public interface OrganizationService {
	
	public List<Organization> getOriginations();
	public Organization saveOrigination(Organization organization);
	public Organization getOrganizationById(Integer orgId);
}
