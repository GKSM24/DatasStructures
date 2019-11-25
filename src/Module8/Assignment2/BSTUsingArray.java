package Module8.Assignment2;
import java.util.Arrays;
public class BSTUsingArray {
    int[] keys;
    int[] left_ind, right_ind;
    int size;

    BSTUsingArray(int capacity){
        keys = new int[capacity];
        left_ind = new int[capacity];
        Arrays.fill(left_ind, -1);
        right_ind = new int[capacity];
        Arrays.fill(right_ind, -1);
        size = 0;
    }

    void insert(int key){
        if(size < keys.length) {
            if (size == 0)
                keys[size++] = key;
            else{
                for(int index = 0; index < size;) {
                    if (key > keys[index]){
                        if (right_ind[index] == -1) {
                            right_ind[index] = size;
                            keys[size++] = key;
                            break;
                        }
                        else
                            index = right_ind[index];
                    }
                    else if (key < keys[index]) {
                        if (left_ind[index] == -1) {
                            left_ind[index] = size;
                            keys[size++] = key;
                            break;
                        }
                        else
                            index = left_ind[index];
                    }
                }
            }
        }
    }

    void display(){
        for(int index = 0; index < size;index++)
            System.out.print(keys[index]+" ");
        System.out.print("\n");
        for(int index = 0; index < size;index++)
            System.out.print(left_ind[index]+" ");
        System.out.print("\n");
        for(int index = 0; index < size;index++)
            System.out.print(right_ind[index]+" ");
        System.out.print("\n");
    }

    public static void main(String[] args){
        BSTUsingArray bstArray = new BSTUsingArray(7);
        bstArray.insert(5);
        bstArray.insert(3);
        bstArray.insert(8);
        bstArray.insert(2);
        bstArray.insert(4);
        bstArray.insert(7);
        bstArray.insert(9);
        bstArray.display();
    }
}
