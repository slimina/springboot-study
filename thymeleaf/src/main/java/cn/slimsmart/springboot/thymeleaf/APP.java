package cn.slimsmart.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Thymeleaf是一个XML/XHTML/HTML5模板引擎，可用于Web与非Web环境中的应用开发。 Spring
 * Boot默认提供静态资源目录位置需置于classpath下，目录名需符合如下规则：
 * /static
 * /public
 * /resources
 * /META-INF/resources
 */
@SpringBootApplication
public class APP {
  public static void main(String[] args) {
    SpringApplication.run(APP.class, args);
  }
}
