package ExtraStudy;

import java.util.LinkedList;

public class DesignHashSet {
    private Bucket[] bucketArray; // array of bucket class
    private int keyRange;
    private Bucket buccketNumb;

    /** Initialize your data structure here. */
    public DesignHashSet() { // when declaring DesignHashSet()
        this.keyRange = 769; // set keyRange to 769 as base of modulo
        this.bucketArray = new Bucket[this.keyRange]; // creates Bucket array of size 769. each index will eventually have a Bucket
        for (int i = 0; i < this.keyRange; ++i) // for 0-768
            this.bucketArray[i] = new Bucket(); // we create a new Bucket() for each position
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key); // hashes the number and add its to variable bucketIndex
        this.bucketArray[bucketIndex].insert(key); // finds bucketArray at index bucetIndex and inserts the value key
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}

class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>(); // when bucket is declared, a new linkedlist is created for variable container
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key); // indexOf returns the index of the element in the list within variable container
        // else -1 if the element is not present in the list.
        // the index is then assigned to variable index
        if (index == -1) { // if index == -1 (DNE)
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key); //remove takes in an index,
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1); //true or false whether exists
    }
}