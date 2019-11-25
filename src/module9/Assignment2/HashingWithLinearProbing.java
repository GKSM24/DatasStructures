package module9.Assignment2;

import java.util.Arrays;

class Hashtable<Key, Value>{
    Key keys[];
    Value values[];

    Hashtable(){
        keys = (Key[]) new Object[20];
        values = (Value[]) new Object[20];
    }

    public int hashCode(){
        return 17;
    }

    private boolean isFull(){
        for(int index = 0; index < keys.length; index++)
            if(keys[index] == null)
                return false;
        return true;
    }

    void put(Key key, Value value){
        int index = hashCode();
        if(isFull()) {
            keys = Arrays.copyOf(keys, 2 * keys.length);
            values = Arrays.copyOf(values, 2 * keys.length);
        }
        else {
            while(keys[index] != null){
                index = (index + 1) % keys.length;
            }
            keys[index] = key;
            values[index] = value;
        }
    }

    Value get(Key key){
        if(key != null){
            int index = hashCode();
            for(; keys[index] != null; index = (index + 1)%keys.length){
                if(keys[index].equals(key))
                    return values[index];
            }
        }
        return null;
    }

    void delete(Key key){
        if(key != null && get(key) != null) {
            int index = hashCode();
            for(; keys[index] != null; index = (index + 1)%keys.length){
                if(keys[index].equals(key)) {
                    keys[index] = null;
                    values[index] = null;
                    return;
                }
            }
        }
    }

    void display(){
        String printString = "{";
        for(int index = 0; index < keys.length; index++)
            if(keys[index] != null)
                printString += keys[index] + "=" + values[index]+ " ";
        printString += "}";
        System.out.println(printString);
    }
}

public class HashingWithLinearProbing {
    public static void main(String[] args){
        Hashtable<String, Integer> obj = new Hashtable<>();
        obj.put("vyas", 22);
        obj.put("pavan", 25);
        obj.put("srujan", 23);
        System.out.println(obj.get("vyas"));
        System.out.println(obj.get("Pavan"));
        obj.display();
    }


}
