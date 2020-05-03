package solution;

import java.util.List;

class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        String LongestWord = "";
        for (String str : d) {
            if (str.length() > LongestWord.length() || str.length() == LongestWord.length() && str.compareTo(LongestWord) < 0) {
                if (isSubsequence(str, s)) {
                    LongestWord = str;
                }
            }
        }
        return LongestWord;
    }

    private boolean isSubsequence(String str, String s){
        int strIndex = 0;
        for (int sIndex = 0; sIndex < s.length() && strIndex < str.length(); sIndex++) {
            if (s.charAt(sIndex) == str.charAt(strIndex)) {
                strIndex++;
            }
        }
        return strIndex == str.length();
    }
}