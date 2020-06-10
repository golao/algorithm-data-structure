package org.golao.com;

/**
 * 查找
 * Created by golao on 2018/4/18.
 */
public class Search {
    static class BiTNode{
        int data;
        BiTNode lChild;
        BiTNode rChild;
    }
    public BiTNode searchBST(BiTNode biTNode, int target){
        if (biTNode == null){
            return null;
        }
        if (biTNode.data == target){
            return biTNode;
        }else if(biTNode.data > target){
            return searchBST(biTNode.lChild,target);
        }else {
            return searchBST(biTNode.rChild,target);
        }
    }

    public BiTNode insertBST(BiTNode biTNode,int value){
        if (biTNode == null){
            biTNode = new BiTNode();
            biTNode.data = value;
            return biTNode;
        }
        if (searchBST(biTNode,value) != null){
            return biTNode;
        }
        BiTNode node = new BiTNode();
        node.data = value;
        //TODO


        return biTNode;
    }
    public void deleteBST(BiTNode biTNode,int value){

    }

    /**
     * 折半查找法
     * @param ary
     * @param target
     * @return
     */
    public int binarySearch(int[] ary,int target){
        int low = 0,high = ary.length-1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (target < ary[mid]){
                high = mid - 1;
            }else if (target > ary[mid]){
                low = mid +1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 练习一次
     * @param ary
     * @param key
     * @return
     */
    public int bSearch(int[] ary ,int key){

        int low = 0,high = ary.length;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (key > ary[mid]) {
                low = mid + 1;
            }else if (key < ary[mid]){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int insertValueSearch(int[] ary,int key){
        int low = 0,high = ary.length;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low) * (key - ary[low])/(ary[high] - ary[low]);
            if (ary[mid] == key){
                return mid;
            }else if (ary[mid] > key){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 斐波那契查找：二分查找的改进，本质上利用黄金分割切分中间点
     * @param ary
     * @param key
     * @return
     */
    public int fibonacciSearch(int[] ary,int key){
        int[] fibonacci = generateFibonacciArray();
        return -1;
    }

    /**
     * 生产一个fibonacci 数组
     * @return
     */

    private static int[] generateFibonacciArray(){
        int[] fibonacci = new int[20];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < 20; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci;
    }




}
