package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Fabian Gillholm on 2015-09-30.
 */
public class QueueTest {
    private static int count;
    // @Before and @After methods are shamelessly stolen from lecture slides.

    /* Executed before every test method. */
    @Before public void setUp() {
        System.out.println("Run test method: " + (++count));
    }
    /* Executed after every test method. */
    @After
    public void tearDown() {
        System.out.println(" --- done with test " + count);
    }

    @Test
    public void testEnqueueSize() {
        QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
        queue.enqueue(0);
        queue.enqueue(2147483647);
        queue.enqueue(-2147483648);
        queue.enqueue(5);
        System.out.println("Queue Size: " + queue.size());

        queue = new QueueImplementation<Integer>();
        for(int i = 0; i < 483647; i++) {
            queue.enqueue(i);
        }
        System.out.println("Queue Size: " + queue.size());
    }

    @Test
    public void testFirstLast() {
        QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(16);
        queue.enqueue(32);
        System.out.println("First: " + queue.first());
        System.out.println("Last: " + queue.last());

        queue = new QueueImplementation<Integer>();
        for(int i = 0; i < 483647; i++) {
            queue.enqueue(i);
        }
        System.out.println("First: " + queue.first());
        System.out.println("Last: " + queue.last());
    }

    @Test  (expected = NullPointerException.class)
    public void testDeQueueIsEmpty() {
        QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("Size: " + queue.size());
        System.out.println("Removing: " + queue.dequeue());
        System.out.println("Removing: " + queue.dequeue());
        System.out.println("Removing: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        assertFalse(queue.isEmpty());
        System.out.println("Removing: " + queue.dequeue());
        assertTrue(queue.isEmpty());
        System.out.println("Removing: " + queue.dequeue());
    }

    @Test
    public void testContains() {
        QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertTrue(queue.contains(1));
        assertFalse(queue.contains(3));
    }

    @Test
    public void testIterator() {
        Queue<Integer> queue = new QueueImplementation<Integer>();
        for(int i = 0; i < 483647; i++) {
            queue.enqueue(i);
        }

        int sum = 0;
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            sum += iterator.next();
        }
        assertEquals(sum, 992851489);
    }
}
