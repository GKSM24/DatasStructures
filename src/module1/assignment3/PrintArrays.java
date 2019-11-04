package module1.assignment3;

import java.util.ArrayList;

public class PrintArrays {

    public static void main(String[] args){
        int[] arr1 = {1,3,5,7,13,16}, arr2 = {1,1,1,1,15};
        ArrayList<Integer> list = new ArrayList<>();
        if (arr1.length >= arr2.length){
            int i = 0, j = 0;
            for (; i < arr2.length && j < arr2.length; ){
                if (arr1[i] < arr2[j]){
                    list.add(arr1[i]);
                    i++;
                }
                else if(arr2[j] < arr1[i]){
                    list.add(arr2[j]);
                    j++;
                }
                else{
                    list.add(arr1[i]);
                    list.add(arr2[j]);
                    i++;
                    j++;
                }
            }
            if (i == arr2.length){
                while (j < arr2.length) {
                    list.add(arr2[j]);
                    j++;
                }
            }
            if (j == arr2.length){
                while (i < arr1.length) {
                    list.add(arr1[i]);
                    i++;
                }
            }
        }
        else {
            int i = 0, j = 0;
            for (; i < arr1.length && j < arr1.length; ){
                if (arr1[i] < arr2[j]){
                    list.add(arr1[i]);
                    i++;
                }
                else if(arr2[j] < arr1[i]){
                    list.add(arr2[j]);
                    j++;
                }
                else{
                    list.add(arr1[i]);
                    list.add(arr2[j]);
                    i++;
                    j++;
                }
            }
            if (i == arr1.length){
                while (j < arr2.length) {
                    list.add(arr2[j]);
                    j++;
                }
            }
            if (j == arr1.length){
                while (i < arr1.length) {
                    list.add(arr1[i]);
                    i++;
                }
            }
        }
        System.out.println(list);
    }
}
