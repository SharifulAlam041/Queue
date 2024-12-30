package org.example;

import java.util.*;

///////////////////////////////////////Common methods in Collection///////////////////////////////////
//size(),isEmpty(),contains(),toArray(),add(),remove(),
//addAll(),removeAll(),clear(),equals(),
// stream() and parallelStream(),iterator()
///////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        ///////////////////////////////////////
        //add()-Insert, Exception if fails, True if succeeds, Null element not allowed(NPE)
        //offer()-Insert, False if fails, True if succeeds, Null element not allowed(NPE)
        //poll()-Retrieves and removes the head, return null if queue empty
        //remove()-Retrieves and removes the head, return Exception if queue empty
        //peek()-Retrieves the value of the head not remove, return null if queue empty
        //element()-Retrieves the value of the head not remove, return Exception if queue empty
        ///////////////////////////////////////

        //Priority Queue: Queue with a priority
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(5);
        minPQ.offer(2);
        minPQ.add(8);
        minPQ.offer(1);
        //offer() and add() both are similar, add() throws exception in insertion fails, offer() returns false
        minPQ.forEach((System.out::println));

        while(!minPQ.isEmpty()) {
            int val = minPQ.poll();
            //We can also use remove() instead of poll()
            System.out.println("remove from top:  " + val);
        }

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer a, Integer b)->b-a);
        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);
        maxPQ.forEach(System.out::println);
        while(!maxPQ.isEmpty()) {
            int val = maxPQ.remove();
            //We can also use remove() instead of poll()
            System.out.println("remove from top:  " + val);
        }
        //***************//
        /* Complexity
        * Add and Offer O(logn)
        * Peek O(1)
        * Poll and Remove O(logn)
        * Remove arbitrary element O(n)
        * */
        //Thread safe version PriorityBlockingQueue
        //***************//


        //*****************************************************************************************************************************************************//
        ///////////////////////////////////////////////
        //addFirst(),offerFirst(),addLast(),offerLast()
        //removeFirst(),pollFirst(),removeLast(),pollLast()
        //getFirst(),peekFirst(),getLast(),peekLast()
        ///////////////////////////////////////////////

        //Deque: Double ended queue
        ArrayDeque<Integer> arrayDequeAsQueue = new ArrayDeque<>();
        arrayDequeAsQueue.addLast(1);
        arrayDequeAsQueue.addLast(5);
        arrayDequeAsQueue.addLast(10);
        int element = arrayDequeAsQueue.removeFirst();
        System.out.println(element);

        ArrayDeque<Integer> arrayDequeAsStack = new ArrayDeque<>();
        arrayDequeAsStack.addFirst(1);
        arrayDequeAsStack.addFirst(5);
        arrayDequeAsStack.addFirst(10);
        int removeElement = arrayDequeAsStack.removeFirst();
        System.out.println(removeElement);

        //***************//
        /* Complexity
         * Insertion: Amortized(Most of the time or average) O(1), O(n) when queue size threshold reached
         * and try to add new element then values are copied to bigger queue
         * Deletion O(1)
         * Search O(1)
         * Remove arbitrary element O(n)
         * */
        //Thread safe version ConcurrentLinkedDeque
        //***************//
    }
}