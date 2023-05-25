package finlab.datastructure;

import java.util.ArrayList;

/**
 * Class: Vertex
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 */
public class Vertex implements Comparable<Vertex>{
    public final String name;

    public ArrayList<Edge> neighbours;
    public MyLinkedList<Vertex> path;
    public double minDistance = Double.POSITIVE_INFINITY;
    public int compareTo(Vertex other){
        return Double.compare(minDistance,other.minDistance);
    }

    public Vertex(String name){
        this.name = name;
        neighbours = new ArrayList<>();
        path = new MyLinkedList<>();
    }
    public String toString(){
        return name;
    }
} // end of Vertex class
