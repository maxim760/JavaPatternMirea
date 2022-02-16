package src.com.company.task4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {
  private ExecutorService service;

  public MyExecutorService(int threadsCount) {
    this.service = Executors.newFixedThreadPool(threadsCount);
  }

  @Override
  public void shutdown() {
    service.shutdown();
  }

  @Override
  public List<Runnable> shutdownNow() {
    return service.shutdownNow();
  }

  @Override
  public boolean isShutdown() {
    return service.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return service.isTerminated();
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    return service.awaitTermination(timeout, unit);
  }

  @Override
  public <T> Future<T> submit(Callable<T> task) {
    return service.submit(task);
  }

  @Override
  public <T> Future<T> submit(Runnable task, T result) {
    return service.submit(task, result);
  }

  @Override
  public Future<?> submit(Runnable task) {
    return service.submit(task);
  }

  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
    return service.invokeAll(tasks);
  }

  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
    return service.invokeAll(tasks, timeout, unit);
  }

  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
    return service.invokeAny(tasks);
  }

  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
    return service.invokeAny(tasks, timeout, unit);
  }

  @Override
  public void execute(Runnable command) {
    service.execute(command);
  }
}
