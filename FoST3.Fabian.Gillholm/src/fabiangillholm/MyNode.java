package fabiangillholm;

import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-10-13.
 */
public class MyNode<E> extends Node<E> {
    private ArrayList<Node<E>> predecessors = new ArrayList<Node<E>>();
    private ArrayList<Node<E>> successors = new ArrayList<Node<E>>();

    protected MyNode(E item) {
        super(item);
    }

    @Override
    public void addPred(Node<E> pred) {
        predecessors.add(pred);
    }

    @Override
    public void addSucc(Node<E> succ) {
        successors.add(succ);
    }

    @Override
    public void removePred(Node<E> pred) {
        predecessors.remove(pred);
    }

    @Override
    public void removeSucc(Node<E> succ) {
        successors.remove(succ);
    }

    @Override
    public void disconnect() {
        predecessors = new ArrayList<Node<E>>();
        successors = new ArrayList<Node<E>>();
    }

    @Override
    public boolean hasPred(Node<E> node) {
        for(Node<E> each : predecessors) {
            if(each.item() == node.item()) {
                return true;
            }
        }
        return false;
        //return predecessors.contains(node);
    }

    @Override
    public boolean hasSucc(Node<E> node) {
        for(Node<E> each : successors) {
            if(each.item() == node.item()) {
                return true;
            }
        }
        return false;
        //return successors.contains(node);
    }

    @Override
    public int inDegree() {
        return predecessors.size();
    }

    @Override
    public int outDegree() {
        return successors.size();
    }

    @Override
    public Iterator<Node<E>> predsOf() {
        return predecessors.iterator();
    }

    @Override
    public Iterator<Node<E>> succsOf() {
        return successors.iterator();
    }
}
