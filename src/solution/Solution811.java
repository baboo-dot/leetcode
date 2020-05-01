package solution;

import java.util.*;

class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> timesCnt = new HashMap(5);
        List<String> list = new LinkedList();
        for (String string : cpdomains) {
            int index = 0;
            char[] chs = string.toCharArray();
            for (char ch : chs) {
                if (Character.isDigit(ch)) {
                    index++;
                } else {
                    break;
                }
            }
            String times = new String(chs, 0, index);
            Integer thisTime = Integer.valueOf(times);
            string = new String(chs, index + 1, chs.length - index - 1);
            String[] domains = string.split("\\.");
            StringBuilder prevBuilder = new StringBuilder();
            for (int i = domains.length - 1; i >= 0; i--) {
                StringBuilder domainBuilder = new StringBuilder(domains[i]);
                domainBuilder.append(prevBuilder);
                timesCnt.merge(domainBuilder.toString(), thisTime, Integer::sum);
                prevBuilder = new StringBuilder("." + domainBuilder);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = timesCnt.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            list.add((new StringBuilder(entry.getValue()
                    + " " + entry.getKey())).toString());
        }
        return list;
    }


    public static void main(String[] args) {
        Solution811 solution811 = new Solution811();
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> list = solution811.subdomainVisits(cpdomains);
        int finish = -1;
    }
}
// 作者：baboo-3
//        链接：https://leetcode-cn.com/problems/subdomain-visit-count/solution/811-zi-yu-ming-fang-wen-ji-shu-by-baboo-3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。