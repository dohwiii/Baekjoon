import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        for(int i=1; i<=numbers.length(); i++) {
            solve(0, i, numbers);
        }
        return primes.size();
    }
    public void solve(int depth, int length, String numbers) {
        if(depth == length) {
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)) {
                primes.add(num);
            }
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                solve(depth + 1, length, numbers);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true; // 2와 3은 소수
        if (num % 2 == 0 || num % 3 == 0) return false; // 짝수와 3의 배수는 소수가 아님

        // 6k ± 1 패턴으로 검사
        for (int i = 5; i <= Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
} 