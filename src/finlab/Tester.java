package finlab;

import finlab.datastructure.*;

import java.io.*;
import java.util.Scanner;

/**
 * Class: Tester
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 *
 * Contains the executable class of the program.
 */
public class Tester {
    static BufferedReader reader;
    static Scanner console = new Scanner(System.in);
    static int nodess;

    /**
     * Runs the program.
     * Calls the methods in accordance to the user's choice:
     * [1] - Load File
     * [2] - Depth First Search
     * [3] - Breadth First Search
     * [4] - Dijkstra's Algorithm
     * [5] - Exit
     */
    void run() {
        while (true) {
            System.out.print("\n==========MAIN MENU==========\n" +
                    "[1] - Load File\n" +
                    "[2] - Depth First Search\n" +
                    "[3] - Breadth First Search\n" +
                    "[4] - Dijkstra's Algorithm\n" +
                    "[5] - Exit\n" +
                    "=============================\n");

            byte choice = inputByte();
            switch (choice) {
                case 1 -> loadFile();
                case 2 -> DFS();
                case 3 -> BFS();
                case 4 -> dijkstra();
                case 5 -> {
                    System.out.println("Good bye!");
                    System.exit(1);
                }
                default -> System.err.println("Invalid input. Try again.");
            }
        }
    }

    /**
     * prompts the user to input a choice
     * @return user choice in byte
     */
    byte inputByte() {
        while (true) {
            try {
                System.out.print("Enter Choice: ");
                return Byte.parseByte(console.next());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Input a number only. Please try again.");
            }
        }
    }

    /**
     * Loads the file the contains the graph details
     * @return list
     */
    MyLinkedList<Integer> loadFile(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        try {
            reader = new BufferedReader(new FileReader("./src/test.txt"));
            System.out.printf("\n%-5s%15s%10s\n", "Source", "Destination", "Weight");
            String line;
            int counter = 0;

            //read text file then display data
            while (true){
                line = reader.readLine();
                if (line == null) break;

                String[] data = line.split(" ");
                Integer src = list.insert(Integer.parseInt(data[0]));
                Integer dst = list.insert(Integer.parseInt(data[1]));
                Integer wt = list.insert(Integer.parseInt(data[2]));
                System.out.printf("%3s%13s%12s\n", src, dst, wt);
                counter++;
            }
            System.out.println("\nFile loaded successfully!");
            nodess = counter;
        } catch (FileNotFoundException e) {
            System.out.println("File loaded unsuccessfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Performs Depth First Search
     */
    void DFS(){
        try {
            if (nodess == 0){
                System.err.println("There are no data found!");
            } else {
                MyLinkedList<Integer> list = new MyLinkedList<>();
                Graph.Graph2 g = new Graph.Graph2(nodess);
                reader = new BufferedReader(new FileReader("./src/test.txt"));
                System.out.print("Enter the Starting Vertex: ");
                int vertex = console.nextInt();
                String line;

                while (true){
                    line = reader.readLine();
                    if (line == null) break;

                    String[] data = line.split(" ");
                    Integer src = list.insert(Integer.parseInt(data[0]));
                    Integer dst = list.insert(Integer.parseInt(data[1]));
                    Integer wt = list.insert(Integer.parseInt(data[2]));

                    g.addEdge(src, dst);
                }

                System.out.print("Depth First Search: ");
                //compute dfs
                g.DFS(vertex);
            }
        } catch (FileNotFoundException e){
            System.err.println("There are no data found!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("\nInvalid input: Total Number of Vertex is " + nodess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs Breadth First Search
     */
    void BFS(){
        try {
            if (nodess == 0){
                System.err.println("There are no data found!");
            }else {
                MyLinkedList<Integer> list = new MyLinkedList<>();
                Graph g = new Graph(nodess);
                reader = new BufferedReader(new FileReader("./src/test.txt"));
                System.out.print("Enter the Starting Vertex: ");
                int vertex = console.nextInt();
                String line;

                while (true) {
                    line = reader.readLine();
                    if (line == null) break;

                    String[] data = line.split(" ");
                    Integer src = list.insert(Integer.parseInt(data[0]));
                    Integer dst = list.insert(Integer.parseInt(data[1]));
                    Integer wt = list.insert(Integer.parseInt(data[2]));

                    g.addEdge(src, dst);
                }

                System.out.print("Breadth First Search: ");
                //compute bfs
                g.bfs(vertex);
            }
        } catch(FileNotFoundException e){
            System.err.println("There are no data found!");
        } catch(ArrayIndexOutOfBoundsException e){
            System.err.println("\nInvalid input: Total Number of Vertex is " + nodess);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Find the shortest path of a source to a destination using dijkstra's algorithm
     */
    void dijkstra(){
        try {
            if (nodess == 0){
                System.out.println("There are no data found!");
            } else {
                MyLinkedList<Integer> list = new MyLinkedList<>();
                DijkstraAlgorithm obj = new DijkstraAlgorithm();

                // Create new graph.
                Graph.Graph1 g = new Graph.Graph1(nodess);
                reader = new BufferedReader(new FileReader("./src/test.txt"));
                System.out.print("Enter the Starting Vertex: ");
                int vertex = console.nextInt();
                String  line;

                while (true) {
                    line = reader.readLine();
                    if (line == null) break;

                    String[] data = line.split(" ");
                    Integer src = list.insert(Integer.parseInt(data[0]));
                    Integer dst = list.insert(Integer.parseInt(data[1]));
                    Integer wt = list.insert(Integer.parseInt(data[2]));

                    g.addEdge(src, dst, wt);
                }

                // compute Dijkstra
                obj.calculate(g.getVertex(vertex));

                for (Vertex v : g.getVertices()) {
                    if (v.minDistance != Double.POSITIVE_INFINITY){
                        System.out.println("v" + vertex + " - " + v + " --> " + v.minDistance);
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("There are no data found!");
        } catch (IndexOutOfBoundsException e){
            System.err.println("Invalid input: Total Number of Vertex is " + nodess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes the program
     * @param args args
     */
    public static void main(String[] args){
        Tester tester = new Tester();
        tester.run();
    }
}

