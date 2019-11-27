package Queues_Project1;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque <Item> implements Iterable<Item> {
        private Node<Item> head, tail;
        private int size;
        class Node<I>{
            Node<I> prev;
            I data;
            Node<I> next;
        }
        // construct an empty deque
        public Deque(){
            head = null;
            tail = null;
            size = 0;
        }

        // is the deque empty?
        public boolean isEmpty(){
            return head == null;
        }

        // return the number of items on the deque
        public int size(){
            return size;
        }

        // add the item to the front
        public void addFirst(Item item) throws IllegalArgumentException{
            if(item == null)
                throw new IllegalArgumentException("entered a null value.not accepted");
            Node<Item> obj = new Node<>();
            obj.data = item;
            if(isEmpty()){
                head = obj;
                tail = obj;
            }
            else{
                obj.next = head;
                head.prev = obj;
                head = obj;
            }
            size++;
        }

        // add the item to the back
        public void addLast(Item item) throws IllegalArgumentException{
            if(item == null)
                throw new IllegalArgumentException("entered a null value.not accepted");
            Node<Item> obj = new Node<>();
            obj.data = item;
            if(isEmpty()){
                head = obj;
                tail = obj;
            }
            else{
                tail.next = obj;
                obj.prev = tail;
                tail = obj;
            }
            size++;
        }

        // remove and return the item from the front
        public Item removeFirst() throws NoSuchElementException{
            if(isEmpty())
                throw new NoSuchElementException("No item to remove");
            Node<Item> temp = head;
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
            size--;
            return temp.data;
        }

        // remove and return the item from the back
        public Item removeLast() throws NoSuchElementException{
            if(isEmpty())
                throw new NoSuchElementException("No element to remove");
            Node<Item> temp = tail;
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
                temp.prev = null;
            }
            size--;
            return temp.data;
        }

        // return an iterator over items in order from front to back
        @Override
        public Iterator<Item> iterator(){
            class DequeIterator implements Iterator<Item>{
                Node<Item> temp = head;
                @Override
                public boolean hasNext(){
                    return temp != null;
                }
                @Override
                public Item next(){
                    if(!hasNext())
                        throw new NoSuchElementException("There is no more elements to iterate");
                    Item t = temp.data;
                    temp = temp.next;
                    return t;
                }
                @Override
                public void remove() throws UnsupportedOperationException{
                    throw new UnsupportedOperationException("This operation cannot be performed");
                }
            }
            return new DequeIterator();
        }

        // unit testing (required)
        public static void main(String[] args){
            try {
                Deque<String> deckObj = new Deque<>();
                System.out.println("List is empty: "+deckObj.isEmpty());
                deckObj.addFirst("Srujan");
                deckObj.addFirst("pavan");
                deckObj.addFirst("suneeth");
                deckObj.addLast("akhil");
                deckObj.addLast("santosh");
                System.out.println("List is empty: "+deckObj.isEmpty());
                deckObj.removeFirst();
                deckObj.removeLast();
                deckObj.removeLast();
                System.out.println(deckObj.removeFirst());
                //deckObj.addLast(null);
                //deckObj.addFirst(null);
                System.out.println("List size: "+deckObj.size());
                System.out.println(deckObj.removeFirst());
                System.out.println("List is empty: "+deckObj.isEmpty());
                //deckObj.removeFirst();
                Iterator<String> itr = deckObj.iterator();
                while(itr.hasNext())
                    System.out.println(itr.next());
                //itr.next();
                //itr.remove();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

}

