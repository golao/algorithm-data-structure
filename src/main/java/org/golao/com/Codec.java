package org.golao.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by golao on 2019/11/12.
 * leetcode
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 * 用一个全局唯一的数字，转换成62进制数值，这个数值对应longurl存储在map
 * 中，解码时从map中提取
 */
public class Codec {
    private  String chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private int count = 1;
    private Map<String,String> maps = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        int number = count;

        while (number > 0 ){
            number--;
            sb.append(chars.charAt(number % 62));
            number /= 62;
        }
        count++;
        String key = sb.reverse().toString();
        maps.put(key,longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return maps.get(shortUrl.replace("http://tinyurl.com/",""));
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        String encodeStr = codec.encode("hello/world/abc");
        System.out.println(encodeStr);
        System.out.println(codec.decode(encodeStr));
    }
}
