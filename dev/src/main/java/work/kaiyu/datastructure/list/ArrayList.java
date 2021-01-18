package work.kaiyu.datastructure.list;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Getter
@Setter
@Slf4j
public class ArrayList<E> {
    private int size = 0;
    private Object[] elements;
    private final static int DEFAULT_CAPACITY = 2;
    private final static int ELEMENT_NOT_FOUND = -1;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        elements = new Object[(capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity];
    }

    /**
     * 增加
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 当前位置增加一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity() {
        ensureCapacity(size + 1);
    }

    /**
     * 确认容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        Object[] newElements = new Object[newCapacity];
//        for (int i = 0; i < size; i++) {
//            newElements[i] = elements[i];
//        }
//        System.arraycopy(elements, 0, newElements, 0, elements.length);
//        elements = newElements;
        elements = Arrays.copyOf(elements, newCapacity);
        log.info("Grow Capacity");
    }

    public void clear() {
        size = 0;
    }

    public E remove(int index) {
        rangeCheck(index);
        E old = elementData(index);
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 替换元素
     *
     * @param index
     * @param element
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elementData(index);
        elements[index] = element;
        return old;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查询元素位置
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 转化类型
     *
     * @param index
     * @return
     */
    private E elementData(int index) {
        return (E) elements[index];
    }

    /**
     * 是否有这个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(":[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
