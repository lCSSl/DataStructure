package work.kaiyu.datastructure.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.LRUCache;
import work.kaiyu.datastructure.domain.Person;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

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
    public void testMap(){
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
    public void testTread(){

    }
    class MyCallable implements Callable<Integer> {
        public Integer call() {
            return 123;
        }
    }
}
