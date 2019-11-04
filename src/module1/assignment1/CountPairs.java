package module1.assignment1;
import java.util.*;
import java.time.Clock;

public class CountPairs {

    public static void main(String args[]){
        int[] arr = {1,1,1,1,1,7,5,4,3,2,8,7,3,2,8,7,4,5,10,1,7,4,3};
        //System.out.println(System.nanoTime());
        System.out.println(findPairQuadratic(arr));
        //System.out.println(System.nanoTime());
        System.out.println(findPairsSorted(arr));
        //System.out.println(System.nanoTime());
    }

    static int findPairQuadratic(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int countPairs = 0;
        for (int index = 0, count_value = 1; index < arr.length; index++, count_value = 1){
            if (!list.contains(arr[index])){
                for (int next_index = index + 1; next_index < arr.length; next_index++)
                    if (arr[index] == arr[next_index])
                        count_value++;
                countPairs += (count_value/2);
                list.add(arr[index]);
            }
        }
        return countPairs;
    }

    static int findPairsSorted(int[] arr){
        Arrays.sort(arr);
        int countPairs = 0;
        for (int index = 0, count_value = 1; index < arr.length - 1; index++){
            if (arr[index] != arr[index + 1]){
                countPairs += (count_value/2);
                count_value = 1;
                continue;
            }
            count_value++;
        }
        return countPairs;
    }
}
