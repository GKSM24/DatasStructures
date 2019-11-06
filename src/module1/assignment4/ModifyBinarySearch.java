package module1.assignment4;

public class ModifyBinarySearch {
    int arr[] = {1,1,1,2,2,2,2,2,2,3,3,4,5,6,7,7,8};
    public static void main(String args[]){
        ModifyBinarySearch mbs = new ModifyBinarySearch();
        System.out.println(mbs.binarySearch(2));
    }

    int binarySearch(int key){
        int low= 0, high = arr.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if (key > arr[mid]) low = mid + 1;
            else if (key < arr[mid]) high = mid - 1;
            else{
                if (low == high && key == arr[low])
                    return low;
                if (arr[high - 1] == key || arr[low + 1] == key)
                    continue;
            }
        }
        return -1;
    }
}
