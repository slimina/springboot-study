package cn.slimsmart.springboot.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//http://blog.51cto.com/zero01/2086195
@SpringBootApplication
@ServletComponentScan  //FilterRegistrationBean、ServletRegistrationBean、ServletListenerRegistrationBean
public class TestApplication {

	public static void main(String[] args) throws  Exception{
        SpringApplication.run(TestApplication.class, args);
	}
}
