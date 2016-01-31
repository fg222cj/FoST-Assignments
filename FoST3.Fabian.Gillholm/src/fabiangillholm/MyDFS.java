package fabiangillholm;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyDFS<E> implements DFS<E> {
    private List<Node<E>> postOrderedGraph = new LinkedList<Node<E>>(); // Contains the graph wiht post order numbers assigned
    private List<Node<E>> visited = new LinkedList<Node<E>>(); // Keeps track of which nodes have been visited in a DFS or a post order
    private int depth = 0; // Contains the current search depth (each visited node adds 1 to the depth)
    private int postOrder = 0; // Contains the post order value (each visited node adds 1 to this)

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        // Make sure visited is empty
        visited.clear();
        dfs(root);
        return visited;
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        // Make sure visited is empty
        visited.clear();
        for(Node<E> node : graph) {
            if(!visited.contains(node)) {
                dfs(node);
            }
        }
        return visited;
    }

    private void dfs(Node<E> node) {
        // Assign the current depth to the node's num variable, then add 1 to it
        node.num = depth++;
        // Add this node to the list of visited nodes
        visited.add(node);
        // Get all successors of this node
        Iterator<Node<E>> successors = node.succsOf();
        // Recursively visit all unvisited successors of this node
        while(successors.hasNext()) {
            Node<E> successor = successors.next();
            if(!visited.contains(successor)) {
                dfs(successor);
            }
        }
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        // Make sure postOrderedGraph and visited are both empty
        postOrderedGraph.clear();
        visited.clear();
        postOrder(root);
        return postOrderedGraph;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        // Make sure postOrderedGraph and visited are both empty
        postOrderedGraph.clear();
        visited.clear();
        Iterator<Node<E>> nodes = g.iterator();
        while(nodes.hasNext()) {
            Node<E> node = nodes.next();
            if(!visited.contains(node)) {
                postOrder(node);
            }
        }
        return postOrderedGraph;
    }

    private void postOrder(Node<E> node) {
        // Add this node to the list of visited nodes
        visited.add(node);
        // Get all successors of this node
        Iterator<Node<E>> successors = node.succsOf();
        // Recursively visit all unvisited successors of this node
        while(successors.hasNext()) {
            Node<E> successor = successors.next();
            if(!visited.contains(successor)) {
                postOrder(successor);
            }
        }
        // Assign the current post order to the node's num variable, then add 1 to it
        node.num = postOrder++;
        // Add the altered node to the
        postOrderedGraph.add(node);
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        // Make sure postOrderedGraph and visited are both empty
        postOrderedGraph.clear();
        visited.clear();
        for(Node<E> node : g) {
            if(attach_dfs_number) {
                node.num = depth++;
                postOrder(node);
            } else {
                postOrder(node);
            }
        }
        return postOrderedGraph;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        // Get the post order of the graph
        List<Node<E>> postOrdered = postOrder(graph);
        // Loop through each node in the post order of the graph
        for(Node<E> node : postOrdered) {
            // Loop through each of the node's successors
            Iterator<Node<E>> successors = node.succsOf();
            while(successors.hasNext()) {
                // If the current node has a lower or equal post order value compared to one of its successors, the graph is cyclic
                if(node.num <= successors.next().num) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        // Get the post order, then reverse it
        List<Node<E>> result = postOrder(graph);
        Collections.reverse(result);
        return result;
    }
}
