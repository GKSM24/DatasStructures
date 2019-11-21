package module6.assignment2;

public class Solution{
    public static double[] dynamicMedian(double[] arr){
        double arr_mod[] = new double[arr.length];
        for(int index = 0; index < arr.length; index++){
            double temp = arr[index];
            int temp_index = index;
            for(int back_index = index - 1; back_index > -1; back_index--){
                if(temp < arr[back_index])
                    arr[temp_index--] = arr[back_index];
                else
                    break;
            }
            arr[temp_index] = temp;

            //median finding
            if((index+1) % 2 == 1)
                arr_mod[index] = arr[index/2];
            else {
                int i = (index + 1)/2;
                arr_mod[index] = (arr[i-1] + arr[i])/2;
            }
        }
        return arr_mod;
    }
}