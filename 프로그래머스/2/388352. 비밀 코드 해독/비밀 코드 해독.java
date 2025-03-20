import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        int[] arr = new int[5];
        combi(0, 1, n, arr, q, ans);
        return answer;
    }

    public void combi(int depth, int start, int n, int[] arr, int[][] q, int[] ans) {
        if (depth == 5) {
            if (checkMatch(arr, q, ans)) {  
                answer++;
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            combi(depth + 1, i + 1, n, arr, q, ans);
        }
    }

    public boolean checkMatch(int[] arr, int[][] q, int[] ans) {
        for (int k = 0; k < q.length; k++) {
            int matchCount = 0;
            
            // 🚀 기존 방식 (이중 루프) 유지
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (q[k][i] == arr[j]) {
                        matchCount++;
                        break;  // 🚀 조기 종료 (이미 매치되었으면 더 확인할 필요 없음)
                    }
                }
            }

            if (matchCount != ans[k]) {
                return false;  // 🚀 조기 종료 (불필요한 비교 방지)
            }
        }
        return true;
    }
}
