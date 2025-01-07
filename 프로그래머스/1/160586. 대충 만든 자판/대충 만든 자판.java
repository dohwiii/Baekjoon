import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> alpMap = new HashMap<>();

        // 최소 키 입력 횟수 저장
        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                alpMap.put(c, Math.min(alpMap.getOrDefault(c, j + 1), j + 1));
            }
        }

        // 각 target에 대한 최소 입력 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            for (char c : target.toCharArray()) {
                if (!alpMap.containsKey(c)) {
                    total = -1;
                    break;
                }
                total += alpMap.get(c);
            }
            answer[i] = total;
        }

        return answer;
    }
}