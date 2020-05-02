package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet();
        int index = 0;
        int res = 0;
        for (char ch : chars) {
            // 如果set添加失败了，里面有重复元素
            // 从字符串起始位置index开始remove到原有重复元素
            if (!set.add(ch)) {
                res = Math.max(res, set.size());
                while (chars[index] != ch) {
                    set.remove((Character) chars[index++]);
                }
                //remove完index就是下一个无重复子字符串起始位置
                index++;
            }
        }
        return Math.max(res, set.size());
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String string = "aabaab!bb";
        int res = solution2.lengthOfLongestSubstring(string);
        int finish = -1;
    }
}
