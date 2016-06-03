package data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class MyHashSet<E> implements Set<E> {

    public static final int DEFAULT_TABLE_SIZE = 16;
    private Node[] table;
    private int size;

    public MyHashSet() {
        table = (Node[]) new Object[DEFAULT_TABLE_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        int position = getHash(o);

        if(table[position] == null){
            return false;
        }else{
            Node iter = table[position];

            while(iter != null){
                if(iter.el.equals(o)){
                    return true;
                }
                iter = iter.next;
            }
        }
        return false;
    }

    private int getHash(Object o) {
        int hash = Math.abs(o.hashCode());
        return hash % table.length;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        int hash = Math.abs(e.hashCode());
        int position = hash % table.length;

        if(table[position] == null){
            table[position] = new Node(e, null);

        }else{
            Node iter = table[position];
            Node last = iter;

            while(iter != null){
                if(iter.el.equals(e)){
                    return false;
                }
                last = iter;
                iter = iter.next;
            }
            last.next = new Node(e, null);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    private class Node {
        E el;
        Node next;

        private Node(E el, Node next) {
            this.el = el;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E>{
        private int position = 0;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
