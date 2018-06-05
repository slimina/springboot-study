package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by zhutw on 2018/3/12.
 */
public class ApplicationStartingEventListener
        implements ApplicationListener<ApplicationStartingEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartingEvent event) {
    System.err.println("......ApplicationStartingEvent......");
  }
}
