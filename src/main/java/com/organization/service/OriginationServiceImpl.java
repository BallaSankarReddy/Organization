package com.organization.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.enitity.Organization;
import com.organization.repository.OrganizationRepository;

@Service
public class OriginationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;

	

	@Override
	public List<Organization> getOriginations() {
		return organizationRepository.getOrganizations();
	}



	@Override
	public Organization saveOrigination(Organization organization) {
		organization.setIsActive(organization.getActiveStatus()==true ? 1 : 0);
		Integer orgId = organizationRepository.saveOrganization(organization);
		if(Optional.ofNullable(organization).isPresent()) {
			organization.setId(orgId);
		}else {
			//T0DO -- exception case
		}
		return organization;
	}



	@Override
	public Organization getOrganizationById(Integer orgId) {
		return organizationRepository.getOrganizationById(orgId);
	}

}
