package fabiangillholm;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        return null;
    }
}
