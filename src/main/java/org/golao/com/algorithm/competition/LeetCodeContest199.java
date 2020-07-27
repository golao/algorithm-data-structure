package org.golao.com.algorithm.competition;

public class LeetCodeContest199 {
    public String restoreString(String s, int[] indices) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices.length; j++) {
                if (indices[j] == i){
                    str.append(s.charAt(j));
                    break;
                }
            }
        }
        return str.toString();
    }

    public int minFlips(String target) {
        char cur = '0';
        int ans = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == cur){
                continue;
            }
            ans++;
            cur = cur == '0' ? '1' : '0';
        }
        return ans;
    }
}
