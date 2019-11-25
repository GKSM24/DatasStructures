package module9.LearningByDoing2;

import java.util.Arrays;

class Node{
    char key;
    Node next;
}

class Hashtable{
    Node[] hashtable;
    Hashtable(int capacity){
        hashtable = new Node[capacity];
    }

    public int hashFunc(char k){
        return (11*k) % hashtable.length;
    }

    void put(char key){
        int index = hashFunc(key);
        //System.out.println(index);
        Node obj = new Node();
        obj.key = key;
        if(hashtable[index] == null)
            hashtable[index] = obj;
        else{
            Node temp = hashtable[index];
            while(temp.next != null) {
                //System.out.println(temp.key);
                temp = temp.next;
            }
            temp.next = obj;
        }
    }

    void display(){
        for(int index = 0; index < hashtable.length; index++){
            if(hashtable[index] != null){
                Node temp = hashtable[index];
                while(temp != null) {
                    System.out.print(temp.key + " ");
                    temp = temp.next;
                }
                System.out.print("\n");
            }
            else
                System.out.println(hashtable[index]);
        }
    }
}

public class Assignment {
    public static void main(String[] args){
        String str = "EASYQUTION";
        Hashtable h_obj = new Hashtable(5);
        for(int index = 0; index < str.length(); index++)
            h_obj.put(str.charAt(index));
        h_obj.display();
    }


}
