import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 우박수열 계산과 동시에 면적을 저장할 배열 선언
        List<Double> areas = new ArrayList<>();
        List<Integer> collatz = new ArrayList<>();

        // 첫 번째 값을 리스트에 추가
        collatz.add(k);

        // 우박수열 계산과 면적 계산 동시에 수행
        while (k != 1) {
            int next;
            if (k % 2 == 0) {
                next = k / 2;
            } else {
                next = k * 3 + 1;
            }

            // 현재 구간의 면적 계산 (트래페조이드)
            areas.add((k + next) / 2.0);
            collatz.add(next);
            k = next;
        }

        // 우박수열의 길이 저장
        int n = areas.size();

        // 결과 배열 선언
        double[] answer = new double[ranges.length];

        // 주어진 구간들에 대한 계산 수행
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1]; // 끝점은 우박수열의 길이에 상대적으로 계산
            
            // 시작점이 끝점보다 크다면 유효하지 않은 구간
            if (start > end) {
                answer[i] = -1.0;
            } else {
                // 주어진 구간에 대한 정적분 결과 계산
                double sum = 0.0;
                for (int j = start; j < end; j++) {
                    sum += areas.get(j);
                }
                answer[i] = sum;
            }
        }

        return answer;
    }
}
