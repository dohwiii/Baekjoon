import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, int[]> map = new HashMap<>();
        
        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 다중집합 생성
        for (int i = 0; i < str1.length() - 1; i++) {
            char front = str1.charAt(i);
            char back = str1.charAt(i + 1);
            if (Character.isLetter(front) && Character.isLetter(back)) {
                String str = "" + front + back;
                map.putIfAbsent(str, new int[2]);
                map.get(str)[0]++;
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char front = str2.charAt(i);
            char back = str2.charAt(i + 1);
            if (Character.isLetter(front) && Character.isLetter(back)) {
                String str = "" + front + back;
                map.putIfAbsent(str, new int[2]);
                map.get(str)[1]++;
            }
        }

        // 교집합과 합집합 계산
        double intersection = 0;
        double union = 0;
        for (int[] counts : map.values()) {
            intersection += Math.min(counts[0], counts[1]);
            union += Math.max(counts[0], counts[1]);
        }

        // 공집합 처리
        if (union == 0) {
            return 65536;
        }

        // 유사도 계산
        double similar = intersection / union;
        return (int) (similar * 65536);
    }
}
