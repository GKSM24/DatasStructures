package DSA2.Graphs;
import java.util.*;
public class BFSTraversal {
    static AdjacencyList obj;
    public static void main(String[] args) {
        obj= new AdjacencyList();
        obj.main(null);
        System.out.println("BFS of graph:" + performBFS(obj.arr, obj.a));
    }
    static ArrayList<Integer> performBFS(int[] vertices, LinkedList<Integer>[] neighbour_lst){
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(vertices[0]);
        resultList.add(vertices[0]);
        while(!queue.isEmpty()) {
            int index = obj.getIndex(queue.pollFirst());
            if(neighbour_lst[index]!=null) {
                Collections.sort(neighbour_lst[index]);
                for(int value : neighbour_lst[index]) {
                    if(!resultList.contains(value)) {
                        queue.add(value);
                        resultList.add(value);
                    }
                }
            }
        }
        return resultList;
    }
}
