package module3;

public class Problem1 {

    public static void main(String args[]){
        char arr[] = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        arr = selectionSort(arr);
        for(int index = 0; index < arr.length; index++)
            System.out.println(arr[index]);
    }

    static char[] selectionSort(char[] arr){
        for (int index = 0; index < arr.length - 1; index++){
            int minIndex = findMinimumValueIndex(arr, index, arr[index]);
            char temp  = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    static int findMinimumValueIndex(char[] arr, int index, int key){
        char min = arr[index];
        int returnIndex = index;
        index += 1;
        while(index < arr.length){
            if (min > arr[index]) {
                min = arr[index];
                returnIndex = index;
            }
            index++;
        }
        return  returnIndex;
    }

}
