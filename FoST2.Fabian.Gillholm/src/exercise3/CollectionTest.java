package exercise3;

import da1031.IntList;
import da1031.IntStack;
import exercise1.ArrayIntList;
import exercise1.ArrayIntStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fabian Gillholm on 2015-09-29.
 * The interface and the abstract class should have separate tests which is why I won't waste any time
 * to test the methods provided in them except if I have overridden them.
 */
public class CollectionTest {
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

    // Start test of ArrayIntList

    @Test
    public void testListAddGet() {
        IntList arrayIntList = new ArrayIntList();
        arrayIntList.add(4);
        arrayIntList.add(4);
        arrayIntList.add(4);
        arrayIntList.add(5);
        assertEquals(5, arrayIntList.get(3));

        // Add max value of int
        boolean success = true;
        try{
            arrayIntList.add(2147483647);
        }
        catch(IllegalArgumentException e) {
            success = false;
        }
        assertTrue(success);

        // Add min value of int
        success = true;
        try{
            arrayIntList.add(-2147483648);
        }
        catch(IllegalArgumentException e) {
            success = false;
        }
        assertTrue(success);

        arrayIntList = new ArrayIntList();

        // Add a big bunch of numbers
        for (int i = 0; i < 100000000; i++) {
            arrayIntList.add(i);
        }
        assertEquals(99999999, arrayIntList.get(99999999));

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testListAddAt() {
        IntList arrayIntList = new ArrayIntList();
        arrayIntList.add(0);
        arrayIntList.add(2);
        arrayIntList.add(3);
        arrayIntList.addAt(1, 1);
        assertEquals(1, arrayIntList.get(1));

        boolean success = true;
        // Make sure that an IndexOutOfBoundsException is thrown
        try {
            arrayIntList.addAt(1, 10);
        }
        catch(IndexOutOfBoundsException e) {
            success = false;
        }
        assertFalse(success);

        // Should be out of bounds
        arrayIntList.addAt(1, -1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testListRemove() {
        IntList arrayIntList = new ArrayIntList();
        arrayIntList.add(2);
        arrayIntList.add(3);
        arrayIntList.add(4);
        arrayIntList.add(5);
        arrayIntList.remove(2);
        assertEquals(5, arrayIntList.get(2));
        assertEquals(3, arrayIntList.size());

        // Should be out of bounds
        arrayIntList.remove(3);
    }

    @Test
    public void testListIndexOf() {
        IntList arrayIntList = new ArrayIntList();
        arrayIntList.add(2);
        arrayIntList.add(3);
        arrayIntList.add(4);
        arrayIntList.add(5);
        assertEquals(2, arrayIntList.indexOf(4));

        assertEquals(-1, arrayIntList.indexOf(6));
    }

    // End test of ArrayIntLit

    // Start test of ArrayIntStack

    @Test
    public void testPushPeek() {
        IntStack arrayIntStack = new ArrayIntStack();

        // Check if IndexOutOfBoundsException is thrown when peeking at empty stack
        boolean success = true;
        try{
            arrayIntStack.peek();
        }
        catch(IndexOutOfBoundsException e) {
            success = false;
        }
        assertFalse(success);

        arrayIntStack.push(1);
        arrayIntStack.push(2);
        assertEquals(2, arrayIntStack.peek());

        arrayIntStack.push(3);
        arrayIntStack.push(4);
        assertEquals(4, arrayIntStack.peek());

        // Clear stack and try a huge bunch of values
        arrayIntStack = new ArrayIntStack();
        for (int i = 0; i < 100000000; i++) {
            arrayIntStack.push(i);
        }
        assertEquals(99999999, arrayIntStack.peek());
    }

    @Test
    public void testPop() {
        IntStack arrayIntStack = new ArrayIntStack();

        // Check if IndexOutOfBoundsException is thrown when popping empty stack
        boolean success = true;
        try{
            arrayIntStack.pop();
        }
        catch(IndexOutOfBoundsException e) {
            success = false;
        }
        assertFalse(success);

        arrayIntStack.push(1);
        arrayIntStack.push(2);
        arrayIntStack.push(3);
        arrayIntStack.push(4);
        assertEquals(4, arrayIntStack.pop());
        assertEquals(3, arrayIntStack.pop());

        // Clear stack and test with a big heap of values
        arrayIntStack = new ArrayIntStack();
        for (int i = 0; i < 100000000; i++) {
            arrayIntStack.push(i);
        }
        assertEquals(99999999, arrayIntStack.pop());
        assertEquals(99999998, arrayIntStack.pop());

    }
}
