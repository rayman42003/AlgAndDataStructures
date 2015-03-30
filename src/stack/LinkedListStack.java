package stack;

import java.util.List;
import java.util.ArrayList;

public class LinkedListStack<E> implements IStack<E> {
    public LinkedNode head;

    public LinkedListStack() {
        head = null;
    }

    public void push(E e) {
        LinkedNode node = new LinkedNode(e);
        node.next = head;
        head = node;
        // head = new LinkedNode(e).next = head;
    }

    public boolean pop() {
        if(head == null)
            return false;
        head = head.next;
        return true;
    }

    public E peek() {
        return head.data;
    }

    public List<E> toList() {
        ArrayList<E> res = new ArrayList<E>();
        for(LinkedNode curr = head; curr != null;  curr = curr.next)
            res.add(curr.data);
        return res;
    }


    private class LinkedNode {
        public LinkedNode(E e) {
            data = e;
            next = null;
        }
        public LinkedNode next;
        public E data;
    }
}
