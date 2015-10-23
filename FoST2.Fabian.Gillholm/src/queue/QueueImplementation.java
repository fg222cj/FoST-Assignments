package queue;

import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-09-13.
 */
public class QueueImplementation<E> implements Queue<E> {
    private int size = 0;
    private Node head;
    private Node tail;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    // Add object to the end of the queue
    public void enqueue(E element) {
        Node node = new Node(element);

        // If queue is empty, object is placed at both front and end
        if(this.size() == 0) {
            this.head = node;
            this.tail = node;
        }
        // Otherwise, append it to the last element and place it as tail
        else {
            this.tail.setNextNode(node);
            this.tail = node;
        }
        this.size++;
    }

    // Removes the first object from the queue and returns it
    public E dequeue() throws IndexOutOfBoundsException {
        Node node = this.head;
        this.head = node.next();
        size--;
        return node.node;
    }

    public E first() throws IndexOutOfBoundsException {
        return this.head.node;
    }

    public E last() throws IndexOutOfBoundsException {
        return this.tail.node;
    }

    // Checks if an object exists inside the queue
    public boolean contains(E o) {
        Node node = this.head;

        while(node.hasNext()) {
            if(node.node.equals(o)) {
                return true;
            }
            node = node.next();
        }

        return node.node.equals(o);
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node node = head;

        public E next() {
            Node value = node;
            node = node.next();
            return value.node;
        }

        public boolean hasNext() {
            return node != null;
        }
    }

    // Node contains a stored object and the next Node in the queue
    public class Node {
        private E node;
        private Node nextNode = null;

        public Node(E object) {
            this.node = object;
        }

        public Node next() {
            return this.nextNode;
        }

        public boolean hasNext() {
            return this.nextNode != null;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public String toString() {
            return node.toString();
        }
    }
}
