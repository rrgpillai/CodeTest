package com.rbc;

import java.text.ParseException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.model.AppConfig;
import com.rbc.repository.ConfigRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestConfigRepository {

    @Autowired
    private ConfigRepository repository;

    @Test
    public void testFindByNameAndVersion() throws ParseException {
       repository.save(new AppConfig(101,"v1","Loan App v1", "John Smith", "2017-02-18"));
       String appOwner =repository.findByAppCodeAndVersion(101, "v1").getAppOwner();
        Assert.assertEquals("John Smith", appOwner);
    }
    
    @Test
    public void testfindAll() throws ParseException {
       
       repository.save(new AppConfig(101,"v1","Loan App v1", "John Smith", "2017-02-18"));
       List<AppConfig> lst =(List<AppConfig>) repository.findAll();
        Assert.assertTrue(lst.size()>0);
    }
}