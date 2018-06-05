package cn.slimsmart.springboot.helloworld.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/** Created by zhutw on 2018/3/12. */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    System.err.println("......ApplicationReadyEvent......");
  }
}
