package module7.Assignment2;
import java.util.Iterator;

class Node<Key, Value>{
    Key key;
    Value value;
    Node next;
}

class LinkedList<K, V>{
    Node head, tail;

    void insert(K k, V v){
        Node obj = new Node();
        obj.key = k;
        obj.value = v;
        if(head == null){
            head = obj;
            tail = obj;
        }
        else{
            obj.next = head;
            head = obj;
        }
    }

    Node<K,V> isKeyAvailable(K k){
        Node temp = head;
        while (temp != null) {
            if (temp.key.equals(k))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void moveToBack(Node<K, V> node){
        if(node != null){
            if(node == head){
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
            }
            else if(node == tail)
                return;
            else{
                Node temp = head;
                while(temp.next != node)
                    temp = temp.next;
                temp.next = node.next;
                tail.next = node;
                tail = node;
                tail.next = null;
            }
        }
    }
}

public class SequentialSearchST<Key, Value> implements Iterable{
    LinkedList<Key, Value> list;
    SequentialSearchST(){
        list = new LinkedList<>();
    }

    class ListIterator implements Iterator{
        Node<Key, Value> temp = list.head;
        public boolean hasNext() {return temp != null;}
        public Key next(){
            Key k = temp.key;
            temp = temp.next;
            return k;
        }
    }

    void put(Key k, Value v){
        Node<Key,Value> temp = list.isKeyAvailable(k);
        if(temp == null)
            list.insert(k, v);
        else
            temp.value = v;
    }

    Value get(Key k){
        Node<Key,Value> temp = list.isKeyAvailable(k);
        if(temp != null) {
            list.moveToBack(temp);
            return temp.value;
        }
        return null;
    }

    public Iterator iterator(){
        return new ListIterator();
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
}
