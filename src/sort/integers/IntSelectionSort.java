package sort.integers;

public IntSelectionSort extends IntISort
{
    @Override
    public int[] sort(int[] list)
    {
        for(int i = 0; i < list.length - 1; i++)
        {
            int minPos = i;
            for (int j = i+1; j < list.length; j++)
            {
                if(list[minPos] > list[j])
                    minPos = j;
            }
            swap(list, i, minPos);
        }
        return list;
    }

    @Override
    public int[][] sortSteps(int[] list)
    {
        int[][] res = new int[10][];
        res[0] = list.clone();
        for(int i = 0; i < list.length - 1; i++)
        {
            int minPos = i;
            for(int j = i+1; j < list.length; j++)
            {
                if(list[minPos] > list[j])
                    minPos = j;
            }
            swap(list, i, minPos);
            if(size(res) < i)
            expandRow(res);
            res[i+1]  = list.clone();
        }
        return res;
    }

    @Override
    public String name
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
