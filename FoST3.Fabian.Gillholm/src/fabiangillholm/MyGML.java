package fabiangillholm;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.io.File;
import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 */
public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        StringBuilder stringBuilder = new StringBuilder();
        if(graph != null) {
            stringBuilder.append("graph [\n");
            stringBuilder.append("\tdirected 1\n");

            Iterator<Node<E>> graphIterator = graph.iterator();
            Node<E> node;
            while(graphIterator.hasNext()) {
                node = graphIterator.next();
                stringBuilder.append("\tnode [\n");
                stringBuilder.append("\t\tid " + node.toString() + "\n");
                stringBuilder.append("\t]\n");
            }

            graphIterator = graph.iterator();
            while(graphIterator.hasNext()) {
                node = graphIterator.next();
                Iterator<Node<E>> predIterator = node.predsOf();
                Node<E> pred;
                while(predIterator.hasNext()) {
                    pred = predIterator.next();
                    stringBuilder.append("\tedge [\n");
                    stringBuilder.append("\t\tsource " + pred.toString() + "\n");
                    stringBuilder.append("\t\ttarget " + node.toString() + "\n");
                    stringBuilder.append("\t]\n");
                }
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    @Override
    public void dumpGML(File graph_file) {
        super.dumpGML(graph_file);
    }

    @Override
    public void dumpGML() {
        super.dumpGML();
    }
}
