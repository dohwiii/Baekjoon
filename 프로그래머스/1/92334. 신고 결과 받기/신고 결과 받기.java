import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        // ID를 인덱스로 매핑
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // 신고 기록 처리 (중복 제거)
        boolean[][] reports = new boolean[n][n];
        for (String r : report) {
            String[] parts = r.split(" ");
            int reporter = idIndexMap.get(parts[0]);
            int reported = idIndexMap.get(parts[1]);
            reports[reporter][reported] = true;
        }

        // 신고 횟수 집계
        int[] reportCount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (reports[j][i]) {
                    reportCount[i]++;
                }
            }
        }

        // 결과 메일 계산
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (reportCount[i] >= k) {
                for (int j = 0; j < n; j++) {
                    if (reports[j][i]) {
                        answer[j]++;
                    }
                }
            }
        }

        return answer;
    }
}