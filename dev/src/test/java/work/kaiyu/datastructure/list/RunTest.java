package work.kaiyu.datastructure.list;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class RunTest {
    @Test
    public void testRun() {
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.hashCode();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.size();
    }

    @Test
    public void testMap() {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }

    class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private static final int MAX_ENTRIES = 3;

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }

        LRUCache() {
            super(MAX_ENTRIES, 0.75f, true);
        }
    }

    @Test
    @SneakyThrows
    public void testTread() {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }

    class MyCallable implements Callable<Integer> {
        public Integer call() {
            return 123;
        }
    }

    /**
     * 可以用原子类、synchronized修饰 或 ReentrantLock类加锁
     */
    @Test
    @SneakyThrows
    public void testMultipleTread() {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
//                synchronized (this) { example.add(); }
//                lock.lock();
//                try {
                example.add();
//                } finally {
//                    lock.unlock();
//                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }

    class ThreadUnsafeExample {

        //        private AtomicInteger cnt = new AtomicInteger();
        private int cnt = 0;

        public void add() {
//            cnt.incrementAndGet();
            cnt++;
        }

        public int get() {
//            return cnt.get();
            return cnt;
        }
    }
}
