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
        if(low >= high)
            return list;
        int pos = partition(list, low, high);
        quicksort(list, low, pos-1);
        quicksort(list, pos+1, high);
        return list;
    }

    private int partition(int[] list, int low, int high)
    {
        int pivot = choosePivot(low, high);
        int value = list[pivot];
        swap(list, pivot, high);
        int pivotPos = low;
        for(int i = low; i <= high-1; i++)
        {
            if(list[i] < value)
            {
                swap(list, i, pivotPos++);
            }
        }
        swap(list, pivotPos, high);
        return pivotPos;
    }
    
    private int choosePivot(int low, int high)
    {
        Random r = new Random();
        return r.nextInt(high - low + 1) + low;
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
        int[][] res = new int[10][];
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
