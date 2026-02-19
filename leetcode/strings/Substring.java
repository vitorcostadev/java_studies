package leetcode.strings;

import java.util.LinkedList;
import java.util.List;

public class Substring {
    public static void main(String[] args) {
        List<String> s = List.of("pwwkew", "bbbbb", "abcabcbb");
        for(String x : s){
            System.out.println(x+": "+lengthOfLongestSubstring(x));
        }
    }

    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.isEmpty()) return 0;
        LinkedList<Character> subStr = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            if(subStr.contains(charAt)){
                while(subStr.contains(charAt)) subStr.removeFirst();
            }
            subStr.add(charAt);
            max = Math.max(max, subStr.size());
        }
        return max;
    }
}
