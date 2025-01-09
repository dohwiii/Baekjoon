import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (lastIndexMap.containsKey(c)) {
                answer[i] = i - lastIndexMap.get(c);
            } else {
                answer[i] = -1;
            }

            lastIndexMap.put(c, i); // 현재 문자의 인덱스를 업데이트
        }

        return answer;
    }
}
