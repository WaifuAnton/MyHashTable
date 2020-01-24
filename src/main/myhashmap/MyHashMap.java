package myhashmap;

public class MyHashMap {
    private static final double LOAD_FACTOR = 0.7;
    private static final int INITIAL_CAPACITY = 20;

    private Integer[] keys;
    private Long[] values;

    private int capacity;
    private int size;
    private double loadFactor;

    public MyHashMap() {
        keys = new Integer[INITIAL_CAPACITY];
        values = new Long[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        loadFactor = LOAD_FACTOR;
        size = 0;
    }

    public MyHashMap(int initialCapacity) {
        keys = new Integer[initialCapacity];
        values = new Long[initialCapacity];
        capacity = initialCapacity;
        loadFactor = LOAD_FACTOR;
        size = 0;
    }

    public MyHashMap(double loadFactor) {
        keys = new Integer[INITIAL_CAPACITY];
        values = new Long[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        this.loadFactor = loadFactor;
    }

    public MyHashMap(int initialCapacity, double loadFactor) {
        keys = new Integer[initialCapacity];
        values = new Long[initialCapacity];
        capacity = initialCapacity;
        size = 0;
        this.loadFactor = loadFactor;
    }

    public long put(int key, long value) {
        if ((double) size / capacity > loadFactor)
            expandCapacity();
        int hash = key % capacity;
        if (keys[hash] == null)
            keys[hash] = key;
        else if (keys[hash] == key)
            values[hash] = value;
        else {
            int i;
            for (i = hash + 1; i < capacity; i++)
                if (keys[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
//            if (i == capacity)
//                for (i = 0; i < hash; i++)
//                    if
        }
        return value;
    }

    private void expandCapacity() {
        int newCapacity = (int) (capacity + capacity / loadFactor);
        capacity = newCapacity;
        Long[] tempV = values;
        values = new Long[newCapacity];
        Integer[] tempK = keys;
        keys = new Integer[newCapacity];
    }
}
