package module2.assignment3;

class Solution{
    static class ParenthesisChecker{
        char brackets[];
        int size;
        ParenthesisChecker(){
            brackets = new char[1];
        }

        boolean isEmpty(){
            return size == 0;
        }

        boolean isFull(){
            return size == brackets.length;
        }

        void resize(int capacity){
            char copy[] = new char[capacity];
            for(int index = 0; index < size;index++)
                copy[index] = brackets[index];
            brackets = copy;
        }

        void push(char ch){
            if(isFull())
               resize(2 * size);
            brackets[size++] = ch;
        }

        char pop(){
            if(size == brackets.length/4)
                resize(brackets.length/2);
            if(!isEmpty()){
                char temp = brackets[--size];
                brackets[size] = ' ';
                return temp;
            }
            return ' ';
        }

        char peek(){
            if(!isEmpty())
                return brackets[size - 1];
            return ' ';
        }
    }
    public static String isMatching(String str){
        int length = str.length();
        if (length > 1) {
            ParenthesisChecker stack = new ParenthesisChecker();
            for (int index = 0; index < length; index++) {
                char temp = str.charAt(index);
                if (temp == '{' || temp == '[' || temp == '(')
                    stack.push(temp);
                else{
                    char top = stack.peek();
                    if ((top == '{' && temp == '}') || (top == '(' && temp == ')') ||(top == '[' && temp == ']'))
                        stack.pop();
                    else
                        return "NO";
                }
            }
            if (stack.isEmpty())
                return "YES";
        }
        return "NO";
    }
}