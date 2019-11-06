package module3;

public class Problem2 {

    public static void main(String args[]){
        char arr[] = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        arr = insertionSort(arr);
        for (char number:arr)
            System.out.println(number);
    }

    static char[] insertionSort(char[] arr){
        for (int index = 1;index < arr.length; index++){
            char temp = arr[index];
            int temp_index = index;
            for (int back_index = index - 1; back_index > -1 ;back_index--) {
                if (arr[back_index] > temp){
                    arr[temp_index] = arr[back_index];
                    temp_index--;
                }
                else{
                    break;
                }
            }
            arr[temp_index] = temp;
        }
        return arr;
    }

}
