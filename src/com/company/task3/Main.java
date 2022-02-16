package src.com.company.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws InterruptedException {
//    testMap();
    testSet();
  }
  private static void testMap() throws InterruptedException {
    Map defaultMap = new HashMap<>();
    ConcurrentMap map = new ConcurrentMap(1);
    Thread thread1 = new Thread(()->{
      for (int i = 0; i < 1_000_000; i++) {
        map.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
        defaultMap.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
      }
    });
    Thread thread2 = new Thread(()-> {
      for (int i = 0; i < 1_000_000; i++) {
        map.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
        defaultMap.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
      }
    });
    Thread thread3 = new Thread(()-> {
      for (int i = 0; i < 1_000_000; i++) {
        map.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
        defaultMap.compute("test", (k, v) -> v == null ? 1 : (int)v + 1);
      }
    });
    thread1.start();
    thread2.start();
    thread3.start();
    Thread.sleep(3000);
    System.out.println(map.get("test"));
    System.out.println(defaultMap.get("test"));
  }
  private static void testSet() throws InterruptedException {
    Set defaultSet = new HashSet<Integer>();
    ConcurrentSet set = new ConcurrentSet<Integer>();
    Thread thread1 = new Thread(()->{
      for (int i = 1; i <= 10_000; i++) {
        set.add(i);
        defaultSet.add(i);
      }
    });
    Thread thread2 = new Thread(()-> {
      for (int i = 10_001; i <= 20_000; i++) {
        set.add(i);
        defaultSet.add(i);
      }
    });
    Thread thread3 = new Thread(()-> {
      for (int i = 20_001; i <= 30_000; i++) {
        set.add(i);
        defaultSet.add(i);
      }
    });
    thread1.start();
    thread2.start();
    thread3.start();
    Thread.sleep(3000);
    System.out.println(set.size());
    System.out.println(defaultSet.size());
  }
}
