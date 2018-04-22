package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/** Created by zhutw on 2018/3/12. */
public class ApplicationEnvironmentPreparedEventListener
    implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    System.err.println("......ApplicationEnvironmentPreparedEvent......");
  }
}
