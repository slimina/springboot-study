package cn.slimsmart.springboot.taks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AsyncTask task;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> f1 = task.doTaskOne();
        Future<String> f2 = task.doTaskTwo();
        Future<String> f3 = task.doTaskThree();
        f1.get();
        f2.get();
        f3.get();
        System.out.println(f1.isDone());
        System.out.println(f2.isDone());
        System.out.println(f3.isDone());
        System.out.println("任务全部完成，总耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    @Autowired
    private AsyncThreadPoolTask poolTask;

    @Test
    public void poolTest() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> f1 = poolTask.doTaskOne();
        Future<String> f2 = poolTask.doTaskTwo();
        f1.get();
        f2.get();
        System.out.println("任务全部完成，总耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
