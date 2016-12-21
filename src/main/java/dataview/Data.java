package dataview;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Anand_Rajneesh on 10/26/2016.
 */
public class Data<T extends Comparable<T>> {

    private T[] items;
    private int size;
    private View view;

    private Data(){
        this.view = new View();
    }

    public Data(int size) {
        this();
        if(size<1) throw new IllegalArgumentException("size cannot be less than 1");
        items = (T[]) new Object[size];
        this.size = size;
    }

    public Data(T[] items) {
        this();
        if(items == null) throw new IllegalArgumentException("Null Items array");
        this.items = items;
        this.size = items.length;
    }

    public T get(int index){
        checkBounds(index);
        //view.printWithPointers(items,index);
        return items[index];
    }

    public void exchange(int i, int j){
        checkBounds(i);
        checkBounds(j);
        view.print(items);
        T tmp = items[j];
        items[j] = items[i];
        items[i] = tmp;
        view.printWithPointers(items,i,j);
    }

    private boolean checkBounds(int index){
        if(index>size) throw new ArrayIndexOutOfBoundsException("Index out of bounds "+index+ " actual size "+size);
        else return true;
    }

    public void print(int ... pointers){
        view.printWithPointers(items, pointers);
    }

    public void shuffle(){
        StdRandom.shuffle(items);
    }

    public int length(){
        return size;
    }

}
