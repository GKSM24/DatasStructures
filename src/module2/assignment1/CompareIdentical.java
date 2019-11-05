package module2.assignment1;

public class CompareIdentical {
    int costSelectionSort = 1, costInsertionSort = 1;
    int arr[] = {1,1,1,1,1,1,1,1};
    public static void main(String args[]){
        int arr[] = {1,1,1,1,1,1,1,1};
        CompareIdentical ci = new CompareIdentical();
        ci.selectionSort(arr);
        ci.insertionSort(arr);
        System.out.println("Selection sort cost:"+ci.costSelectionSort);
        System.out.println("Insertion sort cost:"+ci.costInsertionSort);
    }

    void selectionSort(int[] arr){
        for (int index = 0; index < arr.length; index++){
            int min = arr[index], min_index = index, temp = arr[index];
            costSelectionSort+=4;
            for (int next_index = index+1; next_index < arr.length; next_index++, costSelectionSort+=3){
                if (min > arr[next_index]){
                    min = arr[next_index];
                    min_index = next_index;
                    costSelectionSort += 2;
                }
            }
            arr[index] = arr[min_index];
            arr[min_index] = temp;
            costSelectionSort+=2;
        }
    }

    void insertionSort(int[] arr){
        for (int index = 1; index < arr.length; index++){
            int temp = arr[index], temp_index = index;
            costInsertionSort += 3;
            for (int back_index = index - 1; back_index > -1; back_index--, costInsertionSort+=3){
                if (arr[back_index] > temp) {
                    arr[temp_index--] = arr[back_index];
                    costInsertionSort += 1;
                }
                else
                    break;
            }
            arr[temp_index] = temp;
            costInsertionSort+=1;
        }
    }
}
