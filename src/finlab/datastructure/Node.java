package finlab.datastructure;

/**
 * Class: Node
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 */
public class Node<E> {
    E data;
    Node<E> link;

    public Node(){}

    public void setData(E data) {
        this.data = data;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }

    public E getData() {
        return data;
    }

    public Node<E> getLink() {
        return link;
    }

}
