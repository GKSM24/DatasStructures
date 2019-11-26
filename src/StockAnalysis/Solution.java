package StockAnalysis;
import java.util.*;
import java.io.*;

class Stock implements Comparable<Stock>{
    String stock_name;
    double stock_percent;

    Stock(String stock_name, double stock_percent){
        this.stock_name = stock_name;
        this.stock_percent = stock_percent;
    }

    public int compareTo(Stock s1){
        double result = (s1.stock_percent - this.stock_percent);
        if(result > 0)
            return 1;
        else if(result == 0)
            return s1.stock_name.compareTo(this.stock_name);
        else
            return -1;
    }

    public String toString(){
        return stock_name+" "+stock_percent;
    }
}


public class Solution {
    ArrayList<Stock> list = new ArrayList<>(), minPQ = new ArrayList<>(), maxPQ = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        for(int i = 0; i<5; i++){
            String inputFile = "C:\\Users\\Gopi Venkat Krishna\\IdeaProjects\\DatasStructures\\src\\StockAnalysis\\testcases\\input00"+i+".txt";
            String outputFile = "C:\\Users\\Gopi Venkat Krishna\\IdeaProjects\\DatasStructures\\src\\StockAnalysis\\testcases\\output00"+i+".txt";
            sol.readInput(inputFile, outputFile);
        }
    }

    void readInput(String inputFile, String outputFile) throws Exception{
        ArrayList<String> output = new ArrayList<>();
        //stock data
        Scanner file_reader = new Scanner(new File(inputFile));
        Hashtable<String, Integer> minST = new Hashtable<>(), maxST = new Hashtable<>();
        int number_of_stocks = Integer.parseInt(file_reader.nextLine());
        for(int itr = 1; itr <= (6*number_of_stocks); itr++){
            String[] stock_det = file_reader.nextLine().split(",");
            list.add(new Stock(stock_det[0], Double.parseDouble(stock_det[1])));
            if(itr % number_of_stocks == 0){
                Collections.sort(list);
                for(int i = 0; i < 5; i++){
                    Stock temp = list.get(i);
                    maxPQ.add(temp);
                    if(maxST.containsKey(temp.stock_name))
                        maxST.put(temp.stock_name, maxST.get(temp.stock_name)+1);
                    else
                        maxST.put(temp.stock_name, 1);
                }
                for(Stock obj:maxPQ)
                    output.add(obj.toString());
                output.add("");// indication for empty space for next line.
                for(int i = list.size() - 1; i >= list.size() - 5; i--){
                    Stock temp = list.get(i);
                    minPQ.add(temp);
                    if(minST.containsKey(temp.stock_name))
                        minST.put(temp.stock_name, minST.get(temp.stock_name) + 1);
                    else
                        minST.put(temp.stock_name, 1);
                }
                for(Stock obj:minPQ)
                    output.add(obj.toString());
                output.add("");// indication for empty space for next line.
                maxPQ.clear();
                minPQ.clear();
                list.clear();
            }
        }

        //Query data
        int query = Integer.parseInt(file_reader.nextLine());
        if(query > 0){
            while(query > 0){
                String[] query_line = file_reader.nextLine().split(",");
                if(query_line.length == 3){
                   if(query_line[1].equalsIgnoreCase("maxST")){
                       if(maxST.containsKey(query_line[2]))
                           output.add(String.valueOf(maxST.get(query_line[2])));
                       else
                           output.add(String.valueOf(0));
                   }
                   else{
                       if(minST.containsKey(query_line[2]))
                           output.add(String.valueOf(minST.get(query_line[2])));
                       else
                           output.add(String.valueOf(0));
                   }
                }
                else{
                    ArrayList<String> sortList = new ArrayList<>();
                    for(String str:maxST.keySet())
                        if(minST.containsKey(str))
                            sortList.add(str);
                    Collections.sort(sortList);
                    for(String str:sortList)
                        output.add(str);
                }
                query--;
            }
        }
        checkOutput(output, outputFile);
    }

    void checkOutput(ArrayList<String> output, String outputFile) throws Exception{
        Scanner file_reader = new Scanner(new File(outputFile));
        for(String str:output){
            String temp = file_reader.nextLine();
            if(!str.equals(temp)){
                System.out.println("Failed TestCase "+outputFile);
                return;
            }
        }
        System.out.println("Test Case Passed." + outputFile);
    }

}
