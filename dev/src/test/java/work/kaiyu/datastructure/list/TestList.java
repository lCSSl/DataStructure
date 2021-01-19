package work.kaiyu.datastructure.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import work.kaiyu.datastructure.domain.Person;

import java.lang.reflect.Array;

@Slf4j
public class TestList {
    @Test
    public void functionTest() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("a", 1));
        list.add(new Person("b", 2));
        list.add(null);
        list.add(new Person("c", 3));
        list.add(new Person("d", 4));
        list.add(new Person("e", 5));
        list.add(null);
        list.add(new Person("f", 6));
        list.add(new Person("g", 7));
        list.add(new Person("h", 8));
        list.add(null);
        list.add(new Person("i", 9));
        list.add(new Person("j", 10));
        list.add(new Person("k", 11));
        list.add(null);
        list.add(new Person("l", 12));
        int i = list.indexOf(null);
        System.out.println(i);
        Person[] people = new Person[2];
        log.error("list:{}", list);
    }

    @Test
    public void toDoTList() {
    }


    public static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object) newType == (Object) Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }
}
