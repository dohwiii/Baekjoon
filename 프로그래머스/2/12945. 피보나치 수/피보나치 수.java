import java.util.*;

class Solution {
    static int[] number;
    public int solution(int n) {
        int answer = 0;
        number = new int[n+1];
        Arrays.fill(number, -1);
        number[0] = 0;
        number[1] = 1;
        
        answer = fibonacci(n) % 1234567;
        return answer;
    }
    public int fibonacci(int n) {
        if(number[n] != -1) {
            return number[n];
        }
        number[n] = (fibonacci(n-1) % 1234567 + fibonacci(n-2) % 1234567);
        return (fibonacci(n-1) % 1234567 + fibonacci(n-2) % 1234567);
    }
}