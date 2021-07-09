package org.zero.algorithm;



/**
 * 最长不重复字串
 */
public class MaxSubString {

    public static void main(String[] args) {
        System.out.println(maxSubStringSize("abcabcbb"));
        System.out.println(maxSubStringSize("pwwkew"));
        System.out.println(maxSubStringSize("aaa"));
        System.out.println(maxSubStringSize("ab"));
    }

    static int maxSubStringSize(String word) {
        if(word == null || word.isEmpty()) {
            return 0;
        }
        if(word.length() == 1) {
            return 1;
        }
        int res = 1, tmp = 1;
        for(int j = 1; j < word.length(); j++) {
            int i = j - 1;
            while(i >= 0 && word.charAt(i) != word.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
