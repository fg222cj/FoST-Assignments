package fabiangillholm;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Fabian Gillholm on 2015-10-13.
 */
public class MyGraph<E> implements DirectedGraph<E> {
    private List<MyNode<E>> nodes = new LinkedList<MyNode<E>>();
    private List<Node<E>> heads = new LinkedList<Node<E>>();
    private List<Node<E>> tails = new LinkedList<Node<E>>();

    @Override
    public MyNode<E> addNodeFor(E item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }

        MyNode<E> node;

        try{
            node = getNodeFor(item);
            return node;
        }
        catch(IllegalArgumentException e) {
            node = new MyNode<E>(item);

            // Add and return
            nodes.add(node);
            heads.add(node);
            tails.add(node);
            return node;
        }
    }

    @Override
    public MyNode<E> getNodeFor(E item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }

        for(MyNode<E> node : nodes) {
            if(node.item() == item) {
                return node;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        if(from == null || to == null) {
            throw new RuntimeException("Fuck it");
        }

        MyNode<E> fromNode = addNodeFor(from);
        MyNode<E> toNode = addNodeFor(to);

        if(fromNode.hasSucc(toNode)) {
            return false;
        }

        if(toNode.hasPred(fromNode)) {
            return false;
        }

        fromNode.addSucc(toNode);
        toNode.addPred(fromNode);

        heads.remove(toNode);
        tails.remove(fromNode);

        return true;
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        if(from == null || to == null) {
            throw new RuntimeException("Fuck it");
        }

        try {
            MyNode<E> fromNode = getNodeFor(from);
            MyNode<E> toNode = getNodeFor(to);
            return fromNode.hasSucc(toNode) && toNode.hasPred(fromNode);
        }

        catch(IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public int nodeCount() {
        return nodes.size();
    }

    @Override
    public boolean containsNodeFor(E item) {
        if(item == null) {
            throw new RuntimeException("Fuck it");
        }
        try {
            MyNode<E> node = getNodeFor(item);
        }
        catch(IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        ArrayList<Node<E>> nodeList = new ArrayList<Node<E>>();
        for (MyNode<E> node : nodes) {
            nodeList.add(node);
        }
        return nodeList.iterator();
    }

    @Override
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    @Override
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    @Override
    public int headCount() {
        return heads.size();
    }

    @Override
    public int tailCount() {
        return tails.size();
    }

    @Override
    public int edgeCount() {
        int edges = 0;
        for(MyNode<E> node : nodes) {
            Iterator<Node<E>> iterator = node.succsOf();
            while(iterator.hasNext()) {
                iterator.next();
                edges++;
            }
        }
        return edges;
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        if(containsEdgeFor(from, to)) {
            MyNode<E> fromNode = getNodeFor(from);
            MyNode<E> toNode = getNodeFor(to);

            fromNode.removeSucc(toNode);
            toNode.removePred(fromNode);

            if(fromNode.isTail() && !tails.contains(fromNode)) {
                tails.add(fromNode);
            }

            if(toNode.isHead() && !heads.contains(toNode)) {
                heads.add(toNode);
            }

            return true;
        }
        return false;
    }

    @Override
    public List<E> allItems() {
        List<E> items = new ArrayList<E>();
        for(MyNode<E> node : nodes) {
            items.add(node.item());
        }
        return items;
    }

    @Override
    public void removeNodeFor(E item) {
        if(item == null){
            throw new RuntimeException("Fuck it");
        }

        if(containsNodeFor(item)) {
            MyNode<E> node = getNodeFor(item);
            Iterator<Node<E>> predIterator = node.predsOf();
            Iterator<Node<E>> succIterator = node.succsOf();

            Node<E> next;

            for(MyNode<E> noderino : nodes) {
                removeEdgeFor(noderino.item(), node.item());
                removeEdgeFor(node.item(), noderino.item());
            }

            nodes.remove(node);
            heads.remove(node);
            tails.remove(node);
        }
        else {
            throw new RuntimeException("Fuck it");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(MyNode<E> node : nodes) {
            sb.append(node.toString());
        }
        return sb.toString();
    }
}
