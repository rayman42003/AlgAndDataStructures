package sort.integers;

public class IntBubbleSort extends IntISort {

    @Override
    public int[] sort(int[] in)
    {
        for(int i = 0; i < in.length-1; i++)
        {
            boolean swapMade = false;
            for(int j = 0; j < in.length-1-i; j++)
            {
                if(in[j] > in[j+1])
                {
                    swap(in, j, j+1);
                    swapMade = true;
                }
            }
            if(!swapMade)
                return in;
        }
        return in;
    }

    private boolean swap(int[] in, int a, int b)
    {
        if(a >= 0 && a < in.length && b >= 0 && b < in.length)
        {
            int temp = in[a];
            in[a] = in[b];
            in[b] = temp;
            return true;
        }
        return false;
    }

    @Override
    public String name()
    {
        return "Bubble Sort";
    }

    @Override
    public int[][] sortSteps(int[] in)
    {
        int[][] steps = new int[10][];
        steps[0] = in.clone(); //Only works for primitives
        int stepCount = 1;
        for(int i = 0; i < in.length-1; i++)
        {
            boolean swapMade = false;
            for(int j = 0; j < in.length-1-i; j++)
            {
                if(in[j] > in[j+1])
                {
                    swap(in, j, j+1);
                    swapMade = true;
                }
            }
            if(!swapMade)
                return steps;
            if(stepCount >= steps.length)
                expandRow(steps);
            steps[stepCount++] = in.clone(); //Only works for primitives
        }
        return steps;
    }

}
