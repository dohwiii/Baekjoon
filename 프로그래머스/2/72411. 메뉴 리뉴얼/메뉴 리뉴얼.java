import java.util.*;

class Solution {
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int length = course[i]; //코스요리에 해당하는 길이(요리 개수)
            
            for(int j=0; j<orders.length; j++) {
                if(length > orders[j].length()) {
                    continue;
                }
                char[] charArr = orders[j].toCharArray(); // String to Char Array
                Arrays.sort(charArr); // Char Array 알파벳 순 정렬

                combi(length, charArr, 0, new StringBuilder(), map);
            } 
            int maxCount = 2;
            List<String> maxCombinations = new ArrayList<>();
            
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxCombinations.clear();
                    maxCombinations.add(entry.getKey());
                }
                else if(entry.getValue() == maxCount) {
                    maxCombinations.add(entry.getKey());
                }
            }
            result.addAll(maxCombinations);
        }
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    public void combi(int length, char[] menuItems, int start, StringBuilder combination, Map<String, Integer> combinationCount) {
        if(combination.length() == length) {
            //원하는 길이의 문자열 조합 만들어짐
            String combo = combination.toString();
            combinationCount.put(combo, combinationCount.getOrDefault(combo, 0) + 1);
            return;
        }
        for(int i=start; i<menuItems.length; i++) {
            combination.append(menuItems[i]);
            combi(length, menuItems, i + 1, combination, combinationCount);
            combination.deleteCharAt(combination.length() - 1); //마지막 지우기(백트래킹)
        }
        
    }
    public int countSameMenu(String str, String[] orders) {
        int cnt = 0;
        
        for(int i=0; i<orders.length; i++) {
            boolean isPossible = true;
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(!orders[i].contains(Character.toString(c))) {
                    isPossible = false;
                }
            }
            if(isPossible) {
                cnt++;
            }
        }
        return cnt;
    }
}