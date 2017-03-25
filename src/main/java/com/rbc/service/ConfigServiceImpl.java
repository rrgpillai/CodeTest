package com.rbc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbc.model.AppConfig;
import com.rbc.repository.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	ConfigRepository repository;

	// return JSON document for specified appCode and version
	@Override
	public AppConfig retrieveConfig(int appCode, String version) {

		return repository.findByAppCodeAndVersion(appCode, version);
	}

	// add new or update existing JSON document for specified appCode and
	// version. JSON document should be included in the request body
	@Override
	public List<AppConfig> addUpdateConfiguration(int appCode, String version, AppConfig appConfig) {

		System.out.println("appversion->"+appCode +" : version-> "+version);
		repository.save(appConfig);// save or update
		List<AppConfig> resultLst = new ArrayList<>();
		repository.findAll().forEach(resultLst::add);
		return resultLst; // return the updated list
	}

	// return list of available versions in JSON sorted by last modified date in
	// descending order
	@Transactional(readOnly = true)
	@Override
	public List<AppConfig> retrieveAllConfigByAppCodeDescDate(int appCode) {

		return repository.findByAppCodeSortByDate(appCode).collect(Collectors.toList());

	}

}
