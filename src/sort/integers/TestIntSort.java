package sort.integers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
public class TestIntSort {
    
    private IntISort sorter;
    
    @Before
    public void init()
    {
        sorter = new IntBubbleSort();
    }


    private void checkSort(int[] expected, int[] observed)
    {
        assertEquals(expected.length, observed.length);
        assertArrayEquals(expected, observed);
    }

    private int[] createNewSorted(int[] in)
    {
        int[] out = in.clone(); //Works for primitives
        Arrays.sort(out);
        return out;
    }
    
    @Test
    public void TestEmpty()
    {
        int[] empty = new int[] {};
        checkSort(empty, sorter.sort(empty));
    }
    
    @Test
    public void TestSingle()
    {
        int[] single = new int[] {1};
        checkSort(single, sorter.sort(single));
    }

    @Test
    public void TestDuplicates()
    {
        int[] zeros = new int[] { 0, 0, 0 };
        checkSort(zeros, sorter.sort(zeros));
        int[] ones = new int[] { 1, 1, 1, };
        checkSort(ones, sorter.sort(ones));
        int[] negOnes = new int[] { -1, -1, -1 };
        checkSort(negOnes, sorter.sort(negOnes));
        int[] dupPerm1 = new int[] { 1, 0, 1 };
        checkSort(createNewSorted(dupPerm1), sorter.sort(dupPerm1));
        int[] dupPerm2 = new int[] { 1, 0, 1 };
        checkSort(createNewSorted(dupPerm2), sorter.sort(dupPerm1));
    }

    @Test
    public void TestInOrder()
    {
        int[] duplicates = new int[] { 0, 1, 1 };
        checkSort(duplicates, sorter.sort(duplicates));
        int[] simple = new int[] { 1, 2, 3, 4, 5 };
        checkSort(simple, sorter.sort(simple));
        int[] zero = new int[] { 0, 0, 1, 1, 2, 3, 3, };
        checkSort(zero, sorter.sort(zero));
        int[] negative = new int[] { -1, 0, 1 };
        checkSort(negative, sorter.sort(negative));
        int[] onlyNegative = new int[] { -5, -4, -3, -2, -1 };
        checkSort(onlyNegative, sorter.sort(onlyNegative));
}
    
    @Test
    public void TestNegatives()
    {
        int[] onlyNegative = { -3, - 5, - 2, -1, -4 };
        checkSort(createNewSorted(onlyNegative), sorter.sort(onlyNegative));
        int[] negAndZero = { -7, -9, 0, -8, 0, -1, -2, -1, -5, -4 };
        checkSort(createNewSorted(negAndZero), sorter.sort(negAndZero));
        int[] mix = { -7, 9, 7, -4, 3, 0, 2, -1, 0 , 5, -8, -8 };
        checkSort(createNewSorted(mix), sorter.sort(mix));
    }

    @Test
    public void TestReverse()
    {
        int[] simple = { 5, 4, 3, 2, 1 };
        checkSort(createNewSorted(simple), sorter.sort(simple));
        int[] zero = { 4, 3, 2, 1, 0 };
        checkSort(createNewSorted(zero), sorter.sort(zero));
        int[] negative = { 2, 1, 0, -1, -2 };
        checkSort(createNewSorted(negative), sorter.sort(negative));
    }

    @Test
    public void TestNormal ()
    {
        int[] simple = { 2, 5, 3, 4, 1 };
        checkSort(createNewSorted(simple), sorter.sort(simple));
    }

    @Test
    public void TestRandomLists()
    {
        Random r = new Random();
        for(int i = 0; i < 100; i ++)
        {
            int[] list = new int[r.nextInt(1000)];
            for(int j = 0; j < list.length; j++)
            {
                list[j] = r.nextInt();
            }
            checkSort(createNewSorted(list), sorter.sort(list));
        }
    }
}
