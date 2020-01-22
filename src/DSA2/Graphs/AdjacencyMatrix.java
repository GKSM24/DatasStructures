package DSA2.Graphs;

import java.util.*;

public class AdjacencyMatrix {
    private static int arr[][];
    static char labels[];
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int m=sc.nextInt();
        arr=new int [m][m];
        labels = new char[m];
        for(int i=0;i<m;i++) {
            System.out.println("Enter label for vertex "+(i+1));
            labels[i]=sc.next().charAt(0);
        }
        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,5);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,3);
        addEdge(2,5);
        addEdge(3,4);
        addEdge(4,5);
        printMatrix();
    }
    static void addEdge(int s, int t) {
// directed version with weight: arr[s][t] = 1;
        if(arr[s][t] == 0)
            arr[s][t] = 1;
        if(arr[t][s] == 0)
            arr[t][s] = 1;
    }
    static void addEdge(int s, int t, int wt) {
// directed version with weight: arr[s][t] = wt;
        if(arr[s][t] == 0)
            arr[s][t] = wt;
        if(arr[t][s] == 0)
            arr[t][s] = wt;
    }
    static void printMatrix() {
        System.out.print("  ");
        for(int index = 0; index < labels.length; index++)
            System.out.print(labels[index]+" ");
        System.out.print("\n");
        for(int i=0;i<arr.length;i++) {
            System.out.print(labels[i]+" ");
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}