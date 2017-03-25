package com.rbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.ApplicationConstants;

import com.rbc.model.AppConfig;
import com.rbc.service.ConfigService;

import java.util.List;

@RestController
public class AppConfigController {
	
	
	
	@Autowired
	ConfigService service;
	
	@RequestMapping(value=ApplicationConstants.RETRIEVE_APP_CONFIG_END_POINT, method=RequestMethod.GET)
	public AppConfig retrieveConfig(@PathVariable int appCode, @PathVariable String version)
	{
		
		return service.retrieveConfig(appCode, version);
	}
	
	
	@RequestMapping(value=ApplicationConstants.ADD_UPDATE_APP_CONFIG_END_POINT, method=RequestMethod.POST)
	public List<AppConfig> AddUpdateConfiguration(@PathVariable int appCode, @PathVariable String version, @RequestBody AppConfig config)
	{
		
		return service.addUpdateConfiguration(appCode, version, config);
	}
	
	@RequestMapping(value=ApplicationConstants.RETRIEVE_ALL_APP_CONFIG_END_POINT, method=RequestMethod.GET)
	public List<AppConfig> getAllConfiguration(@PathVariable int appCode)
	{
		
				return service.retrieveAllConfigByAppCodeDescDate(appCode);
	}
	
	
	

}
