import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    static Set<Integer> uniqueNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        generateCombinations("", numbers);
        
        int count = 0;
        for (int num : uniqueNumbers) {
            if (isPrime(num)) { // 소수로 판별된 경우에만 count를 증가
                count++;
            }
        }
        return count;
    }
    
    // 모든 숫자 조합을 구하는 함수
    private void generateCombinations(String prefix, String remaining) {
        if (!prefix.isEmpty()) {
            uniqueNumbers.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < remaining.length(); i++) {
            generateCombinations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (primes.contains(num)) return true; // 이미 소수로 판별된 경우 빠르게 반환

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        primes.add(num); // 소수로 판별된 경우 primes에 추가
        return true;
    }
}
