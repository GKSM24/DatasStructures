package DSA2.Graphs;
import java.util.*;

public class DFSTraversal {
    static AdjacencyList obj;
    public static void main(String[] args) {
        obj= new AdjacencyList();
        obj.main(null);
        System.out.println("DFS of graph:" + performDFS(obj.arr, obj.a));
    }
    static ArrayList<Integer> performDFS(int[] vertices, LinkedList<Integer>[] lst) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack stack = new Stack<>();
        stack.push(vertices[0]);
        resultList.add(vertices[0]);
        while(!stack.isEmpty()) {
            System.out.println("Top of the stack: "+stack.peek());
            int index = obj.getIndex((Integer)stack.peek());
            System.out.println("neighbours: "+lst[index]);
            if(lst[index] == null)
                stack.pop();
            else {
                boolean neighbour_flag = false;
                Collections.sort(lst[index]);
                for(int value:lst[index]) {
                    if(!resultList.contains(value)) {
                        resultList.add(value);
                        stack.push(value);
                        neighbour_flag = true;
                        break;
                    }
                }
                if(neighbour_flag == false)
                    stack.pop();
            }
        }
        return resultList;
    }
}
