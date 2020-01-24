package myhashmap;

public class MyHashMap {
    private static final double LOAD_FACTOR = 0.7;
    private static final int INITIAL_CAPACITY = 20;

    private int[] keys;
    private long[] values;

    private int capacity;
    private int size;
    private double loadFactor;

    private int key;
    private long value;

    public MyHashMap() {
        keys = new int[INITIAL_CAPACITY];
        values = new long[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
    }

    public MyHashMap(int initialCapacity) {
        keys = new int[initialCapacity];
        values = new long[initialCapacity];
        capacity = initialCapacity;
        size = 0;
    }

    public MyHashMap(double loadFactor) {
        keys = new int[INITIAL_CAPACITY];
        values = new long[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        this.loadFactor = loadFactor;
    }

    public MyHashMap(int initialCapacity, double loadFactor) {
        keys = new int[initialCapacity];
        values = new long[initialCapacity];
        capacity = initialCapacity;
        size = 0;
        this.loadFactor = loadFactor;
    }
}
