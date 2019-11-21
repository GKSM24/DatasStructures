package module6.assignment1;

public class Solution{
    public static boolean isMinHeap(double[] arr){
        if(arr.length == 0)
            return false;
        else if(arr.length == 1)
            return true;
        else{
            for(int index = 0; index < arr.length/2; index++){
                if((2*index + 1) < arr.length)
                    if(arr[index] >  arr[2*index + 1])
                        return false;
                if((2*index + 2) < arr.length)
                    if(arr[index] > arr[2*index + 2])
                        return false;
            }
            return true;
        }
    }
}
