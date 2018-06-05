package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** Created by zhutw on 2018/3/12. */
public class ApplicationStartedEventListener
    implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    System.err.println("......ApplicationStartedEvent......");
  }
}
