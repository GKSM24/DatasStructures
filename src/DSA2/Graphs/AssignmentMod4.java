package DSA2.Graphs;
import java.util.*;
public class AssignmentMod4 {
    static LinkedList<Integer>[] neighbours;
    static int vertices[];
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        String line1 = sc.nextLine(), temp_arr[];
        temp_arr = line1.split(" ");
        int tasks = Integer.parseInt(temp_arr[0]), dependencies = Integer.parseInt(temp_arr[1]);
        vertices = new int[tasks];
        neighbours = new LinkedList[tasks];
        for(int index = 0; index < tasks; index++)
            vertices[index] = index + 1;
        buildGraph(dependencies);
    }
    private static void buildGraph(int dependencies){
        while(dependencies-- > 0){
            String temp[] = sc.nextLine().split(" ");
            int target = Integer.parseInt(temp[0]), num = Integer.parseInt(temp[1]), start = 2;
            while(num-- > 0) {
                addEdge(Integer.parseInt(temp[start++]), target);
            }
        }
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for(int index = 0; index < vertices.length; index++)
            graph.put(vertices[index], neighbours[index]);
        System.out.println("Topological sort order:" + performSort(graph));
    }
    static void addEdge(int n1,int  n2) {
        int index=getIndex(n1);
        if(index != -1) {
            if(neighbours[index] == null) {
                neighbours[index] = new LinkedList<>();
            }
            neighbours[index].add(n2);
        }
    }
    static int getIndex(int label) {
        for(int i=0;i<vertices.length;i++) {
            if(vertices[i]==label) {
                return i;
            }

        }
        return -1;
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
