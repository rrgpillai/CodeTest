package com.rbc;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.model.AppConfig;
import com.rbc.repository.ConfigRepository;
import com.rbc.service.ConfigService;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestConfigService {
	
	@Autowired
	ConfigService service;
	
	@Autowired
	ConfigRepository repository;
	
	@Test
	public void TestAddConfig() throws ParseException
	{
		AppConfig config=(new AppConfig(102,"v1","Loan App v1", "John Smith", "2017-02-18"));
		List<AppConfig> lst=service.addUpdateConfiguration(102, "v1", config);
		System.out.println("list size ->"+lst.size());
		Assert.assertTrue(lst.size()>0);
	}
	
	@Test
	public void TestretrieveConfig() throws ParseException
	{
		AppConfig config=(new AppConfig(102,"v2","Credit App v2", "Creidt Smith", "2017-02-19"));
		List<AppConfig> lst=service.addUpdateConfiguration(102, "v2", config);
		Assert.assertNotNull(service.retrieveConfig(102, "v2"));
	}

	@Test
	public void TestRetrieveAllConfigByAppCodeDescDate() throws ParseException
	{
		AppConfig config=(new AppConfig(102,"v1","Loan App v1", "John Smith", "2017-02-18"));
		repository.save(config);
		config=(new AppConfig(102,"v2","Loan App v2", "John Smith", "2017-02-19"));
		repository.save(config);
		config=(new AppConfig(102,"v3","Loan App v3", "John Smith", "2017-02-20"));
		repository.save(config);
		List<AppConfig> lst=service.retrieveAllConfigByAppCodeDescDate(102);
		AppConfig config2=lst.get(0);
		System.out.println("date -> "+config2.getUpdatedDate());
		Assert.assertFalse(config.getUpdatedDate().equals("2017-02-19"));
		
	}

}
