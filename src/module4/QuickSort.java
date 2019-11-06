package module4;

public class QuickSort {
    int arr[] = {50,60,90,100,10,20,50,200,190,20,190};
    public static void main(String args[]){
        QuickSort qs = new QuickSort();
        qs.quickSort(0, qs.arr.length-1);
        for (int num:qs.arr)
            System.out.println(num);
    }

    void quickSort(int low, int high){
        if (low < high){
            int pivot_index = partition(low, high);
            quickSort(low, pivot_index);
            quickSort(pivot_index+1, high);
        }
    }

    int partition(int low, int high){
        int pivot = arr[low], l=low, h=high;
        while (l < h){
            /*while(l < high && arr[l] <= pivot){
                ++l;
            }*/
            do{
                    ++l;
            }while(l < high && arr[l] < pivot);
            /*while(h > low && arr[h] >= pivot){
                --h;
            }*/
            do{
                if (arr[h] < pivot){
                    break;
                }
                --h;
            }while(h > low && arr[h] > pivot);
            if (l < h) {
                //swap
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }
        }

            //swap the pivot with the last element which is smaller than pivot.
            arr[low] = arr[h];
            arr[h] = pivot;

        //return pivot index
        return h;
    }
}
