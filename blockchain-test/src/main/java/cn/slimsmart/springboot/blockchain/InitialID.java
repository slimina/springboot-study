package cn.slimsmart.springboot.blockchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.UUID;

/**
 * Created by zhutw on 2018/3/17.
 */
//在服务器启动时，将UUID设置到ServletContext属性中，这样我们的服务器就拥有了唯一标识
@WebListener
public class InitialID implements ServletContextListener {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        servletContext.setAttribute("uuid", uuid);
        logger.info("contextInitialized uuid = {}",uuid);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("contextDestroyed. ...");
    }
}
