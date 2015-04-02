package sort.integers;

public class IntInsertionSort extends IntISort 
{
    @Override
public int[] sort(int[] list)
{
for(int i = 1; i < list.length; i++)
{
for(int j = i; j >= 0 && list[j] > list[i]; j--)
{
    swap(list, i, j);
}
}
return list;
}

@Override
public int[][] sortSteps(int[] list)
{
    int[][] res = new int[10][];
    res[0] = list;

    for(int i = 1; i < list.length; i++)
    {
        for(int j = i; j >= 0 && list[j] > list[i]; j--)
        {
            swap(list, i, j);
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
        
