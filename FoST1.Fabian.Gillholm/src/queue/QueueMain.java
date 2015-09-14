package queue;

import java.util.Iterator;

/**
 * Created by Fabian Gillholm on 2015-09-14.
 */
public class QueueMain {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();

        sb1.append("Ettan");
        sb2.append("Tvåan");
        sb3.append("Trean");
        sb4.append("Fyran");

        Queue q = new Queue();

        q.enqueue(sb1);
        q.enqueue(sb2);
        q.enqueue(sb3);

        System.out.println("Borde vara Ettan: " + q.first().toString());
        System.out.println("Borde vara Trean: " + q.last().toString());

        q.dequeue();

        q.enqueue(sb4);

        System.out.println("Borde vara Tvåan: " + q.first().toString());
        System.out.println("Borde vara Fyran: " + q.last().toString());

        if(q.contains(sb2)) {
            System.out.println("Tvåan finns!");
        }

        System.out.println("Hela listan:");
        Iterator i = q.iterator();
        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }
}
