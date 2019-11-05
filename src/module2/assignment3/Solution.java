package module2.assignment3;

class Solution{
    public int[] sortInsertion(int[] arr){
        if (arr != null && arr.length > 0){
            for (int index = 0; index < arr.length; index++){
                int temp = arr[index], temp_index = index;
                for (int back_index = index - 1; back_index > -1; back_index--){
                    if (arr[back_index] > temp)
                        arr[temp_index--] = arr[back_index];
                    else
                        break;
                }
                arr[temp_index] = temp;
            }
        }
        return arr;
    }
    public int[] sortSelection(int[] arr){
        if (arr != null && arr.length > 0){
            for (int index =0 ; index<arr.length; index++){
                int min = arr[index], min_index = index, temp = arr[index];
                for (int next_index = index + 1; next_index < arr.length; next_index++){
                    if (min > arr[next_index]){
                        min = arr[next_index];
                        min_index = next_index;
                    }
                }
                arr[index] = min;
                arr[min_index] = temp;
            }
        }
        return arr;
    }
}
