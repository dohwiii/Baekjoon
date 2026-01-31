import java.util.*;

class Solution {
    private Set<Integer> primes;
    
    public int solution(String numbers) {
        primes = new HashSet<>();
        int[] digits = new int[numbers.length()];

        for(int i=0; i<numbers.length(); i++) {
            digits[i] = numbers.charAt(i) - '0';
        }
        
        for(int len=1; len<=digits.length; len++) {
            permutation(0, len, digits, new boolean[digits.length], 0);
        }
        
        
        return primes.size();
    }
    // 순열 만들기
    private void permutation(int depth, int target, int[] digits, boolean[] visited, int current) {
        if(depth == target) {
            if(isPrime(current)) {
                primes.add(current);
            }
            return;
        }
        for(int i=0; i<digits.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(depth + 1, target, digits, visited, current * 10 + digits[i]);
                visited[i] = false;
            }
            
        }
        
    }
    // 소수 판별
    private boolean isPrime(int num) {
        if(num < 2) {   // 0과 1 제거
            return false;
        }
        if(num == 2) {
            return true;
        }
        if(num % 2 == 0) {  // 짝수 제거
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