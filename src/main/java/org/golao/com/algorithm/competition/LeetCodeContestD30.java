package org.golao.com.algorithm.competition;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeContestD30 {
    public String reformatDate(String date) {
        String[] days = new String[32];
        days[1] = "1st";
        days[2] = "2nd";
        days[3] = "3rd";
        for (int i = 4; i < days.length - 1; i++) {
            days[i] = i + "th";
        }
        days[11] = "11st";
        days[12] = "12nd";
        days[13] = "13rd";
        days[21] = "21st";
        days[22] = "22nd";
        days[23] = "23rd";
        days[31] = "31st";
        String[] month = {null,"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < days.length; i++) {
            String key = i + "";
            if (i < 10){
                key = "0" + i;
            }
            map.put(days[i], key);
        }
        for (int i = 1; i < month.length; i++) {
            String key = i + "";
            if (i < 10){
                key = "0" + i;
            }
            map.put(month[i], key);
        }
        String[] split = date.split(" ");
        return split[2] + "-" + map.get(split[1]) + "-" + map.get(split[0]);
    }


    /**
     *
     * @param n
     * @return
     */
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
