package org.golao.com.algorithm.competition.virtual;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeContest188 {
    /**
     * 1
     * 思路：
     *     快慢指针
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        String push = "Push", pop = "Pop";
        List<String> ans = new ArrayList<>();
        int list = 0;
        for (int i = 0; i < target.length; i++) {
            ans.add(push);
            list++;
            while (list < target[i]){
                ans.add(pop);
                ans.add(push);
                list++;
            }
        }
        return ans;
    }

    /**
     * 2
     * 编号： 1442
     * 思路： 模拟法，三个指针去尝试组合方案，进行结果统计
     *        看了题解，关键是  a ^ b = 0  可以推导出  a = b，反过来也成立
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        if (arr.length < 2){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == 0){
                    ans = ans + j - i;
                }
            }
        }
        return ans;
    }

}
