import java.util.*;

class Solution {
    static int[] number;
    public int solution(int n) {
        int answer = 0;
        number = new int[n+1];
        Arrays.fill(number, -1);
        number[0] = 0;
        number[1] = 1;
        
        answer = fibonacci(n, n);
        return number[n];
    }
    public int fibonacci(int n, int target) {
        if(number[n] != -1) {
            return number[n];
        }
        number[n] = (fibonacci(n-1, target) + fibonacci(n-2, target)) % 1234567;
        return number[n];
    }
}