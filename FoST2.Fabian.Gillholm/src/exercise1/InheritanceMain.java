package exercise1;

import da1031.IntList;
import da1031.IntStack;

/**
 * Created by Fabian Gillholm on 2015-09-22.
 */
public class InheritanceMain {
    public static void main(String[] args) {
        IntList intList = new ArrayIntList();
        intList.add(4);
        intList.add(5);
        intList.add(7);
        intList.add(12);
        intList.add(14);
        intList.add(17);
        System.out.println(intList.toString());
        intList.addAt(22, 4);
        System.out.println(intList.toString());
        intList.remove(3);
        System.out.println(intList.toString());
        System.out.println("Value at index 1: " + intList.get(1));
        System.out.println("Index of 14: " + intList.indexOf(14));

        System.out.println();
        System.out.println();

        IntStack intStack = new ArrayIntStack();
        intStack.push(3);
        intStack.push(6);
        intStack.push(9);
        intStack.push(12);
        intStack.push(15);
        System.out.println(intStack.toString());
        System.out.println("Popping: " + intStack.pop());
        System.out.println(intStack.toString());
        System.out.println("Peeking: " + intStack.peek());
        System.out.println(intStack.toString());
    }
}
