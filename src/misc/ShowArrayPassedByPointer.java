package misc;
import java.util.Arrays;


public class ShowArrayPassedByPointer {

    public static void main(String[] args) 
    {
        int[] help = new int[]{ 1, 2, 3, 4, 5};
        int[] pointer = help;
        int[] newObj = help.clone();
        System.out.println("Start: " + printArray(help));
        System.out.println("Method Return: " + printArray(testSwap(help, 0 , 1)));
        System.out.println("End: " + printArray(help));
        System.out.println("Pointer: " + printArray(pointer));
        System.out.println("New obj: " + printArray(newObj));
        System.out.println("createNewSorted(): " + printArray(createNewSorted(help)));
        System.out.println("Original array: " + printArray(help));
    }
    
    public static int[] testSwap(int[] in, int a, int b)
    {
        if(a >= 0 && a < in.length && b >= 0 && b < in.length)
        {
            int temp = in[a];
            in[a] = in[b];
            in[b] = temp;
        }
        System.out.println("In method: " + printArray(in));
        return in;

    }
    
    public static String printArray(int[] in)
    {
        String out = "{ ";
        for(int i = 0; i < in.length -1; i++)
            out += (in[i] + ", ");
        out += in.length > 0 ? in[in.length - 1] + " }" : "}";
        return out;
    }
    
    public static int[] createNewSorted(int[] in)
    {
        int[] out = in.clone(); //Works for primitives
        Arrays.sort(out);
        return out;
    }

}
