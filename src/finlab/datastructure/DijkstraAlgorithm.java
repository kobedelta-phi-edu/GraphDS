package finlab.datastructure;

/**
 * Class: DijkstraAlgorithm
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 *
 * Take the unvisited node with minimum weight.
 * Visit all its neighbours.
 * Update the distances for all the neighbours (In the Priority Queue).
 * Repeat the process till all the connected nodes are visited.
 */
public class DijkstraAlgorithm {
    public void calculate(Vertex source){
        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.enqueue(source);

        while(!queue.isEmpty()){
            Vertex u = queue.dequeue();
            for (Edge neighbour:u.neighbours) {
                double newDist = u.minDistance+neighbour.weight;

                if(neighbour.target.minDistance>newDist){
                    // Remove node from queue to update distance
                    queue.deleteNode(neighbour.target);
                    neighbour.target.minDistance = newDist;

                    // take visited path then add new node
                    neighbour.target.path = new MyLinkedList<>(u.path);
                    neighbour.target.path.insertLinkedList(u);

                    //Re-enter the node with new distance.
                    queue.enqueue(neighbour.target);
                }
            }
        }
    }
} // end of DijkstraAlgorithm class
