package com.gwego.cms;

import com.gwego.cms.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
		SysUser sysUser = new SysUser();
		sysUser.setAccount("test");
		sysUser.setMobile("1862345");
		sysUser.setPassword("123456");
		sysUser.setUserName("test");
		sysUser.setStatus(Byte.valueOf("1"));
		sysUser.setCreateTime(new Date());
		mongoTemplate.insert(sysUser);
	}

}
