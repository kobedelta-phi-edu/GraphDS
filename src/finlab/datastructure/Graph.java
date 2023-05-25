package finlab.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class: Graph
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 */
public class Graph {
    List <List<Integer>> graph;
    boolean[] visited;

    /**
     * constructs the graph
     * @param nodes data in the graph
     */
    public Graph(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }

    }

    /**
     * adds edge to the graph
     */
    public void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    /**
     * method for breadth first search
     * @param startIndex starting point
     */
    public void bfs(int startIndex) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.enqueue(startIndex);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.dequeue();
            System.out.print(node + " ");

            List<Integer> childList = graph.get(node);

            for (Integer child : childList) {
                if (!visited[child]) {
                    queue.enqueue(child);
                    visited[child] = true;
                }
            }
        }
    }

    public static class Graph1 {
        private final ArrayList<Vertex> vertices;

        public Graph1(int numberVertices){
            vertices = new ArrayList<>(numberVertices);
            for(int i=0;i<numberVertices;i++){
                vertices.add(new Vertex("v"+ i));
            }
        }

        /**
         * adds edge to the graph
         * @param src starting point
         * @param dest destination
         * @param weight weight
         */
        public void addEdge(int src, int dest, int weight){
            Vertex s = vertices.get(src);
            Edge new_edge = new Edge(vertices.get(dest),weight);
            s.neighbours.add(new_edge);
        }

        public ArrayList<Vertex> getVertices() {
            return vertices;
        }

        public Vertex getVertex(int vert){
            return vertices.get(vert);
        }
    } // end of Graph1 class

    public static class Graph2 {
        int V;
        LinkedList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public Graph2(int v){
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        /**
         * add w to v's list
         * @param v vertex
         * @param w weight
         */
        public void addEdge(int v, int w){
            adj[v].add(w);
            adj[w].add(v);
        }

        /**
         * marks nodes as visited
         * @param v vertex
         * @param visited
         */
        void dfsHelper(int v, boolean[] visited){
            // node are marked as visited
            visited[v] = true;
            System.out.print(v + " ");

            for (int n : adj[v]) {
                if (!visited[n])
                    dfsHelper(n, visited);
            }
        }

        public void DFS(int v){
            // vertices are marked as not visited
            boolean[] visited = new boolean[V];

            // compute dfs
            dfsHelper(v, visited);
        }
    } // end of Graph2 class
} // end of Graph class
