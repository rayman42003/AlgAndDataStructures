package sort.integers;

public class IntInsertionSort extends IntISort 
{
    @Override
    public int[] sort(int[] list)
    {
        for(int i = 1; i < list.length; i++)
        {
            int j = i;
            for( ; j > 0 && list[j-1] > list[j]; j--)
            {
                swap(list, j, j-1); 
            }
        }
        return list;
    }

    @Override
    public int[][] sortSteps(int[] list)
    {
        int[][] res = new int[10][];
        res[0] = list.clone();

        for(int i = 1; i < list.length; i++)
        {
            int j = i;
            for( ; j > 0 && list[j-1] < list[j]; j--)
            {
                swap(list, j, j-1);
            }

            res[i] =  list.clone(); // only for primitives
        }
        return res;
    }

    @Override
    public String name()
    {
        return "Selection Sort";
    }

    private boolean swap(int[] list, int a, int b)
    {
        if(a >= 0 && a < list.length && b >= 0 && b < list.length)
        {
            int temp = list[a];
            list[a] = list[b];
            list[b] = temp;
            return true;
        }
        return false;
    }
}

