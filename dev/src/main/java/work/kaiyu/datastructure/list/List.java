package work.kaiyu.datastructure.list;

public interface List<E> {
    static final  int DEFAULT_CAPACITY = 2;
    static final  int ELEMENT_NOT_FOUND = -1;
    static final  int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 增加
     *
     * @param element
     */
    void add(E element);

    /**
     * 当前位置增加一个元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * Clear Array
     * point to the new object array
     * clear to let GC do its work
     */
    void clear();

    E remove(int index);

    /**
     * 替换元素
     *
     * @param index
     * @param element
     */
    E set(int index, E element);

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 查询元素位置
     *
     * @param element
     * @return
     */
    int indexOf(E element);


}
