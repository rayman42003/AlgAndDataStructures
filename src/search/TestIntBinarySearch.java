import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;
import java.util.Arrays;
public class TestIntBinarySearch
{
    @Test
    public void TestEmpty()
    {
        assertEquals(-1, IntBinarySearch.find(new int[] {}, 1));
    }
    
    @Test
    public void TestSingle()
    {
        int[] list = new int[] {0};
        assertEquals(-1, IntBinarySearch.find(list, -1));
        assertEquals(0, IntBinarySearch.find(list, 0));
        assertEquals(-2, IntBinarySearch.find(list,1));
    }

    @Test
    public void TestDuplicates()
    {
        int[] dup = new int[] { -1, -1 };
        assertEquals(0, IntBinarySearch.find(dup, -1));
        assertEquals(-1, IntBinarySearch.find(dup, -2));
        assertEquals(-3, IntBinarySearch.find(dup, 0));
        int[] trip = new int[] { 1, 1, 1 };
        assertEquals(-1, IntBinarySearch.find(trip, -1));
        assertEquals(0, IntBinarySearch.find(trip, 1));
        assertEquals(-4, IntBinarySearch.find(trip, -2));
    }
    
    @Test
    public void TestSimple()
    {
        int[] list = new int[] { -5, -3, 0, 2, 4 };
        assertEquals(-1, IntBinarySearch.find(list, -6));
        assertEquals(0, IntBinarySearch.find(list, -5));
        assertEquals(-2, IntBinarySearch.find(list, -4));
        assertEquals(0, IntBinarySearch.find(list, -3));
        assertEquals(-3, IntBinarySearch.find(list, -2));
        assertEquals(-3, IntBinarySearch.find(list, -1));
        assertEquals(0, IntBinarySearch.find(list, 0));
        assertEquals(-4, IntBinarySearch.find(list, 1));
        assertEquals(0, IntBinarySearch.find(list, 2));
        assertEquals(-5, IntBinarySearch.find(list, 3));
        assertEquals(0, IntBinarySearch.find(list, 4));
        assertEquals(-6, IntBinarySearch.find(list, 5));
    }   

    //@Test
    //public void TestMaxIntArray()
    //{
    //}

    @Test
    public void TestRandom()
    {
        int range = 100;
        Random r = new Random();
        for(int i = 0; i < 1000; i++)
        {
            int[] list = new int[r.nextInt(1000)];
            for(int j = 0; j < list.length; j++)
            {
                list[j] = r.nextInt(range) - range/2;
            }
            Arrays.sort(list);
            int toFind = r.nextInt(2*range) - range;
            assertEquals(Arrays.binarySearch(list, toFind), IntBinarySearch.find(list, toFind));
        }
    }
}
