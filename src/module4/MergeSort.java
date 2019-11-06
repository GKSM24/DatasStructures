package module4;

public class MergeSort {
    int arr[] = {25,0,1,15,10,13,1,2,15,14,20};
    public static void main(String args[]){
        MergeSort ms = new MergeSort();
        ms.mergeSort(0, ms.arr.length-1);
        for(int num:ms.arr)
            System.out.println(num);
    }

    void mergeSort (int low, int high){
        if (low < high){
            int mid = (low+high)/2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }

    void merge(int low, int mid, int high){
        int l = low, m = mid + 1, tempArr[] = new int[high-low+1], k = 0;
        while (l <= mid && m <= high){
            if (arr[l] < arr[m])
                tempArr[k++] = arr[l++];
            else if (arr[m] < arr[l])
                tempArr[k++] = arr[m++];
            else{
                tempArr[k++] = arr[l++];
                tempArr[k++] = arr[m++];
            }
        }
        for (;l <= mid; l++)
            tempArr[k++] = arr[l];
        for(;m <= high; m++)
            tempArr[k++] = arr[m];
        k= 0;
        for(int index = low; index <= high; index++)
            arr[index] = tempArr[k++];
    }
}
