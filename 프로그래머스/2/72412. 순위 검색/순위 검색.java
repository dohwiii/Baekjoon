import java.util.*;

class Solution {
    Map<String, List<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 지원자 정보를 가능한 모든 조건 조합으로 infoMap에 저장
        for (String i : info) {
            String[] arr = i.split(" ");
            int score = Integer.parseInt(arr[4]);
            buildCombinations(arr, "", 0, score);
        }

        // 각 조건별로 점수 리스트를 정렬
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }

        // 쿼리 처리
        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and ", "").split(" ");
            String key = q[0];
            int targetScore = Integer.parseInt(q[1]);

            // 해당 key가 있는 경우 이진 탐색을 통해 점수 조건 만족하는 지원자 수 찾기
            if (infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                int idx = lowerBound(scores, targetScore);
                answer[i] = scores.size() - idx;
            }
        }

        return answer;
    }

    // 가능한 모든 조건 조합을 만드는 함수
    private void buildCombinations(String[] arr, String str, int depth, int score) {
        if (depth == 4) {
            infoMap.computeIfAbsent(str, s -> new ArrayList<>()).add(score);
            return;
        }
        buildCombinations(arr, str + "-", depth + 1, score);
        buildCombinations(arr, str + arr[depth], depth + 1, score);
    }

    // 이진 탐색으로 조건을 만족하는 첫 인덱스 찾기
    private int lowerBound(List<Integer> scores, int targetScore) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < targetScore) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
