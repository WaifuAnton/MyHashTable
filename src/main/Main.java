import myhashmap.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap(1);
        myHashMap.put(2, 489L);
        myHashMap.put(2, 56L);
        System.out.println(myHashMap.get(2));
    }
}
