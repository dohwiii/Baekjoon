import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // arrayA와 arrayB의 최대공약수를 각각 구함
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);

        // gcdA와 gcdB가 각각 상대 배열에서 나누어지지 않으면 해당 gcd를 반환
        int candidateA = (gcdA > 1 && !canBeDivided(gcdA, arrayB)) ? gcdA : 0;
        int candidateB = (gcdB > 1 && !canBeDivided(gcdB, arrayA)) ? gcdB : 0;

        // 두 조건 중 더 큰 값 반환
        return Math.max(candidateA, candidateB);
    }

    // 배열의 최대공약수를 구하는 함수
    private int getGCD(int[] array) {
        return Arrays.stream(array).reduce(array[0], (a, b) -> gcd(a, b));
    }

    // 상대 배열에서 최대공약수로 나누어지는지 확인하는 함수
    private boolean canBeDivided(int gcdValue, int[] otherArray) {
        return Arrays.stream(otherArray).anyMatch(num -> num % gcdValue == 0);
    }

    // 유클리드 알고리즘을 이용한 최대공약수 계산
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
