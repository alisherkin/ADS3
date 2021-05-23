package hashTable;

import java.util.ArrayList;

public class MyHT<K,V> {

    ArrayList<HashNode<K, V> > arr = new ArrayList<>();
    int capacity = 11;
    int size;

    public MyHT(){
        //as a default fill our array with empty buckets up to
        //our fixed size number
        for(int i = 0; i < capacity; i++){
            arr.add(null);
        }
    }
    //modular hashing method
    private int hash(K key){
//        return (key.hashCode() & 0x7fffffff % capacity);
        return Math.abs(key.hashCode() % capacity);
    }
    //get value function
    public void get(K key){
        int position = hash(key);
        HashNode<K, V> head = arr.get(position);
        while(head != null) {
            if(head.key.equals(key)) {
                System.out.println("----------------");
                System.out.println(key + " value: " + head.value);
                return;
            }
            head = head.next;
        }
        System.out.println("-------------");
        System.out.println("no such data");
        return;
    }
    //delete key-value from bucket
    public void remove(K key) {
        int position = hash(key);//find index by hashing key
        HashNode<K, V> head = arr.get(position);
        //for occasion when empty
        if(head == null) {
            System.out.println("---------------------");
            System.out.println("is empty");
//            return null;
        }
        //if first one needed
        if(head.key.equals(key)) {
            V value = head.value;
            head = head.next;
            arr.set(position, head);
            size = size - 1;//decrement size after delete
            System.out.println("---------------------");
            System.out.println("you removed: key " + key + "and value " + value);
        } else {
            //otherwise search in a whole array
            HashNode<K, V> prev = null;
            while(head != null) {
                if(head.key.equals(key)) {
                    prev.next = head.next;
                    size--;
                    System.out.println("---------------------");
                    System.out.println("you removed: key " + key + " and value " + head.value);
                    return;
                }
                //go to the next one if not found
                prev = head;
                head = head.next;
            }
            System.out.println("----------------------");
            System.out.println("no such data");
        }
    }
    public void put(K key,V value) {
        int index = hash(key);
        System.out.println(key + " index: " + index);
        HashNode<K, V> head = arr.get(index);
        HashNode<K, V> putItem = new HashNode<>();
        putItem.key = key;
        putItem.value = value;
        //if empty
        if(head == null) {
            arr.set(index, putItem);
            size++;

        } else {
            //if we already have that key
            while(head!=null) {
                if(head.key.equals(key)) {
                    head.value=value;
                    size++;
                    break;
                }
                head = head.next;
            }
            if(head == null) {
                head=arr.get(index);
                putItem.next=head;
                arr.set(index, putItem);
                size++;
            }
        }
        //if we get of the limit of 75% of capacity
        //so we increase it to double times
        if((1.0 * size) / capacity > 0.75) {
            ArrayList<HashNode<K, V>>tmp=arr;
            arr = new ArrayList<>();
            capacity = 2 * capacity;
            //do same as in default but starting from that position
            for(int i = 0; i < capacity; i++) {
                arr.add(null);
            }
            for(HashNode<K, V> headNode : tmp) {
                while(headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }

        }

    }

    //method to return the size of current hash table
    public void hashSize(){
        System.out.println("----------------------");
        System.out.println("The size of hash table: " + size);
    }

    //method to check for emptiness of hash table
    public void isEmpty(){
        if (size == 0) {
            System.out.println("-----------------------");
            System.out.println("hashtable is empty");
        }
        else {
            System.out.println("-----------------------");
            System.out.println("hashtable is NOT empty");
        }

    }

}
