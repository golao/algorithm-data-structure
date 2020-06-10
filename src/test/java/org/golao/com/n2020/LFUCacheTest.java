package org.golao.com.n2020;

import org.golao.com.algorithm.LFUCache_O1;
import org.junit.Test;

/**
 * Created by golao on 2020/5/4.
 */
public class LFUCacheTest {
    private LFUCache_O1.LFUCache lfuCache_o1 = new LFUCache_O1().new LFUCache(2);

    /**
     * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
     [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
     */
    @Test
    public void test(){
        lfuCache_o1.put(1,1);
        lfuCache_o1.put(2,2);
        lfuCache_o1.get(1);
        lfuCache_o1.put(3,3);
        lfuCache_o1.get(2);
        lfuCache_o1.get(3);
        lfuCache_o1.put(4,4);
        lfuCache_o1.get(1);
        lfuCache_o1.get(3);
        lfuCache_o1.get(4);


    }
}
