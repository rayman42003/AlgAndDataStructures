package stack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TestIntStack {
    private IStack<Integer> stack;

    @Before
    public void init() 
    {
        stack = new LinkedListStack<Integer>();
    }

    private void add(int[] list, IStack s)
    {
        for(int i = 0; i < list.length; i++)
            s.push(list[i]);
    }

    private void pop(int num, IStack s)
    {
        for(int i = 0; i < num; i++)
            s.pop();
    }

    private List<Integer> reverse(int[] list)
    {
        List<Integer> stackList = new ArrayList<Integer>();
        for(int i = 0; i < list.length; i++)
            stackList.add(list[i]);
        Collections.reverse(stackList);
        return stackList;
    }

    @Test
    public void TestEmpty()
    {
        assertEquals(false, stack.pop());
        assertEquals(0, stack.toList().size());
        stack.push(1);
        stack.pop();
        assertEquals(false, stack.pop());
        assertEquals(0, stack.toList().size());
    }

    @Test
    public void TestSimple()
    {
        int[] toAdd = new int[] { 1, 2, 3 };
        add(toAdd, stack);
        assertEquals(toAdd.length, stack.toList().size());
        assertEquals(reverse(toAdd), stack.toList());
        for(int i = toAdd.length-1; i >= 0; i--)
        {
            assertEquals(new Integer(toAdd[i]), stack.peek());
            assertEquals(true, stack.pop());
        }
        assertEquals(false, stack.pop());
    }
}

