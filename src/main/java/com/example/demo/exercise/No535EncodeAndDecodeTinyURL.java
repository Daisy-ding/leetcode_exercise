package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/4 10:19 下午
 */
public class No535EncodeAndDecodeTinyURL {
    public class Codec {
        private Map<String, String> urlMap = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String alphabeticDigits = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            char[] result = new char[6];
            Random random = new Random();
            for (int i = 0; i < 6; ++i) {
                result[i] = alphabeticDigits.charAt(random.nextInt(alphabeticDigits.length()));
            }

            String shortUrl = "http://tinyurl.com/" + new String(result);
            urlMap.put(shortUrl, longUrl);
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return urlMap.getOrDefault(shortUrl, "");
        }
    }
}
