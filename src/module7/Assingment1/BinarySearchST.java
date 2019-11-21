package module7.Assingment1;

import java.util.Iterator;

public class BinarySearchST<Key extends Comparable<Key>, Value>  implements Iterable{
    Key keys[];
    Value values[];
    int size;

    BinarySearchST(){
        keys = (Key[]) new Comparable[50];
        values = (Value[]) new Comparable[50];
        size = 0;
    }
    /*private void resize(int capacity){
        Key copy_keys[] = (Key[]) new Comparable[capacity];
        Value copy_values[] = (Value[]) new Comparable[capacity];
        for(int index = 0; index<size; index++) {
            copy_keys[index] = keys[index];
            copy_values[index] = values[index];
        }
        keys = copy_keys;
        values = copy_values;
    }*/
    public Iterator<Key> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Key>{
        int i = 0;
        public boolean hasNext(){
            return i < size;
        }
        public Key next(){
            return keys[i++];
        }
    }
    void put(Key key, Value value){
        if(contains(key)){
            int index = rank(key);
            values[index] = value;
        }
        else {
            /*if(size == keys.length)
                resize(keys.length +1);*/
            int index = rank(key);
            for(int start = size; start > index; start--)
                keys[start] = keys[start - 1];
            for(int start = size; start > index; start--)
                values[start] = values[start - 1];
            keys[index] = key;
            values[index] = value;
            size++;
        }
    }

    Value get(Key key){
        int index = rank(key);
        if(size != 0){
            if (index < size && key.compareTo(keys[index]) == 0)
                return values[index];
        }
        return null;
    }

    boolean contains(Key key){
        return get(key) != null;
    }

    Key max(){
        if(size == 0)
            return null;
        return keys[size - 1];
    }

    Key floor(Key key){
        int index = rank(key);
        if(size == 0)
            return null;
        return keys[index].compareTo(key) == 0 ? keys[index] : keys[index - 1];
    }

    int rank(Key key){
            int low = 0, high = size - 1;
            while (low <= high) {
                int mid =  (low + high) / 2;
                int comp = key.compareTo(keys[mid]);
                if (comp < 0) {
                    high = mid - 1;
                } else if (comp > 0) {
                    low = mid + 1;
                } else return mid;
            }
            return low;
    }

    void deleteMin(){
        if(size != 0) {
            for(int start = 0; start < size - 1; start++)
                keys[start] = keys[start + 1];
            for(int start = 0; start < size - 1; start++)
                values[start] = values[start + 1];
            size--;
            /*if (size == keys.length / 4)
                resize(keys.length / 2);*/
        }
    }

    Iterable<Key> keys(){
        return this;
    }

    public String toString(){
        String printString = "";
        for(Key k : this.keys())
            printString += k + " ";
        return printString;
    }

    public static void main(String[] args){
        BinarySearchST<String, Integer> symbolTable = new BinarySearchST<String, Integer>();
        symbolTable.put("S",0);
        symbolTable.put("E",1);
        symbolTable.put("A",2);
        symbolTable.put("R",3);
        symbolTable.put("C",4);
        symbolTable.put("H",5);
        symbolTable.put("E",6);
        symbolTable.put("X",7);
        symbolTable.put("A",8);
        symbolTable.put("M",9);
        symbolTable.put("P",10);
        symbolTable.put("L",11);
        symbolTable.put("E",12);
        System.out.println(symbolTable);
    }
}

