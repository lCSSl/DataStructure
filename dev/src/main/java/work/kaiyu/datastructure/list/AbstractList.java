package work.kaiyu.datastructure.list;

public abstract class AbstractList<E> implements List<E>{
    protected int size = 0;
    @Override
    public void add(E element) {
        add(this.size, element);
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return size == 0;
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
    protected String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
}
