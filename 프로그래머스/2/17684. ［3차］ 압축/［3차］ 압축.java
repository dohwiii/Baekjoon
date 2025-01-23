import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> alp = new HashMap<>();

        // 기존 알파벳 사전 추가
        for (int i = 0; i < 26; i++) {
            alp.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int order = 27; // 새로운 단어의 번호
        int start = 0;  // 현재 단어의 시작 인덱스

        while (start < msg.length()) {
            int end = start + 1; // 현재 단어의 끝 인덱스

            // 사전에 존재하지 않는 단어를 찾을 때까지 확장
            while (end <= msg.length() && alp.containsKey(msg.substring(start, end))) {
                end++;
            }

            // 마지막으로 발견된 단어의 번호를 추가
            list.add(alp.get(msg.substring(start, end - 1)));

            // 새로운 단어를 사전에 추가
            if (end <= msg.length()) {
                alp.put(msg.substring(start, end), order++);
            }

            // 다음 단어로 이동
            start = end - 1;
        }

        // 결과를 배열로 변환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
