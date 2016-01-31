package fabiangillholm;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyBFS<E> implements BFS<E> {
    private List<Node<E>> visited = new LinkedList<Node<E>>(); // List of all visited nodes
    private List<Node<E>> result = new LinkedList<Node<E>>(); // Final result of bfs, this is returned
    private Queue<Node<E>> queue = new LinkedList<Node<E>>(); // A queue to stores nodes temporarily
    private int width = 0;

    private void bfs(Node<E> node) {
        // Add current node to visited and queue
        visited.add(node);
        queue.add(node);

        while(queue.size() > 0) {
            // Get the node at the top of the queue
            Node<E> current = queue.remove();
            // Current node is added to the result
            result.add(current);
            // Assign the current width value to the current node, then increment it by one
            current.num = width++;

            // Loop through the current node's successors and add them to the queue if they haven't already been visited
            Iterator<Node<E>> successors = current.succsOf();
            while(successors.hasNext()) {
                Node<E> successor = successors.next();
                if(visited.contains(successor)) {
                    continue;
                }
                visited.add(successor);
                queue.add(successor);
            }
        }
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        // Clear all Lists to make sure they're empty
        visited.clear();
        result.clear();
        queue.clear();
        bfs(root);

        return result;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        // Clear all Lists to make sure they're empty
        visited.clear();
        result.clear();
        queue.clear();
        // Do BFS of each unvisited node in the graph
        for(Node<E> node : graph) {
            queue.clear();
            if(visited.contains(node)) {
                continue;
            }
            bfs(node);
        }

        return result;
    }
}
