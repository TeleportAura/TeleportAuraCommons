package de.teleportaura.commons.container;

import java.util.Map;

public class Pair<K, V> implements Cloneable, Map.Entry<K, V> {

    private K k;
    private V v;

    @Deprecated
    public Pair(){}

    public Pair(K key, V value){
        this();
        this.k = key;
        this.v = value;
    }

    public void setKey(K key){
        this.k = key;
    }

    public V setValue(V value){
        this.v = value;
        return value;
    }

    public K getKey(){
        return this.k;
    }

    public V getValue(){
        return this.v;
    }

    public String toString(){
        return "[" + k.toString() + ","  + v.toString() + "]";
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pair<K, V> clone() {
        try {
            return (Pair<K, V>)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
