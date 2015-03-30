package sort.integers;
public abstract class IntISort {

    // Takes a list of integers and sorts them in non-decreasing order
    public abstract int[] sort(int[] in);

    public abstract String name();

    // Returns the steps it takes to perform the sort
    public abstract int[][] sortSteps(int[] in);

    // Assume that all rows are equal length, and all rows are defined.
    public int[][] expandRow(int[][] in)
    {
        if(in.length == 0)
            return new int[1][];
        int[][] out = new int[in.length*2][];
        for(int i = 0; i < in.length; i++)
            out[i] = in[i];
        return out;
    }

    public static int size(int[][] in)
    {
        int count;
        for(count = 0; count < in.length && in[count] != null; count++)
        {
            // Do nothing here
        }
        return count;
    }

    public static String printArray(int[][] in)
    {
        String out = "{ ";
        for(int i = 0; i < size(in) - 1; i++)
        {
            out += printArray(in[i]) + ", \n";
        }
        out += size(in) > 0 ? printArray(in[size(in) - 1]) + " }" : "}";
        return out;
    }

    public static String printArray(int[] in)
    {
        String out = "{ ";
        for(int i = 0; i < in.length - 1; i++)
        {
            out += in[i] + ", ";
        }
        out += in.length > 0 ? in[in.length - 1] + " }" : "}";
        return out;
    }


    //public Complexity computeComplexity();
}


