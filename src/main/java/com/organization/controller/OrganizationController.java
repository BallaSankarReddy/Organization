package com.organization.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.enitity.Organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "OriginationController", description = "REST APIs related to Origination Entity!!!!")
@RequestMapping("/api/origination")
@RestController
public interface OrganizationController {

	@ApiOperation(value = "Get list of Origination in the System ", tags = "getOriginations")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@GetMapping(value = "/getOrigination")
	public List<Organization> getOrganization();
	
	
	@ApiOperation(value = "Create Origination in the System ", tags = "Create Origination")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 201, message = "Success|Created"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@PostMapping(value = "/save/Origination")
	public Organization saveOrigination(@RequestBody Organization organization);
}
