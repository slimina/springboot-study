package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** Created by zhutw on 2018/3/12. */
public class ApplicationPreparedEventListener
    implements ApplicationListener<ApplicationPreparedEvent> {

  @Override
  public void onApplicationEvent(ApplicationPreparedEvent event) {
    System.err.println("......ApplicationPreparedEvent......");
  }
}
