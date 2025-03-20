import java.util.*;

class Solution {
    static List<int[]> arrList;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        arrList = new ArrayList<>();
        int[] arr = new int[5];
        combi(0, 1, n, arr, q, ans);
        return answer;
    }
    public void combi(int depth, int start, int n, int[] arr, int[][] q, int[] ans) {
        if(depth == 5) {
            if(checkMatch(arr, q, ans)) {    //정답
                answer++;
            }
            return;
        }
        for(int i=start; i<=n; i++) {
            arr[depth] = i;
            combi(depth+1, i+1, n, arr, q, ans);
        }
    }
    public boolean checkMatch(int[] arr, int[][] q, int[] ans) {  //주어진 q배열과 비교
        for(int k=0; k<q.length; k++) {
            int[] qr = q[k];
            int cnt = 0;
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if(qr[i] == arr[j]) {
                        cnt++;
                    }
                }
            }
            if(cnt != ans[k]) {
                return false;
            }
        }
        return true;
    }
}