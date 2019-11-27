package module19;

/*
* Farthest pair (in one dimension). Write a program that, given an array a[] of N double values,
* finds a farthest pair : two values whose difference is no smaller than the difference between any other pair.
* The running time of your program should be linear in the worst case. (Analysis of Algorithms)
* */

public class Assignment1 {
    public static void main(String[] args){
        double arr[] = {4.8,9.1,3.4,2.2,7.8,-1.3,10.7,11.9,-2.4,-10.9};
        findFarthestPair(arr);
    }

    static void findFarthestPair(double arr[]){
        if(arr != null && arr.length > 0){
            double min = arr[0], max = arr[0];
            for(int index = 0; index < arr.length; index++){
                if(min > arr[index])
                    min = arr[index];
                if(max < arr[index])
                    max = arr[index];
            }
            System.out.println("The farthest pair: "+"("+min+", "+max+")");
        }
        else
            System.out.println("arr is empty.");
    }
}
