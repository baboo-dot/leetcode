package solution;

import java.util.*;

/**
 * @program: leetcode
 * @description: 集合操作
 * @author: Yifeng
 * @create: 2020-05-03 14:27
 **/
public class Solution1002 {
    public List<String> commonChars(String[] A) {
        List<Map<Character, Integer>> mapList = new ArrayList(A.length);
        for (String string : A) {
            mapList.add(toMap(string));
        }
        Map<Character, Integer> ansMap = mapList.get(0);
        for (Map<Character, Integer> map : mapList) {
            ansMap =  combineMaps(ansMap, map);
        }
        Set<Map.Entry<Character, Integer>> entrySet = ansMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        List<String> ansList = new LinkedList();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            for (int i = 0; i < entry.getValue(); i++) {
                ansList.add(entry.getKey()+"");
            }
        }
        return ansList;
    }

    private Map<Character, Integer> toMap(String string) {
        Map<Character, Integer> map = new HashMap();
        for (char ch : string.toCharArray()) {
            map.merge(ch,1,Integer::sum);
        }
        return map;
    }

    private Map<Character, Integer> combineMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        Map<Character, Integer> map = new HashMap();

        Set<Map.Entry<Character, Integer>> entrySet = map1.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            for (int i = 0; i < entry.getValue(); i++) {
                if (map2.containsKey(entry.getKey())) {
                    map.put(entry.getKey(), Math.min(entry.getValue(), map2.get(entry.getKey())));
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] strings = {"bella","label","roller"};
        Solution1002 solution1002 = new Solution1002();
        List<String> strings1 = solution1002.commonChars(strings);
        int finish = -1;
    }
}
