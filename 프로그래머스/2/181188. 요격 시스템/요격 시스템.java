import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int end = -1;

        for (int[] target : targets) {
            int start = target[0];

            if (start >= end) {
                answer++;
                end = target[1];
            }
        }

        return answer;
    }
}