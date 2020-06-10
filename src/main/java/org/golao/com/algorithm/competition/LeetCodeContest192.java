package org.golao.com.algorithm.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeContest192 {
    /**
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        if ( nums == null || nums.length == 0){
            return nums;
        }
        int[] ans = new int[nums.length];
        int j = 0, k = n;
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0){
                ans[i] = nums[j++];
            }else {
                ans[i] = nums[n++];
            }
        }
        return ans;
    }

    public int[] getStrongest(int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        Arrays.sort(arr);
        int m = arr[(arr.length -1) / 2];
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            list.add(a);
        }
        list.sort((x1,x2) -> {
         int a1 = Math.abs(x1 - m);
         int a2 = Math.abs(x2 - m);
         if (a1 > a2 || (a1 == a2 && x1 > x2)){
             return 1;
         }else {
             return -1;
         }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        return ans;
    }

    class BrowserHistory {
        private LinkedList<String> back = new LinkedList<>();
        private LinkedList<String> forward = new LinkedList<>();
        private String nowUrl;
        public BrowserHistory(String homepage) {
            this.nowUrl = homepage;
        }

        public void visit(String url) {
            if (!this.nowUrl.equals(url)){
                back.addFirst(this.nowUrl);
                this.nowUrl = url;
            }
            forward.clear();
        }

        public String back(int steps) {
            if (back.isEmpty()){
                return this.nowUrl;
            }
            forward.addFirst(nowUrl);
            while (steps > 1 && back.size() > 1){
                steps--;
                String url = back.removeFirst();
                forward.addFirst(url);
            }
            this.nowUrl = back.removeFirst();
            return this.nowUrl;
        }

        public String forward(int steps) {
            if (forward.isEmpty()){
                return this.nowUrl;
            }
            back.addFirst(this.nowUrl);
            while (steps > 1 && forward.size() > 1){
                steps--;
                String s = forward.removeFirst();
                back.addFirst(s);
            }
            this.nowUrl = forward.removeFirst();
            return this.nowUrl;
        }
    }


    public static void main(String[] args) {
        LeetCodeContest192 leetCodeContest192 = new LeetCodeContest192();
//        int[] ary = {2,5,1,3,4,7};
        int[] ary = {1,1,2,2};
        int[] shuffle = leetCodeContest192.shuffle(ary, 2);
        System.out.println(Arrays.toString(shuffle));

//        int[] ary2 = {1,2,3,4,5};
        int[] ary2 = {1,1,3,5,5};

        int[] strongest = leetCodeContest192.getStrongest(ary2, 2);
        System.out.println(Arrays.toString(strongest));

        BrowserHistory browserHistory = leetCodeContest192.new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"



    }
}
