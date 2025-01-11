import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 최대값 우선 순위 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 배열 값을 힙에 추가
        for (int s : score) {
            maxHeap.add(s);
        }

        // m개씩 묶음 계산
        while (maxHeap.size() >= m) {
            int minInBundle = Integer.MAX_VALUE;

            // 묶음 중 최소값 찾기
            for (int i = 0; i < m; i++) {
                minInBundle = Math.min(minInBundle, maxHeap.poll());
            }

            // 묶음 점수 합산
            answer += minInBundle * m;
        }

        return answer;
    }
}