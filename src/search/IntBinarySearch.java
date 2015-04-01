package search;

public class IntBinarySearch
{
    public static int find(int[] list, int value)
    {
        return find(list, value, 0, list.length-1);
    }

    private static int find(int[] list, int value, int low, int high)
    {
        if(list.length == 0 || low > high)
            return -low - 1;
        int mid = (low + high)/2;
        if(list[mid] == value)
            return mid;
        if(list[mid] > value)
            return find(list, value, low, mid-1);
        return find(list, value, mid+1, high);
    }
}
