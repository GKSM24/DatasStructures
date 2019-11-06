package module4;

public class LearningByDoing2 {
    char[] arr = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
    public static void main(String args[]){
        LearningByDoing2 qs = new LearningByDoing2();
        qs.quickSort(0, qs.arr.length-1);
        for (char num:qs.arr)
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
        char pivot = arr[low];
        int l=low, h=high;
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
                char temp = arr[l];
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
