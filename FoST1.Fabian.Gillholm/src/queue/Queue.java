package queue;

import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-09-13.
 */
public class Queue implements QueueInterface {
    private int size = 0;
    private Node head;
    private Node tail;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void enqueue(Object element) {
        Node node = new Node(element);
        if(this.size() == 0) {
            this.head = node;
            this.tail = node;
        }
        else {
            this.last().setNextNode(node);
            this.tail = node;
        }
        this.size++;
    }

    public Node dequeue() throws IndexOutOfBoundsException {
        Node node = this.head;
        this.head = node.next();
        size--;
        return node;
    }

    public Node first() throws IndexOutOfBoundsException {
        return this.head;
    }

    public Node last() throws IndexOutOfBoundsException {
        return this.tail;
    }

    public boolean contains(Object o) {
        Node node = this.head;

        while(node.hasNext()) {
            if(node.equals(o)) {
                return true;
            }
            node = node.next();
        }

        return node.equals(o);
    }

    public Iterator<Node> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Node>{
        private Node node = head;

        public Node next() {
            Node value = node;
            node = node.next();
            return value;
        }

        public boolean hasNext() {
            return node.hasNext();
        }
    }

    private class Node {
        private Object node;
        private Node nextNode = null;

        public Node(Object object) {
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
    }
}
