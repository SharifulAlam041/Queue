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

        //Using deque functionality
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.addLast(200);
        linkedList1.addLast(300);
        linkedList1.addLast(400);
        linkedList1.addLast(100);
        System.out.println(linkedList1.getFirst());

        //Using list functionality
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(0,100);
        linkedList2.add(1,300);
        linkedList2.add(2,400);
        linkedList2.add(1,200);
        System.out.println(linkedList2.get(1) + " and " + linkedList2.get(2));
        /* Complexity
         * Insertion: O(1)-at start or end of the Linkedlist
         * O(n)-inserting element at a specific index(O(n) for lookup,O(1) for inserting
         * Deletion O(n)-deleting element at a specific index(O(n) for lookup,O(1) for deleting
         * O(1)-at start or end of the Linkedlist
         * Search O(n)
         * */
        //Thread safe version CopyOnWriteArrayList
        //***************//

        //Vector is same as arraylist but threadsafe, stack also threadsafe in java

        //*****************************************************************************************************************************************************//
        ///////////////////////////////////////////////
        //size()-returns the number of key value mapping present
        //isEmpty()-returns true if map contains no key value mapping
        //containsKey(Object key)-if given key is present in the map returns true else false
        //containsValue(Object value)-return true, if one or more key mapped to specified value
        //get(Object key)-return the value to which key is mapped
        //put(K key, V value)-if already same key present it overwrite, if not present then insert
        //remove(Object key)-removes the key value mapping from map
        //putAll(Map<K,V> m)-insert the mappings from specified map to this map
        //clear()-remove all the mappings from the map
        //Set<K> keySet()-returns the set view of the key contained in the map
        //Collection<V> values()-returns the collection view of all values
        //Set<Map.Entry<K,V>> entrySet()-returns the set view of the mappings present in the map
        //putIfAbsent(K key, V value)-if key exists return the value associated with it, else create new mapping with this key and value
        //getOrDefault(key,defaultValue)-if key not exists or value null, return default value
        //Entry sub-interface
        //          ->getKey()
        //          ->getValue()
        //          ->int hashCode()
        //          ->boolean equals(Object o)
        ///////////////////////////////////////////////

        Map<Integer,String> integerStringMap = new HashMap<>();
        integerStringMap.put(null,"Test");
        integerStringMap.put(0,null);
        integerStringMap.put(1,"A");
        integerStringMap.put(2,"B");

        integerStringMap.putIfAbsent(null,"test");
        integerStringMap.putIfAbsent(0,"ZERO");
        integerStringMap.putIfAbsent(3,"C");

        for (Map.Entry<Integer,String> entryMap: integerStringMap.entrySet()) {
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: "+ key +" Value: "+ value);
        }
        System.out.println("Check If Empty: " + integerStringMap.isEmpty());
        System.out.println("Size: " + integerStringMap.size());
        System.out.println("Contains(5): " + integerStringMap.containsKey(5));
        System.out.println("get(1): " + integerStringMap.get(1));
        System.out.println("getOrDefault(9): " + integerStringMap.getOrDefault(9,"Default Value"));
        System.out.println("Remove(null): " + integerStringMap.remove(null));
        for (Map.Entry<Integer,String> entryMap: integerStringMap.entrySet()) {
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: "+ key +" Value: "+ value);
        }
        for(Integer key:integerStringMap.keySet()) {
            System.out.println("Key: "+ key );
        }
        Collection<String> values = integerStringMap.values();
        for(String value:values) {
            System.out.println("Value: "+ value );
        }

        /* Complexity
         * add:amortized O(1)
         * remove:amortized O(1)
         * get:amortized
         * O(1)
         * Thread safe version : ConcurrentHashMap and HashTable
         * */

        //*****************************************************************************************************************************************************//
        //Linked hash map maintains order(Insertion order and access order)
        //Similar to hashmap but use double linkedlist
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"A");
        linkedHashMap.put(21,"B");
        linkedHashMap.put(23,"C");
        linkedHashMap.put(141,"D");
        linkedHashMap.put(25,"E");
        linkedHashMap.forEach((Integer key, String val)-> System.out.println(key + " : " + val));

        LinkedHashMap<Integer,String> linkedHashMap2 = new LinkedHashMap<>(16,0.75F,true);
        linkedHashMap2.put(1,"A");
        linkedHashMap2.put(21,"B");
        linkedHashMap2.put(23,"C");
        linkedHashMap2.put(141,"D");
        linkedHashMap2.put(25,"E");
        linkedHashMap2.get(23);
        linkedHashMap2.forEach((Integer key, String val)-> System.out.println(key + " : " + val));
        //Complexity same as hashmap, no Thread safe version
        //For converting thread safe version ->, Collections.synchronizedMap(new LinkedHashMap<>())

        Map<Integer,String> treeMap = new TreeMap<>((Integer key1, Integer key2) -> key2-key1);
        treeMap.put(21,"SJ");
        treeMap.put(11,"TJ");
        treeMap.put(13,"PJ");
        treeMap.put(5,"KJ");
        treeMap.forEach((Integer key, String val)-> System.out.println(key + " : " + val));
        Map<Integer,String> treeMap2 = new TreeMap<>();
        treeMap2.put(21,"SJ");
        treeMap2.put(11,"TJ");
        treeMap2.put(13,"PJ");
        treeMap2.put(5,"KJ");
        treeMap2.forEach((Integer key, String val)-> System.out.println(key + " : " + val));
        //Write, Get, Delete complexity O(logn)
        //TreeMap Implements SortedMap and NavigableMap,
        //Methods in SortedMap
        //SortedMap<K,V> headMap(K toKey)-returns elements from head to given key, excluding the given key
        //SortedMap<K,V> tailMap(K fromKey)-returns elements from given key to tail, including the given key
        //K firstKey()-returns first key
        //K lastKey()-returns last key
        SortedMap<Integer,String> sortedMap = new TreeMap<>();
        sortedMap.put(21,"SJ");
        sortedMap.put(11,"TJ");
        sortedMap.put(13,"PJ");
        sortedMap.put(5,"KJ");
        System.out.println(sortedMap.headMap(13));
        System.out.println(sortedMap.tailMap(13));
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

        NavigableMap<Integer,String> map = new TreeMap<>();
        //Map.Entry<K,V> lowerEntry(K key)-immediate lower entry of the given key
        //K lowerKey(K key)-immediate lower key of the given key
        //Map.Entry<K,V> floorEntry(K key)-return equal or immediate lower entry of the given key
        //K floorKey(K key)-return equal or immediate lower key of the given key
        //Map.Entry<K,V> ceilingEntry(K key)-return equal or immediate greater entry of the given key
        //K ceilingKey(K key)-return equal or immediate greater key of the given key
        //Map.Entry<K,V> higherEntry(K key)-immediate higher entry of the given key
        //K higherKey(K key)-immediate higher key of the given key
        //Map.Entry<K,V> firstEntry()-return the first Entry
        //Map.Entry<K,V> lastEntry()-return the last Entry
        //Map.Entry<K,V> pollFirstEntry()-remove and return the first Entry
        //Map.Entry<K,V> pollLastEntry()-remove and return the last Entry
        //NavigableMap<K,V> descendingMap()-return and reverse the element of the map
        //NavigableSet<K> navigableKeySet()-if tree map is ascending it returns ascending else descending
        //NavigableSet<K> descendingKeySet()-if tree map is ascending it returns descending else ascending
        //NavigableMap<K,V> headMap(K toKey, boolean inclusive)-same as SortedMap
        //NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)-same as SortedMap

        //*****************************************************************************************************************************************************//
        //add(E element)-returns true, if element is not present in the set, then add it to set, otherwise false and do not add element to set
        //addAll(Collection c)-performs Union of two set collections
        //removeAll(Collection c)-performs difference of two set, delete the values given in the collection
        //retainAll(Collection c)-performs intersection of two set collections,  return common elements from both sets
        //
        Set<Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(11);
        set1.add(33);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(11);
        set2.add(9);
        set2.add(88);
        set2.add(10);
        set2.add(5);
        set2.add(12);
        set1.addAll(set2);
        System.out.println("After Union");
        set1.forEach((Integer val)-> System.out.println("----------------"+val));

        Set<Integer> set3 = new HashSet<>();
        set3.add(12);
        set3.add(11);
        set3.add(33);
        set3.add(4);

        Set<Integer> set4 = new HashSet<>();
        set4.add(11);
        set4.add(9);
        set4.add(88);
        set4.add(10);
        set4.add(5);
        set4.add(12);
        set3.retainAll(set4);
        System.out.println("After Intersection");
        set3.forEach((Integer val)-> System.out.println("----------------"+val));

        Set<Integer> set5 = new HashSet<>();
        set5.add(12);
        set5.add(11);
        set5.add(33);
        set5.add(4);

        Set<Integer> set6 = new HashSet<>();
        set6.add(11);
        set6.add(9);
        set6.add(88);
        set6.add(10);
        set6.add(5);
        set6.add(12);
        set5.removeAll(set6);
        System.out.println("After Removal");
        set5.forEach((Integer val)-> System.out.println("----------------"+val));



    }
}