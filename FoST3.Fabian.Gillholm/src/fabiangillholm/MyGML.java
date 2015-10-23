package fabiangillholm;

import graphs.DirectedGraph;
import graphs.GML;

import java.io.File;

/**
 * Created by Fabian Gillholm on 2015-10-16.
 * Not implemented!
 */
public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> edsfs) {
        super(edsfs);
    }

    @Override
    public String toGML() {
        return null;
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
