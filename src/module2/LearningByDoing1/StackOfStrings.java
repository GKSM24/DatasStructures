package module2.LearningByDoing1;

public class StackOfStrings {
    String stack[];
    int size;

    StackOfStrings(){
        stack = new String[1];
        size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == stack.length;
    }

    void resize(int capacity){
        String copy[] = new String[capacity];
        for (int index = 0; index < size;index++)
            copy[index] = stack[index];
        stack = copy;
    }

    void push(String data){
        if(isFull())
            resize(2 * size); //repeated doubling
        stack[size++] = data;
    }

    String pop(){
        if(size == (stack.length/4))
            resize(stack.length/2);
        if(!isEmpty()) {
            String temp = stack[--size];
            //to avoid loitering
            stack[size] = null;
            return temp;
        }
        return "";
    }

    String peek(){
        if(!isEmpty())
            return stack[size - 1];
        return "";
    }

    void display(){
        for(int index = size - 1; index > -1; index--)
            System.out.println(stack[index]);
    }

    public static void main(String[] args){
        StackOfStrings stackObj = new StackOfStrings();
        String[] words = "it was - the best - of times - - - it was - the - -".split(" ");
        for(String word:words){
            if (word.equals("-"))
                System.out.println(stackObj.pop());
            else
                stackObj.push(word);
        }
        System.out.println("Elements still in the stack:");
        stackObj.display();
    }
}
