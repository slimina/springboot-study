package cn.slimsmart.springboot.ldapdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LdapDemoApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(LdapDemoApplication.class, args);
        LdapEmployeeDao ldapEmployeeDao = context.getBean(LdapEmployeeDao.class);
        System.out.println(ldapEmployeeDao.findByAccountName("zhutw"));
        ldapEmployeeDao.findAll("OU=研发部,OU=集团", "person").forEach(System.out::println);
    }
}
