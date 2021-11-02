package de.teleportaura.commons.container;

import java.util.*;

public class ArrayMap<K, V> implements Map<K, V>{

    private ArrayList<K> keyList = new ArrayList<>();
    private ArrayList<V> valueList = new ArrayList<>();

    @Override
    public int size() {
        return keyList.size();
    }

    @Override
    public boolean isEmpty() {
        return keyList.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keyList.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return valueList.contains(value);
    }

    public boolean contains(Pair<?, ?> pair){
        int index = keyList.indexOf(pair.getKey());
        if(index>=0) return valueList.get(index).equals(pair.getKey());
        return false;
    }

    @Override
    public V get(Object key){
        return valueList.get(keyList.indexOf(key));
    }

    public Pair<K, V> getEntry(K key){
        return new Pair<>(key, get(key));
    }

    @Override
    public V put(K key, V value) {
        int index = keyList.indexOf(key);
        if(index>=0)
            valueList.set(keyList.indexOf(key), value);
        else
            keyList.add(key);
            valueList.add(value);
        return value;
    }

    public Pair<K, V> putEntry(Pair<K, V> entry){
        put(entry.getKey(), entry.getValue());
        return entry;
    }

    @Override
    public V remove(Object key) {
        int index = keyList.indexOf(key);
        if(index>=0){
            keyList.remove(index);
            return valueList.remove(index);
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(K k:m.keySet()) put(k, m.get(k));
    }

    @Override
    public void clear() {
        keyList.clear();
        valueList.clear();
    }

    @Override
    @Deprecated
    public Set<K> keySet() {
        return new ArrayMapKeySet<K>(this);
    }

    @Override
    @Deprecated
    public Collection<V> values() {
        return valueList;
    }

    @Override
    @Deprecated
    public Set<Entry<K, V>> entrySet() {
        return new ArrayMapEntrySet<>(this);
    }

    static class ArrayMapKeySet<E> implements Set<E>{

        private final ArrayMap<E,?> owner;

        public ArrayMapKeySet(ArrayMap<E, ?> owner){
            this.owner = owner;
        }

        @Override
        public int size() {
            return owner.size();
        }

        @Override
        public boolean isEmpty() {
            return owner.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return owner.containsKey(o);
        }

        @Override
        public Iterator<E> iterator() {
            return owner.keyList.iterator();
        }

        @Override
        public Object[] toArray() {
            return owner.keyList.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return owner.keyList.toArray(a);
        }

        @Override
        public boolean add(E e) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public boolean remove(Object o) {
            return owner.remove(o)!=null;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return owner.keyList.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public void clear() {
            owner.clear();
        }
    }

    static class ArrayMapEntrySet<K, V> implements Set<Entry<K, V>>{

        private final ArrayMap<K, V> owner;

        public ArrayMapEntrySet(ArrayMap<K, V> owner){
            this.owner = owner;
        }

        @Override
        public int size() {
            return owner.size();
        }

        @Override
        public boolean isEmpty() {
            return owner.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return o instanceof Pair&&owner.contains((Pair<?, ?>)o);
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        @Deprecated
        public boolean add(Entry<K, V> entry) {
            owner.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override
        public boolean remove(Object o) {
            if(o instanceof Entry)
                return owner.remove(((Entry<?, ?>)o).getKey())!=null;
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public boolean addAll(Collection<? extends Entry<K, V>> c) {
            for(Entry<K, V> entry:c) add(entry);
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("This doesn't work with maps!");
        }

        @Override
        public void clear() {
            owner.clear();
        }
    }

}
