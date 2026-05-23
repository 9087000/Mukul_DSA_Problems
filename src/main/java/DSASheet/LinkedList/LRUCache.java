package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    public static void main(String args[]) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
    public static class LruCache {
        //brute
        //ArrayList - usage order
        // Map - key-value pair
        // front = most recently used
        // back = least recently used
        // get
        // if key does not exists -> return -1
        // remove the key value from list
        // Add the list value to front
        // return map key value
        // put
        // if key already exisits
        // in map put value of key , value
        // remove the old node  key from list
        // add the old node key to list
        // remove the key value from list
        // if list size == capacity
        // for leastcapcity remove the list.size() - 1
        // remove least capacity from map as well
        // add the key value to list
        // add the key value pair to map
        // T.c : o(n)
        // S.c : o(n)
//        int capacity;
//        List<Integer> list;
//        Map<Integer, Integer> map;
//        LruCache(int capacity) {
//            this.capacity = capacity;
//           list = new ArrayList<>();
//           map = new HashMap<>();
//        }
//
//        public int get(int key) {
//            if(!map.containsKey(key)){
//                return -1;
//            }
//            list.remove(Integer.valueOf(key));
//            list.add(0, key);
//            return map.get(key);
//        }
//        public void put(int key, int value) {
//           if(map.containsKey(key)) {
//               map.put(key, value);
//
//               list.remove(Integer.valueOf(key));
//               list.add(0, key);
//               return;
//           }
//
//           if(list.size() == capacity) {
//               int leastCapacity = list.remove(list.size() - 1);
//               map.remove(leastCapacity);
//           }
//
//           list.add(0, key);
//           map.put(key, value);
//        }

        //optimized
        // Map <Integer, Nodes> map  -> key value pair
        // we use doubly LL here
        // node head -> prev -> next
        // LRuCache
        // intialize map
        // capacity
        // head
        // tail
        // insert
        //  first = head.next
        //  node.next = first
        // node.prev = head
        // head.next = node
        // first.prev = node
        // remove
        // before = node.prev
        // after = node.next
        // before.next = after
        // after.prev = before
        // get
        // if it does not exists -> -1
        // node = map.get(key)
        // remove(node)
        // insert(node)
        // node.value
        // put
        // if it exists
        // oldNode = map.get(key)
        // remove(oldNode)
        // remove it from map this oldNode
        // if size of map == capacity
        // leastCapacity = tail.prev
        // remove(leastCapcity)
        // from map remove the leastCapacity.key
        // newNode = new Node(key, value)
        // insert(newNode)
        // map add the key, newNode
        // T.C : o(1)
        // S.C :o(1)
        int capcity;
        Map<Integer , Nodes> map;
        Nodes head;
        Nodes tail;
        public void remove(Nodes node) {
            Nodes before = node.prev;
            Nodes after = node.next;
            before.next = after;
            after.prev = before;
        }

        public void insert(Nodes node) {
            Nodes firstNode = head.next;

            node.next = firstNode;
            node.prev = head;

            head.next = node;
            firstNode.prev = node;

        }
        LruCache(int capacity) {
          this.capcity = capacity;
          map = new HashMap<>();
          head = new Nodes(0,0);
          tail = new Nodes(0,0);

          head.next = tail;
          tail.prev = head;
        }
        public int get(int key) {
             if(!map.containsKey(key)){
                 return -1;
             }
             Nodes node =map.get(key);
             remove(node);
             insert(node);
             return node.value;
        }

        public void put(int key, int value) {
             if(map.containsKey(key)) {
                 Nodes oldCode = map.get(key);
                 remove(oldCode);
                 map.remove(key);
             }
             if(map.size() == capcity) {
                 Nodes least = tail.prev;
                 remove(least);
                 map.remove(least.key);
             }
             Nodes newNode = new Nodes(key, value);
             insert(newNode);
             map.put(key, newNode);
        }
    }
}
