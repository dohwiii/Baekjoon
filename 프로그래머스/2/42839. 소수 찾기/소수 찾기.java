import java.util.*;

class Solution {
    static int answer;
    static Set<Integer> set;
    
    public int solution(String numbers) {
         answer = 0;
        set = new HashSet<>();
        char[] numArr = numbers.toCharArray();

        //numbers 1 ~ 자리수만큼 
        for(int i=1; i<=numbers.length(); i++) {
            permutation(0, new boolean[numbers.length()], numArr, new char[i], i);
        }

        // 소수 몇 개 만들 수 있는지
        return set.size();
    }
    private static void permutation(int depth, boolean[] visited, char[] numbers, char[] arr, int N) {
        if(depth == N) {
            StringBuilder sb = new StringBuilder();
            for(char a : arr) {
                sb.append(a);
            }
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)) {
                set.add(num);
                answer++;
            }
            return;
        }
        for(int i=0; i<numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                permutation(depth+1, visited, numbers, arr, N);
                visited[i] = false;
            }
        }
    }
    private static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        for(int i=2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    } 
}