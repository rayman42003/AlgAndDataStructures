package sort.integers;
import java.util.Random;

public class IntQuickSort extends IntISort
{
    @Override
    public int[] sort(int[] list)
    {
        return quicksort(list, 0, list.length - 1); 
    }

    private int[] quicksort(int[] list, int low, int high)
    {
        if(low > high)
            return list;
        int pos = partition(list, low, high);
        quicksort(list, low, pos-1);
        quicksort(list, pos+1, high);
    }

    private int paritition(int[] list, int low, int high)
    {
        Random r = new Random();
        int pivot = r.nextInt(low, high);   
        int value = list[pivot];
        swap(list, pivot, high);
        int left = low;
        int right = high-1;
        while(left <= right)
        {
            while(list[left] < value && left <= right)
                left++;
            while(list[right] > value && left <= right)
                right--;
            swap(list, left, right);    
        }
        list[left] = pivot;
        return pivot;
    }

    private boolean swap(int[] list, int a, int b)
    {
        if(a >= 0 && a < list.length && b >= 0 && a < list.length)
        {
            int temp = list[a];
            list[a] = list[b];
            list[b] = temp;
            return true;
        }
        return false;
    }

    @Override
    public int[][] sortSteps(int[] list)
    {
        int[][] res = new res[10][];
        res[0] = list.clone();
        res[1] = sort(list);
        return res;
    }

    @Override
    public String name()
    {
        return "Quick sort";
    }
}
