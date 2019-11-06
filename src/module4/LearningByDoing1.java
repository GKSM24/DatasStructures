package module4;

public class LearningByDoing1 {
    char[] arr = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
    public static void main(String args[]){
        LearningByDoing1 lbd1 = new LearningByDoing1();
        lbd1.mergeSort(0, lbd1.arr.length-1);
        for(char ch:lbd1.arr)
            System.out.println(ch);
    }

    public void mergeSort(int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(low,mid);
            mergeSort(mid+1,high);
            merge(low,mid,high);
        }
    }

    public void merge(int low, int mid, int high){
        int l = low, m =mid+1 , k = 0;
        char tempArr[] = new char[high - low +1];
        while (l <= mid && m <= high){
            if (arr[l] < arr[m])
                tempArr[k++] = arr[l++];
            else if(arr[m] < arr[l])
                tempArr[k++] = arr[m++];
            else{
                tempArr[k++] = arr[m++];
                tempArr[k++] = arr[l++];
            }
        }
        for(;l <= mid;l++)
            tempArr[k++] = arr[l];
        for(;m <= high;m++)
            tempArr[k++] = arr[m];
        k =0;
        for(int index = low; index <= high; index++)
            arr[index] = tempArr[k++];
    }
}
