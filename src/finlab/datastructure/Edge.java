package finlab.datastructure;

/**
 * Class: Edge
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 */
public class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex target, double weight){
        this.target = target;
        this.weight = weight;
    }
} // end of Edge class
