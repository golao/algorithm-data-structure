package org.golao.com.algorithm.topic.easy;

import java.util.*;

/**
 *  1. 位运算
 *  2.
 */
public class LeetCodeEasyOthers {
    /**
     * https://leetcode-cn.com/problems/number-of-1-bits/
     * 191. 位1的个数
     * 思路： 对 n 每个二进制位进行 与 操作，结果为0 说明该位是 1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    /**
     * 思路： 1. 将 x, y 的每一位进行对比
     *        2. 要对比每一位，就必需先屏蔽其他位的干扰，将其他位全部变为1 ，需要比较的位 mask 为 0
     *        3. 移动比较位 mask，同时统计不同的数量
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int diff = 0;
        int b = 1;
        int mask = (-1 ^ b);
        for (int i = 0; i < 32; i++) {
            if ((x | mask) != (y | mask)){
                diff++;
            }
            b <<= 1;
            mask = (-1 ^ b);
        }
        return diff;
    }

    /**
     * https://leetcode-cn.com/problems/missing-number/
     * 268. 缺失数字
     * 思路： 方法一： 实现略，已在力扣上进行了提交
     *              1. 设置一个和 nums 同等大小的 flag 数组作为标记
     *              2. 遍历 nums，对出现[0, n-1]的数，标记 flag 下标元素为true
     *              3. 遍历 flag 数组，遇到第一个 false ，返回其下标
     *              4. 如果 flag 全为 true，那么按顺序，是 n 未出现，返回n即可
     *              5. 时间复杂度: O(n)
     *              6. 空间复杂度: O(n)
     *
     *         方法二：为当前实现
     *              1. 使用 nums 数组自身来做标记，省去空间开销
     *              2. 遍历nums 数组，把所有负数改为 n+1
     *              3. 把非负数，全部进行 +1 操作，这样做的目的，是为了把 0 提升为 1,因为 0 没有
     *                 正负之分，不能作为标识
     *              4. 利用数的正负值，来识别序列数的出现，下一轮遍历 nums 时，nums[i] ∈ [1,n]
     *                 的值，nums[nums[i]] = -nums[nums[i]],
     *              5. 最后 遍历 nums，遇到第一个负数，返回其下标，即使缺失的数
     *              6. [0,n-1] 都有时，最后返回 n
     *              7. 时间复杂度: O(n)
     *              8. 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] >= 0 ? nums[i] + 1 : n + 1;
        }
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if (abs > 0 && abs < n + 1){
                nums[abs-1] = - Math.abs(nums[abs-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i;
            }
        }
        return n;
    }

    /**
     * https://leetcode-cn.com/problems/pascals-triangle/
     * 118. 杨辉三角
     * 思路：   1. 观察规律，两边为1 ，下层的数，等于上一层的后一位当前位的和
     *          2. 根据规律，两层循环模拟实现
     *          3. 处理边界情况
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                }else {
                    List<Integer> upper = ans.get(i - 1);
                    row.add(upper.get(j - 1) + upper.get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/valid-parentheses/
     * 20. 有效的括号
     * 思路：  1. 应用栈进行判断，左符号进栈，右符号时，判断栈里的符号是否匹配
     *         2. 循环结束后，判断栈里是否还有元素
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character left = stack.pop();
                if ((c == '}' && left != '{') ||
                        (c == ']' && left != '[') ||
                        (c == ')' && left != '(')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * https://leetcode-cn.com/problems/count-primes/
     * 204. 计数质数
     * 思路:   方法一： 1. 暴力解，根据定义，质数只能是1 乘以它本身
     *                  2. 两层循环，里层循环逐个试着是否能整除 范围： [2, i-1]
     *                  3. 时间复杂度: O(n²)  当 n = 500,000 时，超时
     *                  4. 空间复杂度: O(1)
     *
     *          方法二：1. 在方法一的基础上，进行优化
     *                  2. 里层循环，缩小尝试整除范围，满足 j * j < i 时才继续尝试
     *                     这是一个数学知识，只需枚举到满足这个条件，如前面没有能整除的，
     *                     后续的也没有
     *                  3. i 只尝试奇数，除2外，其他质数都是奇数
     *                  4. 整除时，只尝试已求出来的质数，并且加入 j * j < i 的判断
     *                  5. 时间复杂度: 比较难计算，外层一半的 n ，里层 小于 n
     *                  6. 空间复杂度: O(k)  质数的数量
     *                  7. 虽然是简单类型题，但时间空间优化上，是个好题，力扣上面的题解
     *                     大部分上来都是开辟一个 boolean[n+1] 的数组空间，每获得一个质数
     *                     就把该质数的整数倍下标，标记为非质数，以空间换时间，不过当n 大
     *                     于百万时，这个方式有内存溢出的可能，我的实现，在本地电脑，能够
     *                     支持 n < 6百万,不超时(1s)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int count = 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for(int i = 3; i < n; i += 2){
            boolean flag = false;
            for(int j = 0; j < primes.size(); j ++){
                int p = primes.get(j);
                if(p * p > i){
                    break;
                }
                if(i % p == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                primes.add(i);
            }
        }
        return primes.size();
    }

    /**
     * https://leetcode-cn.com/problems/power-of-three/
     * 326. 3的幂
     * 思路：  1. 注意power 是从1 开始，幂是从 0 开始算起的，这地方 W/A 了一次
     *         2.  越界判断的先后顺序，要注意，先判断是否相等，再判断乘以3是否会溢出
     *              最后进行 power 乘以 3.  如果前面两步调换顺序，就会导致1162261467
     *              这样的边界值判断不到
     *         3. 时间复杂度: O(logN) 底数为3
     *         4. 空间复杂度: O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        int power = 1;
        int max = Integer.MAX_VALUE / 3;
        for(int i = 0; i < n; i++){
            if(power == n){
                return true;
            }
            if(power > n || power > max){
                return false;
            }
            power *= 3;

        }
        return false;
    }

    /**
     *https://leetcode-cn.com/problems/roman-to-integer/
     * 13. 罗马数字转整数
     * 思路：  1. 顺序读取，累加，遇到当前值 cur 比前面值 pre 大的情况
     *            说明遇到了特殊情况，需要减去 pre * 2
     *         2. 时间复杂度: O(n)
     *         3. 空间复杂度: O(1) map 为常数空间
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = map.get(s.charAt(0));
        int pre = sum, cur = 0;
        for(int i = 1; i < s.length(); i++){
            cur = map.get(s.charAt(i));
            if(cur > pre){
                sum = sum + cur - pre * 2;
                pre = cur - pre * 2;
            }else{
                sum += cur;
                pre = cur;
            }
        }
        return sum;
    }
}
