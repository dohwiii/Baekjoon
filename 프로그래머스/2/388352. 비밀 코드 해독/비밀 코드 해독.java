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
        Set<Integer> codeSet = new HashSet<>();
        for (int num : arr) codeSet.add(num);  // 현재 비밀 코드 후보를 Set에 저장

        for (int k = 0; k < q.length; k++) {
            int matchCount = 0;
            for (int num : q[k]) {
                if (codeSet.contains(num)) matchCount++;  // 빠른 검색 O(1)
            }
            if (matchCount != ans[k]) {
                return false;
            }
        }
        return true;
    }
}
