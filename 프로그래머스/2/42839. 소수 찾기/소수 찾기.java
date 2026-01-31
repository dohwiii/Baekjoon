import java.util.*;

class Solution {
    static int cnt;
    static boolean[] numVisited = new boolean[10_000_000];
    
    public int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        char[] strArr = numbers.toCharArray();
    
        for(int i=1; i<=length; i++) {
            combi(0, i, strArr, new boolean[length], new StringBuilder());
        }
        
        
        return cnt;
    }
    // 조합 만들기
    private static void combi(int depth, int targetCnt, char[] arr, boolean[] visited, StringBuilder sb) {
        if(depth == targetCnt) {
            String temp = sb.toString();
            int num = Integer.parseInt(temp);
            if(numVisited[num]) {   // 이미 검증한 숫자라면
                return;
            }
            numVisited[num] = true;
            if(isPrime(num)) {
                cnt++;
            }
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]);
                combi(depth + 1, targetCnt, arr, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
            
        }
        
    }
    // 소수 판별
    private static boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}