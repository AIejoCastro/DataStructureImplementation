package model;

import java.util.LinkedList;

public class HashTable <K, V> {

    private LinkedList<HashNode<K, V>>[] table;
    private int size;
    private int capacity;

    public HashTable(int capacity) {
        this.table = new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public HashTable() {
        this(16);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (HashNode<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new HashNode<>(key, value));
        size++;

        if (size >= capacity * 0.75) {
            rehash();
        }
    }

    public V get(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        }

        for (HashNode<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        }

        for (int i = 0; i < table[index].size(); i++) {
            HashNode<K, V> entry = table[index].get(i);
            if (entry.getKey().equals(key)) {
                table[index].remove(i);
                size--;
                return entry.getValue();
            }
        }

        return null;
    }

    private void rehash() {
        LinkedList<HashNode<K, V>>[] oldTable = table;
        capacity *= 2;
        size = 0;
        table = new LinkedList[capacity];

        for (LinkedList<HashNode<K, V>> bucket : oldTable) {
            if (bucket == null) {
                continue;
            }
            for (HashNode<K, V> entry : bucket) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
