package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/** Created by zhutw on 2018/3/12. */
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

  @Override
  public void onApplicationEvent(ApplicationFailedEvent event) {
    System.err.println("......ApplicationFailedEvent......");
  }
}
