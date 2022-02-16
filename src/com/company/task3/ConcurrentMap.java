package src.com.company.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.function.BiFunction;

public class ConcurrentMap implements Map {
  private Map map;
  private final Semaphore semaphore;
  public ConcurrentMap(int count) {
    this.map = new HashMap();
    this.semaphore = new Semaphore(count);
  }

  @Override
  public int size() {
    try {
      semaphore.acquire();
      return map.size();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return 0;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public boolean isEmpty() {
    try {
      semaphore.acquire();
      return map.isEmpty();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public boolean containsKey(Object key) {
    try {
      semaphore.acquire();
      return map.containsKey(key);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public boolean containsValue(Object value) {
    try {
      semaphore.acquire();
      return map.containsValue(value);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Object get(Object key) {
    try {
      semaphore.acquire();
      return map.get(key);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Object compute(Object key, BiFunction remappingFunction) {
    try {
      semaphore.acquire();
      return map.compute(key, remappingFunction);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Object put(Object key, Object value) {
    try {
      semaphore.acquire();
      System.out.println(value);
      return map.put(key, value);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Object remove(Object key) {
    try {
      semaphore.acquire();
      return map.remove(key);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public void putAll(Map m) {
    try {
      semaphore.acquire();
      map.putAll(m);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  @Override
  public void clear() {
    try {
      semaphore.acquire();
      map.clear();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Set keySet() {
    try {
      semaphore.acquire();
      return map.keySet();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Collection values() {
    try {
      semaphore.acquire();
      return map.values();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }

  @Override
  public Set<Entry> entrySet() {
    try {
      semaphore.acquire();
      return map.entrySet();
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      semaphore.release();
    }
  }
}
