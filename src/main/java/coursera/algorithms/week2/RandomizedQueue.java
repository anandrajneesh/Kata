package coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anand_Rajneesh on 10/7/2016.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
   /* public RandomizedQueue()                 // construct an empty randomized queue
    public boolean isEmpty()                 // is the queue empty?
    public int size()                        // return the number of items on the queue
    public void enqueue(Item item)           // add the item
    public Item dequeue()                    // remove and return a random item
    public Item sample()                     // return (but do not remove) a random item
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    public static void main(String[] args)   // unit testing*/


    private Object[] data;
    private int DEFAULT_CAPACITY = 10;
    private int size;

    public RandomizedQueue(){
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty(){
        return size < 1;
    }

    public int size(){
        return size;
    }

    public void enqueue(Item t){
        if(t == null){
            throw null;
        }
        if(size == data.length/2){
            //extend capacity
            Object[] tmp = new Object[data.length*2];
            for(int i =0 ; i<size;i++){
                tmp[i] = data[i];
            }
            data = tmp;
        }
        data[size++] = t;
    }

    public Item dequeue(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        int n = StdRandom.uniform(size);
        Object[] tmp = new Object[data.length];
        for(int i =0; i<size; i++){
            if(i >= n){
                tmp[i] = data[i+1];
            }else{
                tmp[i] = data[i];
            }
        }
        Item t = (Item) data[n];
        data[n] = null;
        data = tmp;
        size--;
        return t;

    }
    public Item sample(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        int n = StdRandom.uniform(size);
        return (Item) data[n];
    }

    public Iterator<Item> iterator(){
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item>{

        private Object[] iterateData;
        private int counter;

        public RandomIterator(){
            iterateData = new Object[size];
            for(int i = 0; i< size; i++){
                iterateData[i] = data[i];
            }
            StdRandom.shuffle(iterateData);
        }

        @Override
        public boolean hasNext() {
            return counter < iterateData.length;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (Item) iterateData[counter++];
        }
    }

}
