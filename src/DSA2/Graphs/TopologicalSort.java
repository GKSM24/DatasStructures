package DSA2.Graphs;
import java.util.*;
public class TopologicalSort {
    static AdjacencyList obj;
    public static void main(String[] args) {
        obj= new AdjacencyList();
        obj.main(null);
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for(int index = 0; index < obj.arr.length; index++)
            graph.put(obj.arr[index], obj.a[index]);
        System.out.println("Topological sort order:" + performSort(graph));
    }
    static ArrayList<Integer> performSort(HashMap<Integer, LinkedList<Integer>> graph){
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> inDegVer = getInDegree(graph);
        while(!inDegVer.isEmpty()) {
            for(int key:inDegVer.keySet()) {
                if(inDegVer.get(key) == 0) {
                    resultList.add(key);
                    modifyGraph(graph, key);
                }
            }
            inDegVer = getInDegree(graph);
        }
        return resultList;
    }
    static HashMap<Integer, Integer> getInDegree(HashMap<Integer,LinkedList<Integer>> map){
        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int key:map.keySet()) {
            int count = 0;
            for(LinkedList<Integer> l:map.values())
                if(l!=null&&l.contains(key))
                    count++;
            temp.put(key, count);
        }
        return temp;
    }
    static void modifyGraph(HashMap<Integer, LinkedList<Integer>> g, Object vertex) {
        for(LinkedList<Integer> lst:g.values()) {
            if(lst!=null&&lst.contains(vertex))
                lst.remove(vertex);
        }
        g.remove(vertex);
    }
}

