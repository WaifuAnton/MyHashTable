package myhashmap;

public class MyHashMap {
    private static final double LOAD_FACTOR = 0.75;
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

    public Long put(Integer key, Long value) {
        if ((double) size++ / capacity > loadFactor)
            expandCapacity();
        int hash = key % capacity;
        if (keys[hash] == null) {
            values[hash] = value;
            keys[hash] = key;
            return value;
        }
        if (keys[hash].equals(key)) {
            values[hash] = value;
            return value;
        }
        for (int i = hash + 1; i < capacity; i++)
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                return value;
            }
        for (int i = 0; i < hash; i++)
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
            }
        return value;
    }

    public Long get(Integer key) {
        int hash = key % capacity;
        for (int i = hash; i < capacity; i++)
            if (keys[i].equals(key))
                return values[i];
        for (int i = 0; i < hash; i++)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public int size() {
        return size;
    }

    public Integer[] getKeys() {
        Integer[] keys = new Integer[size];
        for (int i = 0, j = 0; i < this.keys.length; i++) {
            if (this.keys[i] == null)
                continue;
            keys[j++] = this.keys[i];
        }
        return keys;
    }

    public Long[] getValues() {
        Long[] values = new Long[size];
        for (int i = 0, j = 0; i < this.values.length; i++) {
            if (this.values[i] == null)
                continue;
            values[j++] = this.values[i];
        }
        return values;
    }

    private void expandCapacity() {
        int newCapacity = (int) (capacity + capacity / loadFactor);
        capacity = newCapacity;
        Integer[] tempK = keys;
        keys = new Integer[newCapacity];
        Long[] tempV = values;
        values = new Long[newCapacity];
        for (int i = 0; i < tempK.length; i++)
            if (tempK[i] != null)
                put(tempK[i], tempV[i]);
    }

    @Override
    public String toString() {
        Long[] values = getValues();
        Integer[] keys = getKeys();
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < values.length; i++)
            stringBuilder.append(keys[i] + "=" + values[i] + ", ");
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
