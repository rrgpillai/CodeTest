package com.rbc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rbc.controller.AppConfigController;
import com.rbc.service.ConfigService;

@RunWith(SpringRunner.class)
@WebMvcTest(AppConfigController.class)
public class TestConfigController {
	
	private static final String retrieve_URL="/api/101/config/v1";
	private static final String retrieve__ALL_URL="/api/101/config";
	private static final String add_URL="/api/102/config/v2";
	
	@Autowired
	MockMvc mvc;
	
		
	@MockBean
	ConfigService service;
	
	@Test
	public void testController_add() throws Exception
	{
		String input=
		"{\"appCode\":\"102\",\"version\":\"v1\",\"description\":\"Credit App v1\",\"appOwner\":\"Credit Smith\",	\"updatedDate\":\"2017-02-18\"}";
		mvc.perform(post(TestConfigController.add_URL).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON_UTF8).content(input))
		.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testController_retrieve() throws Exception
	{
		mvc.perform(get(TestConfigController.retrieve_URL).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
	}

	
	@Test
	public void testController_retrieveAll() throws Exception
	{
		mvc.perform(get(TestConfigController.retrieve__ALL_URL).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
	}
	
	
}
