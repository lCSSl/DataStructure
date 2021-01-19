package work.kaiyu.datastructure.list;

import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Accessors(chain = true)
public class ArrayList<E> extends AbstractList<E> {
    private Object[] elements;
    private final static Logger log = LoggerFactory.getLogger(ArrayList.class);

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        elements = new Object[(capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity];
    }


    @Override
    public int size() {
        return this.size;
    }

    /**
     * 增加
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * 当前位置增加一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1,
                size - index);
//        for (int i = size - 1; i >= index; i--) {
//            elements[i + 1] = elements[i];
//        }
        elements[index] = element;
        size++;
    }

    /**
     * Clear Array
     * point to the new object array
     * clear to let GC do its work
     */
    @Override
    public void clear() {
//        modCount++;
//        elements = new Object[DEFAULT_CAPACITY];
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    @Override
    public E remove(int index) {

        rangeCheck(index);

        E old = elementData(index);

        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }

        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;

        return old;
    }

    /**
     * 替换元素
     *
     * @param index
     * @param element
     */
    @Override
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
    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }


    /**
     * 查询元素位置
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
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

    @Override
    protected void finalize() throws Throwable {
        log.warn(this.getClass().getName() + "--finalize");
        super.finalize();
    }
}
