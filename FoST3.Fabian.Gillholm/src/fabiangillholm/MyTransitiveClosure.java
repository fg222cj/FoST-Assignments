package fabiangillholm;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    private Map<Node<E>, Collection<Node<E>>> result = new LinkedHashMap<Node<E>, Collection<Node<E>>>();
    private List<Node<E>> visited  = new LinkedList<Node<E>>();
    private List<Node<E>> connected  = new LinkedList<Node<E>>();
    private int depth;

    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        // Make sure the map and lists are empty
        result.clear();
        connected.clear();
        visited.clear();

        // Loop through all the nodes in the graph and compute each of them
        for(Node<E> node : dg) {
            visited = new LinkedList<Node<E>>();
            compute(node);
            result.put(node, visited);
        }

        return result;
    }

    private void compute(Node<E> node) {
        // Add this node to the list of visited nodes
        visited.add(node);
        // Assign the current depth to this node, then increment it by 1
        node.num = depth++;

        // Loop through all unvisited successors to the current node, and recursively compute each of them
        Iterator<Node<E>> successors = node.succsOf();
        while(successors.hasNext()) {
            Node<E> successor = successors.next();
            if(!visited.contains(successor)) {
                compute(successor);
            }
        }
    }
}
