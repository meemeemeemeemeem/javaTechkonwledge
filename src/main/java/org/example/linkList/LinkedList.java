package org.example.linkList;

/**
 * @Author mei
 * @create 2023/1/1 14:05
 */
public class LinkedList<E> {
    /**
     * 空构造方法
     */
    public LinkedList() {
    }

    /**
     * 链表节点
     *
     * @param <E>
     */
    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
