package cn.slimsmart.springboot.helloworld;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class HelloworldApplication implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8000);
        container.setContextPath("/helloworld");
    }

    @Bean
    public EmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory()
            throws IOException {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    // 优化tomcat链接配置
    public Connector httpConnector() throws IOException {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol http11NioProtocol = (Http11NioProtocol) connector.getProtocolHandler();
        connector.setPort(8080);
        // 设置最大线程数
        http11NioProtocol.setMaxThreads(100);
        // 设置初始线程数 最小空闲线程数
        http11NioProtocol.setMinSpareThreads(20);
        // 设置超时
        http11NioProtocol.setConnectionTimeout(5000);
        return connector;
    }

    // 测试事件加载顺序
    @Bean
    public DataLoader dataLoader() {
        return new DataLoader();
    }

    // 实例化测试例子
    static class DataLoader implements CommandLineRunner {
        @Override
        public void run(String... strings) throws Exception {
            System.out.println("Loading data...");
        }
    }
}
