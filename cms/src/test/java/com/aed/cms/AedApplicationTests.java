package com.aed.cms;

import com.aed.AedApplication;
import com.aed.core.util.CipherUtil;
import com.aed.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AedApplication.class)
public class AedApplicationTests {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {

	}

}
