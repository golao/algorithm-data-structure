package org.golao.com.algorithm.topic.easy;

import java.util.List;
import java.util.Random;

/**
 * 专题： 对象设计类问题
 */
public class LeetCodeEasyDesign {
    /**
     * https://leetcode-cn.com/problems/shuffle-an-array/
     * 384. 打乱数组
     * 思路： 1. 采用 {@link java.util.Collections#shuffle(List, Random)} 的实现
     *        2. 数组元素顺序进行随机交换，已交换的下标，不再参与后面的交换
     *        3. reset 的操作，不单是返回原数组，还要重置内部的随机数组
     *        4. 时间复杂度: O(n)
     *        5. 空间复杂度: O(n)
     */
    class Shuffle{
        private int[] shuffle;
        private int[] original;
        private Random random;
        public Shuffle(int[] nums) {
            this.original = nums;
            this.shuffle = nums.clone();
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            this.shuffle = original;
            original = original.clone();
            return shuffle;
        }

        /** Returns a random shuffling of the array. */

        public int[] shuffle() {
            for (int i = shuffle.length; i > 1; i--) {
                swap(shuffle, i-1, random.nextInt(i));
            }
            return shuffle;
        }

        private void swap(int[] shuffle, int i, int nextInt) {
            int temp = shuffle[i];
            shuffle[i] = shuffle[nextInt];
            shuffle[nextInt] = temp;
        }

    }
}
