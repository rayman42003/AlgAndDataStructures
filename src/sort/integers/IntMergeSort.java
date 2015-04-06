package sort.integers;

public class IntMergeSort extends IntISort
{
    @Override
    public int[] sort(int[] list)
    {
        if(list.length <= 1)
            return list;
        int mid = (list.length-1)/2;
        int[] left = sort(copyArray(list, 0, mid));
        int[] right = sort(copyArray(list, mid+1, list.length-1));
        return merge(left, right);
    }

    private int[] copyArray(int[] list, int low, int high)
    {
        int[] copy = new int[high - low + 1];
        for(int i = low; i <= high; i ++)
            copy[i-low] = list[i];
        return copy;
    }

    private int[] merge(int[] left, int[] right)
    {
        int[] out = new int[left.length + right.length];
        int lCount = 0;
        int rCount = 0;
        while(lCount < left.length && rCount < right.length)
        {
            if(left[lCount] <= right[rCount])
                out[lCount+rCount] = left[lCount++];
            else
                out[lCount+rCount] = right[rCount++];
        }
        while(lCount < left.length)
            out[lCount+rCount] = left[lCount++];
        while(rCount < right.length)
            out[lCount+rCount] = right[rCount++];
        return out;
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
        return "Merge Sort";
    }
}
