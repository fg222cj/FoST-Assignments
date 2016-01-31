package fabiangillholm;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {
    private Set<Node<E>> visited = new HashSet<Node<E>>(); // Keeps track of the visited nodes
    private Set<Node<E>> connection  = new HashSet<Node<E>>();
    private Set<Collection<Node<E>>> collections = new HashSet<Collection<Node<E>>>();

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        // Make sure all sets are empty.
        connection.clear();
        visited.clear();
        collections.clear();

        // Loop through all the nodes in the graph
        for(Node<E> node : dg) {
            // Skip to next if the node is already visited
            if(visited.contains(node)) {
                continue;
            }
            // Compute all connections for this node
            computeConnections(node);

            // Loop through all previously added collections and only add this one if it hasn't already been added
            Iterator<Collection<Node<E>>> collectionIterator = collections.iterator();
            while(collectionIterator.hasNext()) {
                Collection<Node<E>> collection = collectionIterator.next();
                if(Collections.disjoint(collection, connection)) {
                    continue;
                }
                collection.addAll(connection);
                // Empty the connection (clear() doesn't work here since it would empty by reference)
                connection = new HashSet<Node<E>>();
                continue;
            }

            // As long as the collection isn't empty, it is safe to add it
            if(connection.isEmpty()) {
                continue;
            }
            collections.add(connection);
            // Empty the connection (clear() doesn't work here since it would empty by reference)
            connection = new HashSet<Node<E>>();
        }

        return collections;
    }

    private void computeConnections(Node<E> node) {
        // Add the current node to visited and connection
        visited.add(node);
        connection.add(node);

        // Loop through all unconnected successors and add them as connections
        Iterator<Node<E>> successors = node.succsOf();
        while(successors.hasNext()) {
            Node<E> successor = successors.next();
            if(connection.contains(successor)) {
                continue;
            }
            computeConnections(successor);
        }
    }
}
