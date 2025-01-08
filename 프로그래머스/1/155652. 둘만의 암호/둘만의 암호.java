import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        // Skip 문자열을 Set으로 변환하여 검색 속도를 최적화
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        // 결과 문자열을 저장할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 문자열 변환
        for (char c : s.toCharArray()) {
            result.append(shiftChar(c, index, skipSet));
        }

        return result.toString();
    }

    // 특정 문자를 index만큼 이동, skipSet에 포함된 문자 건너뛰기
    private char shiftChar(char start, int index, Set<Character> skipSet) {
        int count = 0; // 유효한 이동 횟수
        char current = start;

        while (count < index) {
            current++; // 다음 문자로 이동
            if (current > 'z') {
                current = 'a'; // 'z'를 넘어가면 'a'로 순환
            }
            if (!skipSet.contains(current)) {
                count++; // 유효한 이동
            }
        }

        return current;
    }
}