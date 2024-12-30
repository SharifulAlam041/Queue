package org.example;

import java.util.*;

///////////////////////////////////////Common methods in Collections///////////////////////////////////
//size(),isEmpty(),contains(),toArray(),add(),remove(),
//addAll(),removeAll(),clear(),equals(),
// stream() and parallelStream(),iterator()
///////////////////////////////////////
///////////////////////////////////////Common methods in Iterator///////////////////////////////////
//hasNext()-returns true if there are more elements in the collection
//next()-return the next element,
//remove()-remove the last element returned by the iterator

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


        //*****************************************************************************************************************************************************//
        ///////////////////////////////////////////////
        //add(int index, E element)-insert element at the specific position
        //addAll(int index, Collection c)-insert all elements at the specific position
        //replaceAll(UniaryOperator op)-replace all element of the list, with result of applying operation
        //sort(Comparator c)-sort based on the provided comparator
        //get(int index)-return the element at a specific position
        //set(int index, Element e)-replace the element at a specific index
        //remove(int index)-remove the element from the index
        //indexOf(Object o)-return index of the first occurrence of the object, -1 if no element found
        //lastIndexOf(Object o)-return index of the last occurrence of the object, -1 if no element found
        //ListIterator<E> listIterator()
        //*****************************Methods of ListIterator************************//
        //hasPrevious()-return true if there more elements in the list while traversing reverse order
        //E previous()-return the previous element
        //int nextIndex()-return the index of next element
        //int previousIndex()-return the index of previous element
        //set(E e)-set element
        //add(E e)-add element
        //ListIterator<E> listIterator(int index)
        //List<E> subList(int fromIndex, int toIndex)//Any change in sublist will also change in main list
        ///////////////////////////////////////////////

        List<Integer> list1 = new ArrayList<>();
        list1.add(0,100);
        list1.add(1,200);
        list1.add(2,300);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0,400);
        list2.add(1,500);
        list2.add(2,600);
        list1.addAll(2,list2);
        list1.forEach(val-> System.out.println(val));

        list1.replaceAll(val->-1*val);
        System.out.println("Print after replace");
        list1.forEach(val-> System.out.println(val));

        list1.sort((Integer val1, Integer val2)->val1-val2);
        System.out.println("Sort list1");
        list1.forEach(val-> System.out.println(val));

        System.out.println("Value present in index 2: "+ list1.get(2));
        list1.set(2,-4000);
        System.out.println("After set method");
        list1.forEach(val-> System.out.println(val));

        list1.remove(2);
        System.out.println("After removing");
        list1.forEach(val-> System.out.println(val));

        System.out.println("index of -200 Integer object is: " + list1.indexOf(-200));

        ListIterator<Integer> listIterator1 = list1.listIterator(list1.size());
        while (listIterator1.hasPrevious()) {
            int prevVal = listIterator1.previous();
            System.out.println("traversing backward: "+prevVal+" nextIndex: "+ listIterator1.nextIndex()+ " previousIndex: "+ listIterator1.previousIndex());
            if(prevVal==-100) {
                listIterator1.set(-50);
            }
        }
        list1.forEach(val->System.out.println(val));

        ListIterator<Integer> listIterator2 = list1.listIterator();
        while (listIterator2.hasNext()) {
            int val = listIterator2.next();
            System.out.println("traversing forward: "+val+" nextIndex: "+ listIterator2.nextIndex()+ " previousIndex: "+ listIterator2.previousIndex());
            if(val==-500) {
                listIterator2.add(-400);
            }
        }
        list1.forEach(val->System.out.println(val));

        System.out.println("Sub List");
        List<Integer> subList = list1.subList(1,4);
        subList.forEach(val->System.out.println(val));
        System.out.println("List1");
        subList.add(-5);
        list1.forEach(val->System.out.println(val));

        //***************//
        /* Complexity
         * Insertion: O(1)-inserting add the end of the array
         * O(n)-inserting element at a specific index
         * O(n)-inserting add the end when threshold reached
         * Deletion O(n)-have to shift all values
         * Search O(1)
         * */
        //Thread safe version CopyOnWriteArrayList
        //***************//

    }
}