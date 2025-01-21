import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] progress = new int[N + 2]; // 각 스테이지에 머물러 있는 플레이어 수 저장
        for (int stage : stages) {
            progress[stage]++;
        }

        int players = stages.length; // 전체 플레이어 수
        double[] failureRates = new double[N]; // 각 스테이지의 실패율 저장
        for (int i = 1; i <= N; i++) {
            if (players > 0) {
                failureRates[i - 1] = (double) progress[i] / players;
                players -= progress[i];
            } else {
                failureRates[i - 1] = 0.0; // 플레이어가 없는 경우 실패율 0
            }
        }

        // 스테이지 번호와 실패율을 쌍으로 묶어 정렬
        Integer[] stageOrder = new Integer[N];
        for (int i = 0; i < N; i++) {
            stageOrder[i] = i + 1; // 스테이지 번호 저장
        }

        Arrays.sort(stageOrder, (a, b) -> {
            if (failureRates[b - 1] != failureRates[a - 1]) {
                return Double.compare(failureRates[b - 1], failureRates[a - 1]);
            }
            return a - b; // 실패율이 같다면 스테이지 번호가 작은 순서대로
        });

        // 결과 배열 생성
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageOrder[i];
        }

        return answer;
    }
}
