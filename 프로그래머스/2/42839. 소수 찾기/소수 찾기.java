import java.util.*;

class Solution {
    static Set<Integer> uniquePrimes = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        // 가능한 모든 조합을 생성하고 소수 여부를 판별합니다.
        for (int i = 1; i <= numbers.length(); i++) {
            generatePrimes("", i, numbers);
        }
        
        return uniquePrimes.size();
    }

    // 모든 숫자 조합을 생성하여 소수를 판별하는 함수
    private void generatePrimes(String current, int targetLength, String numbers) {
        // 현재 길이가 목표 길이에 도달하면 소수 판별을 수행
        if (current.length() == targetLength) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                uniquePrimes.add(num); // 소수인 경우 Set에 추가하여 중복 제거
            }
            return;
        }
        
        // 각 자릿수를 사용해 조합 생성 (중복 검사 및 방문 여부 확인)
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePrimes(current + numbers.charAt(i), targetLength, numbers);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
