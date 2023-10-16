package view;

import java.util.HashSet;
import java.util.Set;
import controller.Node;

public class Principal<E> {
    private Node<E> head;
    private int size;
    private Set<E> set;

    public Principal() {
        head = null;
        size = 0;
        set = new HashSet<>();
    }

    public void add(E data) {
        if (!set.contains(data)) {
            Node<E> newNode = new Node<>(data);
            newNode.setNext(head);
            head = newNode;
            size++;
            set.add(data);
        }
    }

    public void remove(E data) {
        if (head == null) {
            return;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            set.remove(data);
            return;
        }

        Node<E> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                set.remove(data);
                return;
            }
            current = current.getNext();
        }
    }

    public boolean contains(E data) {
        return set.contains(data);
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
        set.clear();
    }
}

