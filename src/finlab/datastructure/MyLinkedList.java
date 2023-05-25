package finlab.datastructure;

/**
 * Class: MyLinkedList
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 */
public class MyLinkedList<E>{
    Node<E> head; // starting point
    private MyLinkedList<E> headLinkedList;
    MyLinkedList<E> nextLinked;
    private int size = 0; // size of the list
    private int sizeLinked = 0;


    /**
     * constructs MyLinkedList
     */
    public MyLinkedList() {}
    public MyLinkedList(MyLinkedList<E> path){
        headLinkedList = path;
    }

    /**
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * @return the head of the list
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * @param data data to be inserted
     * @return inserted data
     */
    public E insert(E data){
        Node<E> pointer = head;
        Node<E> newNode = new Node<>();
        while (pointer != null) {
            pointer = pointer.getLink();
            if (pointer == null) {
                newNode.setData(data);
                newNode.setLink(head);
                head = newNode;
            }
        }
        size++;
        return data;
    }

    public MyLinkedList<E> insertLinkedList(E data) {
        MyLinkedList<E> pointer = headLinkedList;
        MyLinkedList<E> newNode = new MyLinkedList<>();
        while (pointer != null) {
            pointer = pointer.nextLinked;
            if (pointer == null) {
                nextLinked = headLinkedList;
                headLinkedList = newNode;
            }
        }
        sizeLinked++;
        return newNode;
    }
    /**
     * @param node node to be searched
     * @return searched node
     */
    Node<E> search(E node) {
        Node<E> pointer = head;
        while (pointer != null) {
            if (pointer.data.equals(node))
                return pointer;
            pointer = pointer.getLink();
        }
        return null;
    }
}

