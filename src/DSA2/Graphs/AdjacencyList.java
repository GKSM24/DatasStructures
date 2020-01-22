package DSA2.Graphs;

import java.util.*;

/*class Node<T>{
    T label;
    Node(T l){
        label = l;
    }
    public String toString() {
        return ""+label;
    }
}

class Edge<T>{
    Node<T> source, target;
    int weight;
    Edge(Node<T> s, Node<T> t, int wt){
        source = s;
        target = t;
        weight = wt;
    }
    public String toString() {
        return ""+target;
    }
}
public class AdjacencyList {
    static Scanner sc=new Scanner(System.in);
    private static int n;
    static LinkedList<Edge<Integer>> edges[];
    static Node<Integer>[] labels;
    public static void main(String[] args) {
        System.out.println("Enter the number of vertices:");
        n=sc.nextInt();
        labels = new Node[n];
        System.out.println("//Enter the labels for vertices//");
        for(int index = 0; index < labels.length; index++) {
            System.out.println("Enter the label for vertex "+(index+1));
            labels[index] = new Node<>(sc.nextInt());
        }
        edges = new LinkedList[n];
        addEdge(new Node<>(10),new Node<>(12),30);
        addEdge(new Node<>(12),new Node<>(10),50);
        addEdge(new Node<>(13),new Node<>(14),90);
        addEdge(new Node<>(13),new Node<>(12),100);
        addEdge(new Node<>(14),new Node<>(10),200);
        printGraph();
    }
    private static void addEdge(Node<Integer> n1, Node<Integer> n2, int wt) {

// directed version logic
 int index = findIndex(n1);
if(index != -1) {
if(edges[index] == null)
{
edges[index] = new LinkedList<>();
}
edges[index].add(new Edge<>(n1,n2,wt));
}

//undirected version
        int index1 = findIndex(n1), index2 = findIndex(n2);
        if(index1 != -1 && index2 != -1) {
            if(edges[index1] == null)
                edges[index1] = new LinkedList<>();
            if(edges[index2] == null)
                edges[index2] = new LinkedList<>();
            if(!edges[index1].contains(n2))
                edges[index1].add(new Edge<>(n1,n2,wt));
            if(!edges[index2].contains(n1))
                edges[index2].add(new Edge<>(n2,n1,wt));
        }
 }
    private static int findIndex(Node<Integer> n) {
        for(int index = 0; index < labels.length; index++)
            if(labels[index].label == n.label)
                return index;
        return -1;
    }
    public static void printGraph() {
        for(int index = 0; index < labels.length; index++)
            System.out.println(labels[index].label+" : "+edges[index].toString());
    }
}*/
public class AdjacencyList {
    static LinkedList<Integer>[] a;
    static int arr[];
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++) {
            System.out.println("Enter vertices");
            arr[i]=sc.nextInt();
        }
        a=new LinkedList[n];
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,4);
        addEdge(2,5);
        addEdge(4,6);
        addEdge(4,7);
        addEdge(7,8);
        addEdge(9,8);
        print();
    }
    static void addEdge(int n1,int  n2) {
        int index=getIndex(n1); //int index2 = getIndex(n2)
        if(index !=-1) { //(index1 != -1 && index2 != -1)
            if(a[index] == null) {
                a[index]=new LinkedList<>();
            }
// if (a[index2] == null) {a[index2]=new LinkedList<>();}
//if (!a[index1].contains(n2)){a[index1].add(n2)}
//if (!a[index2].contains(n1)){a[index2].add(n1)}
            a[index].add(n2);
        }
    }
    static int getIndex(int lable) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==lable) {
                return i;
            }

        }
        return -1;
    }
    static void print() {
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]+" : " + a[i]);
        }
    }
}