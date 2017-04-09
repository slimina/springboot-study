package cn.slimsmart.springboot.helloworld;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import cn.slimsmart.springboot.helloworld.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloworldApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testSayHello() throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		User user = new User();
		user.setAge(30);
		user.setBirthday(new Date());
		user.setName("tom");
		HttpEntity<User> request = new HttpEntity<User>(user, requestHeaders);
		Long id = restTemplate.postForObject("/user", request, Long.class);
		Assert.assertEquals(restTemplate.getForEntity("/user/sayHello/{id}", String.class,  id).getBody(), "hello tom");;
	}
	
	@Test
	public void testSayHelloNoFound() throws Exception {
		Assert.assertEquals(restTemplate.getForEntity("/user/sayHello/{id}", String.class,  -1).getBody(), "not found");;
	}
	
	@Test
	public void testsave() throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		User user = new User();
		user.setAge(30);
		user.setBirthday(new Date());
		user.setName("jetty");
		HttpEntity<User> request = new HttpEntity<User>(user, requestHeaders);
		Assert.assertNotNull(restTemplate.postForEntity("/user", request, Long.class).getBody());
	}
	
	@Test
	public void testList() throws Exception {
		Assert.assertTrue(restTemplate.getForEntity("/user/list", List.class).getBody().size() > 0);
	}
}
