import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 결과 배열 초기화
        int[] answer = new int[id_list.length];

        // 중복 제거된 신고 기록
        Set<String> distinctReports = new HashSet<>(Arrays.asList(report));

        // 유저별 신고 당한 횟수와 신고자 리스트를 저장할 Map
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, List<String>> reporters = new HashMap<>();

        // 초기화
        for (String id : id_list) {
            reportCount.put(id, 0);
            reporters.put(id, new ArrayList<>());
        }

        // 신고 정보 처리
        for (String r : distinctReports) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            // 신고 횟수 증가 및 신고자 기록
            reportCount.put(reported, reportCount.get(reported) + 1);
            reporters.get(reported).add(reporter);
        }

        // 정지된 유저 처리
        for (String reported : id_list) {
            if (reportCount.get(reported) >= k) {
                for (String reporter : reporters.get(reported)) {
                    answer[Arrays.asList(id_list).indexOf(reporter)]++;
                }
            }
        }

        return answer;
    }
}