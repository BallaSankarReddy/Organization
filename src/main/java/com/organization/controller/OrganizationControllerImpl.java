package com.organization.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.enitity.Organization;
import com.organization.service.OrganizationService;
@RequestMapping("/api/origination")
@RestController
public class OrganizationControllerImpl implements OrganizationController {
	
	 private Logger logger = LoggerFactory.getLogger(OrganizationControllerImpl.class);
	
	@Autowired
	private  OrganizationService organizationService ;

	@Override
	public List<Organization> getOrganization() {
		return organizationService.getOriginations();
	}

	@Override
	public Organization saveOrigination(Organization organization) {

		logger.info("Saving Organization details : ");
		return organizationService.saveOrigination(organization);
	}

}
