package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @who luhaoming
 * @when 2022/5/29 1:02
 * @what lengthOfLongestSubstring
 */
public class Q3LengthOfLongestSubstring {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 10^4
     * s 由英文字母、数字、符号和空格组成
     */
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "au";
        String s5 = "abba";
//        System.out.println((lengthOfLongestSubstring(s1)));
//        System.out.println((lengthOfLongestSubstring(s2)));
//        System.out.println((lengthOfLongestSubstring(s3)));
        System.out.println((lengthOfLongestSubstring1(s5)));
        System.out.println((lengthOfLongestSubstring2(s5)));
    }


    public static int lengthOfLongestSubstring(String s) {
        // 转成字符数组
        char[] charArray = s.toCharArray();
        if (s.length() == 0) return 0;
        int start = 0, max = 1;
        boolean flag;
        for (int i = start + 1; ; ) {
            // 字符串最后一位
            if (i == charArray.length) {
                max = Math.max(max, (i - start));
                break;
            }
            flag = true;
            /**
             * 从start开始，到当前字符下标为止（不包含当前字符），和当前字符比较比较，
             * 如果等于则滑动当前start到重复字符下标 + 1 的地方，跳出该次循环
             * 如果不等于跳过
             **/
            for (int end = start; end < i; end++) {
                if (charArray[end] == charArray[i]) {
                    max = Math.max(max, (i - start));
                    start = end + 1;
                    i = start + 1;
                    flag = false;
                    break;
                }
            }

            if (flag) i++;
        }
        return max;
    }


    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        for (; end < s.length(); end++) {
            char current = s.charAt(end);
            if (map.containsKey(current)) {
                // w包含当前字符，移动滑动窗口开始下标start
                start = Math.max(start, map.get(current) + 1);
            }
            map.put(current, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
