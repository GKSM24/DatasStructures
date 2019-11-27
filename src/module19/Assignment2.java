package module19;

/*

Write a Queue implementation that uses a circular linked list, which is the same as a linked list except that no links are null and the value of
last.next is first when-ever the list is not empty. Keep only one Node instance variable ( last ).
Compare this implementation to the queue implemented using arrays and regular linked list. (Queues)

*/
class Node<Item>{
    Item data;
    Node<Item> next;
}

class QueueUsingLinkedList<Item>{
    Node<Item> last;
    int size;
    void enqueue(Item data){
        Node<Item> obj = new Node<>();
        obj.data = data;
        if(last == null) {
            last = obj;
            last.next = obj;
        }
        else{
            obj.next = last.next;
            last.next = obj;
            last = obj;
        }
        size++;
    }

    Item peek(){
        if(last == null)
            return null;
        return last.next.data;
    }

    Item dequeue(){
        if(last == null)
            return null;
        Node<Item> temp = last.next;
        if(size == 1) {
            last = null;
            temp.next = null;
        }
        else {
            last.next = temp.next;
            temp.next = null;
        }
        size--;
        return temp.data;
    }

    void display(){
        if(last != null) {
            Node<Item> temp = last.next;
            while (temp.next != last.next) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
        else
            System.out.println("Queue is empty.");
    }
}

public class Assignment2 {
    public static void main(String[] args){
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(60);
        queue.enqueue(10);
        queue.enqueue(80);
        queue.display();

        System.out.println("Dequed item:"+queue.dequeue());
        System.out.println("Dequed item:"+queue.dequeue());
        queue.display();
    }
}
