package org.golao.com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**来自《数据结构与算法分析：c语言版》Weiss
 * 回溯法：
 * 1. 收费公路重建问题
 */
public class BackTracking {
    /**
     *题解：
     * @param dist 点与点之间距离的集合
     * @param n   共有n个点
     * @return 返回合适的点集，如不存在返回null
     */
    public int[] turnpike(List<Integer> dist,int n){
        dist.sort((x1,x2) -> x1-x2 );
        int[] result = new int[n];
        boolean place = false;

        result[0] = 0;
        result[n-1] = dist.remove(dist.size()-1);
        result[n-2] = dist.remove(dist.size()-1);
        Integer d1 = result[n-1] - result[n-2];
        if (dist.remove(d1)){//包含了检查是否存在和移除的两个动作
            place = place(result, dist, 1, n - 3);
        }
        return place ? result : null;
    }
    private boolean place(int[] x ,List<Integer> dist,int left,int right){
        boolean found = false;
        if (dist.isEmpty()){
            return true;
        }
        int max = dist.get(dist.size() -1);
        //尝试 x[right] = max
        boolean checkRight = checkContain(x, left, right, dist, max);
        if (checkRight){
            x[right] = max;
            update(x,dist,left,right,x[right],true);
            found = place(x,dist,left,right-1);
            if (!found) {//需要回溯
                update(x,dist,left,right,max,false);
            }
        }
        //尝试 x[left] = x[n-1] - max
        if (!found && checkContain(x,left,right,dist,x[x.length-1] - max)){
            x[left] = x[x.length - 1] -max;
            update(x,dist,left,right,x[left],true);
            found = place(x,dist,left+1,right);
            if (!found){
                update(x,dist,left,right,x[left],false);
            }
        }
        return found;
    }
    private boolean checkContain(int[] x, int L, int R, List<Integer> dist,int p){
        List<Integer> copy = new ArrayList<>(dist);
        for (int i = 0; i < L; i++) {
            Integer d = Math.abs(p - x[i]);
            if (!copy.remove(d)){
                return false;
            }
        }
        for (int i = R + 1; i < x.length; i++) {
            Integer d = Math.abs(p - x[i]);
            if (!copy.remove(d)){
                return false;
            }
        }
        return true;
    }

    private void update(int[] x, List<Integer> dist, int L, int R, int p, boolean isRemove){
        for (int i = 0; i < L; i++) {
            Integer d = Math.abs(p - x[i]);
            if (isRemove){
                dist.remove(d);
            }else {
                dist.add(d);
            }
        }
        for (int i = R + 1; i < x.length; i++) {
            Integer d = Math.abs(p - x[i]);
            if (isRemove){
                dist.remove(d);
            }else {
                dist.add(d);
            }
        }
        if (!isRemove){
            dist.sort((x1,x2) -> x1 - x2);
        }
    }

}
