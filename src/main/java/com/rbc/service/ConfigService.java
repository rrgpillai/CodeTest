package com.rbc.service;

import java.util.List;

import com.rbc.model.AppConfig;

public interface ConfigService {
	
	List<AppConfig> retrieveAllConfigByAppCodeDescDate(int appCode);
	AppConfig retrieveConfig(int appCode, String version);
	List<AppConfig> addUpdateConfiguration(int appCode, String version, AppConfig appConfig);
	

}
