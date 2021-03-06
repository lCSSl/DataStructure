package work.kaiyu.datastructure.list;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> firstNode;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            firstNode = new Node<>(element, null);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        firstNode = null;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        if (index == 0) {
            firstNode = firstNode.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        this.size--;
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode;
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }

        }

        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        Node<E> firstNode = this.firstNode;
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(":[");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(firstNode.element);
            firstNode = firstNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
