package stack;

import java.util.List;

public interface IStack<E> {
    public void push(E e);
    public boolean pop();
    public E peek();
    public List<E> toList();
}
