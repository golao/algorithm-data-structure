package org.golao.com.algorithm.competition.virtual;

import java.util.*;

/**
 * virtual contest
 */
public class LeetCodeContest189 {
    /**
     * 1
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]){
                ans++;
            }
        }
        return ans;
    }

    /**
     * 2
     * @param text
     * @return
     */
    public String arrangeWords(String text) {
        String[] split = text.split(" ");
        split[0] = split[0].toLowerCase();
        List<String> list = new ArrayList<>(Arrays.asList(split));
        list.sort((x1,x2) -> x1.length() - x2.length());
        String head = list.get(0);
        char[] chars = head.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        StringBuilder sb = new StringBuilder(new String(chars));
        if (split.length > 1){
            for (int i = 1; i < list.size(); i++) {
                sb.append(" " + list.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * 3
     * @param favoriteCompanies
     * @return
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String,List<Integer>> map = new HashMap<>();
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> strList = favoriteCompanies.get(i);
            Set<String> set = new HashSet<>();
            for (int j = 0; j < strList.size(); j++) {
                List<Integer> indexList = map.get(strList.get(j));
                if (indexList == null){
                    indexList = new ArrayList<>();
                    map.put(strList.get(j), indexList);
                }
                indexList.add(i);

                set.add(strList.get(j));
            }
            list.add(set);
        }
        List<Integer> result = new ArrayList<>();
        outer:
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> compare = new HashSet<>();
            compare.add(i);
            Set<String> companies = list.get(i);
            for (String company : companies) {
                List<Integer> others = map.get(company);
                for (Integer index : others) {
                    if (!compare.contains(index)){
                        boolean sub = list.get(index).containsAll(companies);
                        if (sub){
//                            i++;
                            continue outer;
                        }
                    }
                    compare.add(index);
                }
            }
            result.add(i);
            compare.clear();
        }
        return result;
    }


    /**
     *  以下为力扣上，用户xxx 的评论，借鉴学习
     * @Description: 几何问题
     * 题意：在某个区域内有若干个点，移动r为半径的圆，使得这个圆能覆盖尽量多的点，求出覆盖最多的点的个数
     * 分析：在移动过程中，如果要使得圆尽量能覆盖住更多的点，那么这个圆如果恰好有两个点在圆周上的话，就能把它所能利用的空间最大化了
     * 或者说，两个点是可以固定一个圆的，那么就可以对所有点依次两两枚举，确定所有的圆，分别求出各个圆的圆心，然后再枚举所有的点
     * ，求出被圆包住的点的个数。
     * 最后返回最大值即可
     *
     */
    public class Solution {
        double eps = 1e-8;

        public int numPoints(int[][] points, int r) {

            int n = points.length;
            if (n == 1)
                return 1;
            int ans = 1;
            for (int i = 0; i < n; i++){
                int x1 = points[i][0], y1 = points[i][1];
                for (int j = i + 1; j < n; j++){
                    int x2 = points[j][0], y2 = points[j][1];
                    int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    if (d > r * r * 4) //如果(根号d)>2r也就是超出了直径
                        continue;
                    //(x1,y1)和(x2,y2)的中点坐标
                    double xm = (x1 + x2) / 2.0;
                    double ym = (y1 + y2) / 2.0;
                    double dis = Math.sqrt(d);  //(x1,y1)和(x2,y2)两个点的距离
                    double query = Math.sqrt(r * r - d / 4.0); //勾股定理求出圆心到(x1,y1)和(x2,y2)连线的中点的距离

                    //以(x1,y1)，(x2,y2)构建向量(v1,v2)
                    double v1 = x1 - x2;
                    double v2 = y1 - y2;

                    double xc, yc; //圆心坐标(xc,yc)
                    //根据向量(v1,v2)与圆心到(x1,y1)和(x2,y2)连线中点的连线垂直，得到向量乘积为0
                    //由于可能有对称两个圆心，所以指向两个圆心的向量分别为(-v2,v1)和(v2,-v1)
                    //然后分别根据这两个向量的单位向量*圆心到(x1,y1)和(x2,y2)连线中点的距离query求得圆心坐标(xc,yc)
                    //单位向量也根据垂直乘积为0求得.
                    //(v1/dis,v2/dis)为(v1,v2)的单位向量，那么可以得到两个单位向量分别为(v2/dis,-v1/dis)和(-v2/dis,v1/dis)
                    xc = xm - v2 / dis * query;
                    yc = ym + v1 / dis * query;
                    ans = Math.max(ans, count(points, xc, yc, r));

                    xc = xm + v2 / dis * query;
                    yc = ym - v1 / dis * query;
                    ans = Math.max(ans, count(points, xc, yc, r));
                }
            }
            return ans;
        }

        /**
         * 求出被(xc,yc)为圆心,r为半径的圆覆盖的点的个数
         * @param points
         * @param xc
         * @param yc
         * @param r
         * @return
         */
        public int count(int[][] points, double xc, double yc, int r) {
            int ans = 0;
            for (int[] pt : points) {
                double dx = xc - pt[0];
                double dy = yc - pt[1];
                /**
                 * 由于计算机中采用的是由二进制编码来表示数字，因此浮点数在计算机中的存储并不是精确的，例如在经过大量计算后，
                 * 一个浮点型的数3.14在计算机中就可能存储为3.1400000000001，也有可能存储为3.1399999999999，
                 * 这种情况下会对比较操作带来极大的干扰（因为C/C++中的“==”操作是完全相同才会判定为true）。
                 * 于是需要引入一个极小数eps来对这种误差进行修正。
                 * 如果一个数字a落在了[b-eps, b+eps]的区间中时，就应该判断为a == b成立。那么eps应当取多少呢？
                 * 经验表明，eps取1e-8是一个合适的数字---对于大多数的情况既不会漏判也不会误判，因此可以将eps定义为常量1e-8:
                 * https://zhuanlan.zhihu.com/p/51528623
                 */
                //如果距离<=r
                if (dx * dx + dy * dy <= r * r + eps) { //比较浮点数的关系，需要加上eps
                    ans++;
                }
            }
            return ans;
        }
    }


}
