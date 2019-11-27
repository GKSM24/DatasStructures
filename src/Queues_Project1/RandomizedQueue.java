package Queues_Project1;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Queues_Project1.StdRandom;

public class RandomizedQueue <Item> implements Iterable<Item> {
    private Item queue[];
    private int size;
    // construct an empty randomized queue
    public RandomizedQueue(){
        queue = (Item[]) new Object[5];
        size = 0;
    }

    //resize's the queue array
    private void resize(int capacity){
        Item copy[] = (Item[]) new Object[capacity];
        for(int index = 0 ;index < size; index++)
            copy[index] = queue[index];
        queue = copy;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item) throws IllegalArgumentException{
        if(item == null)
            throw new IllegalArgumentException("null as item is not accepted.");
        if(size == queue.length)
            resize(2 * size);
        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() throws NoSuchElementException{
        if(isEmpty())
            throw new NoSuchElementException("There are no elements to remove.");
        if(size == queue.length/4)
            resize(queue.length/2);
        int index = StdRandom.uniform(size);
        Item temp = queue[index];
        for(;index < size-1; index++)
            queue[index] = queue[index+1];
        queue[size] = null;
        size--;
        return temp;
    }

    // return a random item (but do not remove it)
    public Item sample() throws NoSuchElementException{
        if(isEmpty())
            throw new NoSuchElementException("No elements are there in queue.");
        int index = StdRandom.uniform(size);
        Item temp = queue[index];
        return temp;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        StdRandom.shuffle(queue,0,size);
        class RQIterator implements Iterator<Item>{
            int index = 0;
            public boolean hasNext(){
                return index < size;
            }
            public Item next() throws NoSuchElementException{
                if(!hasNext())
                    throw new NoSuchElementException("No elements to iterate.");
                return queue[index++];
            }
            public void remove() throws UnsupportedOperationException{
                throw new UnsupportedOperationException("remove Operation not supported.");
            }
        }
        return new RQIterator();
    }

    // unit testing (required)
    public static void main(String[] args){
        try{
            RandomizedQueue<Integer> rqObj = new RandomizedQueue<>();
            System.out.println("Queue is empty? "+rqObj.isEmpty());
            rqObj.enqueue(20);
            rqObj.enqueue(10);
            rqObj.enqueue(40);
            rqObj.enqueue(90);
            rqObj.enqueue(50);
            rqObj.enqueue(80);
            rqObj.enqueue(100);
            //rqObj.enqueue(null);
            System.out.println("Queue is empty? "+rqObj.isEmpty());
            System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("Dequed element: "+rqObj.dequeue());
            //System.out.println("Dequed element: "+rqObj.dequeue());
            //System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("Size of queue:"+rqObj.size());
           // System.out.println("Dequed element: "+rqObj.dequeue());
            System.out.println("sample of queue: "+rqObj.sample());
            Iterator<Integer> itr = rqObj.iterator();
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
