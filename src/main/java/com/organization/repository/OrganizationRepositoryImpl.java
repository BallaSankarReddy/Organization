package com.organization.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.common.BaseRepository;
import com.organization.enitity.Organization;

@Repository
public class OrganizationRepositoryImpl extends BaseRepository<Organization> implements OrganizationRepository {

	@Override
	public List<Organization> getOrganizations() {
		return this.findAll(Organization.class);
	}

	@Override
	public Integer saveOrganization(Organization organization) {
		return this.create(organization);
	}

	@Override
	public Organization getOrganizationById(Integer orgId) {
		return this.findById(Organization.class, orgId);
	}

}
