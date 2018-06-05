package cn.slimsmart.springboot.applicationconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationConfigApplication.class, args);

    /*
    SpringApplication springApplication = new SpringApplication(new Object[]{ApplicationConfigApplication.class});
    springApplication.setAddCommandLineProperties(false); //禁用命令行修改配置参数
    springApplication.run(args);
    */
    }
}
