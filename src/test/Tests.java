import myhashmap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private static MyHashMap myHashMap;

    @Before
    public void init() {
        myHashMap = new MyHashMap(1);
    }

    @Test
    public void addOne() {
        myHashMap.put(5, 1L);
        assertEquals(1L, myHashMap.get(5).longValue());
    }

    @Test
    public void addTwo() {
        myHashMap.put(2, 489L);
        myHashMap.put(2, 56L);
        myHashMap.put(12, 73L);
        assertEquals(73L, myHashMap.get(12).longValue());
    }

    @Test
    public void addOneHundred() {
        for (int i = 0; i < 100; i++) {
            long l = i + 100000L;
            myHashMap.put(i, l);
        }
        assertEquals(100000L, myHashMap.get(0).longValue());
    }
}
