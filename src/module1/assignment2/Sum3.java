package module1.assignment2;

public class Sum3 {

    public static void main(String args[]){
        int arr[] = {30, -40, -20, -10, 40, 0, 10, 5}, sum3Count = 0;
        arr = bubbleSort(arr);
        if (arr != null && arr.length > 0) {
            for (int index = 0; index < arr.length; index++)
                for (int next_index = index + 1; next_index < arr.length; next_index++)
                    if (binarySearch(arr, -(arr[index] + arr[next_index]))) {
                        //System.out.println("("+arr[index]+","+ arr[next_index]+","+(arr[index]+ arr[next_index])+","+-(arr[index] + arr[next_index])+")");
                        sum3Count++;
                    }
        }
        System.out.println(sum3Count);
    }

    static int[] bubbleSort(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int index = 0; index < arr.length; index++)
                for (int next_index = index + 1; next_index < arr.length; next_index++)
                    if (arr[index] > arr[next_index]) {
                        int temp = arr[index];
                        arr[index] = arr[next_index];
                        arr[next_index] = temp;
                    }
        }
       return arr;
    }

    static boolean binarySearch(int[] arr, int key){
        int low = 0, high = arr.length - 1, mid = (low+high)/2;
        while (low <= high){
            if (key < arr[mid]) high = mid - 1;
            else if (key > arr[mid]) low = mid + 1;
            else return true;
            mid = (low+high)/2;
        }
        return false;
    }
}
