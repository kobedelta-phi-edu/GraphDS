package finlab.datastructure;


/**
 * Class: PriorityQueue
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 *
 * implements the Queue interface while keeping the queue in order
 * @param <E> Object
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private Node<E> front; //the first object in the queue
    private int count = 0; // the size of the queue

    /**
     * empty constructor PriorityQueue
     */
    public PriorityQueue() {}

    /**
     * @return size of the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return the first object in the queue
     * @throws QueueException thrown when the queue is empty.
     */
    @Override
    public E first() throws QueueException {
        if (isEmpty())
            throw new QueueException("Sorry, The queue is empty.");
        return front.getData();
    }

    /**
     * @return data of the first item in the queue
     * @throws QueueException thrown when the queue is empty
     */
    @Override
    public E dequeue() throws QueueException {
        Node<E> temp;
        if (isEmpty())
            throw new QueueException("Dequeue operation failed. The queue is empty.");
        temp = front;
        front = front.getLink();
        count--;
        return temp.getData();
    }

    /**
     * gets the count of items in the queue
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * queues a node to the list
     *
     * @param item data to be queued
     * @throws QueueException thrown when an error in the queue has occurred
     */
    public void enqueue(E item) throws QueueException {
        boolean isInserted = false;
        Node<E> newNode = new Node<>();
        Node<E> nextNode = new Node<>();
        if(count > 1) {
            nextNode = front.link;
        }
        newNode.setData(item);
        if (front == null) {
            front = newNode;
            isInserted = true;
        }
        if (front.data.compareTo(newNode.data) >= 0 && !isInserted) {
            newNode.link = front;
            front = newNode;
            isInserted = true;
        }
        if (front.data.compareTo(newNode.data) < 0 && front.link == null && !isInserted) {
            front.link = newNode;
            isInserted = true;
        }
        if (count == 2 && nextNode.data.compareTo(newNode.data) < 0 && !isInserted) {
            front.link.link = newNode;
            isInserted = true;
        }
        if (count == 2 && nextNode.data.compareTo(newNode.data) > 0 && !isInserted) {
            newNode.link = front.link;
            front.link = newNode;
            isInserted = true;
        }

        Node<E> curr = front;
        Node<E> nextCurr = curr.link;
        if (!isInserted) {
            while (nextCurr != null && nextCurr.data.compareTo(newNode.data) <= 0) {
                curr = curr.link;
            }
            if (curr.link == null) {
                curr.link = newNode;
                isInserted = true;
            }
            if (!isInserted) {
                newNode.link = curr.link;
                curr.link = newNode;
            }
        }
        count++;
    }

    public void deleteNode(E item){
        if (isEmpty()) return;
        Node<E> temp = new Node<>();
        temp.setData(item);

        Node<E> curr = front;
        Node<E> prev = new Node<>();

        if(curr.data == null) return;
        while(curr.data.compareTo(temp.data) != 0){
            prev = curr;
            if(curr.link == null)
                break;
            else
                curr = curr.link;
        }
        if (curr.data.compareTo(temp.data) == 0){
            if(curr.link == null)
                curr.setData(null);
            else {
                prev.setLink(temp);
                temp.setLink(curr.link);
            }
            count--;
        }
    }
}